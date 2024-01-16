package org.example.springProject.jsonTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeMap {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map1.put("1","1");
        map1.put("2","2");
                map1.put("3","3");
                map1.put("4","4");
                map1.put("5","5");
                map1.put("6","6");
                map1.put("7","7");
                map1.put("8","8");
                map1.put("9","9");
                map1.put("10","10");

        map2.put("1","11");
        map2.put("2","2");
        map2.put("3", "3");
        map2.put("4","14");
        map2.put("5","15");
        map2.put("6","16");
        map2.put("7","17");
        map2.put("8","18");
        map2.put("9","19");
        map2.put("10","110");

        MergeMap mergeMap = new MergeMap();
        mergeMap.merge(map1, map2);
    }

    public void merge(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> map3 = new HashMap<>(map1);

        for(String key : map2.keySet()) {
            if(!map3.containsKey(key)) {
                map3.put(key, map2.get(key));
            } else {
                map3.put(key+"_2", map2.get(key));
            }
        }
        System.out.println(map3.size());
        System.out.println(map3.toString());

        //remove duplicate values
        map3.values().stream().map(String::toString)
                .collect(Collectors.toSet()).forEach(System.out::println);

    }
}
