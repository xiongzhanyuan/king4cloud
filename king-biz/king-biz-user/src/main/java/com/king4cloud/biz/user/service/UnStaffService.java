package com.king4cloud.biz.user.service;

import com.king4cloud.biz.user.feign.UnAccountFeign;
import com.king4cloud.common.core.base.BaseService;
import com.king4cloud.common.core.message.BaseResponse;
import com.king4cloud.orm.mapper.UnStaffMapper;
import com.king4cloud.orm.model.UnStaff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UnStaffService extends BaseService<UnStaffMapper, UnStaff> {

    @Autowired
    private UnAccountFeign unAccountFeign;

    public void regist(UnStaff unStaff) {
//        Assert.isTrue(false,"123");
//        this.save(unStaff);
        System.out.println("当前线程regist:" + Thread.currentThread().getName());

        BaseResponse response = unAccountFeign.createAccount("123123", "STAFF");

        log.info("返回结果:{}", response);

    }

}
