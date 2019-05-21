package com.king4cloud.common.core.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtUserTokenProperties {
    private int expire;
    private String userSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;

}
