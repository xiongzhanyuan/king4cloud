package com.king4cloud.king.biz.user.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.king4cloud.common.core.message.BaseResponse;
import com.king4cloud.common.core.message.DataResponse;
import com.king4cloud.king.biz.user.service.UnStaffService;
import com.king4cloud.king.orm.model.UnStaff;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class UnStaffController {
    @Autowired
    private UnStaffService unStaffService;
    @GetMapping("/unstaff/list")
    public DataResponse list() {
        System.out.println("当前线程list:" + Thread.currentThread().getName());

        UnStaff b0306038 = unStaffService.getOne(Wrappers.<UnStaff>lambdaQuery().eq(UnStaff::getStaffCode, "B0306038"));
        return new DataResponse(b0306038);
    }

    @PostMapping("/unstaff/regist")
    public BaseResponse regist(@RequestBody UnStaff unStaff) {
        System.out.println("当前线程regist:" + Thread.currentThread().getName());
        unStaffService.regist(unStaff);

        return new BaseResponse("注册成功");

    }

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
