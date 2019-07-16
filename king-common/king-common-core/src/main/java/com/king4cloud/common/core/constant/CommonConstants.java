package com.king4cloud.common.core.constant;


public class CommonConstants {

    public enum ResponseStatus {
        SUCCESS, FAIL, ERROR, UNAUTH, NOT_FOUND, FORBIDDEN, NEED_LOGIN
    }

    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_IP = "currentIp";
    public static final String CONTEXT_KEY_USER_NAME = "currentUserName";
    public static final String CONTEXT_KEY_CAMPUS_ID = "currentCampusId";

    public static final String AUTHORIZATION = "Authorization";
    public final static String CLIENT_TOKEN_USER = "ClientTokenUser";
    public final static String CLIENT_TOKEN = "ClientToken";

    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_LOGIN_TYPE = "type";

    public enum DelFlag {
        /**
         * 有效
         */
        VALID,
        /**
         * 无效
         */
        INVALID
    }

    public enum LoginStatus {
        NEEDLOGIN,
        LOGIN
    }

    public enum LoginType {
        /**
         * 后台管理
         */
        ADMIN,
        /**
         * 用户
         */
        USER,
    }

}
