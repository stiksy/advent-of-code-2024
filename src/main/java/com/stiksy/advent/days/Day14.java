package com.stiksy.advent.days;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day14 {
    public static int seconds = 0;

    public List<Robot> parseInput(String input) {
        String lines[] = input.split("\n");
        List<Robot> robots = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            Robot robot = new Robot();
            robot.position = new Point(Integer.parseInt(parts[0].split(",")[0].substring(2)), Integer.parseInt(parts[0].split(",")[1]));
            robot.velocity = new Point(Integer.parseInt(parts[1].split(",")[0].substring(2)), Integer.parseInt(parts[1].split(",")[1]));
            robots.add(robot);
        }
        return robots;
    }

    public char[][] walkRobots(List<Robot> robots, char[][] map, int times) {
        for (Robot robot : robots) {
            int x = robot.position.x;
            int y = robot.position.y;
            addToMap(map, y, x);
        }
        printMap(map);
        for (int i = 0; i < times; i++) {
            for (Robot robot : robots) {
                int x = robot.position.x;
                int y = robot.position.y;
                if (map[y][x] == '1') {
                    map[y][x] = '.';
                } else {
                    int newValue = Integer.parseInt(String.valueOf(map[y][x])) - 1;
                    map[y][x] = String.valueOf(newValue).charAt(0);
                }
                robot.position.x += robot.velocity.x;
                robot.position.y += robot.velocity.y;
                if (robot.position.x < 0) {
                    robot.position.x += map[0].length;
                }
                if (robot.position.x >= map[0].length) {
                    robot.position.x -= map[0].length;
                }
                if (robot.position.y < 0) {
                    robot.position.y += map.length;
                }
                if (robot.position.y >= map.length) {
                    robot.position.y -= map.length;
                }
                addToMap(map, robot.position.y, robot.position.x);
            }
            printMap(map);
        }
        return map;
    }

    private static void printMap(char[][] map) {
        for (int line = 0; line < map.length; line++) {
            for (int column = 0; column < map[0].length - 10; column++) {
                if (map[line][column] != '.' && map[line][column + 1] != '.' && map[line][column + 2] != '.' && map[line][column + 3] != '.' && map[line][column + 4] != '.'
                        && map[line][column + 5] != '.' && map[line][column + 6] != '.' && map[line][column + 7] != '.' && map[line][column + 8] != '.' && map[line][column + 9] != '.') {
                    List<String> actualMap = new ArrayList<>();
                    for (char[] row : map) {
                        actualMap.add(new String(row));
                    }
                    System.out.println("\n\nSeconds: " + seconds);
                    System.out.println(actualMap.stream().collect(Collectors.joining("\n")));
                }
            }
        }
        seconds++;
    }

    private static void addToMap(char[][] map, int y, int x) {
        if (map[y][x] == '.') {
            map[y][x] = '1';
        } else {
            int newValue = Integer.parseInt(String.valueOf(map[y][x])) + 1;
            map[y][x] = String.valueOf(newValue).charAt(0);
        }
    }

    public long getSafetyFactor(char[][] map) {
        int firstQuadrantRobots = 0;
        int secondQuadrantRobots = 0;
        int thirdQuadrantRobots = 0;
        int fourthQuadrantRobots = 0;
        for (int line = 0; line < (map.length - 1) / 2; line++) {
            for (int column = 0; column < (map[0].length - 1) / 2; column++) {
                if (map[line][column] != '.') {
                    firstQuadrantRobots += Integer.parseInt(String.valueOf(map[line][column]));
                }
            }
        }
        for (int line = 0; line < (map.length - 1) / 2; line++) {
            for (int column = (map[0].length + 1) / 2; column < map[0].length; column++) {
                if (map[line][column] != '.') {
                    secondQuadrantRobots += Integer.parseInt(String.valueOf(map[line][column]));
                }
            }
        }
        for (int line = (map.length / 2) + 1; line < map.length; line++) {
            for (int column = 0; column < (map[0].length - 1) / 2; column++) {
                if (map[line][column] != '.') {
                    thirdQuadrantRobots += Integer.parseInt(String.valueOf(map[line][column]));
                }
            }
        }
        for (int line = (map.length / 2) + 1; line < map.length; line++) {
            for (int column = (map[0].length + 1) / 2; column < map[0].length; column++) {
                if (map[line][column] != '.') {
                    fourthQuadrantRobots += Integer.parseInt(String.valueOf(map[line][column]));
                }
            }
        }
        return firstQuadrantRobots * secondQuadrantRobots * thirdQuadrantRobots * fourthQuadrantRobots;
    }

    static class Robot {
        Point position;
        Point velocity;
    }

    public char[][] createEmptyMap(int width, int height) {
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '.';
            }
        }
        return map;
    }
}
