package com.king4cloud.common.core.utils;

import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TreeUtil {

    /**
     * 集合转树形
     *
     * @param collector   集合
     * @param filed       树形对应的字段
     * @param parentFiled 上级字段
     * @param root        指定的父的值
     * @param <T>         类型
     * @return
     */
    public static <T extends TreeNodeAbstract> List<T> build(List<T> collector, Function<T, ?> filed, Function<T, ?> parentFiled, Object root) {
        if (CollectionUtils.isEmpty(collector)) {
            return null;
        }
        Map<?, List<T>> groupCollectorMap = collector.stream().sorted(Comparator.comparing(TreeNodeAbstract::getSort)).collect(Collectors.groupingBy(parentFiled));
        List<T> rootCollector = groupCollectorMap.get(root);
        if (CollectionUtils.isEmpty(rootCollector)) {
            return null;
        }
        // 此处 只获取一个root 来进行建树
        rootCollector.forEach(rootObject -> {
            loodop(groupCollectorMap, rootObject, filed);
        });
//        T rootObject = rootCollector.get(0);


        return rootCollector;
    }

    // 迭代函数
    private static <T extends TreeNodeAbstract> void loodop(Map<?, List<T>> groupCollectorMap, T parentObject, Function<T, ?> filed) {
        Object apply = filed.apply(parentObject);
        List<T> childMenuList = groupCollectorMap.get(apply);
        if (!CollectionUtils.isEmpty(childMenuList)) {
            parentObject.setChildren(childMenuList);
            childMenuList.forEach(childMenu -> loodop(groupCollectorMap, childMenu, filed));
        } else {
            parentObject.setChildren(null);
        }
    }
}
