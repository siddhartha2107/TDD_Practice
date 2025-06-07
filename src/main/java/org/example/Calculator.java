package org.example;

public class Calculator {
    public static int add(String numbers) {
        int sum=0;
        String[] nums = numbers.split(",");
        for(String s:nums){
            sum+=Integer.parseInt(s.trim());
        }
        return sum;
    }
}
