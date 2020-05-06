package com.example.domain;
import java.util.Date;
import lombok.Data;

/**
 * @文件名称：OperationLog.java
 * @创建时间：2020-04-15 14:39:26
 * @创  建  人：gxy 
 * @文件描述：实体类
 * @文件版本：V0.01 
 */
@Data
public class OperationLog{
	private Integer id;
	/**
	 * 编号
	 */
	private String operId;
	/**
	 * 功能模块
	 */
	private String operModul;
	/**
	 * 操作类型
	 */
	private String operType;
	/**
	 * 操作描述
	 */
	private String operDesc;
	/**
	 * 请求参数
	 */
	private String operRequParm;
	/**
	 * 返回参数
	 */
	private String operRespParm;
	/**
	 * 操作员id
	 */
	private String operUserId;
	/**
	 * 操作员名称
	 */
	private String operUserName;
	/**
	 * 操作方法
	 */
	private String operMethod;
	/**
	 * 请求URI
	 */
	private String operUri;
	/**
	 * 请求id
	 */
	private String operIp;
	/**
	 * 操作时间
	 */
	private Date operCreateTime;
	/**
	 * 操作版本号
	 */
	private String operVer;
}

