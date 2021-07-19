package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Description:java使用Apache的ant压缩和解压文件(zip) 这个好用
 * @Author: gaoxi
 * @CreateDate: 2019/7/28 22:37
 * @Version: 1.0
 * https://blog.csdn.net/yaohucaizi/article/details/8863823
 */
@Slf4j
public class ZipUtil {
    /**
     *
     * @param file 要压缩的文件
     * @param zipFile 压缩文件存放地方
     */
    public static void zip(File file, File zipFile) {
        ZipOutputStream outputStream = null;

        try {
            outputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            zipFile(outputStream, file, "");
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ZipUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ZipUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param output ZipOutputStream对象
     * @param file 要压缩的文件或文件夹
     * @param basePath 条目根目录
     */
    private static void zipFile(ZipOutputStream output, File file, String basePath) {
        FileInputStream input = null;
        try {
            // 文件为目录
            if (file.isDirectory()) {
                // 得到当前目录里面的文件列表
                File list[] = file.listFiles();
                basePath = basePath + (basePath.length() == 0 ? "" : "/")
                        + file.getName();
                // 循环递归压缩每个文件
                for (File f : list) {
                    zipFile(output, f, basePath);
                }
            } else {
                // 压缩文件
                basePath = (basePath.length() == 0 ? "" : basePath + "/")
                        + file.getName();
                // System.out.println(basePath);
                output.putNextEntry(new ZipEntry(basePath));
                input = new FileInputStream(file);
                int readLen = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((readLen = input.read(buffer, 0, 1024 * 8)) != -1) {
                    output.write(buffer, 0, readLen);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭流
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(ZipUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     *
     * @param sourceZip 待解压文件路径
     * @param destDir 解压到的路径
     */
    public static void unZip(String sourceZip, String destDir) {
        //保证文件夹路径最后是"/"或者"\"
        char lastChar = destDir.charAt(destDir.length() - 1);
        if (lastChar != '/' && lastChar != '\\') {
            destDir += File.separator;
        }
        Project p = new Project();
        Expand e = new Expand();
        e.setProject(p);
        e.setSrc(new File(sourceZip));
        e.setOverwrite(false);
        e.setDest(new File(destDir));
        /*
         ant下的zip工具默认压缩编码为UTF-8编码，
         而winRAR软件压缩是用的windows默认的GBK或者GB2312编码
         所以解压缩时要制定编码格式
         */
        e.setEncoding("gbk");
        e.execute();
    }

    /**
     * 文件夹压缩成zip
     * https://blog.csdn.net/A_Lonely_Smile/article/details/108274444
     * @param zipFilePath 压缩后的文件
     * @param filePath 需要被压缩的目标文件
     * JAVA 使用Channel将文件夹压缩成ZIP
     * https://mp.weixin.qq.com/s/yC_5iYz9BbabdQ86D1BTow
     */
    public static void zipFileChannel(String zipFilePath, String filePath) {
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(zipFilePath);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            File path = new File(filePath);
            File[] files = path.listFiles();
            FileChannel fileChannel;
            for (File file : files) {
                fileChannel = new FileInputStream(file).getChannel();
                zipOut.putNextEntry(new ZipEntry(file.getName()));
                fileChannel.transferTo(0, file.length(), writableByteChannel);
            }
            long endTime = System.currentTimeMillis();
            log.info("File compression complete. Time consuming: {}ms. File size：{}", endTime - beginTime, CommonUtils.formatBytes(zipFile.length()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String sourcePath = "C:/model.zip";
        String destPath = "C:/test";
//        unZip(sourcePath, destPath);
//        zip(new File("G:/zip"), new File("F:/zip/model.zip"));

        zipFileChannel("G:\\zip\\test\\a.zip", "G:\\zip\\士大夫");
    }


}