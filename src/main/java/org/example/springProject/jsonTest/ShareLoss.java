package org.example.springProject.jsonTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShareLoss {

    public static void main(String[] args) {
       // int[] shares = {3, 2, 4, 2, 1, 5 };
        int[] shares = {5, 3, 4, 2, 3, 1 };
       int minPrice=shares[0];
       int maxLoss=0;
        for(int i=1; i<shares.length; i++) {
            int currentPrice = shares[i];
            if(currentPrice<minPrice){
                minPrice=shares[i];
            }
            else {
                int currentLoss = minPrice-currentPrice;
                maxLoss= Math.min(maxLoss, currentLoss);
            }

        }
        System.out.println(maxLoss);
    }
}
