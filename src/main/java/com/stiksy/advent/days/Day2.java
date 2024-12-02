package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day2 {

    public boolean isOrdered(List<Integer> levels) {
        List<Integer> sortedLevelsCrescent = new ArrayList<>(levels);
        Collections.sort(sortedLevelsCrescent);

        List<Integer> sortedLevelsDecrescent = new ArrayList<>(levels);
        Collections.sort(sortedLevelsDecrescent, Comparator.reverseOrder());

        return levels.equals(sortedLevelsCrescent) || levels.equals(sortedLevelsDecrescent);
    }

    public static List<Integer> getLevels(String report) {
        String[] split = report.split(" ");
        List<Integer> levels = new ArrayList<>();
        for (String item : split) {
            levels.add(Integer.parseInt(item));
        }
        return levels;
    }

    public boolean isSafe(List<Integer> levels) {
        for (int i = 0; i < levels.size() - 1; i++) {
            int difference = Math.abs(levels.get(i) - levels.get(i + 1));
            if (difference == 0 || difference > 3) {
                return false;
            }
        }
        return true;
    }

    public int countSafeLevels(List<String> reports) {
        int count = 0;
        for (String report : reports) {
            List<Integer> levels = getLevels(report);
            boolean isOrdered = isOrdered(levels);
            boolean isSafe = isSafe(levels);
            if (isOrdered && isSafe) {
                count++;
            } else {
                if (!isOrdered) {
                    for (int i = 0; i < levels.size(); i++) {
                        List<Integer> newList = new ArrayList<>(levels);
                        newList.remove(i);
                        if (isOrdered(newList)) {
                            if (isSafe(newList)) {
                                count++;
                                break;
                            }
                        }
                    }
                } else if (!isSafe) {
                    for (int i = 0; i < levels.size(); i++) {
                        List<Integer> newList = new ArrayList<>(levels);
                        newList.remove(i);
                        if (isSafe(newList)) {
                            if (isOrdered(newList)) {
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
