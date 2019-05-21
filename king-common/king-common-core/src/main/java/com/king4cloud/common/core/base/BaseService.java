package com.king4cloud.common.core.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseService<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> {

}
