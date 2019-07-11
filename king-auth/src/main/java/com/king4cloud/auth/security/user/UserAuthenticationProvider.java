package com.king4cloud.auth.security.user;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author guoqianyou
 * @date 2018-11-14 14:27
 */
public class UserAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return super.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return  (UserAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
