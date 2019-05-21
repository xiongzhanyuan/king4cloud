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
    private String unId;
    private String campusId;
    private String userClassType;

    public JWTInfo(String userId,String username,String unId, String campusId, String userClassType) {
        this.userId = userId;
        this.username = username;
        this.unId = unId;
        this.campusId = campusId;
        this.userClassType = userClassType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JWTInfo)) return false;

        JWTInfo jwtInfo = (JWTInfo) o;

        if (!userId.equals(jwtInfo.userId)) return false;
        if (!username.equals(jwtInfo.username)) return false;
        if (!unId.equals(jwtInfo.unId)) return false;
        if (!campusId.equals(jwtInfo.campusId)) return false;
        return userClassType.equals(jwtInfo.userClassType);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + unId.hashCode();
        result = 31 * result + campusId.hashCode();
        result = 31 * result + userClassType.hashCode();
        return result;
    }
}
