package com.ecom.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveNullAndEmpty {
    public static void main(String[] args) {
        String[] str = {"a",null,"j",""};

        List<String> result = Arrays.stream(str).filter
                (s -> s != null && !s.isEmpty()).collect(Collectors.toList());

        System.out.println(result);
    }
}
