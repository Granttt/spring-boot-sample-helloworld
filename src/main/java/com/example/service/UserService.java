package com.example.service;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: 高希阳
 * @Date: 2018/12/27 15:26
 * @Description: redis test
 * SpringBoot 使用 Redis 缓存(3)
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(String keyRedis){

        return userMapper.findById(keyRedis);
    }
    public int addUser(String name,String age){

        return userMapper.addUser(name,age);

    }
    public void updataById(String id, String name){

        userMapper.updataById(id,name);

    }
    public void deleteById(String keyRedis){

        userMapper.deleteById(keyRedis);

    }
}
