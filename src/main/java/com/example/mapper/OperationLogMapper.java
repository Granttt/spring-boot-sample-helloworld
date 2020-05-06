package com.example.mapper;

import com.example.domain.ExceptionLog;
import com.example.domain.OperationLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author gaoxi
 * @title: OperationLogDao
 * @projectName spring-boot-sample-helloworld
 * @description: TODO
 * @date 2020/04/15 15:22
 */
@Mapper
public interface OperationLogMapper {

    @Insert("insert into operation_log(oper_id,oper_modul,oper_type,oper_desc,oper_requ_parm,oper_resp_parm," +
            "oper_user_id,oper_user_name,oper_method,oper_uri,oper_ip,oper_create_time,oper_ver) " +
            "values(#{operId},#{operModul},#{operType},#{operDesc},#{operRequParm},#{operRespParm}," +
            "#{operUserId},#{operUserName},#{operMethod},#{operUri},#{operIp},#{operCreateTime},#{operVer})")
    int insert(OperationLog operationLog);

    @Insert("insert into exception_log(exc_id,exc_requ_param,exc_name,exc_message," +
            "oper_method,oper_uri,oper_ip,oper_create_time,oper_ver) " +
            "values(#{excId},#{excRequParam},#{excName},#{excMessage}," +
            "#{operMethod},#{operUri},#{operIp},#{operCreateTime},#{operVer})")
    int insertExc(ExceptionLog excepLog);
}