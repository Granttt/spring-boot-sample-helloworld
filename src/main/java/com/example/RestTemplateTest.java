package com.example;

import org.springframework.web.client.RestTemplate;

/**
 * @author GXY
 * @Package com.example
 * @date 2020/9/27 18:32
 * @Copyright © 2020-2021 新流通
 * @Description:SpringBoot系列 - 使用RestTemplate
 * https://blog.csdn.net/qq_31491785/article/details/80249917
 */
public class RestTemplateTest {
    public static void main(String[] args) {
        RestTemplate restT = new RestTemplate();
        //通过Jackson JSON processing library直接将返回值绑定到对象
        String quoteString = restT.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
        System.out.println(quoteString);
    }
}
