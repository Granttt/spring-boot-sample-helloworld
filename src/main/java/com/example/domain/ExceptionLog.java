package com.example.domain;
import java.util.Date;
import lombok.Data;

/**
 * @文件名称：ExceptionLog.java
 * @创建时间：2020-04-16 16:10:50
 * @创  建  人：gxy 
 * @文件描述：实体类
 * @文件版本：V0.01 
 */
@Data
public class ExceptionLog{
	private Integer id;
	/**
	 * 编号
	 */
	private String excId;
	/**
	 * 请求参数
	 */
	private String excRequParam;
	/**
	 * 异常名称
	 */
	private String excName;
	/**
	 * 异常信息
	 */
	private String excMessage;
	/**
	 * 操作方法
	 */
	private String operMethod;
	/**
	 * 请求URI
	 */
	private String operUri;
	/**
	 * 请求IP
	 */
	private String operIp;
	/**
	 * 操作版本号
	 */
	private String operVer;
	/**
	 * 创建时间
	 */
	private Date operCreateTime;
}

