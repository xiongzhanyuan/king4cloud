package com.king4cloud.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "周瑜");
        hashMap.put("曹操", "曹操");
        hashMap.put("刘备", "刘备");

//        hashMap.forEach((k,v) -> {
//            int hashCode = k.hashCode();
//            int index = hashCode % 8;
//            System.out.println(String.format("%s的hashCode是%s, index 是 %s", k, hashCode, index));
//        });

//        for (int i=1; i<=10; i++) {
//            System.out.println(i%10);
//        }
        System.out.println(hashMap.get(null));

        System.out.println(10 >> 3);

        System.out.println(10 << 4);

        String[] arg = {"1","3","4"};
        Integer[] intarg={1,2,3};

        List<Integer> strings = Arrays.asList(intarg);
        System.out.println(strings);
    }
}
