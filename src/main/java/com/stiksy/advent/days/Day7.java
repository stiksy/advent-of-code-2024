package com.stiksy.advent.days;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day7 {
    public List<List<String>> breakIntoParts(String input) {
        String[] inputLines = input.split("\n");
        List<List<String>> processedInput = new ArrayList<>();
        for (String line : inputLines) {
            List<String> parts = new ArrayList<>();
            String[] tempParts = line.split(": ");
            parts.add(tempParts[0]);
            tempParts = tempParts[1].split(" ");
            for (String part : tempParts) {
                parts.add(part);
            }
            processedInput.add(parts);
        }
        return processedInput;
    }

    public String checkIfValid(List<String> parts) {
        String expectedResult = parts.get(0);
        List<String> operationsList = generateOperations(parts.size() - 2);
        for (String operations : operationsList) {
            List<String> tempParts = new ArrayList<>(parts);
            tempParts.remove(0);
            for (int i = 0; i < operations.length(); i++) {
                char operation = operations.charAt(i);
                if (operation == '0') {
                    String newPart = new BigInteger(tempParts.get(0)).add(new BigInteger(tempParts.get(1))).toString();
                    tempParts.set(0, newPart);
                    tempParts.remove(1);
                } else if (operation == '1') {
                    String newPart = new BigInteger(tempParts.get(0)).multiply(new BigInteger(tempParts.get(1))).toString();
                    tempParts.set(0, newPart);
                    tempParts.remove(1);
                } else {
                    String newPart = tempParts.get(0) + tempParts.get(1);
                    tempParts.set(0, newPart);
                    tempParts.remove(1);
                }
            }
            if (tempParts.get(0).equals(expectedResult)) {
                return tempParts.get(0);
            }
        }
        return "0";
    }

    public static List<String> generateOperations(int numberOfDigits) {
        List<String> ternaryNumbers = new ArrayList<>();
        int maxNumber = (int) Math.pow(3, numberOfDigits);
        for (int i = 0; i < maxNumber; i++) {
            String ternaryString = Integer.toString(i, 3);
            ternaryString = String.format("%" + numberOfDigits + "s", ternaryString).replace(' ', '0');
            ternaryNumbers.add(ternaryString);
        }
        return ternaryNumbers;
    }

    public String sumValidResults(String input) {
        List<List<String>> parts = breakIntoParts(input);
        BigInteger sum = new BigInteger("0");
        for (List<String> part : parts) {
            sum = sum.add(new BigInteger(checkIfValid(part)));
        }
        return sum.toString();
    }
}
