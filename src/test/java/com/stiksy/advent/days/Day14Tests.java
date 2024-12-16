package com.stiksy.advent.days;

import com.stiksy.advent.days.Day14.Robot;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Tests {
    String input =
            "p=0,4 v=3,-3\n" +
            "p=6,3 v=-1,-3\n" +
            "p=10,3 v=-1,2\n" +
            "p=2,0 v=2,-1\n" +
            "p=0,0 v=1,3\n" +
            "p=3,0 v=-2,-2\n" +
            "p=7,6 v=-1,-3\n" +
            "p=3,0 v=-1,-2\n" +
            "p=9,3 v=2,3\n" +
            "p=7,3 v=-1,2\n" +
            "p=2,4 v=2,-3\n" +
            "p=9,5 v=-3,-3";

    @Test
    void createEmptyMap() {
        Day14 day = new Day14();
        char[][] emptyMap = day.createEmptyMap(11, 7);
        assertEquals(7, emptyMap.length);
        assertEquals(11, emptyMap[0].length);
        assertEquals("...........", new String(emptyMap[0]));
    }

    @Test
    void parseInput() {
        Day14 day = new Day14();
        List<Robot> robots = day.parseInput(input);
        assertEquals(12, robots.size());
        assertEquals(0, robots.get(0).position.x);
        assertEquals(4, robots.get(0).position.y);
        assertEquals(3, robots.get(0).velocity.x);
        assertEquals(-3, robots.get(0).velocity.y);
    }

    @Test
    void walkOneRobotOnce() {
        Day14 day = new Day14();
        List<Robot> robots = day.parseInput(input);
        List<Robot> oneRobot = new ArrayList<>();
        oneRobot.add(robots.get(0));
        char[][] map = day.createEmptyMap(11, 7);
        map = day.walkRobots(oneRobot, map, 1);
        assertEquals("...1.......", new String(map[1]));
    }

    @Test
    void putAllRobotsOnMap() {
        Day14 day = new Day14();
        List<Robot> robots = day.parseInput(input);
        String expectedMap =
                "1.12.......\n" +
                "...........\n" +
                "...........\n" +
                "......11.11\n" +
                "1.1........\n" +
                ".........1.\n" +
                ".......1...";
        char[][] map = day.createEmptyMap(11, 7);
        map = day.walkRobots(robots, map, 0);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void walkRobot5Times() {
        Day14 day = new Day14();
        Robot robot = new Robot();
        robot.position = new Point(2, 4);
        robot.velocity = new Point(2, -3);
        List<Robot> robots = new ArrayList<>(List.of(robot));
        String expectedMap =
                "...........\n" +
                "...........\n" +
                "...........\n" +
                ".1.........\n" +
                "...........\n" +
                "...........\n" +
                "...........";
        char[][] map = day.createEmptyMap(11, 7);
        map = day.walkRobots(robots, map, 5);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void walkRobots100Times() {
        Day14 day = new Day14();
        List<Robot> robots = day.parseInput(input);
        String expectedMap =
                "......2..1.\n" +
                "...........\n" +
                "1..........\n" +
                ".11........\n" +
                ".....1.....\n" +
                "...12......\n" +
                ".1....1....";
        char[][] map = day.createEmptyMap(11, 7);
        map = day.walkRobots(robots, map, 5);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }
}
