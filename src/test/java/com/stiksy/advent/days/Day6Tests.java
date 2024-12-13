package com.stiksy.advent.days;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Day6Tests {

    String input =
            "....#.....\n" +
            ".........#\n" +
            "..........\n" +
            "..#.......\n" +
            ".......#..\n" +
            "..........\n" +
            ".#..^.....\n" +
            "........#.\n" +
            "#.........\n" +
            "......#...";
    String finalInput =
            "..#.........#...#......#...........#.#...#............#...#.........#....#......................#......#..........................\n" +
            "...........#....#.............#.....................................#............................................#.....#..........\n" +
            ".................#.........#.......#.......#..#............#.........#.........#............................................#.....\n" +
            "......#................................#.........................................#................................................\n" +
            "#...............................##......#.#...........................#....................#...#...............#.................#\n" +
            ".............#......#...........................................#..............#..........#..............#........................\n" +
            "...#...................#..............#........#.......#..........#.........................#.#.....#.....#.......................\n" +
            "#.#...#.............................#.................................................#..............#............#...............\n" +
            ".............................#.......#.............#......#...............#.....#.................................................\n" +
            "....................................#.....................................#.................#........#..........#.#..#...........#\n" +
            "......................#......#...............................#.................#.......#......................#.......#...........\n" +
            "...#..............#....................#............#...........##..#.....................................................#.......\n" +
            "....#.........#...................................#................................................#..........................#...\n" +
            "..............#.....#.................................................................#..#.....##.......#.........................\n" +
            ".........#....#...........##..........................................#......#.....................#..........#.......#...........\n" +
            "..#....#..........#.................................................................#....#............#............#........#.....\n" +
            "............#.#....#...........#.............#...........#..................#.....#.................................#.......#.....\n" +
            "..........#.......#............................#........#...........#.......#...#....#........#.............##.#............#.....\n" +
            "...................#.........#....#.....................................................................#.#..........#............\n" +
            ".#...#.#..................#...............................................#...........................#......................#....\n" +
            ".........#..............#.........#.......#.#......##..................#......#...#..#...........#.....................#..........\n" +
            "...............................#.............#..#......#............#..........#......................#..........#.............#..\n" +
            "..........#.....#..........................#..................................................#.#..#.....#........................\n" +
            "............#..##.................................#....................#.....#.......................................#............\n" +
            "......................#.#...................#......#..............................................................#...............\n" +
            ".......#.............................................................................#............................................\n" +
            "........#.................#....................................................#.......................................#....##.#..\n" +
            "..................#........................#......#..##....#.........#...##..#....................................#...............\n" +
            ".............#..............................................................................##...#......#.................#.......\n" +
            "..................................#.#.............................................................................#...............\n" +
            "...........#.................................#.......................................................................#......#.....\n" +
            ".....#............................................................#................................................#..............\n" +
            ".....#...........#.#..........#..............#..........................#.................................................#.......\n" +
            "....#........#...#..........#..#..........................................................................#.......................\n" +
            ".........................................................................#.....#.......................................#....#.....\n" +
            "...............#...#..#.....#.......................#.................#........#..........##....................................#.\n" +
            ".......................#....#...#..................#..................#.....................................#.............#.......\n" +
            "...........#..#...#..............................................^........#........................#......................#.......\n" +
            ".............................................#.................................................................................#..\n" +
            "......#...#.........#.....................................#...............................................#..#....#.......#.......\n" +
            "...#......................................................#.................#..#.............................................#....\n" +
            ".....#......................#.......................................#.............................................#....#..........\n" +
            "...#.....................................................#......#...#.......#....#..............................#....#............\n" +
            "......#.....#.....#...........#...#................#...........................................#..................................\n" +
            "...................................#...............#......................................................#.......................\n" +
            "..............................#...#........................................................#.#.............#......................\n" +
            "......#.......#............#..#......................#..#.....#..................#......#.........................................\n" +
            "#......#....#.......#....................#.....#.#............................................................................#...\n" +
            ".#....#...................................#.................#....................#........................................#.......\n" +
            "............................................#...................................#.......#..............#.........................#\n" +
            "............##.........#..............................................................................#.........#.................\n" +
            "##.................................................#.......................#.#.....#..............................................\n" +
            "...........................#..........#...#.#.........................#.................................##.....#..................\n" +
            ".............#..........#........................................#............#............#.....................................#\n" +
            ".....................................................#.................................................#..........................\n" +
            ".....#........................................#.............................#...#.....................#...........................\n" +
            ".......#..................................#...........#.......#.....#........................................#.......#............\n" +
            ".............#.......................#......................#.....#.......#..................................#..#........#........\n" +
            ".......................................................#......#...............#.........#.............#............#..............\n" +
            "....#...............................#.#.....................#.................................................................#..#\n" +
            "...........................#........#..........................................#........................................#.........\n" +
            "....#.............................................................................................................................\n" +
            ".##........#.......#..................#.#....#.............................................................#.##...................\n" +
            ".#..#.......................##........................................................#...............................#...........\n" +
            ".....#.#..............#...........................................#...............................................................\n" +
            ".....#.#............................#.............................................................................................\n" +
            "......................#............................#....#............................................................#............\n" +
            ".......#.......................................................................#..................#...##..........................\n" +
            "...............#...................................................#.....................................#...............#.#......\n" +
            "....#..........#.......#..#................................#......................................................................\n" +
            "#......##..................................................................#...#........................#.........................\n" +
            "..................................#........................................................................#...........#......#...\n" +
            ".#....................#....#..................................#..#..................#.#.......................#...................\n" +
            "......#..#................................................................................................##......................\n" +
            ".....##........#..#.......................#.........#............#....#...........................................................\n" +
            "...............#...........#.................#...........#.........#.......................#.........#........................#...\n" +
            "............................................................................................#..#..................................\n" +
            "..........................................#.............#..#...............#.............................#.#......#.............#.\n" +
            "......................#............#..........#............................................................#...#................#.\n" +
            "...........#...................#..................................................................................................\n" +
            ".......#........................#.................................................................#.................#.............\n" +
            "#...##................#......................................................................#................................#...\n" +
            "...#.....#.......................#...#..............#....................#.........#.........#....................................\n" +
            "....#.....................................#.............................................................................#.........\n" +
            ".........#..............................................................................#..............#..........................\n" +
            "...................................#.#...............#........................................................................##..\n" +
            ".........#............#..............#..........................................................................#...#.............\n" +
            ".....#.......................#..#....#.#....................#..........................................#..........................\n" +
            ".......................................#........#.........#.....................#.............#...........#...............#.......\n" +
            "................#.................................................................................................................\n" +
            ".......#....................................#..................#...........#.....#.........................#......................\n" +
            "...................#................................................................#...............#................#............\n" +
            "..........#.......................#......................#...........#..#........#....#.........................#.................\n" +
            "...................#........................#.......#................................................#............................\n" +
            ".......................#......................................................#...........#.......#...................#...........\n" +
            "........#..........#........#......#......................#......................................#...............#................\n" +
            "...........................................................#...#..................................................................\n" +
            ".......................#......................#............#..#....#...#............................#.............................\n" +
            ".#.#...............#..........#..........##........#..............................................................................\n" +
            "##.........#....................#...................#.........#......................##..................#...............#........\n" +
            ".#......................#...#...#......................#............#......................#.................#..................#.\n" +
            "#..............................#......................................#.........#.#...............................................\n" +
            "...........#....#......#.......#..........................#..........................................#......#............#..#.....\n" +
            "................................................................................................#.......#.........................\n" +
            "....#..................................#..........................#.................................#...#...#.....................\n" +
            ".......................#.#..#.............................#.#...........................#......#..........#.......................\n" +
            "...##.......................................#..................#....................#.............................................\n" +
            "...#.......#........................#..........##.....#............#......................#.....................................#.\n" +
            "......#..............#.............................#.............................................#.............................#..\n" +
            "#...........................................#.......#....#.#..........#........#............#.......................#.......#.....\n" +
            "..................#.......#............#.....#.............................................................#......................\n" +
            ".#.....................................................................................#...................................#......\n" +
            "...........#.........#.#.................#..........................#............................................#.......##.......\n" +
            ".......................#......#.................................................#........................#.................#......\n" +
            "..................#........................................................#................................................#....#\n" +
            "...............................#.......#....#.........#..........#.....#.......................................#..#...............\n" +
            "......##................##...#....#...#...#............................................................................#..........\n" +
            ".......................#............#...................................#....#.......#.............................#..............\n" +
            "..............................#.........................................................#........#.............#..................\n" +
            "........................#............................................#..................#.....#...................#...............\n" +
            "............#......#...............................#.............................................................................#\n" +
            ".#.........#.........#.........#.......#.#..#...#...............................#.......#.........#..........................#....\n" +
            "........................#.................................................#....................................##......#..........\n" +
            "....#.......#.....................##...#..........................................................................................\n" +
            ".................................#.......................................#.......................#.#......#.......................\n" +
            ".#.............#..................#...........................#.................#...........................................#.....\n" +
            ".....#.........#................#..........#..#..........#......................#...#......................#....#.................\n" +
            ".................#......#.....................................................................#...................................\n" +
            "......................#.......................................................#..#......#..............#..#..#..........#.........\n" +
            "...............................#.........#........#..................#.#.........#.#.#........#..#.........#....##...#............";

    @Test
    void findXY() {
        Day6 day6 = new Day6();
        int[] position = day6.findXY(input.split("\n"));
        assertEquals(4, position[0]);
        assertEquals(6, position[1]);
    }

    @Test
    void shouldWalk() {
        Day6 day6 = new Day6();
        String expectedNewInput =
                "....#.....\n" +
                "....XXXXX#\n" +
                "....X...X.\n" +
                "..#.X...X.\n" +
                "..XXXXX#X.\n" +
                "..X.X.X.X.\n" +
                ".#XXXXXXX.\n" +
                ".XXXXXXX#.\n" +
                "#XXXXXXX..\n" +
                "......#X..";
        String updatedInput = day6.walk(input);
        assertEquals(expectedNewInput, updatedInput);
    }

    @Test
    void createLoop() {
        Day6 day6 = new Day6();
        String input =
                "....#.....\n" +
                ".........#\n" +
                "..........\n" +
                "..#.......\n" +
                ".......#..\n" +
                "..........\n" +
                ".#.#^.....\n" +
                "........#.\n" +
                "#.........\n" +
                "......#...";
        String expectedInput =
                "....#.....\n" +
                "....XXXXX#\n" +
                "....X...X.\n" +
                "..#.X...X.\n" +
                "....X..#X.\n" +
                "....X...X.\n" +
                ".#.#^XXXX.\n" +
                "........#.\n" +
                "#.........\n" +
                "......#...";
        String updatedInput = day6.walk(input);
        assertEquals(expectedInput, updatedInput);
    }

    @Test
    void isLoop() {
        Day6 day6 = new Day6();
        String thisInput =
                "....#.....\n" +
                ".........#\n" +
                "..........\n" +
                "..#.......\n" +
                ".......#..\n" +
                "..........\n" +
                ".#.#^.....\n" +
                "........#.\n" +
                "#.........\n" +
                "......#...";
        assertTrue(day6.isLoop(thisInput));
        assertFalse(day6.isLoop(input));
    }

    @Test
    void shouldCountLoops() {
        Day6 day6 = new Day6();
        int count = day6.countLoops(input);
        assertEquals(6, count);
    }

//    @Test
//    void shouldCountFinalLoops() {
//        Day6 day6 = new Day6();
//        int count = day6.countLoops(finalInput);
//        assertEquals(2022, count);
//    }

    @Test
    void shouldCountX() {
        Day6 day6 = new Day6();
        int count = day6.countX(input);
        assertEquals(41, count);
    }

//    @Test
//    void shouldCountFinalX() {
//        Day6 day6 = new Day6();
//        int count = day6.countX(finalInput);
//        assertEquals(5409, count);
//    }
}
