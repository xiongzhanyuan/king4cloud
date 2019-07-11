package com.king4cloud.auth.security;

import com.king4cloud.common.core.constant.CommonConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
public class MyUserDetails implements UserDetails, Serializable {

    private String id;
    private String username;
    private String password;
    private boolean enabled;
    private CommonConstants.LoginType loginType; // 登陆类型
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
