package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Emp;

/**
 * @Author: gaoxi
 * @CreateDate: 2019/10/24 10:26
 * @Description:
 */
public class JsonMainTest {
    public static void main(String[] args) {
        Emp emp=new Emp();
        emp.setId(1);
        emp.setName("张三");
        emp.setGender("男");
        emp.setDptNo(001);
        emp.setDuty("职员");

        //Java对象转化为JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(emp);
        System.out.println("Java对象转化为JSON对象\n" + jsonObject);

        //Java对象转换成JSON字符串
        String stuString = JSONObject.toJSONString(emp);
        System.out.println("Java对象转换成JSON字符串\n" + stuString);

    }
}