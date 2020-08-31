package com.example.springbootsamplehelloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author GXY
 * @Package com.example.springbootsamplehelloworld
 * @date 2020/8/20 19:39
 * @Copyright © 2020-2021 新流通
 * @Description:RedisTemplate中zset类型的使用
 * https://www.jianshu.com/p/11ade65876ee
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisZSetDemo {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test1() {
        //向集合中插入元素，并设置分数
        redisTemplate.opsForZSet().add("ranking-list", "p1", 2.1);

        //向集合中插入多个元素
        DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<String>("p2", 1.1);
        DefaultTypedTuple<String> tuple2 = new DefaultTypedTuple<String>("p3", 3.1);
        redisTemplate.opsForZSet().add("ranking-list", new HashSet<>(Arrays.asList(tuple1, tuple2)));

        //打印
        printZSet("ranking-list");
    }
    @Test
    public void test4() {
        //返回指定成员的排名（从小到大）
        Long rank = redisTemplate.opsForZSet().rank("ranking-list", "p1");
        //从大到小 获取倒序排列的索引值。
        Long reverseRank = redisTemplate.opsForZSet().reverseRank("ranking-list", "p1");
        System.out.println(rank);
        System.out.println(reverseRank);
    }
    @Test
    public void test5() {
        //返回集合内元素的排名，以及分数（从小到大）
        Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.opsForZSet().rangeWithScores("ranking-list", 0, -1);
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            System.out.println(tuple.getValue() + " : " + tuple.getScore());
        }
    }
    @Test
    public void test8() {
        //获得指定元素的分数
        Double score = redisTemplate.opsForZSet().score("ranking-list", "p1");
        System.out.println(score);
    }
    @Test
    public void test11() {
        //获得指定元素的分数
        Double score = redisTemplate.opsForZSet().score("ranking-list", "p1");
        System.out.println(score);
    }

    private void printZSet(String key) {
        //按照排名先后(从小到大)打印指定区间内的元素, -1为打印全部
        Set<String> range = redisTemplate.opsForZSet().range(key, 0, -1);
        //reverseRange 从大到小
        System.out.println(range);
    }
}
