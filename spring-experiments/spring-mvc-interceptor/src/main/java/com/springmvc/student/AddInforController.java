package com.springmvc.student;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system")
public class AddInforController {

    @RequestMapping("/showInfor")
    public ModelAndView showInfor(Student student, HttpServletRequest request) {
        MultipartFile file = student.getPhoto();
        String originalFilename = file.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/images/");
        String filePath = path + originalFilename;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            System.out.println("保存图片失败！");
        }
        path = request.getServletContext().getContextPath();
        String requestPath = path + "/images/" + originalFilename;
        student.setRequestPath(requestPath);
        student.setPhotoName(originalFilename);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("showInfor");
        return modelAndView;
    }

    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, String fileName)
            throws IOException {
        String filePath = request.getServletContext().getRealPath("/images/") + fileName;
        File file = new File(filePath);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        HttpHeaders headers = new HttpHeaders();
        fileName = URLEncoder.encode(fileName, "UTF-8");
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
