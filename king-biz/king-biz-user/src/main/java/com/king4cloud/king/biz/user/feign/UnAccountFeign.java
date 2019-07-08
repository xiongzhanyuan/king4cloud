package com.king4cloud.king.biz.user.feign;

import com.king4cloud.common.core.message.BaseResponse;
import com.king4cloud.king.biz.user.feign.fallback.UnAccountFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "king-biz-account", fallback = UnAccountFallBack.class)
public interface UnAccountFeign {

    @PostMapping(value = "/createAccount")
    BaseResponse createAccount(@RequestParam("customerId") String customerId, @RequestParam("customerType") String customerType);

}
