package com.king4cloud.common.core.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage<T> {
    int pageNo;
    int pageSize;
    T requestData;
}
