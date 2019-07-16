package com.king4cloud.common.core.context;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import com.king4cloud.common.core.constant.CommonConstants;

import java.util.HashMap;
import java.util.Map;


public class ContextInfoHandler {

    private static ThreadLocal<Map<String, Object>> threadLocal = new InheritableThreadLocal<>();

    private static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();

        if (MapUtil.isEmpty(map)) {
            map = new HashMap<>();
            threadLocal.set(map);
        }

        map.put(key, value);

    }

    private static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (CollectionUtil.isEmpty(map)) {
            map = new HashMap<>();
        }
        return map.get(key);
    }

    public static void setIp(String ip) {
        set(CommonConstants.CONTEXT_KEY_IP, ip);
    }

    public static String getIp() {
        return (String) get(CommonConstants.CONTEXT_KEY_IP);
    }

    public static void setUserId(String userId) {
        set(CommonConstants.CONTEXT_KEY_USER_ID, userId);
    }

    public static String getUserId() {
        return (String) get(CommonConstants.CONTEXT_KEY_USER_ID);
    }

    public static void setUserName(String userName) {
        set(CommonConstants.CONTEXT_KEY_USER_NAME, userName);
    }

    public static String getUserName() {
        return (String) get(CommonConstants.CONTEXT_KEY_USER_NAME);
    }

    public static String getToken() {
        return (String) get(CommonConstants.AUTHORIZATION);
    }

    public static void setToken(String token) {
        set(CommonConstants.AUTHORIZATION, token);
    }

    public static void remove(){
        threadLocal.remove();
    }
}
