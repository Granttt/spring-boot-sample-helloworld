package com.example.service;

import com.example.domain.ExceptionLog;
import com.example.domain.OperationLog;
import com.example.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author gaoxi
 * @title: OperationLogService
 * @projectName spring-boot-sample-helloworld
 * @description: TODO
 * @date 2020/04/15 15:21
 */
@Service
public class OperationLogService {
    @Autowired
    private OperationLogMapper operationLogMapper;

    public int insert(OperationLog operationLog){

        return operationLogMapper.insert(operationLog);

    }

    public int insertExc(ExceptionLog excepLog) {
        return operationLogMapper.insertExc(excepLog);
    }
}