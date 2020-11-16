package com.itheima.shop.proxy;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.proxy.FileUpload
 ****/
public interface FileUpload {


    /****
     * 文件上传方法
     * 返回值：上传的文件访问路径
     */
    String upload(byte[] buffers,String extName);
}
