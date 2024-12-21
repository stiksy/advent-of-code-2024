package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {
    public Map<String, List<int[]>> getNodesList(String input) {
        Map<String, List<int[]>> nodes = new HashMap<>();
        char[][] grid = input.lines().map(String::toCharArray).toArray(char[][]::new);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '.') {
                    if (!nodes.containsKey(String.valueOf(grid[i][j]))) {
                        nodes.put(String.valueOf(grid[i][j]), new ArrayList<>());
                    }
                    nodes.get(String.valueOf(grid[i][j])).add(new int[]{j, i});
                }
            }
        }
        return nodes;
    }

    public Map<String, Boolean> getAntinodes(Map<String, List<int[]>> nodes, int maxX, int maxY) {
        Map<String, Boolean> antinodes = new HashMap<>();
        Map<String, Boolean> allAntennas = new HashMap<>();
        for (List<int[]> tempAntennas : nodes.values()) {
            for (int[] antenna : tempAntennas) {
                allAntennas.put(antenna[0] + "," + antenna[1], true);
            }
        }
        for (List<int[]> antennas : nodes.values()) {
            List<int[][]> pairs = getAllPairs(antennas);
            for (int[][] pair : pairs) {
                antinodes.put(pair[0][0] + "," + pair[0][1], true);
                antinodes.put(pair[1][0] + "," + pair[1][1], true);
                int distanceX = pair[0][0] - pair[1][0];
                int distanceY = pair[0][1] - pair[1][1];
                int[] antinode1 = new int[]{pair[0][0] + distanceX, pair[0][1] + distanceY};
                int[] antinode2 = new int[]{pair[1][0] - distanceX, pair[1][1] - distanceY};
                boolean antinode1out = false;
                boolean antinode2out = false;
                if (antinode1[0] >= 0 && antinode1[0] < maxX && antinode1[1] >= 0 && antinode1[1] < maxY && !allAntennas.containsKey(antinode1[0] + "," + antinode1[1])) {
                    antinodes.put(antinode1[0] + "," + antinode1[1], true);
                } else if (!allAntennas.containsKey(antinode1[0] + "," + antinode1[1])) {
                    antinode1out = true;
                }
                if (antinode2[0] >= 0 && antinode2[0] < maxX && antinode2[1] >= 0 && antinode2[1] < maxY && !allAntennas.containsKey(antinode2[0] + "," + antinode2[1])) {
                    antinodes.put(antinode2[0] + "," + antinode2[1], true);
                } else if (!allAntennas.containsKey(antinode2[0] + "," + antinode2[1])) {
                    antinode2out = true;
                }
                while (!antinode1out) {
                    antinode1[0] += distanceX;
                    antinode1[1] += distanceY;
                    if (antinode1[0] >= 0 && antinode1[0] < maxX && antinode1[1] >= 0 && antinode1[1] < maxY && !allAntennas.containsKey(antinode1[0] + "," + antinode1[1])) {
                        antinodes.put(antinode1[0] + "," + antinode1[1], true);
                    } else if (!allAntennas.containsKey(antinode1[0] + "," + antinode1[1])) {
                        antinode1out = true;
                    }
                }
                while (!antinode2out) {
                    antinode2[0] -= distanceX;
                    antinode2[1] -= distanceY;
                    if (antinode2[0] >= 0 && antinode2[0] < maxX && antinode2[1] >= 0 && antinode2[1] < maxY && !allAntennas.containsKey(antinode2[0] + "," + antinode2[1])) {
                        antinodes.put(antinode2[0] + "," + antinode2[1], true);
                    } else if (!allAntennas.containsKey(antinode2[0] + "," + antinode2[1])) {
                        antinode2out = true;
                    }
                }
            }
        }
        return antinodes;
    }

    public List<int[][]> getAllPairs(List<int[]> antennas) {
        List<int[][]> pairs = new ArrayList<>();
        for (int i = 0; i < antennas.size(); i++) {
            for (int j = i + 1; j < antennas.size(); j++) {
                pairs.add(new int[][]{antennas.get(i), antennas.get(j)});
            }
        }
        return pairs;
    }

    public static class Day17Debugger {
        long registerA;
        long registerB;
        long registerC;
        List<Integer> instructions = new ArrayList<>();
        String output = "";
    }
}
