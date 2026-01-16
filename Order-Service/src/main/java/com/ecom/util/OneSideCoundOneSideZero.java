package com.ecom.util;

import java.util.Arrays;

public class OneSideCoundOneSideZero {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1,0};

        int countOne=0;

        for (int i=0;i<arr.length;i++){

            if (arr[i]==1){
                countOne++;
            }
        }

        for (int i=0;i<arr.length;i++){
            if (i<countOne){
                arr[i]=1;
            }else {
                arr[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
