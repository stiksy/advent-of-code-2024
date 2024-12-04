package com.stiksy.advent.days;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public char[][] createArray(String input) {
        String[] lines = input.split("\n");
        char[][] array = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            array[i] = lines[i].toCharArray();
        }
        return array;
    }

    public List<String> getLines(char[][] input) {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            lines.add(new String(input[i]));
        }
        addInverted(lines);
        return lines;
    }

    private static void addInverted(ArrayList<String> lines) {
        int currentSize = lines.size();
        for (int i = 0; i < currentSize; i++) {
            StringBuilder reversed = new StringBuilder(lines.get(i));
            lines.add(reversed.reverse().toString());
        }
    }

    public List<String> getColumns(char[][] input) {
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 0; i < input[0].length; i++) {
            StringBuilder column = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                column.append(input[j][i]);
            }
            columns.add(column.toString());
        }
        addInverted(columns);
        return columns;
    }

    public List<String> getDiagonals(char[][] input) {
        ArrayList<String> diagonals = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                if (i + j < input.length) {
                    diagonal.append(input[i + j][j]);
                }
            }
            diagonals.add(diagonal.toString());
        }
        for (int i = 1; i < input.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                if (i + j < input.length) {
                    diagonal.append(input[j][i + j]);
                }
            }
            diagonals.add(diagonal.toString());
        }
        addInverted(diagonals);
        return diagonals;
    }

    public List<String> getDiagonalsBackwards(char[][] input) {
        ArrayList<String> diagonals = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                if (i + j < input.length) {
                    diagonal.append(input[input.length - i - j - 1][j]);
                }
            }
            diagonals.add(diagonal.toString());
        }
        for (int i = 1; i < input.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                if (i + j < input.length) {
                    diagonal.append(input[input.length - j - 1][i + j]);
                }
            }
            diagonals.add(diagonal.toString());
        }
        addInverted(diagonals);
        return diagonals;
    }

    public List<String> getAllLists(String input) {
        char[][] inputMap = createArray(input);
        List<String> allLists = new ArrayList<>();
        allLists.addAll(getLines(inputMap));
        allLists.addAll(getColumns(inputMap));
        allLists.addAll(getDiagonals(inputMap));
        allLists.addAll(getDiagonalsBackwards(inputMap));
        return allLists;
    }

    public int countXmas(List<String> list) {
        int count = 0;
        for (String line : list) {
            count += StringUtils.countOccurrencesOf(line, "XMAS");
        }
        return count;
    }

    public int countMasInX(String input) {
        int count = 0;
        char[][] inputMap = createArray(input);
        for (int i = 1; i < inputMap.length-1; i++) {
            for (int j = 1; j < inputMap[i].length-1; j++) {
                if (inputMap[i][j] == 'A') {
                    if ((inputMap[i-1][j-1] == 'M' && inputMap[i+1][j+1] == 'S') || (inputMap[i-1][j-1] == 'S' && inputMap[i+1][j+1] == 'M')) {
                        if ((inputMap[i-1][j+1] == 'M' && inputMap[i+1][j-1] == 'S') || (inputMap[i-1][j+1] == 'S' && inputMap[i+1][j-1] == 'M')) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
