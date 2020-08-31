package com.testclass;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GXY
 * @Package com.testclass
 * @date 2020/8/24 16:10
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        /**
         * putAll只会覆盖map中存在对应的key-value，对于不对应的kley-value不做任何操作。
         * 使用putAll时，新map中的值仅为旧map值所对应对象的引用，并不会产生新对象。
         */
        Map map = new HashMap();
        Map m = new HashMap();
        Map n = new HashMap();

        map.put("a", "haha");
        map.put("b", "haha");
        map.put("c", "haha");
        System.out.println(JSON.toJSONString(map));
        m.put("1", "a");
        m.put("2", "a");
        m.put("3", "a");
        m.put("4", "a");
        map.putAll(m);
        System.out.println(JSON.toJSONString(map));
        n.put("1", "高");
        n.put("2", "洗");
        n.put("3", "样");
        n.put("c", "哈哈");
        map.putAll(n);
        System.out.println(JSON.toJSONString(map));
    }
}
