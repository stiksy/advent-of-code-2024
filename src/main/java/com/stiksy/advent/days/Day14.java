package com.stiksy.advent.days;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day14 {

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
        }
        return map;
    }

    private static void addToMap(char[][] map, int y, int x) {
        if (map[y][x] == '.') {
            map[y][x] = '1';
        } else {
            int newValue = Integer.parseInt(String.valueOf(map[y][x])) + 1;
            map[y][x] = String.valueOf(newValue).charAt(0);
        }
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
