package com.stiksy.advent.days;

import java.util.*;

public class Day12 {
    Map<String, Integer> cache = new HashMap<>();

    public char[][] getMap(String input) {
        return input.lines().map(String::toCharArray).toArray(char[][]::new);
    }

    public List<List<int[]>> getAreas(char[][] map) {
        List<List<int[]>> areas = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
//                System.out.println(i + " " + j + " of " + map.length + " " + map[0].length);
                areas = findAdjacentList(map, i, j, areas);
            }
        }
        return areas;
    }

    private List<List<int[]>> findAdjacentList(char[][] map, int i, int j, List<List<int[]>> areas) {
        List<int[]> neighbours = getNeighbours(map, i, j);
        Set<String> alreadyChecked = new HashSet<>();
        if (neighbours.isEmpty()) {
            List<int[]> newArea = new ArrayList<>();
            newArea.add(new int[]{i, j});
            areas.add(newArea);
            cache.put(i + "," + j, areas.indexOf(newArea));
            return areas;
        }
        alreadyChecked.add(i + "," + j);
        while (!neighbours.isEmpty()) {
            int[] neighbour = neighbours.get(0);
            neighbours.remove(0);
            String key = neighbour[0] + "," + neighbour[1];
            if (cache.containsKey(key)) {
                List<int[]> area = areas.get(cache.get(key));
                area.add(new int[]{i, j});
                cache.put(i + "," + j, areas.indexOf(area));
                return areas;
            }
            alreadyChecked.add(key);
            neighbours.addAll(getNeighbours(map, neighbour[0], neighbour[1]));
            List<int[]> tempNeighbours = new ArrayList<>(neighbours);
            for (int[] newNeighbour : tempNeighbours) {
                if (alreadyChecked.contains(newNeighbour[0] + "," + newNeighbour[1])) {
                    neighbours.remove(newNeighbour);
                }
            }
        }
        List<int[]> newArea = new ArrayList<>();
        newArea.add(new int[]{i, j});
        areas.add(newArea);
        cache.put(i + "," + j, areas.indexOf(newArea));
        return areas;
    }

    private List<int[]> getNeighbours(char[][] map, int i, int j) {
        char thisItem = map[i][j];
        char left = j > 0 ? map[i][j - 1] : '#';
        char up = i > 0 ? map[i - 1][j] : '#';
        char right = j < map[0].length - 1 ? map[i][j + 1] : '#';
        char down = i < map.length - 1 ? map[i + 1][j] : '#';
        List<int[]> neighbours = new ArrayList<>();
        if (left == thisItem) {
            neighbours.add(new int[]{i, j - 1});
        }
        if (up == thisItem) {
            neighbours.add(new int[]{i - 1, j});
        }
        if (right == thisItem) {
            neighbours.add(new int[]{i, j + 1});
        }
        if (down == thisItem) {
            neighbours.add(new int[]{i + 1, j});
        }
        return neighbours;
    }

    public int getPerimeter(List<int[]> area) {
        int perimeter = 0;
        for (int[] position : area) {
            int thisPerimeter = 4;
            if (area.stream().anyMatch(p -> p[0] == position[0] && p[1] == position[1] - 1)) {
                thisPerimeter--;
            }
            if (area.stream().anyMatch(p -> p[0] == position[0] && p[1] == position[1] + 1)) {
                thisPerimeter--;
            }
            if (area.stream().anyMatch(p -> p[0] == position[0] - 1 && p[1] == position[1])) {
                thisPerimeter--;
            }
            if (area.stream().anyMatch(p -> p[0] == position[0] + 1 && p[1] == position[1])) {
                thisPerimeter--;
            }
            perimeter += thisPerimeter;
        }
        return perimeter;
    }

    public int getFenceValue(List<int[]> area) {
        return area.size() * getPerimeter(area);
    }

    public int getUniqueSides(List<int[]> area) {
        Set<String> sides = new HashSet<>();
        for (int[] position : area) {
            boolean isFirstLeft = true;
            boolean found = false;
            for (int[] ints : area) {
                if (ints[0] == position[0] && ints[1] == position[1] - 1) {
                    isFirstLeft = false;
                    break;
                }
            }
            if (isFirstLeft) {
                found = false;
                for (String side : sides) {
                    if (side.startsWith("left-") && side.endsWith((position[0]) - 1 + "," + position[1])) {
                        sides.remove(side);
                        sides.add(side + "-" + position[0] + "," + position[1]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    sides.add("left-" + position[0] + "," + position[1]);
                }
            }
            boolean isLastRight = true;
            for (int[] ints : area) {
                if (ints[0] == position[0] && ints[1] == position[1] + 1) {
                    isLastRight = false;
                    break;
                }
            }
            if (isLastRight) {
                found = false;
                for (String side : sides) {
                    if (side.startsWith("right-") && side.endsWith((position[0]) - 1 + "," + position[1])) {
                        sides.remove(side);
                        sides.add(side + "-" + position[0] + "," + position[1]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    sides.add("right-" + position[0] + "," + position[1]);
                }            }
            boolean isFirstUp = true;
            for (int[] ints : area) {
                if (ints[0] == position[0] - 1 && ints[1] == position[1]) {
                    isFirstUp = false;
                    break;
                }
            }
            if (isFirstUp) {
                found = false;
                for (String side : sides) {
                    if (side.startsWith("up-") && side.endsWith(position[0] + "," + (position[1] - 1))) {
                        sides.remove(side);
                        sides.add(side + "-" + position[0] + "," + position[1]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    sides.add("up-" + position[0] + "," + position[1]);
                }
            }
            boolean isLastDown = true;
            for (int[] p : area) {
                if (p[0] == position[0] + 1 && p[1] == position[1]) {
                    isLastDown = false;
                    break;
                }
            }
            if (isLastDown) {
                found = false;
                for (String side : sides) {
                    if (side.startsWith("down-") && side.endsWith(position[0] + "," + (position[1] - 1))) {
                        sides.remove(side);
                        sides.add(side + "-" + position[0] + "," + position[1]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    sides.add("down-" + position[0] + "," + position[1]);
                }
            }
        }
        return sides.size();
    }

    public int getFenceValueWithDiscount(List<int[]> area) {
        return area.size() * getUniqueSides(area);
    }

    public int getTotalFenceValue(String input) {
        cache = new HashMap<>();
        char[][] map = getMap(input);
        List<List<int[]>> areas = getAreas(map);
        return areas.stream().mapToInt(this::getFenceValue).sum();
    }

    public int getTotalFenceValueWithDiscount(String input) {
        cache = new HashMap<>();
        char[][] map = getMap(input);
        List<List<int[]>> areas = getAreas(map);
        return areas.stream().mapToInt(this::getFenceValueWithDiscount).sum();
    }
}
