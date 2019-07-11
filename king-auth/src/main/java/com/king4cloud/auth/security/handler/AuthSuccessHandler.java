package com.king4cloud.auth.security.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.king4cloud.auth.security.MyUserDetails;
import com.king4cloud.auth.vo.LoginVo;
import com.king4cloud.common.core.message.DataResponse;
import com.king4cloud.common.core.utils.JWTInfo;
import com.king4cloud.common.core.utils.JwtUserTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUserTokenUtil jwtUserTokenUtil;


    //登陆成功返回
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.HTTP_OK);

        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

        LoginVo loginVo = new LoginVo();
        //这里应该判断 如果进来的是后台 则USER_CLASS_TYPE_ADMIN   前台则 USER_CLASS_TYPE_USER
        loginVo.setToken(jwtUserTokenUtil.generateToken(new JWTInfo(myUserDetails.getId(), myUserDetails.getUsername(), myUserDetails.getLoginType().toString())));
        loginVo.setUsername(myUserDetails.getUsername());
        loginVo.setLoginType(myUserDetails.getLoginType());
        httpServletResponse.getWriter().write(JSON.toJSONString(new DataResponse<>(loginVo)));
    }
}
