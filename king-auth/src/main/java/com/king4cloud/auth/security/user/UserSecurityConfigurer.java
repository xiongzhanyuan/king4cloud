package com.king4cloud.auth.security.user;

import com.king4cloud.auth.security.service.MyUserDetailsService;
import com.king4cloud.auth.security.handler.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private AuthSuccessHandler authSuccessHandler;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    //后台登陆认证
    @Override
    public void configure(HttpSecurity builder) throws Exception {
        UserAuthFilter userAuthFilter = new UserAuthFilter();
        userAuthFilter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        userAuthFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        userAuthFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        UserAuthenticationProvider userAuthenticationProvider = new UserAuthenticationProvider();
        userAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        userAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        builder.authenticationProvider(userAuthenticationProvider)
                .addFilterAfter(userAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }
    

}
