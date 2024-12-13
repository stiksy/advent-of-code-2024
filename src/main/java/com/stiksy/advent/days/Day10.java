package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day10 {
    public char[][] getMap(String input) {
        return input.lines().map(String::toCharArray).toArray(char[][]::new);
    }

    public List<int[]> getStartPositions(char[][] map) {
        List<int[]> startPositions = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '0') {
                    startPositions.add(new int[]{i, j});
                }
            }
        }
        return startPositions;
    }

    public int walk(char[][] map, List<int[]> startPositions) {
        List<List<int[]>> allPaths = new ArrayList<>();
        for (int[] startPosition : startPositions) {
            List<int[]> path = new ArrayList<>();
            path.add(startPosition);
            allPaths.add(path);
        }
        boolean allPathsFinished = false;
        while (!allPathsFinished) {
            allPathsFinished = true;
            List<List<int[]>> tempAllPaths = new ArrayList<>(allPaths);
            for (List<int[]> path : allPaths) {
                List<int[]> tempPath = new ArrayList<>(path);
                tempAllPaths.remove(path);
                List<int[]> nextSteps = getNextSteps(tempPath.get(tempPath.size() - 1), map);
                if (nextSteps.size() == 0 && tempPath.size() == 10) {
                    tempAllPaths.add(tempPath);
                } else {
                    allPathsFinished = false;
                    for (int[] nextStep : nextSteps) {
                        List<int[]> newPath = new ArrayList<>(tempPath);
                        newPath.add(nextStep);
                        tempAllPaths.add(newPath);
                    }
                }
            }
            allPaths = tempAllPaths;
        }
        return countUniquePaths(allPaths);
    }

    public int countUniquePaths(List<List<int[]>> allPaths) {
        Set<String> uniquePaths = new HashSet<>();
        List<List<int[]>> result = new ArrayList<>();

        for (List<int[]> path : allPaths) {
            if (path.isEmpty()) continue;
            int[] first = path.get(0);
            int[] last = path.get(path.size() - 1);
            String key = first[0] + "," + first[1] + "-" + last[0] + "," + last[1];

            if (uniquePaths.add(key)) {
                result.add(path);
            }
        }

        return uniquePaths.size();
    }

    public List<int[]> getNextSteps(int[] currentPosition, char[][] map) {
        List<int[]> nextSteps = new ArrayList<>();
        int line = currentPosition[0];
        int column = currentPosition[1];
        int currentStep = Character.getNumericValue(map[line][column]);
        if (line > 0 && Character.getNumericValue(map[line - 1][column]) == currentStep + 1) {
            nextSteps.add(new int[]{line - 1, column});
        }
        if (line < map.length - 1 && Character.getNumericValue(map[line + 1][column]) == currentStep + 1) {
            nextSteps.add(new int[]{line + 1, column});
        }
        if (column > 0 && Character.getNumericValue(map[line][column - 1]) == currentStep + 1) {
            nextSteps.add(new int[]{line, column - 1});
        }
        if (column < map[0].length - 1 && Character.getNumericValue(map[line][column + 1]) == currentStep + 1) {
            nextSteps.add(new int[]{line, column + 1});
        }
        return nextSteps;
    }
}
