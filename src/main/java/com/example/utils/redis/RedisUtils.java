package com.example.utils.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @program: api-server
 * @description: redis 以及 相关json操作
 * @author: wangxingchao
 * @create: 2020/4/24 下午4:19
 **/
public class RedisUtils {

    /* *
     * @description: 获取对象
     * @author: : wangxingchao
     * @create: 2020/4/24 下午4:26
     */
    public static <T> T getObject(StringRedisTemplate template, String key, Class<T> clazz) {
        Boolean hasKey = template.hasKey(key);
        if (hasKey != null && hasKey) {
            String json = template.opsForValue().get(key);
            return JSON.parseObject(json, clazz);
        }
        return null;
    }

    /* *
     * @description: set对象
     * @author: : wangxingchao
     * @create: 2020/4/24 下午4:26
     */
    public static void setObject(StringRedisTemplate template, String key, Object object) {
        if (object != null && StringUtils.isNotEmpty(key)) {
            template.opsForValue().set(key, JSON.toJSONString(object));
        }
    }

    /* *
     * @description: 移除key
     * @author: : wangxingchao
     * @create: 2020/5/2 下午7:15
     */
    public static void delObject(StringRedisTemplate template, String key){
        if (!StringUtils.isEmpty(key)) {
            template.delete(key);
        }
    }

}
