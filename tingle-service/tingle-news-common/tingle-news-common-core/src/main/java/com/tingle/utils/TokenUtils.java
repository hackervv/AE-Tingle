package com.tingle.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/19:56
 * @Description:
 */
@Component
public class TokenUtils {
    @Autowired
    private RedisUtil redisUtil;
    
    /**
     * @param value
     * @param timeOut
     * @return
     */
    public String createToken(String prefix, String value, Long timeOut) {
        //create token
        String token = prefix + "_" + UUID.randomUUID().toString().replace("-", "");
        redisUtil.setString(token, value, timeOut);
        return token;
    }
    
    public String createToken(String prefix, String value) {
        return createToken(prefix, value, null);
    }
    
    public String getTokenValue(String token) {
        return redisUtil.getString(token);
    }
}
