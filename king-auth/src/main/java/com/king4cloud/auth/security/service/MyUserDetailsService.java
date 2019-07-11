package com.king4cloud.auth.security.service;

import cn.hutool.core.util.ObjectUtil;
import com.king4cloud.auth.security.MyUserDetails;
import com.king4cloud.common.core.context.ContextInfoHandler;
import com.king4cloud.auth.service.SysUserService;
import com.king4cloud.orm.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService, Serializable {


    @Autowired
    private SysUserService sysUserService;

    //后台登陆认证
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.getByUsername(username);

        if (ObjectUtil.isNull(sysUser)) {
            log.info("sysUser未查询到信息");
            throw new UsernameNotFoundException("用户不存在或密码错误");
        }

        ContextInfoHandler.setUserId(sysUser.getId());
        ContextInfoHandler.setUserName(sysUser.getUsername());

        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setId(sysUser.getId());
        myUserDetails.setUsername(sysUser.getUsername());
        myUserDetails.setPassword(sysUser.getPassword());
        myUserDetails.setEnabled(true);

        myUserDetails.setLoginType(sysUser.getType());

        return myUserDetails;
    }
}
