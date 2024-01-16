package org.example.springProject.jsonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(Arrays.asList(2,4,121,12,34,2,45,6,653,3));
        SecondLargest sc = new SecondLargest();
        sc.getSecondLarge(numList);
    }

    public void getSecondLarge(List<Integer> numList) {

        if(numList == null || numList.isEmpty() || numList.size()<2) {
            System.out.println("List is empty or less than 2");
            return;
        }

        numList.stream().sorted((int1,int2)-> {
            return int2-int1;
        }).limit(2).skip(1).forEach(System.out::println);
    }
}
