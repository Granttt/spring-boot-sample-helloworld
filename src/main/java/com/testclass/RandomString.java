package com.testclass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @program: zdd-common
 * @description: 随机字无指定用处字符串
 * @author: Mr.G
 * @create: 2019-11-16 11:03
 **/
public class RandomString {

    /**
     * 生成指定长度字母数字混搭随机字符串 去除数字字母混淆
     * 不包含 大写O 小写o 数字0
     */
    public static String genCodes(int length) {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {// 字符串
                sb.append(getChar());
            } else {// 数字
                sb.append(getNumber());
            }
        }
        return sb.toString().toUpperCase();
    }

    public static String genCodesToBasis(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {// 字符串
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母
                sb.append((char) (choice + random.nextInt(26)));
            } else {// 数字
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }

    /**
     * 获取单个字符
     * 不包含 大写O 小写o
     */
    public static char getChar(){
        Random random = new Random();
        int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母
        char temp = (char)(choice + random.nextInt(26));
        String str = String.valueOf(temp);
        if (str.equals("o") || str.equals("O")){
            return getChar();
        }
        return temp;
    }

    /**
     * 获取单个数字
     * 不包含 数字0
     */
    public static String getNumber(){
        Random random = new Random();
        return String.valueOf(random.nextInt(9) + 1);
    }

    /**
     * 获取单个数字
     * 包含 数字0
     */
    public static String getNumberZero(){
        Random random = new Random();
        return String.valueOf(random.nextInt(10));
    }

    /**
     * java中随机生成字符串的方法（三种）
     * https://www.cnblogs.com/jpfss/p/9772019.html
     * @param length
     * @return
     */
    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     *  随机四位字母 大小写
     *  https://blog.csdn.net/qq_19872525/article/details/82724504
     * @return
     */
    private static String generateWord() {
        String[] beforeShuffle = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);
        return result;
    }



    public static void main(String[] args) {
        System.out.println(genCodes(10));
        System.out.println(genCodesToBasis(10));
        System.out.println(getRandomString(4));
        System.out.println(generateWord());
    }

}
