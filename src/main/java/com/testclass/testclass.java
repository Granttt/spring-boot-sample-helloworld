package com.testclass;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: java类作用描述
 * @Author: gaoxi
 * @CreateDate: 2019/4/4 18:03
 * @UpdateUser: gxy
 * @UpdateDate: 2019/4/4 18:03
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class testclass {
    public static void changeStr(String str){
        str="welcome";
    }
    public static void changeObject(ObjectClass object){
        object=new ObjectClass("welcome");
    }

    public static void main(String[] args) {
        String str="1234";
        changeStr(str);
        System.out.println("StringValue:"+str);

        ObjectClass object= new ObjectClass(str);
        changeObject(object);
        System.out.println("ObjectVale:"+object.value);

        List<Long> salesmanIds = new ArrayList<>();
        salesmanIds.add(1L);
        salesmanIds.add(11L);
        salesmanIds.add(111L);
        salesmanIds.add(112L);
        salesmanIds.add(121L);
        List<Long> salesmanIds1 = new ArrayList<>();
        salesmanIds1.add(12L);
        List<Long> collect = salesmanIds.stream().filter(aLong -> salesmanIds1.contains(aLong)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }
}
class ObjectClass{
    String value=null;
    public ObjectClass(final String value){
        this.value=value;
    }
}