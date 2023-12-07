package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
/*    //本地存储
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{},{},{}",username,age,image);
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();

        //拿到文件拓展名
        int index = originalFilename.lastIndexOf(".");
        originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString();
        //本地上传指定目录下
        image.transferTo(new File("D:\\images\\"+newFileName));


        return Result.success();
    }*/
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传：{}",image);
        String url = aliOSSUtils.upload(image);//调用阿里云的工具类
        log.info("文件上传成功，文件访问的url:{}",url);


        return Result.success(url);
    }
}
