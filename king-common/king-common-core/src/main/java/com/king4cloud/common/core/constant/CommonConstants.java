package com.king4cloud.common.core.constant;


public class CommonConstants {

    public enum ResponseStatus {
        SUCCESS, FAIL, ERROR, UNAUTH, NOT_FOUND, FORBIDDEN, NEED_LOGIN
    }

    public enum UserRole{
        CUSTOMER,
        ORGNIZATION,
        UNKNOWN
    }

    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_IP = "currentIp";
    public static final String CONTEXT_KEY_USER_NAME = "currentUserName";
    public static final String CONTEXT_KEY_UN_ID = "currentUnId";
    public static final String CONTEXT_KEY_CAMPUS_ID = "currentCampusId";
    public static final String CONTEXT_KEY_PURCHASE_TYPE_ID = "currentPurchaseTypeId";
    public static final String CONTEXT_KEY_CLASS_ID = "currentClassId";
    public static final String CONTEXT_KEY_CLASS_NAME = "currentClassName";
    public static final String CONTEXT_KEY_OPEN_ID = "currentOpenId";
    public static final String CONTEXT_KEY_LOGIN_TYPE = "currentLoginType";
    public static final String CONTEXT_KEY_UN_NAME = "currentUnName";



    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_USER_CLASS_TYPE = "type";

    public static final String REDIS_KEY_CURRENT_SEMESTER_ID = "currentSemesterId_";

    public static final String USER_CLASS_TYPE_ADMIN = "TYPE_OF_ADMIN";

}
