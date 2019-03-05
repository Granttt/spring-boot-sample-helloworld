package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @auther: 高希阳
 * @Date: 2018/12/27 15:14
 * @Description:
 *   ● @Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
 *   ● @CachePut，指定key，将更新的结果同步到redis中
 *   ● @CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 * SpringBoot 使用 Redis 缓存(2)
 */
@CacheConfig(cacheNames = "users")
@Mapper
public interface UserMapper {

    @Insert("insert into user(id,name,age) values(#{id},#{name},#{age})")
    int addUser(@Param("name")String name,@Param("age")String age);



    @Select("select * from user where id =#{id}")
    @Cacheable(key ="#p0")
    User findById(String keyRedis);



    @CachePut(key = "#p0")
    @Update("update user set name=#{name} where id=#{id}")
    void updataById(@Param("id")String id,@Param("name")String name);



    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    @Delete("delete from user where id=#{id}")
    void deleteById(String keyRedis);

}
