package com.stiksy.advent.days;

import java.util.Collections;
import java.util.List;

public class Day1 {

    public List<Integer> sortList(List<Integer> input) {
        Collections.sort(input);
        return input;
    }

    public int calculateDistance(int x, int y) {
        return Math.max(x, y) - Math.min(x, y);
    }

    public int sumDistances(List<Integer> input1, List<Integer> input2) {
        int sum = 0;
        input1 = sortList(input1);
        input2 = sortList(input2);
        for (int i = 0; i < input1.size(); i++) {
            sum += calculateDistance(input1.get(i), input2.get(i));
        }
        return sum;
    }

    public int countHowManyTimesNumberIsInList(int number, List<Integer> input) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == number) {
                count++;
            }
        }
        return count;
    }

    public int multiplyNumberByCountOfAppearances(int number, List<Integer> input) {
        return number * countHowManyTimesNumberIsInList(number, input);
    }

    public int processLists(List<Integer> finalInput1, List<Integer> finalInput2) {
        int sum = 0;
        for (int i = 0; i < finalInput1.size(); i++) {
            sum += multiplyNumberByCountOfAppearances(finalInput1.get(i), finalInput2);
        }
        return sum;
    }
}
