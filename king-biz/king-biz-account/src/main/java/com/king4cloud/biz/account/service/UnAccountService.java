package com.king4cloud.biz.account.service;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.king4cloud.common.core.base.BaseService;
import com.king4cloud.orm.mapper.UnAccountMapper;
import com.king4cloud.orm.model.UnAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UnAccountService extends BaseService<UnAccountMapper, UnAccount> {

    /**
     * 创建单个账户
     */
    public void createAccount(String customerId, String customerType) {
        UnAccount account = this.getOne(Wrappers.<UnAccount>lambdaQuery().eq(UnAccount :: getCustomerId, customerId)
                .eq(UnAccount :: getCustomerType, customerType));
        Assert.isTrue(false, "错啦");
        if (ObjectUtil.isNull(account)) {
            UnAccount unAccount = new UnAccount();
            unAccount.setCustomerId(customerId);
            unAccount.setCustomerType(customerType);
            unAccount.setAccountAmount(new BigDecimal(0));
            unAccount.setAccountStatus("AVAILABLE");
            this.save(unAccount);
        }
    }

}
