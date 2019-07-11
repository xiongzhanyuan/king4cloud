package com.king4cloud.biz.user.feign.fallback;

import com.king4cloud.common.core.message.BaseResponse;
import com.king4cloud.biz.user.feign.UnAccountFeign;
import org.springframework.stereotype.Component;

@Component
public class UnAccountFallBack implements UnAccountFeign {
    @Override
    public BaseResponse createAccount(String customerId, String customerType) {

        return new BaseResponse("调用account异常");
    }
}
