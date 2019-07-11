package com.king4cloud.auth.security.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.common.core.message.BaseResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//解决登陆 没有权限 问题
@Component
public class CustomAccessDeineHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.HTTP_FORBIDDEN);
        httpServletResponse.getWriter().write(JSON.toJSONString( new BaseResponse(CommonConstants.ResponseStatus.FORBIDDEN,"权限不足，禁止访问")));
    }
}
