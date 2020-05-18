package com.testclass;

import com.alibaba.fastjson.JSON;
import com.example.domain.School;
import com.example.domain.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: gxy
 * @CreateDate: 2020/1/3 10:11
 * @Description:java8 stream流练习
 * https://www.cnblogs.com/dinghaoran/p/11690555.html
 */
public class StreamTest {

    public static void main(String[] args) {
        List<School> schools = new ArrayList<>();
        School school = new School();
        school.setSchoolId("1");
        school.setSchoolName("北大");
        schools.add(school);
        School school1 = new School();
        school1.setSchoolId("2");
        school1.setSchoolName("清华");
        schools.add(school1);
        School school2 = new School();
        school2.setSchoolId("3");
        school2.setSchoolName("北航");
        schools.add(school2);

        System.out.println(JSON.toJSONString(schools));
        //stream().sorted()进行排序默认升序，reversed()为降序
        List<School> schoolAsc = schools.stream().sorted(Comparator.comparing(School::getSchoolId).reversed()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(schoolAsc));

        long count = schools.stream().filter(school3 -> school3.getSchoolId().equals("2")).count();
        System.out.println(count);

        //返回特定的结果集合（limit/skip）：limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素。
        ArrayList<String> forEachLists = new ArrayList<>();
        forEachLists.add("a");
        forEachLists.add("b");
        forEachLists.add("c");
        forEachLists.add("d");
        forEachLists.add("e");
        forEachLists.add("f");
        List<String> collect = forEachLists.stream().skip(2).limit(3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        String json = "{\"name\":\"FLY\",\"age\": 25}";

        System.out.println(((int)(Math.random()*10000)+1));


        //https://blog.csdn.net/zwq_zwq_zwq/article/details/82085786
        //http://www.manongjc.com/detail/6-sfrmuueekmhrzis.html
        List<Student> students = Arrays.asList(
                new Student(1,"zhangsan","class1",18,60,"2020-05-16"),
                new Student(2,"lisi","class1",18,59,"2020-05-16"),
                new Student(3,"lisi","class1",18,100,"2020-05-16"),
                new Student(3,"wangwu","class2",18,100,"2020-05-16"),
                new Student(3,"wangwu","class23",18,100,"2020-05-16"),
                new Student(4,"wangwu","class2",18,100,"2020-05-16"),
                new Student(5,"wangwu","class2",18,100,"2020-05-17"),
                new Student(5,"wangwu","class2",18,99,"2020-05-16"),
                new Student(14,"zhaoliu","class2",18,80,"2020-05-16"));


        //按姓名分组
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        List<Student> students1 = new ArrayList<>();
        for (List<Student> value : map.values()) {
            //time去重
            value = value.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()
                    -> new TreeSet<>(Comparator.comparing(Student::getTime))), ArrayList::new));
            students1.addAll(value);
        }
        //filter(Predicate p) 接收 Lambda ， 从流中排除某些元素。
        //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去
        //除重复元素
        //limit(long maxSize) 截断流，使其元素不超过给定数量。
        //skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素
        //不足 n 个，则返回一个空流。与 limit(n) 互补
        Stream<Student> studentStream = students.stream().filter(e->e.getSorce()>=60).distinct();
        studentStream .forEach(System.out::println);
    }
}

/**
 * 用Collectors对List去重
 * https://www.cnblogs.com/xuwenjin/p/9660393.html
 */
class testCollectingAndThen{
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1,"zhangsan","class1",18,60,"2020-05-16"),
                new Student(2,"lisi","class1",18,59,"2020-05-16"),
                new Student(3,"lisi","class1",18,100,"2020-05-16"),
                new Student(100,"wangwu","class2",18,100,"2020-05-16"),
                new Student(3,"wangwu","class23",18,100,"2020-05-16"),
                new Student(4,"wangwu","class2",18,100,"2020-05-16"),
                new Student(5,"wangwu","class21",18,100,"2020-05-17"),
                new Student(5,"wangwu","class2",18,99,"2020-05-16"),
                new Student(14,"zhaoliu","class2",18,80,"2020-05-16"));
        List<Student> students1 = new ArrayList<>();
        students1 = students.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>
                        (Comparator.comparing(Student::getName))),ArrayList::new));
        students1.forEach(student -> System.out.println("id:" + student.getId() + ", name:" + student.getName()));
        System.out.println("============================================");
        //根据多个属性去重
        List<Student> students2 = students.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(student -> student.getName() +";"+ student.getClassName()))),ArrayList::new));
        students2.forEach(student -> System.out.println("id:" + student.getId() + ", name:" + student.getName()));
    }
    
    
}