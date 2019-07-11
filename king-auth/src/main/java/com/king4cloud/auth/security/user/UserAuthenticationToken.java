package com.king4cloud.auth.security.user;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author guoqianyou
 * @date 2018-11-14 14:28
 */
public class UserAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public UserAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public UserAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
