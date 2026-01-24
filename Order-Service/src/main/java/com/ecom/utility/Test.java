package com.ecom.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        String str = "ksfksdjflko";

        char[] ch= str.toLowerCase().toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        for (char c : ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int count = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){

            if (entry.getValue()==1){
                count++;
                if (count==2){
                    System.out.println("Second non reapting character :" + entry.getKey());
                    break;
                }
            }
        }


    }
}
