package com.stiksy.advent.days;

import com.stiksy.advent.days.Day16.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day16Tests {
    String input =
            "###############\n" +
            "#.......#....E#\n" +
            "#.#.###.#.###.#\n" +
            "#.....#.#...#.#\n" +
            "#.###.#####.#.#\n" +
            "#.#.#.......#.#\n" +
            "#.#.#####.###.#\n" +
            "#...........#.#\n" +
            "###.#.#####.#.#\n" +
            "#...#.....#.#.#\n" +
            "#.#.#.###.#.#.#\n" +
            "#.....#...#.#.#\n" +
            "#.###.#.#.#.#.#\n" +
            "#S..#.....#...#\n" +
            "###############";

    String input2 =
            "#################\n" +
            "#...#...#...#..E#\n" +
            "#.#.#.#.#.#.#.#.#\n" +
            "#.#.#.#...#...#.#\n" +
            "#.#.#.#.###.#.#.#\n" +
            "#...#.#.#.....#.#\n" +
            "#.#.#.#.#.#####.#\n" +
            "#.#...#.#.#.....#\n" +
            "#.#.#####.#.###.#\n" +
            "#.#.#.......#...#\n" +
            "#.#.###.#####.###\n" +
            "#.#.#...#.....#.#\n" +
            "#.#.#.#####.###.#\n" +
            "#.#.#.........#.#\n" +
            "#.#.#.#########.#\n" +
            "#S#.............#\n" +
            "#################";

    String finalInput = "#############################################################################################################################################\n" +
            "#...#.....#.......#...........#...#.............#.......#.........#.....................#.............#.........#.....#.......#.........#..E#\n" +
            "#.#.#.#.###.#.###.#####.#.#.#.#.#.#.###.#######.#######.#.#####.###.#.#######.###.#.#.#.#.#.###.#####.###.#####.#.###.#.###.#.#######.#.#.#.#\n" +
            "#.#...................#.....#...#.#.#.#.......#.........#.....#.....#.........#...#.#.#.#.#.........#.....#...#...#...#.#...#...#.....#...#.#\n" +
            "###.#.#.#.#####.#####.#.#.#######.#.#.#######.#######.#######.###########.#####.#.###.#.#.#########.#######.#.#.###.#####.#####.#.###.#####.#\n" +
            "#...#.#...#...#.#.#...#...#...#...#...#.....#.....#.#.#...#.............#...#...#.#...#...#.......#.....................#.#.....#...#.....#.#\n" +
            "#.###.#####.#.#.#.#.###.#.###.#.#####.#.###.#####.#.#.#.#.#.#####.#.###.#####.#####.#########.#.#.#####.#.#####.#.###.#.#.#.#######.#.###.#.#\n" +
            "#.....#...#.#.#.#...#...#...#.......#.#...#...#...#...#.#...#...#.#...#.......#.....#.........#...#.....#.....#.#.#...#...#.#.......#...#.#.#\n" +
            "#.#####.###.#.#.#.###.#.###.#.#######.###.#.#.#.#.#####.#####.#.#.###.###.#####.#####.#############.#####.###.#.#.###.#####.###.#####.#.#.#.#\n" +
            "#.......#...#...#...#...#...#.#.....#.....#...#.#.#.....#.....#...#...#...#...#.....#...#...........#.#...#.#...#...#...#.....#...#.....#...#\n" +
            "#####.###.#####.###.###.#.#.###.###.#######.###.#.#.#########.#.###.#######.#.#####.###.#.###########.#.###.###.###.#.#.#####.###.#.#.#.###.#\n" +
            "#...#.#...#.......#.......#.#...#...#.....#.#.#.#.#...#...#...#.#...#.....#.#.........#.#.....#.........#.....#.....#.#.....#.....#.#.#.#...#\n" +
            "#.###.#.###.###.###########.#.###.#.#.#.#.#.#.#.#####.#.#.#.###.#.#.#.###.#.#########.#.#####.#.#####.###.###.#######.#####.#######.#.#.#.###\n" +
            "#.....#.#.......#.......................#.#.....................#.#.#...#...#.......#.......#.#.#...#.#...#.#.#.#.........#.#.....#.#.#.#...#\n" +
            "#.#####.#.#####.#.#.#.#######.#.#.#.#.#.#.#.#.###.#######.#####.#.#####.#####.###.#.#######.#.###.#.#.###.#.#.#.#.#########.#.###.###.#.###.#\n" +
            "#.....#.#.....#...#.#.#.........#.#.#.#.....#...#.........#...#.#.........#...#.....#...#...#.#...#.#...#.#.#.#...#.....#...#...#...#.......#\n" +
            "#######.#####.#####.#.#####.###.#.###.###.#.#.#####.#######.#.###########.#.###.#####.###.###.#.###.###.#.#.#.#####.###.#.###.#.###.#.###.###\n" +
            "#.......#...#.#...#...#...#...#.#.....#...#...#...#.......#.#.#.......#...#.#.#.#...#.....#.#...#.#.#.#...#...#.....#...#.#...#.#.#...#...#.#\n" +
            "#.#######.#.#.###.#####.#.#.#.#.#######.#######.#.#.#######.#.#.#####.###.#.#.#.#.#.#.#####.#.#.#.#.#.#####.###.#.###.###.#.###.#.###.#.###.#\n" +
            "#...#...#.#.............#.#...#...#.....#...#...#...#.........#...#.#...#.#.#.....#.#.......#.....#.#.....#.....#...#.#...#...#.#.....#.....#\n" +
            "###.#.#.#.#########.#.###.###.###.###.###.#.#.#.###.#.#######.###.#.###.###.#.###.#.#######.#######.#.###.#######.#.#.#.#######.#.#########.#\n" +
            "#...#.#...#...#.......#.........#...#.#...#.#.....#...#.....#...#.#.........#.....#.............#...#...#.#.....#.#.....#.......#.........#.#\n" +
            "#.#####.###.#.###############.#####.#.#.###.#####.#######.#####.#.#####################.#########.#####.#.#.#####.#####.#.#.###.#######.###.#\n" +
            "#.#...#.#...#.......#.....#.......#...#...#.......#.......#.....#.#...#.....#.........#...........#.....#.#.#.....#.....#.#...#.........#...#\n" +
            "#.#.#.###.#########.#.###.#.###.###.#.###.#.#######.#.#####.###.#.#.#.###.#.#.#####.#.#.#########.#.#.#.#.#.#.#####.#.#####.#.#.#####.###.###\n" +
            "#...#...#.#.....#.#.#...#...#.#.......#.....#.....#.#.....#...#.....#...#.#.#.#...#.#.#.............#...#...#.#...#.#.#...#.#.......#.#...#.#\n" +
            "#.#####.#.#.###.#.#.###.#####.#########.#####.###.###.#.#.###.#.#######.#.###.#.#.#.###.#############.#.#.#.#.#.###.#.#.#.#######.#.###.###.#\n" +
            "#.#...#.....#.....#.....#.....#.......#.....#...#...#...#...#.#.....#...#.......#.#.#...#...#.......#.#.#.#...#.#...#...#.#.....#.#.#...#...#\n" +
            "#.#.#.#.#########.###########.#.###.#######.###.###.#######.#.###.###.#############.#.#####.#.#####.###.#.#.###.#.#######.#.###.#.#.#.###.#.#\n" +
            "#.#.#.#...#...#.#.....#.....#...#.#.#.....#...#.#.#.#.......#...#.#...#.........#...#.......#.#...#...#.#.#.#...#.#.....#.#.#...#.#...#...#.#\n" +
            "#.#.#.#.###.#.#.#####.###.#.#.###.#.#.###.#.#.#.#.#.#.#####.###.#.#.###.#######.#.#######.###.#.#.###.#.#.#.#.#.#.#.###.#.#.#.###.#####.###.#\n" +
            "#.#.#.#.#...#.#.#...#.#...#.#.#...#.....#...#.....#.#.....#.#.#.#.#.#.......#...#.......#.#...#.#...#.#.#.#.#.#...#.#...#...#...#.#.....#...#\n" +
            "###.#.###.###.#.#.#.#.#.###.#.#.#.#########.#######.#.###.#.#.#.###.#######.#.#######.###.#.#####.###.#.###.#.###.#.###.#######.#.#.#######.#\n" +
            "#...#.....#.#.#.#.#...#.#...#.#.#...#.......#.......#...#.....#.....#...#.....#.......#...#.#.....#...#.#...#.....#...#.........#.#...#...#.#\n" +
            "#.#########.#.#.#.#####.###.#.###.#.#.#####.#.#########.#.#########.#.#.#.###.#.#######.###.#.#.###.#.#.#.#########.#.#########.#.###.#.#.#.#\n" +
            "#...#.......#.#.#.#.......#.#...#.#...#.....#...........#.#...#.............#.#.#.......#.#.#.#...#...#.#.#.......#.#...#.......#.....#.#.#.#\n" +
            "###.#.#####.#.#.#.#######.#.###.#.#.#####.###########.#.###.#.#.#####.#####.#.#.#.#######.#.###.#.###.#.#.###.###.#.###.#.#####.#.#####.#.#.#\n" +
            "#...#.....#...#.......#...#...#...#.#...#...#...#.....#.....#.#.#...#.#...#.....#.........#...#.#...#...#.....#.#.#.#.#.#.#.#...#.#.....#.#.#\n" +
            "#.#######.###########.#.#.###.###.#.#.#.###.#.#.#.#.#######.#.#.#.#.#.###.#.#######.#####.###.#.###.###.#####.#.#.#.#.#.#.#.#.#.###.#####.#.#\n" +
            "#.#.......#.........#...#...#...#.#...#...#.#.#...#.#.....#.#.......#...#.#...#.....#...#.#.#.#...#...#.#.......#.#...#...#.#.#.......#...#.#\n" +
            "#.#.#########.###.#.#######.###.#########.#.#.#####.#.#.#.#####.#.###.#.#.#.###.###.#.#.#.#.#.#####.#.#.#.#####.#.#######.#.#.#.#######.###.#\n" +
            "#.#.#.........#...#...#.....#...#.........#.#.#.....#.#.#.....#.#...........#...#.....#.#...#.....#.#.#.#.#...#.#.#.....#...#.#.....#...#.#.#\n" +
            "#.#.###.#########.###.#.#.###.###.###.#####.#.###.###.#.#####.###.#####.#.###.###.#####.#.#######.#.###.#.#.#.#.#.#.###.#####.#.###.#.###.#.#\n" +
            "#.#.....#.#.........#.#.........#.#...#.....#.....#...#.....#...#.#...#.#...#.#...#.....#.#.......#...#.#...#.#.#...#...#...#.......#.#...#.#\n" +
            "#.#######.#.#.#.#.###.#.#######.#.#.###.#####.#.#.#.#######.###.#.#.###.#.#.#.#.###.#######.#######.#.#.#####.#.#####.###.#.###.#####.#.###.#\n" +
            "#.............#.#.#...#.#.....#...#.....#...#.#.#.#.#...#.........#.....#.#...#...#.......#...#.....#.......#.#.#...#.......#.........#.....#\n" +
            "#.#.#.#.#####.#.#.#.###.#.###.#####.#####.#.#.#.#.#.#.###.#.#######.###.#.#.#####.#######.#.#.###########.#.#.#.#.#.###.###.#.#.#.#####.#####\n" +
            "#.#.#.#.#...#.#.#.#.#...#.#...#.....#...#.#.#.#.#.#.#...#.......#.#.....#...#...#...#...#.#.#...........#.....#...#...#...#.#.#.#.....#.#...#\n" +
            "#.#.#.#.#.#.#.#.#.#.#.###.#.###.#####.#.#.#.#.#.#.#.###.#######.#.#####.###.#.#####.###.#.#####.#######.###.#######.#.###.#.#.#.#####.#.#.#.#\n" +
            "#.....#...#...#...#.#...#.#...#...#...#...#...#.#.#...#.......#.....#.....#.#.....#...#.......#.#.....#...#...#.....#.....#.#.#.#.....#...#.#\n" +
            "#.#.#.#.#####.###.#.###.#.###.###.###.###.###.#.#####.#.#.###.#.###.#.###.#.###.#####.#######.#.#.###.###.#.#.#.###.#.#.#.#.#.#.#.#########.#\n" +
            "#.#.#.#.#...#.....#...#.#.#.#.#.......#...#...#.#.....#.#...#.#...#.....#.......#...#.......#.#.#...#.....#.#...#...#...#.#...#...#.........#\n" +
            "#.#.#.###.#.#.###.###.###.#.#.#.#######.###.###.#.#####.#.#.#.###.###.###.#######.#.#######.#.###.#.#.#####.#.#.#.#######.#####.###.#########\n" +
            "#.#.#.#...#...#...#...#...#...#.#...#...#...#.....#.....#...#...#...#.#...#.......#.........#...#.#.#.#...#.#...#.......#...#.....#.#.....#.#\n" +
            "#.###.#.#.###.#.###.###.###.#####.#.###.#.#######.#####.#.###.#####.###.###.###################.###.###.#.#.###########.###.#.#.#.#.#.#.#.#.#\n" +
            "#...#...#...#.#.#...#.....#.......#...#.#.......#.....#.#.#...#...#.....#...#...#...........#.....#.#...#.#...........#.....#.#.#...#.#.#.#.#\n" +
            "###.#####.#.#.#.#.#.#.###.###########.#.#######.#####.###.#####.#.#######.###.#.#.#####.#.#.#.###.#.#.###.###.#######.#######.#.#######.#.#.#\n" +
            "#...#...#.#.#.#...#.#...#.#.......#...#...#.....#...#.....#...#.#.....#...#...#...#...#.#.#...#...#.#...#.#...#.....#.#.....#.#.........#.#.#\n" +
            "#.###.#.#.#.#.###.#.###.#.#.#####.#.#####.#.#######.###.#.#.#.#.#####.#.###.#########.#.#.#####.###.#.###.#####.###.###.###.#.#.#########.#.#\n" +
            "#.#...#.#.#...#.....#.#.#.#.#...#.#.......#.......#.#...#...#.....#...#.#.....#.......#.#.#...#.#.....#...#.....#.#.....#.#...#.............#\n" +
            "#.#.#.#.#.###.#.#####.#.#.#.###.#.#######.#.#####.#.#.#####.#######.###.#####.#.#####.#.#.#.#.#.#######.###.#####.#######.#######.###.#.###.#\n" +
            "#...#.#...#...#.#.......#.#...#.....#...#.#.....#.#.#.#...#.......#...#.....#.#.#...#.#...#.#...#.....#...#.#.#.......#.........#.#...#.....#\n" +
            "#.###.###.#.#.#.#########.###.#.#####.#.#.#######.#.#.#.#.#.#####.#.#.#####.#.#.#.#.#.#.###.#####.###.###.#.#.#.###.###.#.#.###.#.#.###.#####\n" +
            "#.#...#...#.#.............#...#.#.....#...#.......#.#...#...#...#.#.#.#.....#.#.#.#.#.#.....#.#...#.#.....#.#.#.#.#.....#...#.#.#.#.#.#...#.#\n" +
            "#.#.###.#.#.#.###.#.#.#####.#####.#######.#.#######.#########.###.#.#.#.#####.#.#.#.###.#.###.#.#.#.#####.#.#.#.#.###.###.###.#.#.#.#.###.#.#\n" +
            "#.#...#.#...#...#...#.#...#.........#...#...#.#.............#...#...#.#.#.....#...#.....#...#...#.#.....#.#.#.....#...#...#.#...#.#.#.....#.#\n" +
            "#.###.#######.#.#.#.###.#.###########.#.#####.#.#########.###.#.###.#.#.###.###.#####.#####.###.#.#.###.#.#.#######.#.#.###.#.###.#.#.#####.#\n" +
            "#.....#.......#...#.....#.#...........#.#...#...#.....#.#...#.#.....#.#...#...#.#...#.#...#...#.#.#...#...#.#.....#.#.#.#...#.......#.#.....#\n" +
            "#.#.###.#######.#########.#.#####.#####.#.#.#.###.###.#.###.#.#######.###.###.#.#.#.#.###.###.###.###.#####.#.###.#.#.#.#.###.#.#####.#.#####\n" +
            "#.#.....#.....#.#.#.....#...#...#...#...#.#.#.#...#.#...#.#.#.........#...#...#.#.#.#.#.....#.#...#.#.#.....#...#...#.#.#.....#...#...#.....#\n" +
            "#.#.#######.#.#.#.#.###.###.#.#.#####.###.#.#.###.#.###.#.#.#########.#.###.###.#.#.#.#.#####.#.###.#.#.#####.#.#####.#.#####.#.#.#.#######.#\n" +
            "#.#.......#.#...#.#.#.#...#.#.#...#.......#.....#.#.....#.#.....#.....#.#.....#.#.#.#...#.....#.#.....#.#...#.#...#.#.......#.#.#.#.........#\n" +
            "#.#######.#.#####.#.#.###.#.#.###.#.#######.###.#.###.###.#####.#.#######.###.###.#.###.#.#####.#.#####.#.###.###.#.#.#####.###.#.#########.#\n" +
            "#...#.#...#...#...#.#...#.#.#.#...#.#.....#...#.#...#.....#.....#.......#.#...#.......#.#...#...#.#.....#.......#.#.#.......#...#.#...#...#.#\n" +
            "#.#.#.#.#####.#.#.#.#.###.###.#.#.#.#.###.###.#.#.#.#####.#.#.#########.#.#.###.#####.#.###.#.#####.#########.###.#.#.#.###.#.#.#.#.#.#.#.#.#\n" +
            "#.#.#.#...#.....#.#.#...#.....#.#...#...#.....#.#.#...#...#.#.#.........#.....#.#.#...#.#.#.#.......#.......#.#...#.#.#.#...#.#.#.#.#.#.#...#\n" +
            "###.#.###.#######.#.#.#.#######.###.###.#######.#.###.#####.###.#.###.#.#.###.#.#.#.###.#.#.#####.###.#####.###.###.#.#.###.#.#.#.#.###.#####\n" +
            "#...#...#.......#...#.#.......#...#...#.........#...#.....#.....#...#.#.#...#.#...#.#.#...#.....#.#.....#.......#.....#...#.#.#...#...#...#.#\n" +
            "#.#####.#######.#.###.#####.#####.###.#.#####.###.#######.#########.#.#.#####.#.###.#.#.#######.#.###.#.#########.#######.#.#.#.#.###.###.#.#\n" +
            "#.#...#.......#.#...#.#...#.#...#.....#.#.........#.......#...#...#.#.#.....#...#...#...#.....#.#...#.#...#.............#.#.........#.....#.#\n" +
            "#.#.#.#.###.#.#.#.#.#.#.#.#.#.#.###.###.###########.#####.#.#.#.###.#.#####.#####.###.###.###.#.###.#.###.#############.#.###.#.#.#.#.#####.#\n" +
            "#.#.#.#.#...#.#.#.#.#.#.#...#.#.......#.#...........#.....#.#...#...#.#...#.....#.#.#...#.#.#...#.#.#.#...#.......#.......#...#...#.#.#...#.#\n" +
            "#.#.#.#.#.#####.#.#.###.###.#.#######.#.#.#.#########.#####.#####.###.###.#####.#.#.###.#.#.#####.#.###.###.#####.#########.#####.#.#.#.#.#.#\n" +
            "#...#.#.#.......#.#...#...#.#.#.....#.....#.#...#...........#.....#.#.........#...#...#.#.#...#...#.#...#...#.#...#.......#.#.#...#.#...#...#\n" +
            "#.#.#.#.#.#########.#.###.###.#####.#########.#.#.#########.#.#####.#####.###########.#.#.#.#.#.#.#.#.#.#.###.#.###.#####.#.#.#.#.#.#####.#.#\n" +
            "#...#...#.#.......#.#...#.#...#...#.....#.............#.....#...#.#.......#...........#.#.#.#.#.#.#...#...#...#.#...#...#.#.#.......#.......#\n" +
            "#.#.###.#.###.###.#####.#.#.###.#.#.#####.###########.###.#.###.#.#.#######.###.#######.#.#.#.#.#.#####.#.#.###.#.###.#.#.#.###.#.#.#######.#\n" +
            "#.#...#.#...#...#.......#...#...#.#.....#...#...#.....#...#.#.#.......#.....#.#.....#.....#.#.#.#...#.....#.....#.#...#...#...#.#.#.#.....#.#\n" +
            "#.###.#.###.###.#########.###.###.#####.###.#.#.#.#.#.#.###.#.#.#.#####.#####.#####.#.###.#.#.#.###.#.#.#.#.#####.#####.#####.###.#.#.###.###\n" +
            "#...............#.#.....#.#...#...#.......#...#.#.#.#.#.......#.#.#.....#.........#...#.#.#.#.#.........#.#.....#.....#.......#...#.#.#.#...#\n" +
            "#.#####.#.#######.#.###.#.#.#.###.#.#.#.#.#####.#.#.#.#####.#.#.###.#####.###.#.#.#####.#.#.#####.#######.#####.#.###.#########.#.#.#.#.###.#\n" +
            "#.#...#...#.....#...#.#...#.#...#.#.#.#.......#.#.#.#.#...#...#.....#...#...#.#.#.#.......#.........#...#.#.....#...#.......#...#.#.#.#.#...#\n" +
            "#.#.#.#.###.#.###.###.#########.#.#.#.#.#.#####.#.###.#.#.###.#######.#####.#.#.#.#####.#.#.#########.#.#.###.#########.###.#.#.###.#.#.#.#.#\n" +
            "#.#.#.#...#.#.#...#.....#.......#...#...#.#.....#...#.#.#.#.#.#.....#.#.....#.#.......#.#.#.#...#.....#.#...#...#.....#...#.#.#...#...#.#...#\n" +
            "#.#.#.#.#.###.#.#####.#.###.#############.#.#####.#.#.#.#.#.#.#.###.#.#.#.###.#.#####.#.#.###.#.#.#####.###.#.#.#.###.#####.#.###.#####.###.#\n" +
            "#.#.#...#...#.........#.....#.....#.....#.#.#.....#.#...#.#.#...#.....#.#.#...#.......#.#.....#...#...#.....#.#...#.#.....#.#...#.........#.#\n" +
            "#.###.#.###.#.###.#.#########.###.#.#####.#.#.#####.#####.#.#.#.#######.#.#.###.#######.###########.#.#######.#####.#####.#.###.#########.#.#\n" +
            "#...#.#.#...#.#...#...#.........#.#.......#.#.#...#.......#.#.#.#.....#.#.#.#.#.......#...........#.#.#.#.......#.......#.#.#...#.......#.#.#\n" +
            "#.#.#.#.#.###.#####.#.#.#########.#.###.###.###.#.###.###.#.#.#.#.###.#.#.#.#.#######.#.#########.#.#.#.#.#.#####.#.###.#.#.#.###.#####.#.#.#\n" +
            "#.#.#.#.#.#.......#.#.....#.......#.......#.....#.#...#...#.#.#...#...#...#.#...........#.......#.#.#...#.#.......#.#...#.#.#...#.....#.#...#\n" +
            "#.#.###.#.#######.#########.#.#####.#######.#####.#.#.#.###.#.#.###.###.###.#.###########.#.#.#.#.#.#.###.###.#.###.#.###.#.###.#####.#.#####\n" +
            "#.#.#...#.....#.......#.....#...#...#.......#...#...#.#.#.#...#.#.#.....#.....#.#...........#.......#.........#.#...#...#.#.#...#.....#.#...#\n" +
            "#.#.#.#.#####.#######.#.#####.#.#####.#.#.###.#.#####.#.#.#.###.#.#######.###.#.#.###########.#######.#####.#.#.#.#.#.#.#.#.#.###.#######.#.#\n" +
            "#.#.#.......#.....#.....#.....#.....#.#.....#.#...#...#.#...#.#.....#.#...#.....#...#.....#...#.....#.#.....#.#...#.....#...#...#.#.......#.#\n" +
            "#.#.#.###.#.###.#.#######.#########.#.#######.###.#####.#.###.#####.#.#.###########.#####.#.###.###.#.#.###.#.###.#.###.#######.#.#.#######.#\n" +
            "#...#.#.#.#.#...#.#...#...#.#.....#...#...#...#.#...#...#.#...#.....#.#.#...........#.....#...#.#.#...#.#...#.....#...#...#...#.#.#.#.....#.#\n" +
            "#.###.#.#.###.#.#.#.#.#.###.#.###.#####.###.###.###.#.###.#.###.#####.#.#.#########.#.#####.#.#.#.#####.#.#####.#####.###.#.###.#.#.#.###.#.#\n" +
            "#...#.#.#...#.#.#...#...#.....#.#.....#...#.#.....#.#.#.#.#.........#.#.......#...#...#...#.#.#.#...#...#...#...#...#.#.....#...#...#.#...#.#\n" +
            "###.#.#.###.#.#.###########.###.#####.#.#.#.#.#.###.#.#.#.#########.#.#########.#.#.###.#.###.#.#.#.###.###.#.#####.#.#######.###.#####.#.#.#\n" +
            "#...#.#...#...#.....#.....#.........#...#.#.#.#.......#...#.......#...#.........#.#.#...#...#.#.#.#.....#.#...#.....#.......#.#.#.#...#.#.#.#\n" +
            "#.#.#.###.#####.###.###.#.#####.#########.#.###########.###.#####.###.#.#########.###.#####.#.#.#.#####.#.#####.###.#####.#.#.#.#.#.#.#.###.#\n" +
            "#...#.....#...#.#.#.#...#.#.#...#.........#.#.......#.....#.#.....#...#...#...........#.......#...#...#.........#.#.....#...#.#.....#...#...#\n" +
            "#.#.#####.#.#.#.#.#.#.###.#.#.###.#######.#.#.#####.#####.#.#.#####.#####.#.###.#######.#######.#.###.###########.#.###.#.###.###########.#.#\n" +
            "#...#.....#.#.#.#.#...#...#.#.#...#...#.#.#.#.#...#.....#...#.#...#.#.....#.....#...#...#.......#...#.......#.......#...#.....#...#.....#.#.#\n" +
            "###.###.###.#.#.#.#####.###.#.#.###.#.#.#.#.#.#.###.#.#.#####.#.#.#.#.#.#####.#.#.#.#####.#########.#.#####.#.#####.#.#########.#.#.###.#.#.#\n" +
            "#.#...#.#.#.#...#.....#.#.....#.....#...#.#.....#...#.#...#.......#.#.#.#.....#.#.#.......#.#.......#.....#.#.#...#.#.#...#.....#...#.#.#.#.#\n" +
            "#.#.#.#.#.#.#####.#.###.#######.#.#.#.#.#.#####.#.#.#.###.#######.#.#.###.#####.#.#########.#.###.#######.#.#.###.#.#.#.#.###.#######.#.#.#.#\n" +
            "#.....#...#.....#.#.#...#.....#.#.#.#...#.......#.#.#...#...#...#.#.#.#.....#...#.......#...#.#.#.....#...#.#.....#...#.#...#.....#.......#.#\n" +
            "#.#.#####.#####.#.###.###.###.#.#.#.#########.###.#.#######.#.#.#.###.#.#####.#########.#.###.#.#####.#.###.#.#.#######.###.#.###.#########.#\n" +
            "#.....#...#...#.#...#.#.....#.....#.......#...#...#.........#.#.#...#.#.#.#...#.......#.#...#.......#.#...#.#.#.........#.#.#.#.#.....#.....#\n" +
            "#####.###.###.#.###.#.#.###.#####.#####.###.###.#############.#####.#.#.#.#.###.#.#####.#.#.###.#####.#####.#.#####.#.###.#.#.#.#####.###.###\n" +
            "#...#...#.....#.....#.#.#...#...#.....#...#.#...#.....#...........#.#.#...........#...#.#.#.....#.....#.....#.....#.#.#.....#...#...#...#...#\n" +
            "#.#.###.#########.#.#.###.###.###.###.###.#.#.#####.#.#.#########.#.#.###.#######.#.#.#.#.#######.###.#.#.#.###.#.###.#.#####.###.#.#.#.###.#\n" +
            "#.#...#...........#.#.#...#.......#.....#.#.#.....#.#.#...#...#.#.#.#.#...#.....#.#.#...#.......#.#...#.#.#.....#.....#.#...#.#...#.#.#.#.#.#\n" +
            "#.#.###############.#.#.###.#######.###.#.#.#####.#.#####.#.#.#.#.#.#.#.#.#.###.#.#.#####.###.###.#.###.#.#.###.#######.#.#.#.#.###.###.#.#.#\n" +
            "#.#.#.......#.....#...#...#.......#...#...#.......#.....#...#...#.....#.#...#...#.#.......#.#.#...#.#...#.#...#.#.....#.....#.#.............#\n" +
            "#.###.###.###.###.#.#####.#######.#.#.#########.#.#.#.###.###.#.#######.#.#.#.###.#######.#.#.#.#####.###.###.###.#.#######.#.#.#########.#.#\n" +
            "#...#.#.#.......#.#.#...#...#...#...#.......#...#.#.#.......#.#.#.......#.#.#.#...#...#...#...#...#.....#.#...#...#.......#.#.#.....#...#...#\n" +
            "#.#.#.#.#########.#.#.#.###.#.#####.#######.#.###.#.#.#.#.#.#.#.#.#######.#.#.#.###.#.#.#########.#.#####.#.#.#.#####.#####.#.#####.#.#.#.###\n" +
            "#.#.#.....#...#...................#.....#.#.#.#.#.#...#.#.#...#.#...#.....#.#.#.....#...#.......#.....#...#.#.#.#...................#.#.#...#\n" +
            "#.#.#####.#.###.#.###.#######.#.#.#####.#.#.#.#.#.#.#.#.#.#.###.###.#######.#.#############.###.#######.###.#.#.###.#.#.#.#.#####.#####.###.#\n" +
            "#.#.........#...#.#...#.......#.#.....#...#.#...#.#.#...#...#...#...#.......#.........#...#.#...........#...#.#.....#.#.#...#...#.#.....#...#\n" +
            "#.###########.###.#.#.#.###.###.#.#.#####.#.###.#.###.###.###.###.###.#######.#######.#.#.#.#############.#####.#####.#.#####.#.#.#.#.###.###\n" +
            "#...#...#.#...#...#.#.#...#.#...#.#.#.....#.#...#...#...........#.....#.......#...#...#.#.#...#...........#.....#.....#.#.....#...#.#...#.#.#\n" +
            "###.#.#.#.#.###.###.#.###.#.#.###.#.#.#####.#.#####.#.###.#############.#.#.###.#.#.###.#.###.#######.#####.#####.###.#.#.###.#####.###.#.#.#\n" +
            "#.#...#...#.#.#.#...#.#...#...#...#.#.....#.#...#.#.#...#...#.....#.....#.#.#...#.#.....#...#.......#.#.....#...#.#...#.#...#.#...#.#.#.#...#\n" +
            "#.#####.###.#.#.#.###.#.#######.#.###.#####.###.#.#.#####.#.#.#.###.#####.#.#.###.#########.#.#####.#.#.#####.###.#.###.###.#.#.#.#.#.#.###.#\n" +
            "#.....#.#...#...#.#.#...#.....#...#...#.................#.#...........................#...#.#.#.....#.#.#.....#...#.#...#...#.#.#.#.#.#.....#\n" +
            "#.###.#.#.#######.#.#######.#.###.#.###.#########.#.#.#.#.#######.###.#.###.###.#####.#.#.#.#.#.#####.#.#####.#.#####.#######.#.#.#.#.#######\n" +
            "#S..#...#...................#...#.....#...........#...#.........#.....#.............#...#.......#.............#...............#.#...........#\n" +
            "#############################################################################################################################################";

    @Test
    void parseInput() {
        Day16 day = new Day16();
        char[][] map = day.parseInput(input);
        assertEquals(15, map.length);
        assertEquals(15, map[0].length);
        assertEquals('#', map[0][0]);
        assertEquals('E', map[1][13]);
        assertEquals('S', map[13][1]);
    }

    @Test
    void findStart() {
        Day16 day = new Day16();
        char[][] map = day.parseInput(input);
        Position start = day.findStart(map);
        assertEquals(13, start.line);
        assertEquals(1, start.column);
        assertEquals('>', start.direction);
        assertEquals(0, start.currentCost);
        assertEquals(true, start.history.contains("13,1>"));
        assertEquals(1, start.history.size());
    }

    @Test
    void findNextPositions() {
        Day16 day = new Day16();
        char[][] map = day.parseInput(input);
        Position start = day.findStart(map);
        List<Position> nextPositions = day.findNextPositions(map, start);
        assertEquals(13, nextPositions.get(0).line);
        assertEquals(2, nextPositions.get(0).column);
        assertEquals('>', nextPositions.get(0).direction);
        assertEquals(1, nextPositions.get(0).currentCost);
        assertEquals(2, nextPositions.get(0).history.size());
        assertEquals(true, nextPositions.get(0).history.contains("13,1>"));
        assertEquals(true, nextPositions.get(0).history.contains("13,2>"));
        assertEquals(12, nextPositions.get(1).line);
        assertEquals(1, nextPositions.get(1).column);
        assertEquals('^', nextPositions.get(1).direction);
        assertEquals(1001, nextPositions.get(1).currentCost);
        assertEquals(2, nextPositions.get(1).history.size());
        assertEquals(true, nextPositions.get(1).history.contains("13,1>"));
        assertEquals(true, nextPositions.get(1).history.contains("12,1^"));
    }

    @Test
    void walk() {
        Day16 day = new Day16();
        char[][] map = day.parseInput(input);
        Position start = day.findStart(map);
        int cost = day.walk(map, start).currentCost;
        assertEquals(7036, cost);
    }

    @Test
    void walk2() {
        Day16 day = new Day16();
        char[][] map = day.parseInput(input2);
        Position start = day.findStart(map);
        int cost = day.walk(map, start).currentCost;
        assertEquals(11048, cost);
    }

    @Test
    void walkFinal() {
        Day16 day = new Day16();
        char[][] map = day.parseInput(finalInput);
        Position start = day.findStart(map);
        int cost = day.walk(map, start).currentCost;
        assertEquals(143564, cost);
    }
}