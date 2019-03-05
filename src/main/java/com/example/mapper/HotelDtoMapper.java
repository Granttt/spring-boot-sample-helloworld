/**
 * 
 */
package com.example.mapper;

import java.util.List;

import com.example.domain.Person;

/**
 * @Project:spring-boot-sample-helloworld  
 * @Class:HotelDtoMapper 
 * @author 高希阳
 * @date 2018-7-3 下午1:49:11   
 * @version 1.0.0 
 * @Description: 
 */
public interface HotelDtoMapper {
	
	public List<Person> findByName(String country);

}
