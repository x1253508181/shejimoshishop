package com.itheima.shop.proxy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-16 21:23
 **/
@Component
@Data
@ConfigurationProperties(prefix = "upload")
public class FileUploadProxy {

    @Autowired
    private ApplicationContext act;

    //注入map
    private Map<String, List<String>> filemap;

    public String upload(MultipartFile file) throws Exception {
        //获取文件扩展名
        String extName = StringUtils.getFilenameExtension(file.getOriginalFilename());

        //获取文件的字节数组
        byte[] buffer = file.getBytes();
        for (Map.Entry<String, List<String>> entry : filemap.entrySet()) {
            //key ApplicationContext中的id
            String key = entry.getKey();

            //匹配后缀（扩展名）和当前key对应的得体bean要处理的文件后缀匹配
            for (String ext : entry.getValue()) {
                if (extName.equalsIgnoreCase(ext)) {
                    //获取对应的实例
                    act.getBean(key, FileUpload.class).upload(buffer, extName);
                }
            }

        }

        return null;
    }


    public String upload_back(MultipartFile file) throws Exception {
        //获取文件扩展名
        String extName = StringUtils.getFilenameExtension(file.getOriginalFilename());

        //获取文件的字节数组
        byte[] buffer = file.getBytes();
        if (extName.equals("mp4")) {
            //mp4文件上传到AliyunOSS
            FileUpload fileUpload = (FileUpload) act.getBean("aliyunOSSFileUpload");
            return fileUpload.upload(buffer, extName);
        } else if (extName.equals("jpg")) {
            //JPG文件上传到FastDFS
            FileUpload fileUpload = (FileUpload) act.getBean("fastdfsFileUpoad");
            return fileUpload.upload(buffer, extName);
        }

        return null;
    }
}
