package com.example.dormitory.controller;
import com.example.dormitory.common.Result;
import com.example.dormitory.entity.Notice;
import com.example.dormitory.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
@CrossOrigin
public class NoticeController {
    @Autowired private NoticeService noticeService;

    @GetMapping("/list")
    public Result<List<Notice>> list() {
        return Result.success(noticeService.getAllNotices());
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody Notice notice) {
        noticeService.addNotice(notice);
        return Result.success("发布成功");
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Notice notice) {
        noticeService.updateNotice(notice);
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        noticeService.deleteNotice(id);
        return Result.success("删除成功");
    }
}
