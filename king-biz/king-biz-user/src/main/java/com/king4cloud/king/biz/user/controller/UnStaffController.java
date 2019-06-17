package com.king4cloud.king.biz.user.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.king4cloud.common.core.message.BaseResponse;
import com.king4cloud.common.core.message.DataResponse;
import com.king4cloud.king.biz.user.service.UnStaffService;
import com.king4cloud.king.orm.model.UnStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnStaffController {
    @Autowired
    private UnStaffService unStaffService;
    @RequestMapping("/unstaff/list")
    public DataResponse list() {
        UnStaff b0306038 = unStaffService.getOne(Wrappers.<UnStaff>lambdaQuery().eq(UnStaff::getStaffCode, "B0306038"));
        return new DataResponse(b0306038);
    }

    @RequestMapping("/unstaff/regist")
    public BaseResponse regist(@RequestBody UnStaff unStaff) {

        unStaffService.regist(unStaff);

        return new BaseResponse("注册成功");

    }
}
