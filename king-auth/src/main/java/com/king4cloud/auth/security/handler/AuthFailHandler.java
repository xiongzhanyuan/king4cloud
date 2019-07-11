package com.king4cloud.auth.security.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.common.core.message.BaseResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailHandler implements AuthenticationFailureHandler {

    //登陆失败返回
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.HTTP_OK);
        httpServletResponse.getWriter().write(JSON.toJSONString( new BaseResponse(CommonConstants.ResponseStatus.FAIL,"账号或密码错误")));
    }
}
