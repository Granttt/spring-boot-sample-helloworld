/**
 * 
 */
package com.example;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project:spring-boot-sample-helloworld  
 * @Class:TestPerson 
 * @author 高希阳
 * @date 2017-10-26 下午12:13:32   
 * @version 1.0.0 
 */
@RestController
public class TestPerson {

	//绑定PersonalValidator  
	@InitBinder  
	public void initBinder(WebDataBinder webDataBinder){  
	    webDataBinder.addValidators(new PersonalValidto());  
	}  
	
	@RequestMapping(value = "testPersonalValidtor.do")  
	@ResponseBody  
	//直接返回对象  
	public Object testPersonalValidtor(@Valid BoyInfo personScope, BindingResult bindingResult){  
	    if(bindingResult.hasErrors()){  
	        StringBuffer sb = new StringBuffer();  
	        for(ObjectError objectError : bindingResult.getAllErrors()){  
	            sb.append(((FieldError)objectError).getField() +" : ").append(objectError.getDefaultMessage());  
	        }  
	        return sb.toString();  
	    }else{  
	        return personScope;  
	    }  
	}  
}
