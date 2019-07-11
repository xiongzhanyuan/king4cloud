package com.king4cloud.auth.security.user;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAuthFilter extends UsernamePasswordAuthenticationFilter {

    public UserAuthFilter() {
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/sys/login", "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("GET")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        if (StrUtil.isBlank(username)) {
            throw new AuthenticationServiceException("用户名不能为空！");
        }

        if (StrUtil.isBlank(password)) {
            throw new AuthenticationServiceException("密码不能为空！");
        }

        username = username.trim();

        UserAuthenticationToken authRequest = new UserAuthenticationToken(
                username, password);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }
}
