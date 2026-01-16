package com.ecom.util;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.Map;

public class FindFrequency {
    public static void main(String[] args) {
        String str = "sfsgfrdtedsjfsk";
        char[] ch =str.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println("Character : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
}
