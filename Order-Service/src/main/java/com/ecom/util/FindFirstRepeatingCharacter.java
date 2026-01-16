package com.ecom.util;

import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeatingCharacter {
    public static void main(String[] args) {
        String s = "swiss";
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()){
            if (!set.add(c)){
                System.out.println(c);
                break;
            }
        }
    }
}
