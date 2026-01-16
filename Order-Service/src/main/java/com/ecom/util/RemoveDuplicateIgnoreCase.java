package com.ecom.util;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateIgnoreCase {
    public static void main(String[] args) {
        String[] s = {"java", "python", "Java"};

        Set<String> set = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (String str : s){
                if (set.add(str.toLowerCase())){
                    duplicate.add(str);
                }
            }
        System.out.println(set);
    }
}
