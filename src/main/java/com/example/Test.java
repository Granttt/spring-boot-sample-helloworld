package com.market.util.java8;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : Mr.G
 * @version : 1.0
 * @date : 2020/5/22 10:38
 * @description :
 */
@Slf4j
public class Test {

    public static void main(String[] args) {

        /**
         * 题目
         * 动态生成数组x个 对数组进行遍历实现 [任意两个元素a-b等于基准值] 的匹配个数 重复匹配不算 代码填入实施方法中
         * 与默认计算方法比较损耗 以求得最优解 可利用各种算法 规则 模式 进行优化
         * 禁止百度谷歌 自我思考 截止时间至2020年5月22日 14:00 最优者有奖！
         * Java端小伙伴参与 因其他端语言计算容器损耗不相同 故不作数 但也可尝试
         */

        //计算基准值
        Integer standard = 9;

        //预制数据 忽略不计
        List<Integer> list = new ArrayList<>();
        Integer[] arr = null;
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {

            boolean flag = random.nextInt(2) % 2 == 0 ? true : false;//随机加减

            int value = random.nextInt(10000);
            value = flag ? 0 + value : 0 - value;
            list.add(value);

        }
        arr = new Integer[list.size()];
        list.toArray(arr);

        System.out.println("数组元素为:" + Arrays.toString(arr));
        System.out.println("--------------------------------------------");
        System.out.println("默认计算方法开始...");
        long startTime1 = System.currentTimeMillis();
        System.out.println("计算匹配数量为:" + defaultCalculate(arr, standard));
        long endTime1 = System.currentTimeMillis();
        System.out.println("默认计算耗时:" + secondToTime(endTime1 - startTime1));

        System.out.println("--------------------------------------------");
        System.out.println("gxy实施计算方法开始...");
        long startTime2 = System.currentTimeMillis();
        System.out.println("计算匹配数量为:" + calculate(arr, standard));
        long endTime2 = System.currentTimeMillis();
        System.out.println("实施计算耗时:" + secondToTime(endTime2 - startTime2));
//        System.out.println("--------------------------------------------");
//        System.out.println("js实施计算方法开始...");
//        long startTime4 = System.currentTimeMillis();
//        System.out.println("计算匹配数量为:" + calculateJS(arr, standard));
//        long endTime4 = System.currentTimeMillis();
//        System.out.println("实施计算耗时:" + secondToTime(endTime4 - startTime4));
//        System.out.println("--------------------------------------------");
//        System.out.println("swq实施计算方法开始...");
//        long startTime5 = System.currentTimeMillis();
//        System.out.println("计算匹配数量为:" + calculateSWQ(arr, standard));
//        long endTime5 = System.currentTimeMillis();
//        System.out.println("实施计算耗时:" + secondToTime(endTime5 - startTime5));
//        System.out.println("--------------------------------------------");
//        System.out.println("二分查找法方法开始...");
//        long startTime3 = System.currentTimeMillis();
//        System.out.println("匹配坐标:" + binary(arr, standard));
//        long endTime3 = System.currentTimeMillis();
//        System.out.println("二分查找法计算耗时:" + secondToTime(endTime3 - startTime3));

    }

    /**
     * 默认计算方法
     * @param arr
     * @return
     */
    private static int defaultCalculate(Integer[] arr, Integer standard){

        int result = 0;
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));

        for (Integer val : set) {
            for (Integer compare : set) {
                if (val - compare == standard){
                    result ++;
                }
            }
        }
        return result;
    }

    /**
     * 实施计算方法 在此填入计算代码
     * @param arr
     * @return
     */
    private static int calculate(Integer[] arr, Integer standard){

        int result = 0;
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        // 此处填入代码块
        for (Integer integer : set) {
            if (set.contains(integer - standard)){
                result ++;
            }
        }

//         Arrays.sort(arr);
//        int left=0;
//        int right=arr.length-1;
//
//        while(left!=right){
//
//            if(arr[right]-arr[left]>standard){
//                left++;
//
//            }else if(arr[right]-arr[left] == standard){
//                result ++ ;
//                right--;
//            }
//            else left ++;
//        }
        return result;
    }

    /**
     * 实施计算方法 在此填入计算代码
     * by jinshan
     * @param arr
     * @return
     */
    private static int calculateJS(Integer[] arr, Integer standard){

        int result = 0;

        // 此处填入代码块
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        LinkedList<Integer> temp = new LinkedList<>(set);
        for (Integer val : set) {
            temp.peekFirst();
            for (Integer compare : temp) {
                if (val - compare == standard){
                    result ++;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 实施计算方法 在此填入计算代码
     * by songwenqu
     * @param arr
     * @return
     */
    private static int calculateSWQ(Integer[] arr, Integer standard) {

        int result = 0;
//        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
//   1、     for (Integer value : set) {
//            result += set.stream().filter(compare -> value - compare == standard).count();
//        }

        Set<Integer> set = new HashSet<>();
        CollectionUtils.addAll(set, arr);

        for (int val : set) {
            for (int compare : set) {
                if (val - compare == standard) {
                    result++;
                }
            }
        }

        // 此处填入代码块

        return result;
    }

    /**
     * 二分查找法
     * @param arr
     * @param data
     * @return
     */
    public static int binary(Integer[] arr, int data) {
        //二分查找法适合于有序数组，所以先排序
        Arrays.sort(arr);
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (arr[mid] > data) {
                max = mid - 1;
            } else if (arr[mid] < data) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
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
