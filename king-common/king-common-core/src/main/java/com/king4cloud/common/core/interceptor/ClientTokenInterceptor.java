package com.king4cloud.common.core.interceptor;

import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.common.core.context.ContextInfoHandler;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ace on 2017/9/12.
 */
@Slf4j
public class ClientTokenInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            System.out.println(Thread.currentThread().getName());
            requestTemplate.header(CommonConstants.AUTHORIZATION, ContextInfoHandler.getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
