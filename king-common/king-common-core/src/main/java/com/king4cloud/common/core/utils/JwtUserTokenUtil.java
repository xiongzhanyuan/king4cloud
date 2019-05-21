package com.king4cloud.common.core.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.KeyPair;

@Component
public class JwtUserTokenUtil {
    private static String USERSECRET_DEFAULT = "USERSECRET_DEFAULT";
    @Autowired
    private JwtUserTokenProperties jwtUserTokenProperties;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String REDIS_SERVICE_PRI_KEY = "SECRET_PRI_KEY";
    private static final String REDIS_SERVICE_PUB_KEY = "SECRET_PUB_KEY";

    @PostConstruct
    public void init() {
        if (StrUtil.isBlank(jwtUserTokenProperties.getUserSecret())) {
            jwtUserTokenProperties.setUserSecret(USERSECRET_DEFAULT);
        }
        if (jwtUserTokenProperties.getExpire() == 0) {
            jwtUserTokenProperties.setExpire(60 * 60 * 24);
        }

        if (redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)) {
            jwtUserTokenProperties.setUserPubKey((byte[]) redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY));
            jwtUserTokenProperties.setUserPriKey((byte[]) redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY));

        } else {
            KeyPair rsa = SecureUtil.generateKeyPair("RSA", 2048, jwtUserTokenProperties.getUserSecret().getBytes());
            jwtUserTokenProperties.setUserPubKey(rsa.getPublic().getEncoded());
            jwtUserTokenProperties.setUserPriKey(rsa.getPrivate().getEncoded());
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, rsa.getPrivate().getEncoded());
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, rsa.getPublic().getEncoded());
        }


    }

    public String generateToken(JWTInfo jwtInfo) {
        return JWTHelper.generateToken(jwtInfo, jwtUserTokenProperties.getUserPriKey(), jwtUserTokenProperties.getExpire());
    }

    public JWTInfo getInfoFromToken(String token) {
        return JWTHelper.getInfoFromToken(token, jwtUserTokenProperties.getUserPubKey());
    }


}
