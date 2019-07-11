package com.king4cloud.auth.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.king4cloud.common.core.base.BaseService;
import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.orm.mapper.SysUserMapper;
import com.king4cloud.orm.model.SysUser;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends BaseService<SysUserMapper, SysUser> {

    public SysUser getByUsername(String username) {
        return getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username).eq(SysUser :: getDelFlag, CommonConstants.DelFlag.VALID), true);
    }

}
