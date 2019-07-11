package com.king4cloud.auth.config;


import com.king4cloud.auth.security.JwtAuthenticationTokenFilter;
import com.king4cloud.auth.security.handler.AuthFailHandler;
import com.king4cloud.auth.security.handler.AuthSuccessHandler;
import com.king4cloud.auth.security.handler.CustomAccessDeineHandler;
import com.king4cloud.auth.security.handler.CustomAuthHandler;
import com.king4cloud.auth.security.user.UserSecurityConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //登陆后 没有权限
    @Autowired
    private CustomAccessDeineHandler customAccessDeineHandler;

    //匿名用户 没有权限
    @Autowired
    private CustomAuthHandler customAuthHandler;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthFailHandler authFailHandler;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private UserSecurityConfigurer userSecurityConfigurer;



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // 加入自定义的安全认证
//        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()




                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 使用JWT ， 关闭token
                .and()
                .httpBasic().authenticationEntryPoint(customAuthHandler) //AuthenticationEntryPoint 解决匿名用户权限  accessDeniedHandler 解决登陆用户没有权限问题
                .and()
                .authorizeRequests()
//                .antMatchers("/sys/login").permitAll() //所有用户都可以访问
                //swagger start
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                .antMatchers("/wx/portal/**").permitAll()
                //swagger end
                .anyRequest()
                .access("@rbacauthorityservice.hasPermission(request,authentication)") // RBAC 动态 url 认证
                .and()
                .formLogin()
                .successHandler(authSuccessHandler)
                .failureHandler(authFailHandler)
                .permitAll();
        httpSecurity.exceptionHandling().accessDeniedHandler(customAccessDeineHandler);// 无权访问 JSON 格式的数据

        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity.apply(userSecurityConfigurer);

    }


}
