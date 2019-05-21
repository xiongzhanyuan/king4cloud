package com.king4cloud.common.core.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class TreeNodeAbstract {
    private Integer sort = 0;
    private List<? extends TreeNodeAbstract> children = new ArrayList<>();

}
