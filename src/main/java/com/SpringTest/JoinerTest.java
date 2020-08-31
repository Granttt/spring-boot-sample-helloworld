package com.SpringTest;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GXY
 * @Package com.SpringTest
 * @date 2020/8/28 15:37
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class JoinerTest {
    public static void main(String[] args) {

        List<String> vinList = Arrays.asList("gao","xi",null,"yang");
        //skipNulls 跳过空指针
        String format = String.format("where vin in ('%s')", Joiner.on("','").skipNulls().join(vinList));
        System.out.println(format);

        String join = Joiner.on(' ').join(1, 2, 3);
        System.out.println(join);
        //追加字符串拼接
        StringBuilder sb = new StringBuilder("result:");
        StringBuilder stringBuilder = Joiner.on(" ").appendTo(sb, 1, 2, 3);
        System.out.println(stringBuilder);

        //useForNull 将空元素替换为指定元素
        String none = String.format("where vin in ('%s')", Joiner.on("','").useForNull("None").join(vinList));
        System.out.println(none);

        //withKeyValueSeparator 方法指定了键与值的分隔符，同时返回一个 MapJoiner 实例
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"gao");
        map.put(2,"xi");
        map.put(3,"yang");
        map.put(4,null);
        String joinMap = Joiner.on(",").withKeyValueSeparator("=").useForNull("None").join(map);
        System.out.println(joinMap);

    }
}
