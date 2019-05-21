package com.king4cloud.common.core.base;
import cn.hutool.core.convert.Convert;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class BaseRedisService implements InitializingBean {

    private final StringRedisTemplate redisTemplate;

    private static StringRedisTemplate outerRedisTemplate;

    public static StringRedisTemplate getRedisTemplate() {
        return outerRedisTemplate;
    }

    @Autowired
    public BaseRedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object value, long timeoutForSeconds){
        redisTemplate.opsForValue().set(key, Convert.toStr(value), timeoutForSeconds, TimeUnit.SECONDS);
    }

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, Convert.toStr(value));
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

    public void deleteKeys(List<String> keys){
        redisTemplate.delete(keys);
    }

    public String getString(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public Integer getInt(String key){
        return Convert.toInt(redisTemplate.opsForValue().get(key));
    }

    public Long getLong(String key){
        return Convert.toLong(redisTemplate.opsForValue().get(key));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        outerRedisTemplate = redisTemplate;
    }
}
