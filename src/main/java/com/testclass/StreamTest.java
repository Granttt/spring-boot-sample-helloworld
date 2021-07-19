package com.testclass;

import com.alibaba.fastjson.JSON;
import com.example.domain.School;
import com.example.domain.Student;
import org.springframework.util.CollectionUtils;

import javax.naming.Name;
import java.util.*;
import java.util.function.DoubleUnaryOperator;
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
                new Student(6,"wangwu","class2",18,91,"2020-05-16"),
                new Student(7,"wangwu","class2",18,92,"2020-05-16"),
                new Student(8,"wangwu","class22",18,93,"2020-05-16"),
                new Student(9,"wangwu","class2",18,94,"2020-05-16"),
                new Student(10,"wangwu","class2",18,88,"2020-05-16"),
                new Student(11,"wangwu","class4",18,96,"2020-05-16"),
                new Student(12,"wangwu","class2",18,90,"2020-05-16"),
                new Student(14,"zhaoliu","class2",18,98,"2020-05-16"),
                new Student(15,"zhaoliu","class2",18,99,"2020-05-16"),
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
        //filter(Predicate p) 接收 Lambda ， 从流中排除某些元素。对于Stream中包含的元素使用给定的过滤函数进行过滤操作，新生成的Stream只包含符合条件的元素
        //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去
        //除重复元素
        //limit(long maxSize) 截断流，使其元素不超过给定数量。
        //skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素
        //不足 n 个，则返回一个空流。与 limit(n) 互补
        //筛选出分数大于等于90的元素
        Stream<Student> studentStream = students.stream().filter(e->e.getSorce()>=90).distinct();
        studentStream .forEach(System.out::println);

        Map<String, Long> map1 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        //排序由大到小
        Map<String, Long> finalMap = new LinkedHashMap<>();
        map1.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        finalMap.forEach((s, aLong) -> System.out.println("name:"+s+",num:"+aLong));

        //按用户名分组，相同班级去重
        //方式一：
        Map<String,Integer> map3 = new HashMap<>();
        //用户名分组
        Map<String, List<Student>> map2 = students.stream().collect(Collectors.groupingBy(Student::getName));
        List<Student> record1 = new ArrayList<>();

        //相同班级去重
        for (Map.Entry<String, List<Student>> value : map2.entrySet()) {
            List<Student> value1 = value.getValue().stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()
                    -> new TreeSet<>(Comparator.comparing(Student::getClassName))), ArrayList::new));
            record1.addAll(value1);
            map3.put(value.getKey(),record1.size());
        }
            // Map<uid, num>
        map3.forEach((s, integer) -> System.out.println("name:"+s+",num:"+integer));
        //方式二：
        HashMap<String, Integer> map4 = new HashMap<>();
        for (String aLong : map2.keySet()) {
            List<Student> inviteUser = map.get(aLong).stream()
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
                            Comparator.comparing(e -> e.getClassName() + ";" + e.getName()))), ArrayList::new));
            map4.put(aLong, inviteUser.size());
        }
        final double a  = 3.141592;
        double b = 3.141592;

        //Variable used in lambda expression should be final or effectively final
//        DoubleUnaryOperator anotherDoubleUnaryOperator = x -> {
//            a = 2; // ERROR
//            b = 3; // ERROR
//            return 0.0;
//        };

        /**
         * 对于forEach ，当stream 为parallel的时候，是多个线程，并行处理的。因此输出的数据顺序不能保证。
         * 由于是并行处理，数据处理效率较高。
         *
         * 但是，对于操作共享变量的时候，需要注意安全问题，需要保证同步。
         */
        Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("forEach Output:"+s));
        Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s->System.out.println("forEachOrdered Output:"+s));

    }
}

/**
 * 用Collectors对List去重
 * https://www.cnblogs.com/xuwenjin/p/9660393.html
 */
class testCollectingAndThen{
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1,"zhangsan",null,18,60,"2020-05-16"),
                new Student(2,"lisi",null,18,59,"2020-05-16"),
                new Student(3,"lisi",null,18,100,"2020-05-16"),
                new Student(100,"wangwu",null,18,100,"2020-05-16"),
                new Student(3,"wangwu",null,18,100,"2020-05-16"),
                new Student(4,"wangwu",null,18,100,"2020-05-16"),
                new Student(5,"wangwu",null,18,100,"2020-05-17"),
                new Student(5,"wangwu",null,18,99,"2020-05-16"),
                new Student(14,"zhaoliu",null,18,80,"2020-05-16"));

        String[] productCodes = null;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getClassName() != null){

                productCodes[i] = students.get(i).getClassName();
            }
        }
        System.out.println(JSON.toJSONString(productCodes));


//        List<Student> students1 = new ArrayList<>();
//        students1 = students.stream().collect(Collectors.collectingAndThen(
//                Collectors.toCollection(() -> new TreeSet<>
//                        (Comparator.comparing(Student::getName))),ArrayList::new));
//        students1.forEach(student -> System.out.println("id:" + student.getId() + ", name:" + student.getName()));
//        System.out.println("============================================");
//        //根据多个属性去重
//        List<Student> students2 = students.stream().collect(Collectors.collectingAndThen(
//                Collectors.toCollection(() -> new TreeSet<>(
//                        Comparator.comparing(student -> student.getName() +";"+ student.getClassName()))),ArrayList::new));
//        students2.forEach(student -> System.out.println("id:" + student.getId() + ", name:" + student.getName()));
//
//        //start,end分别是第几个到第几个。
//        System.out.println(students.subList(1,3));
//        String a =null;
//        String b = null;
//        //不会空指针
//        System.out.println(a+","+b);
//        //NullPointerException
//        System.out.println(a.concat(b));
    }
    /**
     * 分支合并
     * https://www.cnblogs.com/sxdcgaq8080/p/9293954.html
     */
}

/**
 * java8 Stream分页
 */
class StreamPageTest{
    public static void main(String[] args) {
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

        Integer pageNum=2;
        Integer pageSize=4;
        filterByPage(students,pageNum,pageSize);
    }

    /**
     * 分页方法
     * https://blog.csdn.net/acdhkf/article/details/102928885
     * @param list 数据集合
     * @param pageNum 页码
     * @param pageSize 条数
     * @return
     */
    public static List filterByPage(List list, Integer pageNum, Integer pageSize){
        Object collect = list.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        return (List) collect;
    }

}