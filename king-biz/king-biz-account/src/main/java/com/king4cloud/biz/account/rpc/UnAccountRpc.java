package com.king4cloud.biz.account.rpc;

import com.king4cloud.biz.account.service.UnAccountService;
import com.king4cloud.common.core.context.ContextInfoHandler;
import com.king4cloud.common.core.message.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnAccountRpc {

    @Autowired
    private UnAccountService unAccountService;

    @PostMapping("/createAccount")
    public BaseResponse createAccount(@RequestParam("customerId") String customerId, @RequestParam("customerType") String customerType) {
        try {
            System.out.println("当前线程regist:" + Thread.currentThread().getName());
            System.out.println(ContextInfoHandler.getUserId());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new BaseResponse("创建成功");
    }

}
