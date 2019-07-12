package com.king4cloud.common.core;

public interface IAuthService {

    /**
     * 调用签权服务，判断用户是否有权限
     */
    boolean hasPermission(String authentication, String url);

    /**
     * 是否无效token
     *
     * @param token
     * @return
     */
    boolean invalidJwtAccessToken(String token);

}
