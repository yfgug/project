package com.example.dormitory.controller;

import com.example.dormitory.common.Result;
import com.example.dormitory.entity.Student;
import com.example.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    //获取列表（支持高级搜索）
    @GetMapping("/list")
    public Result<List<Student>> list(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String gender,
                                      @RequestParam(required = false) String dormId,
                                      @RequestParam(required = false) String startDate,
                                      @RequestParam(required = false) String endDate) {
        if (name != null || gender != null || dormId != null || startDate != null || endDate != null) {
            return Result.success(studentService.getStudentsByConditions(name, gender, dormId, startDate, endDate));
        }
        return Result.success(studentService.getAllStudents());
    }

    //新增学生
    @PostMapping("/add")
    public Result<?> add(@RequestBody Student student) {
        studentService.addStudent(student);
        return Result.success("新增成功");
    }

    // 修改学生
    @PutMapping("/update")
    public Result<?> update(@RequestBody Student student) {
        try {
            studentService.updateStudent(student);
            return Result.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("后端处理失败，请看IDEA控制台！");
        }
    }

    // 删除学生
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return Result.success("删除成功");
    }

    // 批量删除学生
    @PostMapping("/delete/batch")
    public Result<?> deleteBatch(@RequestBody List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return Result.error("请选择要删除的学生");
        }
        studentService.deleteBatch(ids);
        return Result.success("批量删除成功");
    }

    // 登录与防暴力破解模块
    private static java.util.concurrent.ConcurrentHashMap<String, Integer> failCount =
            new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<String, Long> lockTime =
            new java.util.concurrent.ConcurrentHashMap<>();

    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String, String> loginForm) {
        String username = loginForm.get("username");
        String password = loginForm.get("password");

        // 防火墙拦截：检查账号是否在锁定冷却期内
        if (lockTime.containsKey(username) && (System.currentTimeMillis() - lockTime.get(username) < 5000)) {
            long remain = 5 - ((System.currentTimeMillis() - lockTime.get(username)) / 1000);
            return Result.error("防火墙已拦截！该账号因暴力破解被锁定，请 " + remain + " 秒后再试。");
        }

        // 验证账号密码与权限分配
        String role = "";
        boolean isSuccess = false;

        // 修复登录逻辑
        if ("admin".equals(username) && "123456".equals(password)) {
            role = "admin";
            isSuccess = true;
        } else if ("stu".equals(username) && "123".equals(password)) {
            role = "student";
            isSuccess = true;
        }

        // 成功与失败的处理
        if (isSuccess) {
            failCount.remove(username);
            lockTime.remove(username);

            // 返回包含角色信息的对象
            Map<String, String> result = new HashMap<>();
            result.put("role", role);
            result.put("username", username);
            return Result.success(result);
        } else {
            int fails = failCount.getOrDefault(username, 0) + 1;
            failCount.put(username, fails);

            if (fails >= 3) {
                lockTime.put(username, System.currentTimeMillis());
                return Result.error("警告：密码错误达3次，触发防暴力破解机制，账号锁定5秒钟！");
            }
            return Result.error("账号或密码错误！还有 " + (3 - fails) + " 次尝试机会。");
        }
    }
}
