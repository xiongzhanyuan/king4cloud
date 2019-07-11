package com.king4cloud.auth.security;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.king4cloud.common.core.context.ContextInfoHandler;
import com.king4cloud.common.core.utils.JWTInfo;
import com.king4cloud.common.core.utils.JwtUserTokenUtil;
import com.king4cloud.auth.security.service.MyUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserTokenUtil jwtUserTokenUtil;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            Cookie[] cookies = httpServletRequest.getCookies();
            String token = "";
            if(ObjectUtil.isNotNull(cookies)) {
                for (Cookie cookie : cookies) {
                    if ("Authorization".equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }

            //判断是否有token
            if (StrUtil.isBlank(token)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }


            JWTInfo infoFromToken=null;
            try {
                infoFromToken = jwtUserTokenUtil.getInfoFromToken(token);
            }catch (ExpiredJwtException e){
                infoFromToken=new JWTInfo(null,null,null);
            }

//            if (StrUtil.isBlank(infoFromToken.getUnId()) && !"SAAS".equals(infoFromToken.getUserClassType())) {
//                httpServletResponse.setCharacterEncoding("UTF-8");
//                httpServletResponse.setContentType("application/json; charset=utf-8");
//                httpServletResponse.setStatus(HttpStatus.HTTP_FORBIDDEN);
//                httpServletResponse.getWriter().write(JSON.toJSONString(new BaseResponse(CommonConstants.ResponseStatus.NEED_LOGIN, "请重新登陆")));
//                return;
//            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = null;
                userDetails = myUserDetailsService.loadUserByUsername(infoFromToken.getUsername());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            ContextInfoHandler.remove();
        }

    }

}
