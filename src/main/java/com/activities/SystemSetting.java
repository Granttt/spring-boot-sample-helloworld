package com.activities;
import java.util.Date;
import java.sql.*;
import lombok.Data;

/**
 * @文件名称：SystemSetting.java
 * @创建时间：2019-12-21 15:24:53
 * @创  建  人：gxy 
 * @文件描述：system_setting 实体类
 * @文件版本：V0.01 
 */@Data
public class SystemSetting{
	private Long id;	//
	private String systemCode;	//系统代码（不用）
	private String name;	//描述
	private String h5Www;	//h5地址
	private String ossPicWww;	//oss地址
	private String cancelSwitch;	//注销开关:false-关闭，true-开启
	private String updateUser;	//
	private Date updateTime;	//
	private String tagStr1;	//
	private String tagStr2;	//
	private String tagStr3;	//
}

