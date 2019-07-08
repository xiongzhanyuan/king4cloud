package com.king4cloud.test;

import java.util.HashMap;

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
        System.out.println(00000010);

        System.out.println(10 >> 3);

        System.out.println(10 << 4);

    }
}
