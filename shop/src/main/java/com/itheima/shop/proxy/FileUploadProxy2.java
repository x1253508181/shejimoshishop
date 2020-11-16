package com.itheima.shop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.proxy.FileUploadProxy
 ****/
@ConfigurationProperties(prefix = "upload")
@Component(value = "fileUploadProxy")
public class FileUploadProxy2 {

    @Autowired
    private ApplicationContext act;

    private Map<String,List<String>> filemap;

    /****
     * 文件上传
     * @param file
     * @return
     */
    public String upload(MultipartFile file) throws Exception{
        //1.文件的字节数组
        byte[] buffers = file.getBytes();

        //2.文件的扩展名   1.jpg
        String fileName = file.getOriginalFilename();
        String extName = StringUtils.getFilenameExtension(fileName);    //jpg|mp4|png

        /***
         * 3.1 aliyunOSSFileUpload----->mp4,avi
         * 3.2 fastdfsFileUpoad----->png,jpg,gif
         */
        for (Map.Entry<String, List<String>> entry : filemap.entrySet()) {
            //获取后缀集合
            for (String suffix : entry.getValue()) {
                //循环迭代匹配后缀
                if(suffix.equalsIgnoreCase(extName)){
                    return act.getBean(entry.getKey(),FileUpload.class).upload(buffers,extName);
                }
            }
        }
        return null;
    }

    /****
     * 文件上传
     * @param file
     * @return
     */
    public String upload_backup(MultipartFile file) throws Exception{
        //1.文件的字节数组
        byte[] buffers = file.getBytes();

        //2.文件的扩展名   1.jpg
        String fileName = file.getOriginalFilename();
        String extName = StringUtils.getFilenameExtension(fileName);    //jpg|mp4|png

        /***
         * 3.1 aliyunOSSFileUpload----->mp4,avi
         * 3.2 fastdfsFileUpoad----->png,jpg,gif
         */
        //1.判断文件后缀
        if(extName.equalsIgnoreCase("mp4") || extName.equalsIgnoreCase("avi")){
            //2.根据文件后缀获取指定对象的实例----->ApplicationContext获取实例
            return act.getBean("aliyunOSSFileUpload",FileUpload.class).upload(buffers,extName);
        }else if(extName.equalsIgnoreCase("png") || extName.equalsIgnoreCase("jpg")){
            return act.getBean("fastdfsFileUpoad",FileUpload.class).upload(buffers,extName);
        }
        return null;
    }

    //依赖注入
    public void setFilemap(Map<String, List<String>> filemap) {
        this.filemap = filemap;
    }
}
