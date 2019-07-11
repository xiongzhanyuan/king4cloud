package com.king4cloud.common.core.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class JWTInfo implements Serializable {

    private static final long serialVersionUID = -6612124193461243383L;

    private String userId;
    private String username;
    private String loginType;

    public JWTInfo(String userId,String username,String loginType) {
        this.userId = userId;
        this.username = username;
        this.loginType = loginType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JWTInfo jwtInfo = (JWTInfo) o;

        if (userId != null ? !userId.equals(jwtInfo.userId) : jwtInfo.userId != null) return false;
        if (username != null ? !username.equals(jwtInfo.username) : jwtInfo.username != null) return false;
        return loginType != null ? loginType.equals(jwtInfo.loginType) : jwtInfo.loginType == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (loginType != null ? loginType.hashCode() : 0);
        return result;
    }
}
