package com.testclass;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author GXY
 * @version V1.0
 * @Package com.testclass
 * @date 2020/5/6 13:35
 * @Copyright © 2020-2021 新流通
 * 使用apache commons-io的FileUtils.copyFile简单地复制文件
 * https://blog.csdn.net/evilcry2012/article/details/79447160
 */
public class AjavaFileCopyExample {
    public static void main(String[] args)
    {
        // 源File对象
        File source = new File("D:\\workspaces\\idea\\ajava.txt");

        // 备份的File对象
        File target = new File("D:\\workspaces\\idea\\ajava-backup.txt");

        //通过JVM读取java.io.tmpdir属性取得临时文件夹
        File targetDir = new File(System.getProperty("java.io.tmpdir"));

        try
        {
            //在同一个文件夹复制文件
            System.out.println("复制 " + source + " 文件到 " + target);
            FileUtils.copyFile(source, target);

            // 根据指定的文件夹复制
            System.out.println("复制 " + source + " 文件到" + targetDir + "目录");
            FileUtils.copyFileToDirectory(source, targetDir);
        } catch (IOException e)
        {
            // Errors will be reported here if any error occures during copying
            // the file
            e.printStackTrace();
        }
    }
}
