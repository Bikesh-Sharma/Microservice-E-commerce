package com.ecom.util;

import java.util.Arrays;

public class FindNumberOfOne {

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        int count = 0;

        for (int num : arr){
            if (num==1){
                count++;
            }
        }
        System.out.println(count);
    }
}
