package com.ecom.util;

import java.util.HashSet;

public class DuplicateIntegerFind {
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,4,5,3};
        HashSet<Integer> s = new HashSet<>();

        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]==arr[j]){
                    s.add(arr[i]);
                }
            }
        }
        System.out.println(s);
    }
}
