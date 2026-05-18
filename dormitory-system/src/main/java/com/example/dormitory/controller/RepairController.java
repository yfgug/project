package com.example.dormitory.controller;
import com.example.dormitory.common.Result;
import com.example.dormitory.entity.Repair;
import com.example.dormitory.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/repair")
@CrossOrigin
public class RepairController {
    @Autowired private RepairService repairService;
    @GetMapping("/list")
    public Result<List<Repair>> list() { return Result.success(repairService.getAllRepairs()); }
    @PostMapping("/add")
    public Result<?> add(@RequestBody Repair repair) { repairService.addRepair(repair); return Result.success("报修提交成功"); }
    @PostMapping("/resolve/{id}")
    public Result<?> resolve(@PathVariable Integer id) { repairService.resolveRepair(id); return Result.success("工单已解决"); }
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) { repairService.deleteRepair(id); return Result.success("删除记录成功"); }
}