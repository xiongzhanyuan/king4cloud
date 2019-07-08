package com.king4cloud.king.biz.account.rpc;

import com.king4cloud.common.core.message.BaseResponse;
import com.king4cloud.king.biz.account.service.UnAccountService;
import com.king4cloud.king.orm.model.UnAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnAccountRpc {

    @Autowired
    private UnAccountService unAccountService;

    @PostMapping("/createAccount")
    public BaseResponse createAccount(@RequestParam("customerId") String customerId, @RequestParam("customerType") String customerType) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new BaseResponse("创建成功");
    }

}
