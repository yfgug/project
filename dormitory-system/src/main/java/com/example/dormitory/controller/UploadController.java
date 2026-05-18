package com.example.dormitory.controller;

import com.example.dormitory.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin
public class UploadController {

    @Value("${file.upload.path}")
    private String uploadPath;

    /**
     * 上传学生头像
     */
    @PostMapping("/avatar")
    public Result<String> uploadAvatar(@RequestParam("file") MultipartFile file) {
        // 检查文件是否为空
        if (file.isEmpty()) {
            return Result.error("请选择要上传的文件");
        }

        // 检查文件类型
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            return Result.error("文件名不能为空");
        }

        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        if (!fileExtension.matches("\\.(jpg|jpeg|png|gif|bmp|webp)$")) {
            return Result.error("只支持上传图片文件 (JPG, JPEG, PNG, GIF, BMP, WEBP)");
        }

        // 检查文件大小（限制为2MB）
        long fileSize = file.getSize();
        if (fileSize > 2 * 1024 * 1024) {
            return Result.error("文件大小不能超过2MB");
        }

        try {
            // 生成唯一文件名
            String newFilename = UUID.randomUUID().toString() + fileExtension;

            // 创建上传目录
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                boolean created = uploadDir.mkdirs();
                if (!created) {
                    return Result.error("创建上传目录失败");
                }
            }

            // 保存文件
            File dest = new File(uploadDir.getAbsolutePath() + File.separator + newFilename);
            file.transferTo(dest);

            // 返回文件访问URL - 使用一个参数的success方法
            String fileUrl = "/uploads/" + newFilename;
            return Result.success(fileUrl); // 修改这里：只用一个参数

        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("文件上传失败: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统错误: " + e.getMessage());
        }
    }

}
