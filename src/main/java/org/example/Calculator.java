package org.example;

public class Calculator {
    public static int add(String numbers) throws Exception {
        int sum=0;
        if(numbers.startsWith("//")){
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            String numbersString = numbers.substring(3);
            String[] nums = numbersString.split(delimiter);
            for(String s:nums){
                int num = Integer.parseInt(s.trim());
                if(num<0){
                    throw new IllegalArgumentException("negative numbers not allowed "+num);
                } else {
                    sum+=num;
                }
            }
        } else {
          throw new IllegalArgumentException("Input string does not starts with //");
        }

        return sum;
    }
}
