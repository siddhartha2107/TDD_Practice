package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
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
        List<String> delimiterList = new ArrayList<>();

        if(numbers.startsWith("//")){
            String delimiterSection = numbers.substring(2, numbers.indexOf("\n"));
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);

            while (matcher.find()) {
                delimiterList.add(Pattern.quote(matcher.group(1)));  // Escape for regex
            }

            if (delimiterList.isEmpty()) {
                throw new IllegalArgumentException("No delimiters found in brackets");
            }

            String numbersString = numbers.substring(numbers.indexOf("\n")+1);

            String regex = delimiterList.stream().reduce((a, b) -> a + "|" + b).orElse("");
            String[] nums = numbersString.split(regex);
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
