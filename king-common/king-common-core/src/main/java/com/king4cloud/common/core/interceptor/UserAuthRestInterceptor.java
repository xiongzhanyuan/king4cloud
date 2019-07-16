package com.king4cloud.common.core.interceptor;

import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.common.core.context.ContextInfoHandler;
import com.king4cloud.common.core.utils.JWTInfo;
import com.king4cloud.common.core.utils.JwtUserTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUserTokenUtil jwtUserTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String token = request.getHeader(CommonConstants.AUTHORIZATION);

        JWTInfo infoFromToken = jwtUserTokenUtil.getInfoFromToken(token);
        ContextInfoHandler.setUserId(infoFromToken.getUserId());
        ContextInfoHandler.setUserName(ContextInfoHandler.getUserName());
        ContextInfoHandler.setToken(token);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ContextInfoHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
