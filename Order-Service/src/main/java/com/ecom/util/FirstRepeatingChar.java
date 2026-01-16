package com.ecom.util;

import java.util.HashSet;

public class FirstRepeatingChar {
    public static void main(String[] args) {
        String str = "swiss";

        HashSet<Character> s = new HashSet<>();
        for (char c : str.toCharArray()){
            if (!s.add(c)){
                System.out.println(c);
                return;
            }
        }

    }
}
