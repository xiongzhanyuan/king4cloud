package com.king4cloud.auth.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

@Component("rbacauthorityservice")
public class RbacAuthorityService {

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //得到的principal的信息是用户名还是整个用户信息取决于在自定义的authenticationProvider中传参的方式
        Object userInfo = authentication.getPrincipal();

        boolean hasPermission = false;

        //用户校验该用户权限下可以访问的资源路径
        if (userInfo instanceof MyUserDetails) {
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //获取该权限下的urls列表 如果 访问的请求在urls 里 则可以访问 否则不可以访问

//            for (String url : urls) {
//                if (antPathMatcher.match(url, request.getRequestURI())) {
//                    hasPermission = true;
//                    break;
//                }
//            }
            hasPermission = true;
        } else {
            //说明未登陆 返回 customAuthEntryPoint
            return true;
        }

        return hasPermission;



    }

}
