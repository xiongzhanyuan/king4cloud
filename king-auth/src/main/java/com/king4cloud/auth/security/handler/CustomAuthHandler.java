package com.king4cloud.auth.security.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.common.core.message.BaseResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//解决未登录用户权限
@Component
public class CustomAuthHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/javascript;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
        httpServletResponse.getWriter().write(JSON.toJSONString(new BaseResponse(CommonConstants.ResponseStatus.UNAUTH, "您没有登陆，禁止访问")));
    }
}
