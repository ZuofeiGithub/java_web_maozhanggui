package com.huiketong.catshopkeeper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * 文件上传工具类
 */
public  class FileUploadUtil {

    private  final   static Logger log= LoggerFactory.getLogger(FileUploadUtil.class);


    public  static  String upload(HttpServletRequest request, MultipartFile multipartFile) {
    /*    long time = System.currentTimeMillis();*/
        //项目服务器地址路径
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort();
        // 上传文件绝对路径
        String path = "File/image/upload/";
        //上传文件名
        String fileName = multipartFile.getOriginalFilename();
        String type = fileName.substring(fileName.lastIndexOf("."));
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String newFileName = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
            newFileName = UUID.randomUUID().toString().replace("-", "") + type;
            bos = new BufferedOutputStream(new FileOutputStream(path + newFileName));
            byte[] bs = new byte[1024];
            int len;
            while ((len = inputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            inputStream.close();
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage()+"---错误");
        }
    /*    long time1 = System.currentTimeMillis();
        System.out.println(time1 - time + "耗时");
        System.out.println(projectServerPath + newFileName);*/
        return projectServerPath +"/File/image/upload/"+ newFileName;
    }
}
