package com.example.springbootsamplehelloworld;

import com.alibaba.fastjson.JSON;
import com.example.domain.Person;
import com.example.domain.Student;
import com.testclass.StaticDemo5;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author GXY
 * @Package com.example.springbootsamplehelloworld
 * @date 2020/6/9 13:24
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisListTest {

    @Resource
    private RedisTemplate redisTemplate;
    private final static String key = "o2o:cp:sortTest2";

    @Test
    public void redisSaveList() {
                List<Student> students = Arrays.asList(
                new Student(1,"zhangsan","class1",18,60,"2020-05-16"),
                new Student(2,"lisi","class1",18,59,"2020-05-16"),
                new Student(3,"lisi","class1",18,100,"2020-05-16"),
                new Student(4,"wangwu","class2",18,100,"2020-05-16"),
                new Student(5,"wangwu","class2",18,100,"2020-05-17"),
                new Student(6,"wangwu","class2",18,91,"2020-05-16"),
                new Student(7,"wangwu","class2",18,92,"2020-05-16"),
                new Student(8,"wangwu","class22",18,93,"2020-05-16"),
                new Student(9,"wangwu","class2",18,94,"2020-05-16"),
                new Student(10,"wangwu","class2",18,88,"2020-05-16"),
                new Student(11,"wangwu","class4",18,96,"2020-05-16"),
                new Student(12,"wangwu","class2",18,90,"2020-05-16"),
                new Student(13,"zhaoliu","class2",18,98,"2020-05-16"),
                new Student(14,"zhaoliu","class2",18,99,"2020-05-16"),
                new Student(15,"zhaoliu","class2",18,80,"2020-05-16"));

        for (Student student : students) {
            Class cls = student.getClass();
            Field[] fields = cls.getDeclaredFields();
            for(int i =0;i<fields.length;i++){
                Field field = fields[i];
                field.setAccessible(true);
                try {
                    System.out.println(field.getName()+","+field.get(student));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        //存储
//        redisTemplate.opsForList().rightPushAll("students", students);


    }
    @Test
    public void getRedisList() {
        //取出
        List<Student> oowwoo = redisTemplate.opsForList().range("students", 6, 7);
        log.info(">>>>>>>>>>>>>>>list = {}", oowwoo.toString());
        Iterator<Student> it = oowwoo.iterator();
        while(it.hasNext()){
            Student p = it.next();
            log.info("student = {}", p.toString());
        }
    }


    /**
     * RedisTemplate ZSet使用、实现排行榜
     * https://blog.csdn.net/lbh199466/article/details/102625560
     */
    @Test
    public void redisZsetTest(){
        for (int i = 0; i < 10; i++) {
            int score = new Random().nextInt(100);
            //新增一个有序集合，元素存在的话为false，不存在的话为true（新增）
            Boolean add = redisTemplate.opsForZSet().add(key, i, score);
            log.info(JSON.toJSONString(add));
        }
        Boolean add = redisTemplate.opsForZSet().add(key, 10, new Random().nextInt(100));
        log.info(JSON.toJSONString(add));
    }

    @Test
    public void redisSortTest(){
        //只返回前三名的value
        //参数注释 key 为有序集合的key，1，50 是分数范围 1-50，0 是偏移量即从哪条数据开始排序， 3是取3条满足条件的数据
        Set set = redisTemplate.opsForZSet().rangeByScore(key, 1, 50, 0, 3);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //按照从大到小 使用 reverse前缀
        Set set1 = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, 1, 100, 0, 3);
        Iterator<ZSetOperations.TypedTuple<Object>>  iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            ZSetOperations.TypedTuple<Object> next = iterator1.next();
            System.out.println("value:" + next.getValue() + "score:" + next.getScore());
        }
    }
    @Test
    public void removeZest(){
        redisTemplate.opsForZSet().remove(key,10,9);
    }
    @Test
    public void incrScore(){
        Double aDouble = redisTemplate.opsForZSet().incrementScore(key, 10, 10);
        Double bDouble = redisTemplate.opsForZSet().incrementScore(key, 11, 55);
        System.out.println(aDouble);
        System.out.println(bDouble);
    }
}
