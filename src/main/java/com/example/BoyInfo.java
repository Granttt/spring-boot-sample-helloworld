/**
 * 
 */
package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project:spring-boot-sample-helloworld  
 * @Class:BoyInfo 
 * @author 高希阳
 * @date 2017-10-23 下午6:00:02   
 * @version 1.0.0 
 */
@Component  //注入实体bean的注解
@ConfigurationProperties(prefix="boy")//获取前缀为boy的属性
public class BoyInfo {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
