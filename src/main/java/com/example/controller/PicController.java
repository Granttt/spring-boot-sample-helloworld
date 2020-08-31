package com.example.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author GXY
 * @Package com.example.controller
 * @date 2020/7/31 14:27
 * @Copyright © 2020-2021 新流通
 * @Description:动态获取图片---服务端获取图片显示在jsp中
 * https://blog.csdn.net/zzq900503/article/details/52457003
 */
@Controller
public class PicController {

    /**
     * 本地服务器访问图片
     * @param response
     * @throws IOException
     */
    @RequestMapping("/testpic")
    public void testpic(HttpServletResponse response) throws IOException {
        FileInputStream fis = null;
        File file = new File("D://新邀请函04.png");
        //File file = new File("home/images/test.png"); 服务器目录和本地图片的区别是图片路径
        fis = new FileInputStream(file);
        response.setContentType("image/png"); //设置返回的文件类型
        response.setHeader("Access-Control-Allow-Origin", "*");//设置该图片允许跨域访问
        IOUtils.copy(fis, response.getOutputStream());
    }
}
