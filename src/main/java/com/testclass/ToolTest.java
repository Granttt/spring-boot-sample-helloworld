package com.testclass;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author GXY
 * @Package com.testclass
 * @date 2021/7/19 9:36
 * @Copyright © 2021-2022 聚优福利
 * @Description:
 * https://mp.weixin.qq.com/s/OLfgVEbrF-_9iJg5B6DN6g
 */
public class ToolTest {

    public static void main(String[] args) {
        //两个List集合取交集
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        list2.retainAll(list1);
        System.out.println(list2);
        // Multimap 一个key可以映射多个value的HashMap
        Multimap<String,Integer> map = ArrayListMultimap.create();
        map.put("key", 1);
        map.put("key", 2);
        map.put("abc", 2);
        Collection<Integer> values = map.get("key");
        System.out.println("map:"+map);
        System.out.println("values:"+values);
        // 还能返回你以前使用的臃肿的Map
        Map<String, Collection<Integer>> collectionMap = map.asMap();
        System.out.println("collectionMap:"+collectionMap);
    }
}
