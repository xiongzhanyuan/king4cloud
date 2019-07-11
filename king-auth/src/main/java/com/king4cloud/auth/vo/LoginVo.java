package com.king4cloud.auth.vo;

import com.king4cloud.common.core.constant.CommonConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVo {
    private String token;
    private String username;
    private CommonConstants.LoginType loginType; // 登陆类型
}
