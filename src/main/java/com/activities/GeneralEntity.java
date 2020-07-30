package com.activities;

import lombok.Data;

import java.util.Date;

/**
 * @program: lead-server
 * @description: 行为通用
 * @author: Mr.G
 * @create: 2020-05-30 13:27
 **/
@Data
public class GeneralEntity {

    private String layoutModuleTape;//版面模块标识
    private String layoutModuleName;//版面模块名称
    private String serverKey;//服务标识 如ZDD
    private String terminalKey;//终端标识 [APP移动端][WX小程序端][PC网页端][SERVER服务端][TUNNEL后门]

    private Long userId;//用户id
    private String nickName;//昵称
    private String phone;//联系方式

    private String wxOpenId;//用户微信OpenId
    private String wxId;//用户微信号
    private String wxNickName;//用户微信昵称

    private Integer behaviorType;//行为类型 源于BehaviorEnum
    private String behaviorName;//行为名称 源于BehaviorEnum
    private Integer behaviorLength;//行为时长
    private String behaviorDescribe;//行为描述 [用户]于[时间]进行了[行为+业务]

    /** 基础字段 */
    private Date createTime;//创建时间

}
