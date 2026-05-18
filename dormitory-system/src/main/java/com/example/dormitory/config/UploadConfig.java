package com.example.dormitory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
public class UploadConfig {

    @Value("${file.upload.max-size:2MB}")
    private String maxFileSize;

    @Value("${spring.servlet.multipart.max-request-size:20MB}")
    private String maxRequestSize;

    /**
     * 配置文件上传参数
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        // 单个文件最大大小
        factory.setMaxFileSize(DataSize.parse(maxFileSize));

        // 整个请求最大大小
        factory.setMaxRequestSize(DataSize.parse(maxRequestSize));

        return factory.createMultipartConfig();
    }
}
