package com.example;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 题目
 * 已知一个动态可变数组，假设5000W。找出数组中匹配的元素的数量。
 * 使用多线程, 可以提交多个类
 * 禁止百度谷歌 自我思考 截止时间至2020年06月01日 19:20 最优者有奖！
 */
public class TestGxy implements Callable<Integer> {

    static String[] arr = null;
    static final int Thread_Num = 100;
    static ExecutorService pool = Executors.newFixedThreadPool(Thread_Num);


    //beginPos 分组开始的索引，endPos 分组结束索引
    int begin;
    int end;
    String searchValue;

    public static int search(String searchValue, int beginPos, int endPos){
        int i = 0;
        //每个线程维护一个变量
        int j = 0;
        for(i = beginPos; i < endPos;i ++){
            if(arr[i] .equalsIgnoreCase(searchValue) ){
                j++;
            }
        }
        return j;
    }
    @Override
    public Integer call() throws Exception {
        int re = search(searchValue, begin, end);
        return re;
    }
    public static int initSearch(String searchValue) throws InterruptedException, ExecutionException {
        //可以分几组，+1 确定分割的区块的大小
        int subArrSize = arr.length/Thread_Num + 1;
        List<Future<Integer>> re = new ArrayList<Future<Integer>>();
        //结果值
        int result = 0;
        //分割数组操作
        for(int i = 0;i < arr.length;i +=subArrSize){
            int end = i + subArrSize;
            if(end >= arr.length){
                end = arr.length;
            }
            //加入线程组
            re.add(pool.submit(new TestGxy(searchValue, i, end)));
        }
        for(Future<Integer> fu : re){
            if(fu.get() >= 0){
                //每条线程最终结果相加
                result+= fu.get();
            }
        }
        return result;
    }
    public TestGxy(String searchValue, int begin, int end){
        this.searchValue = searchValue;
        this.begin = begin;
        this.end = end;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String[] arr = buildCharArr(100000);
        TestGxy.arr = arr;
        // TODO: 各自的姓氏
        String keyword = "一";

        System.out.println("--------------------------------------------");
        System.out.println("默认计算方法开始...");
        long startTime1 = System.currentTimeMillis();
        System.out.println("计算匹配数量为:" + compute01(arr, keyword));
        long endTime1 = System.currentTimeMillis();
        System.out.println("默认计算耗时:" + secondToTime(endTime1 - startTime1));

        System.out.println("--------------------------------------------");
        System.out.println("实施计算方法开始...");
        long startTime2 = System.currentTimeMillis();
        System.out.println("计算匹配数量为:" + initSearch(keyword));
        long endTime2 = System.currentTimeMillis();
        System.out.println("实施计算耗时:" + secondToTime(endTime2 - startTime2));
    }

    public static Long compute(String[] arr, String keyword){
        Long total = 0L;

        return total;
    }

    // 单线程 常规顺序计算
    public static Long compute01(String[] arr, String keyword){
        Long total = 0L;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(keyword)){
                total ++;
            }
        }
        return total;
    }

    /**
     * 构建数组
     * */
    public static String[] buildCharArr(Integer size){
        String[] charArr = new String[size];
        for(int i = 0; i < size; i ++){
            charArr[i] = getRandomChar();
        }
        return charArr;
    }
    /**
     * 随机生成汉字
     * */
    public static String getRandomChar() {
        String str = "";
        int highCode;
        int lowCode;
        Random random = new Random();
        highCode = (176 + Math.abs(random.nextInt(39))); //B0 + 0~39(16~55) 一级汉字所占区
        lowCode = (161 + Math.abs(random.nextInt(93))); //A1 + 0~93 每区有94个汉字
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 时间格式转化
     * @param scanTime
     * @return
     */
    private static String secondToTime(Long scanTime){
        long hours = scanTime / 3600;//转换小时数
        scanTime = scanTime % 3600;//剩余秒数
        long minutes = scanTime / 60;//转换分钟
        scanTime = scanTime % 60;//剩余秒数
        if (hours > 0){
            if (minutes == 0){
                return hours+"小时";
            }else if (scanTime == 0){
                return hours+"小时"+minutes+"分";
            }
            return hours+"小时"+minutes+"分"+scanTime+"秒";
        }else if (minutes > 0){
            if (scanTime == 0){
                return minutes+"分";
            }
            return minutes+"分"+scanTime+"秒";
        }else if (scanTime == 0){
            return "";
        }else {
            return scanTime + "秒";
        }
    }

}
