package com.king4cloud.common.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.king4cloud.common.core.context.ContextInfoHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@ConditionalOnMissingBean(name = "MetaNoUse")
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createUserId", ContextInfoHandler.getUserId(), metaObject);
        this.setFieldValByName("createUserName", ContextInfoHandler.getUserName(), metaObject);
        this.setFieldValByName("updateUserId", ContextInfoHandler.getUserId(), metaObject);
        this.setFieldValByName("updateUserName", ContextInfoHandler.getUserName(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateUserId", ContextInfoHandler.getUserId(), metaObject);
        this.setFieldValByName("updateUserName", ContextInfoHandler.getUserName(), metaObject);
    }
}
