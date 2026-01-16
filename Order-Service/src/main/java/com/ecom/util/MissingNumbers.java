package com.ecom.util;

import java.util.HashSet;
import java.util.Set;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 10};
        int start = 1;
        int end = 10;
        Set<Integer> s = new HashSet<>();

        for (int num : arr){
            s.add(num);
        }
        for (int i=1;i<=10;i++){
            if (!s.contains(i)){
                System.out.println(i);
            }
        }
    }
}
