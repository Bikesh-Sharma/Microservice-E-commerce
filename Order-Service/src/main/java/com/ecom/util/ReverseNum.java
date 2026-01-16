package com.ecom.util;

public class ReverseNum {
    public static void main(String[] args) {
        String str = "ana";
        String rev = "";
        for (int i=str.length()-1;i>=0;i--){
            rev = rev+str.charAt(i);
        }
        System.out.println(rev);
        if (rev.equals(str)){
            System.out.println("this is palindrome num");
        }
    }
}
