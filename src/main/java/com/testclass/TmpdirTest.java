package com.testclass;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: 高希阳
 * @Date: 2018/12/27 12:30
 * @Description:ystem.getproperty(“java.io.tmpdir”)是获取操作系统缓存的临时目录，不同操作系统的缓存临时目录不一样，
 * https://www.cnblogs.com/nbjin/p/7392541.html
 */
public class TmpdirTest {
    public static void main(String[] args) {
        //默认的临时文件路径
        System.out.println(System.getProperty("java.io.tmpdir"));
        //Java供应商的 URL
        System.out.println(System.getProperty("java.vendor.url"));

        String a = "[2,3,4,10]";
        String[] split = a.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        String b = "sbcdef_df";
        System.out.println(b.startsWith("sbcdef"));
        System.out.println(b.endsWith("d"));


        List<Long> codeList = new ArrayList<>();
        codeList.add(1L);
        codeList.add(2L);
        codeList.add(3L);
        codeList.add(4L);
        codeList.add(5L);
        String codes = "";
        for (Long code : codeList) {
            codes += code + ",";
        }
        System.out.println(codes);
        //去掉最后一个逗号
        if (codes != null && !"".equals(codes)){
            codes = codes.substring(0, codes.length() - 1);
        }
        System.out.println(codes);
    }
}
