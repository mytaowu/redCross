package com.red.handler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: TMingYi
 * @date: 2020/9/2 16:14
 */
public class UpfileController {
    private String filePath="D:/photos/"; //定义上传文件的存放位置

    @RequestMapping(value = "/upload")//测试的url接口
    public String upLoadFile(@RequestParam("upload") MultipartFile upload){
        //判断文件夹是否存在,不存在则创建
        File file=new File(filePath);

        if(!file.exists()){
            file.mkdirs();
        }
        String originalFileName = upload.getOriginalFilename();//获取原始图片的扩展名
        String newFileName = UUID.randomUUID()+originalFileName;
        String newFilePath=filePath+newFileName; //新文件的路径

        try {
            upload.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
            System.out.println("上传图片成功进行上传文件测试");
            return newFileName;
        }catch (IllegalStateException e ) {
            //处理异常
        }catch(IOException e1){
            //处理异常
        }
        return "success";
    }
}
