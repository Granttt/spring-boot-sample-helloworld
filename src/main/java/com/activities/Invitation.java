package com.activities;
import java.util.Date;
import lombok.Data;

/**
 * @文件名称：Invitation.java
 * @创建时间：2020-04-26 09:53:40
 * @创  建  人：gxy 
 * @文件描述：实体类
 * @文件版本：V0.01 
 */@Data
public class Invitation{
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 类型：1-邀请函，0-其他
	 */
	private Integer type;
	/**
	 * 邀请函图片url
	 */
	private String picUrl;
	/**
	 * 邀请函类型：‘’KHY，"YDY"
	 */
	private String inviteType;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序 由小到大
	 */
	private Integer sort;
	/**
	 * 启用禁用：0-禁用，1-启用
	 */
	private Integer isEnabled;
	/**
	 * 编号（暂时不用）
	 */
	private String code;
	/**
	 * 数据创建时间
	 */
	private Date createTime;
	/**
	 * 数据创建人
	 */
	private Long createUser;
	/**
	 * 最后修改时间
	 */
	private Date updateTime;
	/**
	 * 最后修改人
	 */
	private Long updateUser;
}

