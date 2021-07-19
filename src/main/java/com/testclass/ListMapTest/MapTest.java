package com.testclass.ListMapTest;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author GXY
 * @Package com.testclass.ListMapTest
 * @date 2020/9/1 12:08
 * @Copyright © 2020-2021 新流通
 * @Description: list分组整理成map
 */
public class MapTest {
    public static void main(String[] args) {

        // 分组
        Map<String, List<String>> map = new HashMap<>();
        List<MapTest.Order> orders = Arrays.asList(
                new MapTest.Order("1","SC001"),
                new MapTest.Order("1","SC002"),
                new MapTest.Order("2","SC003"),
                new MapTest.Order("2","SC004"),
                new MapTest.Order("2","SC005"),
                new MapTest.Order("3","SC006"));
        orders.forEach(order -> {
            List<String> list;
            if (map.containsKey(order.getSn())){
                list = map.get(order.getSn());
            }else {
                list = new ArrayList<>();
            }
            list.add(order.getCode());

            map.put(order.getSn(),list);
        });

        System.out.println(JSON.toJSONString(map));

    }


    @Data
    @AllArgsConstructor
    static class Order{
        private String sn;
        private String code;

    }
}
