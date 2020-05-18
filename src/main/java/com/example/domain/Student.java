package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author GXY
 * @Package com.example.domain
 * @date 2020/5/16 12:52
 * @Copyright © 2020-2021 新流通
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String className;
    private int age;
    private int sorce;
    private String time;
}
