package com.tingle.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/19:36
 * @Description:
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    /**
     * save string
     *
     * @param key     key
     * @param data
     * @param timeout
     */
    public void setString(String key, String data, Long timeout) {
        stringRedisTemplate.opsForValue().set(key, data);
        if (timeout != null) {
            stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
    }
    
    /**
     * save string
     *
     * @param key  key
     * @param data
     */
    public void setString(String key, String data) {
        setString(key, data, null);
    }
    
    /**
     * query by key
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }
    
    /**
     * del buy key
     *
     * @param key
     */
    public void delKey(String key) {
        stringRedisTemplate.delete(key);
    }
}
