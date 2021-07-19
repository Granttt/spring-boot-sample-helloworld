package com.example.utils;

import java.text.DecimalFormat;

/**
 * @author GXY
 * @Package com.example.utils
 * @date 2020/9/5 15:50
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class CommonUtils {
    /**
     * 字节转换,计算文件大小
     *
     * @param size
     * @return
     */
    public static String formatBytes(long size) {
        int GB = 1024 * 1024 * 1024;
        int MB = 1024 * 1024;
        int KB = 1024;
        DecimalFormat df = new DecimalFormat("0.00");
        String resultSize = "";
        if (size / GB >= 1) {
            resultSize = df.format(size / (float) GB) + "GB";
        } else if (size / MB >= 1) {
            resultSize = df.format(size / (float) MB) + "MB";
        } else if (size / KB >= 1) {
            resultSize = df.format(size / (float) KB) + "KB";
        } else {
            resultSize = size + "B";
        }
        return resultSize;
    }

}
