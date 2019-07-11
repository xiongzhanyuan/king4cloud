package com.king4cloud.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
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

    }
}
