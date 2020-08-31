package com.example.utils.redis;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GXY
 * @Package com.example.utils.redis
 * @date 2020/8/31 10:37
 * @Copyright © 2020-2021 新流通
 * @Description: redis 工具类
 */
@Component
public class StringRedisUtils {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 通过管道pop方式批量取出redis中的元素
     * @param key redis key
     * @param count 需要取出的数量
     * @return
     */
    public List<Object> lBatchPop(String key, int count){
        return stringRedisTemplate.executePipelined(
                (RedisCallback<Object>) redisConnection -> {
                    for (int i = 0; i < count; i++) {
                        redisConnection.lPop(key.getBytes());
                    }
                    return null;
                }
        );
    }
}
