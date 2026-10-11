package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadXController {
    /**本地磁盘存储的方式*/
  /*  @PostMapping("/upload")
    public Result uploadX(String name, Integer age, MultipartFile  file) throws IOException {
        log.info("name: {}, age: {}, file: {}", name, age, file);
        //获取原始文件名
        String originalFilename=file.getOriginalFilename();
        String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename= UUID.randomUUID().toString()+extension;
        //保存文件
        file.transferTo(new File("D:/images/"+newFilename));
        return Result.success();
    }
*/
    @Autowired
    private AliyunOSSperator ossOperator;
    /**阿里云OSS存储的方式*/
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}",file.getOriginalFilename());
    //将文件交给OSS存储管理
        String url=ossOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("文件上传到OSS，url{}",url);
        return Result.success(url);
    }
}
