package com.king4cloud.biz.user.feign;

import com.king4cloud.biz.user.feign.fallback.UnAccountFallBack;
import com.king4cloud.common.core.config.FeignConfiguration;
import com.king4cloud.common.core.message.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "king-biz-account", fallback = UnAccountFallBack.class, configuration = FeignConfiguration.class)
public interface UnAccountFeign {

    @PostMapping(value = "/createAccount")
    BaseResponse createAccount(@RequestParam("customerId") String customerId, @RequestParam("customerType") String customerType);

}
