package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";

    public List<String> findMatches(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean foundDo = true;

        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            String match = matcher.group();
            if (match.equals("do()")) {
                foundDo = true;
            } else if (match.equals("don't()")) {
                foundDo = false;
            } else {
                if (foundDo) {
                    matches.add(match);
                }
            }
        }

        return matches;
    }

    public int multiplyNumbers(String input) {
        String[] split = input.split(",");
        int number1 = Integer.parseInt(split[0].substring(4));
        int number2 = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
        return number1 * number2;
    }

    public int processInput(String input) {
        List<String> matches = findMatches(input);
        int sum = 0;
        for (String match : matches) {
            sum += multiplyNumbers(match);
        }
        return sum;
    }
}
