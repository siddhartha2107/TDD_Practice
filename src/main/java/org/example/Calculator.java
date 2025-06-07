package org.example;

public class Calculator {
    public static int add(String numbers) throws Exception {
        int sum=0;
        if(numbers.startsWith("//")){
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            String numbersString = numbers.substring(3);
            String[] nums = numbersString.split(delimiter);
            for(String s:nums){
                sum+=Integer.parseInt(s.trim());
            }
        } else {
          throw new IllegalArgumentException("Input string does not starts with //");
        }

        return sum;
    }
}
