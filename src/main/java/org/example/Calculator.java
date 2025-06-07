package org.example;

import java.util.regex.Pattern;

public class Calculator {
    public static int safeParse(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number: " + input);
            // Option 1: Return default
            return 0;

            // Option 2: Rethrow
            // throw new IllegalArgumentException("Invalid number: " + input, e);
        }
    }
    public static int add(String numbers) throws Exception {
        int sum=0;
        if(numbers.startsWith("//")){
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            String numbersString = numbers.substring(3+delimiter.length());
            String[] nums = numbersString.split(Pattern.quote(delimiter));
            for(String s:nums){

                int num = safeParse(s);
                if(num<0){
                    throw new IllegalArgumentException("negative numbers not allowed "+num);
                } else {
                    if (num <= 1000) {
                        sum+=num;
                    }
                }
            }
        } else {
          throw new IllegalArgumentException("Input string does not starts with //");
        }

        return sum;
    }
}
