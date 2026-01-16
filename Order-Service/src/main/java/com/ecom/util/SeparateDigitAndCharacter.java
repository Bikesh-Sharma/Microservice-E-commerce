package com.ecom.util;

import java.util.ArrayList;
import java.util.List;

public class SeparateDigitAndCharacter {

    public static void main(String[] args) {
        String[] arr = {"2", "v", "3", "b", "5"};

        List<String> digit = new ArrayList<>();
        List<String> letter = new ArrayList<>();

        for (String s : arr){
            char c = s.charAt(0);

            if (Character.isDigit(c)){
                digit.add(s);
            }else if (Character.isLetter(c)){
                letter.add(s);
            }
        }
        System.out.println("Digit : " + digit);
        System.out.println("Letter : " + letter);
    }
}
