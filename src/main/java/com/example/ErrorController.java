package com.example;

import com.example.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxi
 * @title: ErrorController
 * @projectName spring-boot-sample-helloworld
 * @description: TODO
 * @date 2020/04/13 15:32
 */
@Slf4j
@RestController
public class ErrorController {

    //排序
    @RequestMapping("/errortest")
    public List<String> sort(){
        log.debug("sort 开始");
        List<String> people=new ArrayList<>();
        people.add("a");
        people.add("b");
        people.add("c");
        people.add("e");
        log.debug("sort 结束");
        return people;
    }
    //排序
    @RequestMapping("/error2")
    public List<String> errortest(){

//            int i=1/0;

        log.debug("sort 开始");
        List<String> people=new ArrayList<>();
        people.add("a");
        people.add("b");
        people.add("c");
        people.add("e");
        log.debug("sort 结束");

        return people;
    }
}
