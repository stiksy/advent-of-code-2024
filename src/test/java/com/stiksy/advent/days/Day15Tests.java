package com.stiksy.advent.days;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15Tests {
    String finalInputMap = "##################################################\n" +
            "#..OO......OOO.......#O.#O#..O#.O.O.#..O#.O....OO#\n" +
            "#...OO..O..#...O.OO...O...OOOOOO#O...#...O..O#.OO#\n" +
            "#...OO#O....O.......O.......OO..O..O..O#OOOOO.#.##\n" +
            "#O....#...O..#...#OO.O...#O..O.O#O.O....O.....O..#\n" +
            "#OO..O....O........OO..#O...##...OO.........OOOO.#\n" +
            "#.O..O.#..OO#......O.......O..O.......O.O.#..#..##\n" +
            "#.........#.OOOOO....O...O..O.OO....O....##..#.O.#\n" +
            "#.O.O.OO.#..O..O...#O.......OOO.OO...#O.#.#O.O...#\n" +
            "#...#...OO...#OO..O..O#O.OO......O.O...O....O..O.#\n" +
            "#OO.O...O.O#.#.OO....OO...O#O.O.O....O...##...O.##\n" +
            "#.#..O.O#....O...OO.OO..OO.......O#OO.....OOO.#..#\n" +
            "#.......OOO...O..O.O.O..O..#O.O#OO..O..OO.O......#\n" +
            "#....O.O......O...#O.O#O..O..OO.OO...OO..OO...#.O#\n" +
            "#O....O.O.O...OO.O..O....O.O..OO..#OOO.OO.O......#\n" +
            "#O..#.........O..O.O..#..#.....#O.O....#.O...#.O.#\n" +
            "#OO#O..#....O.O...OOO..#..O.#...O..O...O..O.....O#\n" +
            "#O...O.#..O....O....O.........O....#.............#\n" +
            "##.O.....O...O...#O#O...OOOO...O.O....O..OO.....O#\n" +
            "##...O..#.O.#..OO.....#...OO.#....O.......O..O...#\n" +
            "#OOO#...OOOO....#.#.......OO..O.O...O.O..O..O...O#\n" +
            "#......O.O..O...O.#.OO..O....#...OOO........OO#..#\n" +
            "#.OOO.O###..O.....#.OO...OO#O.O.....O#.OO#.....O.#\n" +
            "#.#O.......O#..O.O.........#O...OO..#O...OO..OO.O#\n" +
            "#..O...O......O.OO...O#.@.........OO..#.........O#\n" +
            "#...##.O.OOOO.....O..OO.......O.#O.....O#OO.OOO..#\n" +
            "#OOO#O..##........O......OO....O..##.O..O...O...##\n" +
            "#OO......##.O.O#.#.....O.O.O.#O.O......O.O##.....#\n" +
            "#.O.O.O..O....O.O.....O...#.......#.O###.#O..OO..#\n" +
            "#.OO.OO.....O#.O..O#OO..OOO..OO...O...#O#O.##.#O.#\n" +
            "#O...#.O#...#..O.O....O....OO.....O...OOO....O..O#\n" +
            "#O.......OO..#O.OOOOO#O...OO.OO....OO........#..O#\n" +
            "#.O...O....#.#.OO...O...O.OO...OO..O.O...OO.....O#\n" +
            "#O.OOOOO....O..O..O....#.O........O....O.OO..O...#\n" +
            "#..#...O#...O...........OOO...O.....O.....#......#\n" +
            "#OO.O...........#.....#.#OOO..O.....O....#O.O....#\n" +
            "#.#...OOO..O.#.O.......##O..OO.O...O.#O.###O.....#\n" +
            "#O...OO...O.#.O......##O......O..O......O.....O..#\n" +
            "#.....#O..O......OOO...O.....O.......O##...#O....#\n" +
            "#......O........#O..#...OOO...O...O....#.......O.#\n" +
            "#O...O.O..O.O#...O##.OOOO.O.O.O.........O....#..O#\n" +
            "##OO.......#OO#.O...O..O.O#....O........#.OO...#.#\n" +
            "#.O...#O...O...........OOO...#..O......#.OO..OO.##\n" +
            "#O.#......#......O#...OO...O....#..#O...#.#...#..#\n" +
            "#.OOOO....O........O.....O..#.O..O#O.......O..O.O#\n" +
            "#O...O...#..O...OO...#O#.OO..O....#OOO......O.#..#\n" +
            "#...#..O..O..OO...#O........#.#..OOO#....O.O.#O..#\n" +
            "#O.OOO...O..O..#.O..O..O.O.O.O....OO.O.O.#.....#O#\n" +
            "#OO..#O.O.#.#.O.....O#.....OO.O...OO.....O...OO..#\n" +
            "##################################################";

    String finalInputMoves = "v>>^^<v<^>^v^>>>^v^^<v^<<>v<^>v^><vv>^v^^>>>v<<>>>>>v>^>^>><v>v^vv><>^^>v^<>>^><^^^v^<>v<^^v>^v<<v^<^<^^<<<^<^>^^v<>v<<^<>v<^>v^>^^>><^<<v>v<<v>><<v^^vv<<^>^><vvv<>^><>>><^>v<><vv<<>>v^>v<^><>v<<>><<<v<<>v<<v^^^^>>v^^<v^^>><>^v>vv>v<>^<v^^>^><v^<<>vv>vv>><>^>^>^<v^<<>v>v>v<>><<^>v^<^<v<v<vv<>v<<^>v>>^v^<v<^v^^>><v>vv<^>v^>><>>^>v^v><v>^>><<>^<^>><<><<v<>>>^<^><v>>^^^^vv^vvv>^vv^^v^^<v><vv>^^>v^vvvv^>^^^v<^v^<<vv<^>><^^^<<v>>><><<>^v<<<><^v<>^>^v>^^vv<<><>^<>>^v<^v><v<vv>>v^^><^>v<>^<^^>v<>><vvv<^<<<><vv^<<>><^v<<v<><>vv<v><^v<<^<<v>>vv<<>>>vv^<<<<<^^<><^>vvv>>><<^v<^v^vv^^<v^vv<<>v>v^v<^<><<<<><^>><><v>v><<v<^>^^vvv^^^<^^<>^>v<<<>>v>^^<<<>>>>>>^>v^v^>^>><^><v^v<<v<^>^v^v^v<^<^^<<>^^>^><^<>>>v<^^v<>>v>^<^>>>>^<vv^<^>^>>^v^v^><<^>><>v<<^>v>>v<><>vv>vv><^vv<v<v^>>^v^v<>><^><>^^<v>^^><>^>vvvvv^>v>^><<>><^>v><^<<^v<<vv><^<v^v>^^v^v^>>>^v<<^^>v><^^v<><>v>^^<>^^<^<^<<vvvv<v>v>^v<vv<v><v>^v<^<<<><<<vv><><>v<vvv^<vv>^<vv<v^<><^vv<<^^>>vv^^><vv<v>^<v<<<<>vv<^<<^^>vvv^v^><^v>v^<<^v^><v<<v<v<^^<vv\n" +
            ">v>v<vv>v>^>^>vvv><>v<>>^v>^vv<<^<<v<><vvvvv><^^^v<^v^><<>v>v<>><>v<><<<>vvv^>>^^<^v>^^v^<<>v>v><v><v>>^vv<<><<^^v<<<^vv<^>>>^^<<>^v^^><>>v<>><^v^v><<v><>><^>>^^^><v^>>vv^>><<<^><v>>v<<<<><>vv<>>>><<<^<^vvv><^v<<^v<v^v>>^<^^vv<<^v^>>v>vv^<><^<^><^<^<><>^v>vv<<v><<v>><vv^>^<^v<vv<<^v><^^>v<<<<<>^^>>^>v>^^<v<<^^^^v^>v<>vv<<>v^>><<v<^v<>vvv^v^<>>v<vv^<v^<v^<<^<<^^>vv>v>v>^vv^^v<>v<v><^v^<v>v^><<^vvv>^>v>v<vv<>^vv^>v<<><<>^^v>>v<>^<<<^<<>v<<>>v>><<^^>v<<<vv>>><^<>>>v><<<><^>^v^^^^^<><>^>^<^^^<^<<^^^>vv<><v>^v>>^^v^v^v>><<<<<^v^<<v<v^<^^^<<>>^^v<^>>>>vv>v^>^<<<>>>^><v<^>vv<vv<^>^vv>>vv^>v^^>^v^<<^<^v>>>^^>^^v^>vv^<><<>^vv<<<v>>v>>v^<vvv<vv>^v^^<<>><v<>^<v>>>>>^<<<^><<v^<<<<>^<^^^v<<v^v<^<><v^v^vvv>^>v<<^^^<^>vv^^>^v><^>^v<<^^>vv>>><^><vvv>v<v<<<>^v<^v>vv^>^v^<^<v^^>><<>^><>v>^^<<<>v>v^><>^^^>><><v>>v^<vvvv^v^>>>>>>>>v<v<<^vv><^<^<>^^^>^<^><v<^^<^v^v^v<v>^^<v><^>^^>v^^vv>^><v>v>^^<v^>^v<v<v^<>^^<><^^<<>^<>v<^^>><^v<>>>^><<^<<^^^v>v>^^^v<<^^>^vv>^v><<>>v<v>^v>v<>v><>><v>vv^v^<>^^v>^^>^v<^>v<>\n" +
            "^<><v<^<<<^v>^vv<<>^v^v^<<<^>>>>^^>^<>v><><^^<v^v^^v^><<^^<>><^v^v>><<<^<<<v<>^v>>>v>><^^v<vvvv>>><v<>^v<<v^>v>v>v^<v>^v>>vvv^^<<<<^><>^>>v>vv><<<<<<><><^><v>v<v^>^v<<^^>^<<^<^v<^><>>>>v^>>><<^^v><vv<<v^>^^^>v<v>><v^^^^<>v<<>v<^<><<vv^>^<><^v>v<v^<v^^^>v^><^<>^^v>v>><v<<v>^<v^<><<<<v>>^v<>vv<>^<>v^v^>^^^<>^<>>^^v>v^^^>v^>v<vvv><<>>^^v>^v>>v><vv>^v^<<>^v^>^^^<>vv<>><><<>>^<>^v<><><<v>>^>vv^<^v^<^><^>^^^v<^v>>^<>>^^<><>>v^<vv^<^<>^<<>vv^<<>v^>>vv<<<^v^<<^v^^v<>v^<vv^<>>>vv<><v<<><<vv><<>v^vv^^<v<^<^^v>>v<vvv>^v<><<><v^>v^^v<^<v<v>v>^^vvv>><^^>>v<<<^v^<^<v>^^<^<^>^>^>><><<^vv^<vv><v><<>v>v^<^v^>>^v<<><<v>v^>^^>v>vv<v><^v<v<<>^>><v<v^vvv><^^^^>^v<v^<<<>vv^<>>>>><^v<<v<<v<^><<v>^><><>^>vv<<>^vv<<v><<>^>vvv><<^v><^<>>><><^<>>^>>^v<<<>v<^v<>vvv<><>>>^><v^<>v<<v^>>v^^<v>vv<>v<v>><>>^v>><<>v>v^v>^>>>vv^^v<>v^>>vv^<^v>v<v>v<<>v>^v^v^^>><v^^^^>v>>v<^<><vvvvv<<^^v>>>v<^<^<>^>v^>v><v<^v<<<>^^vv^^^<><^v^v>vv^<>^>>^^v^>vv><^^>^<^>^>v^>^>><v^v<v^<<v>v<^v^v^<v><v>>v<<<^<>>v<><<v<vv^v>^<^vv^v<vv>v><vv<v\n" +
            "<<>^vvvvvv>^<<v^>>v^><>vv<vv>^<<^v<>v><>^>>>vvvv<v>^>^<>^<>>>v<v>>v<<>>v>^>^^^vv^v><v>^<v>v<v>><>v><<v>^<v><<vv^^v>>v<<>>^<^><v^v>>v^^<^^^v<<<<^><vvv>v<^v><>>><^>><v^>>^<^><><^<<><<>^<v><<v<^<^vvvv><^vv<v<v<<><v^^>^^^v<>^>^v^<<^><v>>v>^^^^<v<<vv><>>v^>^^>^^<<vvv<v>v^vv^>v<^^^<^^v<^v^>^<^>^v<vvvvv><^^v>v^><^>^v^<>>^>>^^>^<vv>v^>^v<<^<<><v<>v>>v<><^>>>v^vv^<^v^^>>^<v<v<^>^^^>>>v^^v<^<v<^^<><<v^>^<<^<vvvv<vv<vv>^>vv^<>^>>v><<<<v>^^>^>^><vv>^<v<^vv<<^v>^v^<>>>^v<<<v>>><vv<^>v<^vv<<^><v<><<>^<>vv<v^v>>v>vv<^><>v>>^v<<v>^>v>>><<<<<v<<v<v<<^^<^><<^><v^vv<<<^v>v<v>>>v<^^<<><>v><^^v^^<>>v<v>^><<>v^>>v><^>^<>vv><v^vv><>^>>v^>>v<vv^<<>>><^^v>^<<<<^<>^><<v^^^>v^v^^vv>>^>v>^^vv<>^<<^^v<v>v^<^<>^<v>^v^<>vvv^^>v<v^<^^^v<>v<^<^<<v^><<v>vv<>>^>>v^vv<^<^^^^v^v>^<<<v<>v>^v>v>vv<>^<<>v>v^v^<^>v>>v<^v<^<><^v^^vv^>^<v<>^<^^<^v>>^<><v<v^>>v>>>v>vv>^^vvv>>^^<>>>^><>^^^<<<^^<<<<>><^>>vv>>>^^^><<><<<>^v>v^<^^^<>v<^<vvv>^<<<^^<>^v><>^^^>><<v><vv^<<^<<vv<><>v<<>^><<^^<^^v>>>>vv><<^<^<v><v^>>><>v<v><<<v<>v>v>vvvv>\n" +
            "<vv>v^vvvv>vv^^^<v^vv<<^v<<><^v^v^>^^<^^^<^<<>><<>^>^<<<<v^^>><<^v^><^v<>^>>^<<^<>v<>v>^>><^vv>v^v<><v^><<<v^^<>>v^<<<v^vv>><<^>v><<^><<vv^>v^^<v><<<^<vv<^<<<^>><>^<v^^^^>^v<v>v^v<^<^v<>v><^>^>><<<<>v^v><>^^><>^^^<>^<>v>^vv^^<^<<v<<^^^^v>v^>^>v^><<^^v^^>^>vv>vv<^v<>^v<^^><>>^>v^^v^^>>^^<><v><v<>v>^>^>><v<<<^><<><^<>v>>>>>>>^v^>vv^^<^<>^v>v>^^<v<<<^>><^vv>>^vv<^<^vvv^<<>^^>^^v^>^<<<>^^^v<<>>^<><^>v>^<<^v>>v^^>>><^vv<^^>^v>>^v^>v><v^^<><><<^v<^><^<<v<<>><>v^<>v<<v^>v>^v>v^^>v>>>><vv>^>^><<v^><v>^><>v<v^<^^<^v^^<>>^^v<v^^<>><^><^v<>vv^><>>>><<>^v^<<<^^<>><v^<v>v^>>^>><v><><^v^>>v<<>>v><v^<><<<^^^vv<<<<<><^^>v<^^<v<>>v^<<<^v>v<^^^vvv^^v^<^>vv^<><>>>v^<^^>^><>>>vv<^^<>^><<vv<>>>^<v^<vvv<<<^^<^<vvv><>v>>v^v<^<<>^vv>v>v^vvv<^^^v<^^<^>v^vvv>v>v<<>><^^>v<><^>vvv^>^v<v<<v>v>v<^^v>v^vv^<^<>^>^<<^v<>><<<^<^^<<>^^^>v>><v>>^vv>v^v<>^v^<<><v>^^v^^v^^><><v^><^v>>>v>^<^^v^<^<^>><>>><>^v<<<^>^^<vv^<^^<>><<^<<v^>^^^<<>>>^<>^<^^<v^>vv<v^v<^vvv<>v<v<>><^v^^<^v^v^^v><^v^v^<>>v<>vv^v^vv^^<^>^>vv^vvv<>v^vv^v<\n" +
            "<>v>^<<<<>^v<>^>vv^<vvv^v<<v^>><<v^v^vv^^^^v>vvv><v<^^^>v^>^><^<v>>vv><^^>>v^<^v^<v>v>vv><v><<vvvv>vvv<^^v<^v<>><^^v<<v<^<^^v<<^v<>vvv<v<^>>^v>v^^>^>^^>v<<>^^v<v^^>^<v^<>^v^<v><<v>^v><vv^v^<v^v^><<>>vv>v<^>v>v^<>>v>>>^^>><>^^vv^<v^^v<^<^^^v^^><>v><v^<v<v^v<^^>^v<v^^><><<vv<v<><<>><^v>>v<v^>>><vvvv^>v>v<<v<<^<vv^^^vv<vv<v^^^<>><^<v<<v^><<<>^<>v^>><^v^>vv^><^^>^<^vv<v>^<^^<>>v^<^^<><<vv^<^<<<>><v^<<^^<<>v>><<v<>v^><^><^<>><^<v<^^v>vv^><^>><^<v><<^<><>^^>^^<<^^>vv^^^vv<<>^^^<<><^>>^<^<v<^^<>^<^<><><>v^^vv>>^><>vv>v><^^v>^><<^v>vv<^>^^<v><v^^^><^^>vv^<>v^<v<^^vv^v>>>^>^>>v^^^<v^v>>^^v<<v^>>>v<v>^>v>^^^^^>v<vvv<<<vv>^^<^^>v>^v>v<vv^<<>v<>v<^v><<>>^v^vvv^^><<v<v>>^^>v<vvv>^>^<><vv>><<<<v<vv^<<<<^v^<>v<>v<^^v^<>^>><>><vv^<<<^v<^<>v<><<<^>^^^>^>^v><^>v<v^^>v>v><<^^^<>^<<><>v<>v>^<vv<^<vv<^^vv<<>>>vv>^v^^v^>v<^<^>^v^>^v>>^vv<<vv<<<^^<^<>>vv<>><><>^v<^v<^vvv><^v<v^vv><<<v^^^>v^v<<<^<<><^^v^<<>^>><^v>^v^^^^v^v>>>^<v><vv^v^^<><<<v^>>^>^^vv^v><<<>v>>>^>>^>>^<v<<<vv>^^^<v>^^v><v<><v^v<><>><<^^v<><^>\n" +
            "v<><>>>v^<>^>v<<^vv<<v>^<>^v^<v>^<vvv<v^><>^<v><v<>v^v^^<>v<><v^>vv^^vv<^><><^>vv^>^v>>^<^v<vv^>v<<v<><v^>>^^^>>v>><^>vvv><<^><>v>v^v^v>^><<^^vv<v^v>>>^<v>><<v^<v^^^v^<v^^v<v^<<^v^<>>^>^^><v<>><><<<^<<<^v>v>>v^v^v<vvv>^^>vv<^<^^<^^^<>v>^>v<^><<<<><><<v>^><<v>vv>>><<v<<v>^><v^v^vv^^>>^v<>>v^^<<v<<<>>>^vvv>v^><^vv<<^v<>vv><vv^^>>>^<<v^vvv><^^v<>v>^><<>>v>><<v^v^<^<>v<vv<v^>vv^<^^>>^<^><<v^<<^>^>>v^^<<><vvv<vv^<^<>^v^<v>^<vvv>^<>^>v^^^^vv<^^<>vv^>v><^<^v>vv>vv><v<^<^v^vv^<v>v^v^v^v>><^<><>><>>><^v>>>^^>>v<><<>><^<><<vv>v>>v<^^^^<><<>vv<^<<<v<<<v^v^><v^<<>^vv^<>v<^v^v>^>>vv>vv<vv><^<><^<^^>>><>>^<<^^v>>vvv>v<>^^><>v^v<<^^vvv<<>^v<^^^<^v>v<v^v^>^><<^^<v<>^><v^<^<^<>vv>v><<v>^vv<^<<vv<<<>vv^vv<vv>>><v<v^>>^vv>v^^>v<^^<^vv<>><><^v>v<<<^<>>v<^^<<<>>^vv^v><><v><<^<<^v^^^v^v<v<vvv>>^<v<^>>>^<vv>^>>v^^v<^>^<vvvv>>^>vv<><<<v^><^^v>v^>^^>>>^v<>>^^^v<<v><<vvvv^<^vv>^<^>^vv<><^><vvv>v^^^>><>v^v>^vv>>><<>v>>>vv<v<v^<vv>v^>>v^v<^^<v>>^<v^v>^>v^v><<<><<<^>^<v^>v^v^^>>v<<>><<v>vv^<^^><^vv<v<<>v^^v^><<>v>\n" +
            "<<^vv>^^^>>>v^v^<v<>>><v^^>v>v^v<v>><vv<v^^<>vv<<>><^<>>v<><vv<>>^<^><<v<<<>>vvv><v^^v<vvvv<>^^^v<^<v^<<<<><v>vv^<>v>>v><<>v^><<><v^>>^^<^<v^^<v^>>v>^<v^^<vv><<^v<><v<>^vv<><v<^v><<^^^v>^^>v^><v^^<v^^^>^^<<>>^><>^<^v<>^^v<>v<<v^>^^<^v>v>^^v><<><^^<^v^^^v<^<<>^^>v>v^<<>><<<v>>vv>><v<<>v<v^^^>^^v><^^<<^>^v>^<^>v<<^vvvvv<^^v<>^>>^><v^<^^^>^^<vv<v>vv<<<<v^^<>vv>vv><<><v>>v>^>^v^vv^>>^^v^><<>>>^><<^v><<<<<^^>vv>v<^v<><<^>^^^^>v<>>v><<v>><>>vvv^<<v^<v><>^>v>v^<^<^>^^^v<<^vvv<>vvv^<<v^v^><<<^^^<^^^v>^>^v>vv>v^><<v<<<<^^>>v<^v<<<>>v<^v>^vv^v<<v<<v><v><<^<^v^^^vv>^^v^<>^>>^<^<^>><<^><>>v<v^^v<<^<<<>>^v^vv><>>^<v>><v^<^>>v>^^v^<^>>^>vvvv>><<>>><v>v<<^>v<>^<v>^v>>v<>v<vv>^v>^>>>vv^v^^^^^<vv<v<<v>>v>><v<^<<v^>v<v^<<<v<<>^^>^v^^vv^<^<^v><<>^>^v<<^^>>^^v>v<^v>>^v<^^^>^><^>^<><v><>>^>vv>>>v<v^^>^v^v^><^><v^^^<v><><^<>^>v>><<<^^v<><<>v^v<^>vvv<>^>vv>>><><v<<^<^<<^v><v^<v>^><^^^^v^>^^<<v^<<v^v^><>^>^>>v^<^>v<>v<^^<>vvv<><>v<^<^<<^^>^<><^>v><vvv^^v<^>vvvv>v>^vv^^v>^<vv^<^><v>^v><><><v<<v<v^<^v>^^<>^>>>>\n" +
            "^v<<^>>><v><v<^>^^<v<vv^<v<<vvvv>>^v<v<^<>v>><>v>^><vvvv<>^^<<><>>vv<<^^^<<^^^>><^<<>vv<v^>^>vvvvv<^<^v><v^<<<>>vv^^^>^<<<vv^<^<^v>>^v>v<><^v>^^vv>^<><^^^v<><<vvv><<^>^^<<^^>><<^^<^^<><<>>^<<vv<<>^^^^v><>v^>>^>^<>v^>>><>^<<vv^^>^v>^v^>v^>^<^v^^^>>^vv<>>>^vvv>>^vvv>^<vv^v^^>>><v^v^v<><v^v<<>>>^^>^><vvv^^v>vv<>v<vvv>^<<><^>>^<v><^^>^^<<v^^v<>^^>v<>>><^v^^>>^^<v<<<<^><>v<<>><><^>>^<vvv>^v^vv^vv<^<^>^>v>><v>^^<<v>>><>v^v^>vv>v<>v>v^^<<^<^vv<>^<><vv>^^vv><v>>^^^<<<<>vvv^<<<>><><^^^vv^vv^<>^><<<^vvv<<><>^v<>>^<>>v^^>v<<<^vv<<><v^>>vv<vvv<>vv><^<>^v<>>^v>^<^^vvv<><<>^>v^^^^<>v^^<vv^^^<^^v>>>vvv^^^<^>>^v>>v><v>^v>^<^<^v^<>^^v^v^^^v^<^^<^>>v<^<>^>v^v>>>><>vv^vvv>^>v<<<<><v><>><>>><<v^<vvv>^^vv><^^>>^vv^v^<^^<vvv<<vv^^>^>v^>>>^^>v<>^>><><v<v<>^^v<^vv<vvv^vv^><^<^^>><<<^><v<^>>>v>>>^v<^<>>v>^v^<<v<>^v^v>v>v>>><v>v>v<><<><^v<^v^^>>^vv^^^v>>^<^v><^><<^^<v<>^^^<<v>vv<<vv>^><v<v>>>v^>^><vv^v<v^>^^<vv>>>^vv<v<^v<v<vv><^<vv<<>v<>>v^v^<><>v^^>v>><^>v>v^<>v>^v^<<>>>^^v^^>v<<>v>^>^v^vvv^v<v<^^>v<^^<vv>v>^\n" +
            "^^v^vv^>>>v<<^^<v<^>^^<vv>><^>>v>>v<^>>^^>vvv>^>>vvvv^<<v<<^>>^^^^^^v^<^<>v<^>^<^<v>>>v>>^>^vv<>v<<v^^<v><^><^<^v^<^v>vv^^<>>>>v^<<vv^^>v<^^v<<^^<>^<vvv>>^>v><v<^v<<vv^<v^v<v<vv^<>>>v^^v<<vvvv>v^v><<><^^v^><v^<>>v>>>^<v<vv^v^<v<^<<<^<^v>^<<^<v>^<v^vv><>>v<<<^>^v>^vv^v^v<vvvvvvv^<^^v^v><>^<v><^vv^>>v>>>v<v^^>><^><<>>>^>^v^v>>^<v>v^<>v><^<v^^^<^^<v>v>vv>>>>v<v>^v>^>>>v>^<><<vv<^>^v<v>vv>^><^<>^>^>^>^>>^<vv<v<>>vv>>vv^<<<<<<vv>><><^>><>^><>v>v<^^<v^>vv<>>^^<^<<<<<^v><>^v^>^>>v<v^><^>^v>vv>>^><<v^^^><><^v<v>vv^v>^>vv^v<<>v<<>^<<>^<>>><^^<v>v<v<>vvvv<<<<v<>^<<<<>><vv>^^<^^^v>^^v<v<^>v<<>^vv^^<>v<^v<<>><^<>>>^<v^>>>>^<><<<vv^v<<v<>>>v^^v<v>^^^v^^<><v^vv><^>><^^<<^<^<<><>^vv>>v<>^v<<>vvv^vvv^v<v^<>>><<<v<><<>vvv>^^v^<>v<vv<v><v><>vv<^>^vv>^v^^v^>>>^>^<vv<v>^><>>v<^^><<<<^vv^><<<^>v^<<^>v>><<<>^>>^><<><^v<><^vv^vv<>v^v<v>^>>^vvv^^<>vvv<v^v^<vv^^>>>v<v<v>><v^>vv>^^v<v^^^v<<v<^>^vvvv^><vvv<><^<>^v<<^>^<^><>^^v^^>v<>>v^<>>><><<^^vv>vvv^<>^<v<>><^^^<><<^^v^<v<<^><v<^vv<>^>>^><^v><>v<><<<>v>v^v>^<<\n" +
            "vvv<><v<<v>vv^<><^<>^v^v<<v<^^^^^<>^vv>^<<>^v><^v<^v>^^v^^^^^>v<^<>^>vv^^><<><^<vvv<><v<v^>vvv^v>^^><>^><vv<^<>vv^<<>>>^<v^<vv^v<v<<>>^><v<<^v<^<vv^>^>^><>^<v^^<v^vv<v^>^<v><>^>^v^<^<vv>v>v>>^<^>><^^>^v>^v>^^v<<^^^><>v^^<<<^>^<v<vvv>v<>>^^<v>>><>v>>^>>vv^v>v>>>v<>>^^^<v>v^><^<<vv<>>^><<^v><^>v^<<vv<v^^^>vvvv<^^v<v>>v><vv<>>v^<^<v^>v>v<>^vvv>v<vvv<^^v<v^<<<^v<v<>^^^^<<^<>^><^^^>>^<>v<<>>><^<><<<<vvv><<v<^^vv<vvvv<^^^>^>>><>><<v>^vv>v>^<>>v<v^<vv><>>^vvvv><v<vv<v^>v^^^^<><>^^v>v^vv^<>^<>^><>><v^>><<vv^v^>^>vv<>vvv<<v^^>^>^^<^v>^<v><v>>vv^^v>v>v^>>^^v>^<v<>^>><vv^v^v^<<vvv<>><>><vv>v<>v^>^><<<<>^v^^<^^vv>^<^v>^v>v<<^^<^^^>^^^><^v^<v<^<v<v<^>>v><vv^<v<vv^^<>^^vvv^v^vv^^v^<vv<<<<>>v>^^>v^^<<v<><<^>>^><^v>v^>v<<<^>^v^^^^<^<>^<>>>^^<<^>v<^^<<><vv^^><v^v<^<<>><<<<^<>>^^^>^^>>>vvv^><^<^^^v>vv^^>v<v<^>v^<v><>>^<>>v<^v<vv^<><v><^v<^vv<<^<<^v><^v<v^><<v<^v>><^^v^<^v<^^^<v>><v<^<<^<<^>>>>v<>>><><v>^<v>>>v><<<>>v<<>>>>v>v>^>^>^<<>><>>>v^<vv>vv<^v<<<>v<>>^>^^>>v><^>>>^vvv<v^^vv^vvv<>^v^vv><>vvv^v><^^\n" +
            "v^v<^<>^^^vv<>^vv^><>^><v^^v>v>>^>^>vv><><v^<^v><<^><v>><v><v<^^<^v<><v<>v>^><>v^<v<<^^^>>^^^>><<v^v<><<<<<^v^^<>vv<>^vv<v>>^>^v^<^v^^vv<vv^<<<v^vv<^v^<^<vv<<>>><<>>vvv<v^^<^^^>><><^^^>>^><<<<<<v<<><v<^>^<>><v<<>><<v^^vv^<^vvv<>^>v<<vvv>^>v<>><^^<>v>^^<v<>v<><>vv><v^^>^<^<<v>>v^>vvv>>vv^>>>>^<<>vv<v<<>^>v^^>v^v<v^<<>>>v^v>v>v>vv<<<v><^^v^^<^>^>><v<^^>v>v><<><v<>>^v^>^>^<<vvv^><^<<^<>>^<<>vv>>><>>>^<^<v<>vv^>^v><>v^>vv^><<v<<>^v^>>^^^v^>v^^v>><^<vvv><^^v^><><>>^<vv><<v^<>^<>>>>^v^^^>^>^>vv>^<><<<>^<^v>^v^v^v>>>>^v>>v<^vv>^^<>v^v<vv><v>vvvv>>>^<^<>>>^v<v>>>^^^<vvv>>><<^vv<<<>vvv^>^vv>>><><vv<^^<<>^v>><v<v>>^vvv^v^>^v<<^^<^^v^v<^>v^^v^v^<^v<>v<>^<>>^v<^^^^^<<>^<v^<>>^v<^<^>vv>>^>vvv>^^<v><><<v>v>><>>><^v^<>^v^vvv><v^vv^vv^<^^>>v>^^<<^v<<<^^v<^>>vvv>v<<<>>><>>^v<>>>^^^>>v<vv^<<><v>v><vv<<><>^^vv^^<<^>>v^>^^^>>>>^v^><v^<^^v^^^<^v>vv<<v>v>>^v^>^^>><vvv<<v^><^v><>^<<^>>^><v<><<v^>v^vv<v^^^^^<>><^^<v<^<>vv<^<^v>^^v><><v>^vv>vv<^>>^>v<^vv<vv<<<<>^<v>^<<^>^^^<<>^><>v^^<^>>^^v<v^><^>v><>^<>v^^<<^\n" +
            ">^><^vv<v>v^^^<>>^v^>v>^v^<<v^>>>v<v<vv^<<><<^^v<<^v>^v<^<<<<v<<<>v>^>>^>>^>><^>>v><<v^<>v><<v>^><>v<<v>^v>^>^>^^^>>v>v>^^<^vvv^<^^><v^><>><>v^>>>^>^^>>><>^v<v^<v<^^^v>v>v<v>>vv<v^^<^v>^^^><>^>vvv^^<>^<^<vvv^v<<>>vv><v<vv>vv><<<<>v^^>vv>v<^><>v>>^>>^<v<v>>^^v>^v<^>^v>>^v><>^v>>v^v^^><<><^>><v<>^v^vvv<<v>v><<^>v<>^<<<<vv^>><v^^<<vv<^^>v>><v<><^>^>>v^<vv>>vv^>^<^<^>^v^<<^^^v>>><vvv>^><vv^vv>v<v>^^vvvvv<>^^^^v^v>vv^^vv<^<><v<<v>><>v^v<^>^vvv^<^<^^>v^<^v>><>v^^^>v^^<>>>^<^<>^^<<^v^>v<v<v^>>^^^>>^^<<<>^>^<^^>><>^<^v><v<>><>^>^<>^^^<><v><^<^v^^>^vv^^<>v^>^>v><<v<>^^v^<<^^<^v^v<<v<^>><>vv^v>^<>^^v>>vvvv<v>vv<<><>^^^><^^v^><vvv>v<<vv<<^<vvvvvv>v>vv><^<>v>>>^v<>><^><>v^<>v>^>v^<^^^<v^<v>v^<v<<v<v<^<v<^>^^<<<^v><v<<>^<<>v>^^^v<>v<^v><^^^>>>>v>vv<<^>v<>^v<^v^><<^^><^>v^v^^v<<<><<v>vv<v>^<vv^>v^^^>^v<><^<v^>v^<vv^<^<<<^v<v^^>>>v<v<^><^<><v><<^>^v<<<>>>v>v>^<<><^<v>><v><vv><><<>v<v>v^>^<v^<^^^^^>>>^v<^^>vv>vv<<^^>><<v^><^v>v>v<<<>>v>v<<<vv<vv>^v>^^vv>v^v>v>^^^>^><><v>vv>v^>>^^>v^^>>v>><>v>v><^<<vvv\n" +
            "<v>v>><^<v^^><^<vv^>>v>v^<vv<<vv><vv^>>v<^><v^<v^^<><<<v><v<v^<^>v^>>^^>v^v>^>v>v>>vvvvv>>>^v<><<^^vv>^>v<v^vv>v>v<vv>><v<vv<vv>vvv<<<^<vv<<^<>v<^>v>v>^>v>^v>v<^<<v>v><<>^vv<^v<^^>>^^>v^>vvv>>v^>^^v^><^vv^^v>>>^^v>^^^vv^>>v>^<>v<>v><<>^v<^v^<>vv<^><v^>v^<v<>>>v><v<v<v^vv><^>><v>^<><<^<^^^<<v><<<vv<<><><>v>>><v<<<^<><^>v>^><<<^>v<><<>v<><^><<^^>vv<<vv^>v<>^^v>>v<vv<^^<>v>v>^<^^v>^^>><^^^^vv<^v^^>v>^^>><<v><^v<>vv<^vv>^<<^<^^<v>^^<>v<<<v<<^^^v<v>v^>>><<v>v<<v^>^<><v^>^><<<^^<^^^v<v^<<<>>>^^^<^<vv<^^v<^^<vv>^>v<><^<^><>>>><^^v>^v<<^>><^vv>^<><><^^vvv<>^<>v><>v^v^^v>v>v><<<^^<<^<>><<v<<>>v^^>^^<^v<^^>^^^<^v^^<><^>vv<<^<v^vvvv<^v<vv>^<<><^^^v^<>v>v<^v<v<v>v>^>^<<>>^v^><>v^^>^>>>>>v>v>^<^^>>>^^<<>v^vv<^^^v^^v^v<v>v<<^>v^<>>v^><>>^^>v>vv>>^<v<v^vv><vv><vv><<<<v^vv<^>^<v^>^>><^^><v^>><v^>>^v^>><v^>>^^>v<>><>>>^^vv^^>^>><><<<v>>>^^^^>^vv^^<^v^^^^><v^^^^<<<v<^<>vv<<^>vv<<^>^v<vv>vv<^<><<<v^^v>>>>><v^<^v>v><^<vv<<>>v>v<v<<v>v^><>^>^^<<v><><^>v>v>^^<^^^^<v^^<<><<>>^^><v<^v<v><^<>>>>>v^v><<>v>^vv<^\n" +
            "v<vvv>>v^<^<<^^>>^>v^<<v>v><^v>v^vv<<<v<<<<^>^^^^^vvv><v^<>v>v<^><^<<>^^v<vv>>vv><^v^vv^v^v^^v>>v^<^^<<<^>vv<v<v^><^<<v<^v<><<^>><^^<>>>><v>^^^^^v<>v>vv>^<v<>^^vv<<>^<>^<>>^<>><vv><^<v<v^v>><^>>v<<vvv>>vv<v^>^<^^<>>v^<<^<<>^>vv^>^v<v>v>v^<v<^^><>v<^^v<^^^^<^<^v<v^v^^^<>vv^<<<^^>><<>^>v<<v<v^v>^v^<v>v>>^v<v><>^^<v<<v^>vv^<^>v<^v>v><v<<>^vv<>><v>><>^>v<<^vv><^>>><>vv^^^^<v<<<v>^<>><<<^v>^v><v<^<>^><>>>>v<>vvvv^v>^^<^<^>v>v<><>^v^>vv>^>^><v^>>><vv<^<vv><>>>v<>v^<vv^>v<^><>^<>^^<>^>><v^vv<v><^^<>v^>>vv^<<vv^v>^>><v<<v>v>^^^>v<<<>vv>v<^v<<<><v<^vv<vvv^v<^^^<<<vv<^>><<^>v>v^v^^v^v>v<<<<^>>v<>v^v><^<^^v<vv<v<>>vvvv^>>>v>v>v><vv<<<<>>^vv<^<><v<^^<>><^<>^^>vv^><v^vv<>>v^^v><<^><^^<<^^^^v<^v<v<<v^>vv<<><v<>>^^v>v>>^^^<<>v<v<<>^<v<^^>^^^<<^^<v>><^<^<><^<^v^>vv<>v>^<>^<^v>>v<>>>>v>vvvv^<<<^^><>^v^><>^>>^<<>^v^>>v^v>^^<v>v<<^>>^>^>v>^<^>><<^>^v>>>v<>vv<^>^^v><<^v<<^v>vvv>^v>^<v^^<^v>^<^^<v<<v<^<<^^<v^>>v<>^<<^^<><>v<v><<<^>><<<^<^v><><>v>^>^v>v<^vv<v^>^^^^>^^><^v>^><<v^<v^vv><^<v<<>^^<<>^<>v^>><^>^\n" +
            ">v^vv>vv<^^^^><v<v<^<^v^><v><vvv^><v<v^v><v^^^v^>vv^^<><v<<^vvv<<>^^vv>vv>^^<>>>vv^>^>>>><<<>v>>v^<<^^^v><^^v>vv>^^>v>>v<^<^<v^<>v^^^v^^^vv><>^^>v^<^^<<<^^^>>>v^^v<>>^v>vv><^^vvv<>v^<<^<^<<^<v><<<<v^>><v>^>><^<>>v^><v<^>vvv<<<v>v<v>v<v^>vvv^><v<^^>><^<^>>>>>^^v><v>^^vv^<v<^<>v>^<<v>^v^v^>^>v<>^<^>v>^^>v^^>>^<<<^v<>^<><^v<>v^<^v^v<^v>>>>>^<>^^<v<v><>^<<v>><><<<v<>^^>^<>><^<^>^<<<<>^>^v><<>>><<>>^><<^v<^v><>><v^<<v<>>><>^>v^^<v^^>^<<<>>^^>^><>v<<v<>v<^^>>v><>^<^^>vv<v>^<>v>><^vvv^^v^^>^<<>>^<v<^>^^v^v<v^>v<^>^v^vv^^vv<v^>^^v<^<v<v^<<>>>v<^><>><^vv<<v<^<^v><><^<<v>>^^^v>v<><vv^<v<^v>>>^^^^^^v>><v^>v<<>v<<<><vvv^^v^v<v^v>>^<v<<>>v>^<<^^>^v<v^<^v>^><><<^vv^<<<>>^>>^^^^vvvv<>^>v<v^>^vv<vv^<<v^vv<v>>>v<<v><vv<<>^><><<v><>v<<>v>>^^<<^<>^<^^>v^<^v^^^^^^^v^^>v<>>^<><<^^>vv^^v<^^v<^^>>v<^^<v<^>><>^v<^<v<^<^<^<^>^<^v>>v<>><<^<>^^>v^>>vvv^<^><<^v>^v^^vvvv>^>v<<v<v>>><v>^^>>>>^><^<v>v^v^>v<v>^^^vv^>vv>v<^v<><^<vvv>><>>>vv><v><v<v^><><^><<vv>^<>v>><><vv><><^>^<v^v>^<v^v<^>vvvv<^^>^>>v<<^<^<^<v^v<^^<v\n" +
            ">vvv^vv>v<>>v<<<v<<<>><v<v<^^v^<>^v^v<>>>^>^>^v<^<<<v<^>>vvv<vv>v>>^<v>v><v>^v>^v<><v^v<^^vvv^v<>><^>v<>v^<<<>v>v><<^>vv^><^v><<^^^><^<^>>>>v<>vvv^<v><>>>>>^<>^^>vv<>><v^^<^<<>>><<>^<<^>>v^v>><v<v^<^^<><><^v<vvv^v>>>^^^>><<<<vvv^v>><>>>v>^v>>^><>^<<v<^>^<>>vv<v^v<>^>^v^<>^<^^><<<v>>^v<v>><v<v^>^vv>>>^vv^v<>^^^v<v<<^>vvv^>><^v>^><^>>v<^^v>^<^<^^v<^^<<^><v<v><^^<^<v^>vv<<><v^^<<^>v^>v<><>^^v^<vv^^<>v^<>>^><vv>><^><^^>v>>^<^<>^v>><^v^v>>>v^>>>^v<^<>>^vv^<>><>v<^<^<^^><^<vv^<^>><>vv^v<<>v>v>vv>^<^<^>^<>^^<>v><><><^<v><v^^<^v^<<>^vv<v^v>^>v><>^>^v<^>>vv><^<^>>^><^<>><^v^^v><^^>v<>>vv<v<v^><^^<v<>>^<>^<v<<^<v>vv<^^^>>><<^<v>><v^^>vv>^<^^<^v^<^<v<<>v^^^>vvvv^><>>v<v><>^>^v<<><<>^<vv<<<v<>><v^>vvv^^<<^>>>vvvv>v><^<>v<<^v^^>^>v^^vvv^v<><>><v<v>><^><^v>^^^<<^<v<<^^<^v<^<<vvv>>>>vv><<v>^>vvv^^^<>v^v^vvv<>>^^>>^^<<^^<<<<^^^>>>>^<^<<^><>^<^v^>><^<^><v<^<>>vvvv><>><^^>v^v<v^>>v<v>v>^^v^<>><><<v>>^v^^v<<^>^v^^v<<>^>^>>^<<v><><><<>^vvv<>>^v>^^>^<>v<v<^><^^<>^>^^v<>><<^>vv<v<^^<><v<^<<v>><><v<<>^>^^^>^\n" +
            "><>>v<<<<<^<v<vv^>^>v<v^<><^>^<>><^>^^>vvvv<>^>^^^vv>v<>v<<>>^<>v^v^>^vvvvv<^v<^^^<vv>^v>^>vv<^^>^>><>v<v>>v<v<><<vv^^>^^v<^>v>^<<<v^vv<<v^>v^>>^^^>>^<^>v^<^<<>>^>>v>vv>^<v<>^><v^<>>><<>><^>^vv^>^v^v^<<<<>^v><^>><>>v^^^>v<<>>^<>^>^<^v^v<^vv>^>v<v^>v<v>^^>>vv^^^<<v^<v^<^v<^v>^>>v^^vv<v^>>^^^v><^^<><^v<v><v<<^<^>^<><<<v>v>>v>v^><v>^><^><>><>>>vvv><>^^>>>><<<^v^><>>v><^<>>><v<v>><^v^^^>vv><v>vv<<^^v^>^^^>>>>v<>><^>><^<^vv^><<^v^v<><vv<^v^<v^<^<^<><<<v<^<vv<<>^<>v^>><v^vvvvv^>^v^^<^^^><<vv^<v^v^>^vv^<<vv^^v^<<<<><<vvvv<>^>><>^>><<>><v^^<<>^><>v^<^><^><vv^^>v^v>vv>^^vv^^^<<v>>>v<v<^>^>^v<^vv^<>>^v<^^<v^>^<^<<>^>^^vvvv<<v>v<<^<<>v^^^^^v<vv>v>^v>v>^^>v^v^<^v<v>^vv^v^^v>^<vv<^>vv^v>>^>^<^>>v>v<<^^^>^^v^><v<>^vv>^vv^vv>v^><<><^^<<^v>^^v>>>>>^v<v<^v<^v^>v<<v<<>v><v<><vvv<<vv>vv<^v>v<^v<>><<^^vvv<>^>v^>vvv<v^v<v<v<>>v<>><<<v^^<^^<<<<^v><<>^v^<v><v<^^vv^^^>><<><^v^v<<<<v>^<>^<>><^v><^><^^><>><<^<<^>vv<<<v>v<^^>^^^<v<>>v<v<^v<^>>v><v<^>v^^>>v<^v^>>^<<>vv^^^<v>>>^v<^v>>^^^^vvv><^<^^<^<v^>v<v>^>v<^^<\n" +
            "^^v<v<<vv<^v<^^^^>^<><v<^>><>v>v<>>v>^<>>^^<<vv<^v^^^^<^<>^^^^v<>v<<^^^v><^<><v<vv>>^<^^<v<^>><<vv^<v<<><><v^v^^><^<<><^v>>v>^v<^<v^^v><<>>^<vvv<vv^^<vvvv>v^<<><>>><>^<^v^v^v^^v^^<<^<<>><vv>v^v^v>v^<v><v^>>>^v<^v><>v>>>v><v^v^>><>>v><>^<v>>^v>^<v<v><<<<^^<<^>>^^>>^v<^>^><>><^<<v<^>>v^<><<><v><^<^^^<vvv<^<<<<>>^vv<<vvvvv^>><>v^<v>vv>>v^>^^v<v^<v^vvv<>^>v<><^>^><<<<>>^>^<^v^^^>v><^<>v><<<v^<>>v^<v>^<<v<<<v<>^><v<vv>^>vv>v<^^><^<<vv^>><^<vv<^v>>^>^<<v^^<><v><>^>vv^^<vvv^v^^<><^^>>v<<<>v^>^^<<^<><v>>>^^^><v^v><>v<>v^v<vvv^v<<vvv^>vv<<>v<>v^^<vv<^<>>><vv>>v^<>^^<<>v>v^<>^<<v^<>v^>v^<>vv<>^<<<>>^vvv>>v<v<>v<<><<<><v<<v^v>>v>>^v^^v<vv<v>>v<vv<v<>v^^^>v^^v^^><^<^<^<v^<>v^^<v^><^vv^^vv^<vvvv^^^v<<^>v>><^v^<^vvv<v^>^<v<vv^v^v>^><^^v<>^v^>v<^<<^<^v><^vvv^>v<v<>^v<^^v<>>v<^v>^vv>v<<<v>>^>v^<<<>^<^^^v>^^vv>v<vv>>v^><>v<<>><vvv^v^^vv<<^^v>><<v>v^<>><<<^^>vv^v<>v^^v>vvv>^><>v<<<>><>^^><<<>^>>^^<^v^^v><^>^><<v^v<^^>>v>^v>v>>^<<^v><<>v^^v^<^><><<^^>^^<^<^^<<<>^vv^>><<v<>^^vv^>v>v><^^>v><^<^^>^^^<>^v>vv\n" +
            "vvv^>>vv^v>>>>^<<v>><vv^^vv<^^^><^><>v<>^>v<>^v>>v<v<>vv^v<><<^^^v^^<<^<<><^^><^<vv><>^^v^>^>^>^<<><<><<v<>v><v<vv>>>>v<^v<v><>vvvvvv^<v^v><^<><v<^<^^vv>>v><<^<v<<>^>>><v<^>^^^^>v<<<<>>v<<vv^<vvv><>^<>v<>><<>v^^<^>^>v><v>^<<v<^v>v^^<v<<v>vv>^<<>>^<^>^^<^>v<>>v>v><^vvv<^<>v>>^^>^v>vv>^v^<^^<<>^<^<v<v>>^><><><>v^><>v^^vvvv^<^^^^<^>^v>^vv>>v<<v^^<>><>vv^>^v><v<>^<v^<>v<<^v<<v^v<>vv<v>v<>^vv^v>^<^>v^v^<<<<v^>vv^v<<v^><^><^^v>^v<^^<>v<>>>^^<<<>>>v>^^^^^<>v^vv>^<^<^^^vv>^<v^>v>>>>^>^<^^vv^^vv^v>vvv>>>><<v<>vv^vv<<><vvv^>>>^^^v><v<><v><^<>^v>^>>^^>vv<<v><>>v^^^^<v>v<><v^^^^<>^>^v>^><><^>>v<^>^vv>^>v^<^^>v>^<v><vv>^^v><<><^><>>v<^><v^^v<^>^^<<^><><v><>>>^<vv<<>v^<v^^>>vv>>v<^>v>>>><^><^>v^<v<^<v^>^><v>^v>>^>>v^vv<<vv<<>vv^^>>v>vv<><>vv^<<vv>^^^^v^^<vv><vv>>><^^<^^<><^v<v>v>^^^v^>v<><vv>^<>^>v>>^v>v^>v<<<<vv^>v>^v<v>v>>vv<<^><><<<v^^>^><<<^v<<^^^<<v^v<v^v>>v<v>vv^><v^^<>^^<^>^vvv>v>>vvv<>v>>^>><>^v>v<^<^^><^>v<>v>v<<>^^^>>^>>>^^v^<<^>^^<^>>>^^^^^>^v<^v>^^<<v>>^<^<v>v<>>>^v^<v>v^^<^><<v^v^v^<<v>";

    String inputMap = "########\n" +
                      "#..O.O.#\n" +
                      "##@.O..#\n" +
                      "#...O..#\n" +
                      "#.#.O..#\n" +
                      "#...O..#\n" +
                      "#......#\n" +
                      "########";

    String inputMoves = "<^^>>>vv<v>>v<<";

    String largeInputMap = "##########\n" +
                           "#..O..O.O#\n" +
                           "#......O.#\n" +
                           "#.OO..O.O#\n" +
                           "#..O@..O.#\n" +
                           "#O#..O...#\n" +
                           "#O..O..O.#\n" +
                           "#.OO.O.OO#\n" +
                           "#....O...#\n" +
                           "##########";

    String largeInputMoves = "<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^\n" +
            "vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v\n" +
            "><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<\n" +
            "<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^\n" +
            "^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><\n" +
            "^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^\n" +
            ">^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^\n" +
            "<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>\n" +
            "^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>\n" +
            "v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^";

    @Test
    void parseMap() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        assertEquals(8, map.length);
        assertEquals(8, map[0].length);
        assertEquals('#', map[0][0]);
        assertEquals('O', map[1][3]);
        assertEquals('@', map[2][2]);
    }

    @Test
    void findRobot() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        int[] robot = day.findRobot(map);
        assertEquals(2, robot[0]);
        assertEquals(2, robot[1]);
    }

    @Test
    void moveRobotRight() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        map = day.moveRobot(map, '>');
        int[] robot = day.findRobot(map);
        assertEquals(3, robot[0]);
        assertEquals(2, robot[1]);
    }

    @Test
    void moveRobotLeft() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        map = day.moveRobot(map, '<');
        int[] robot = day.findRobot(map);
        assertEquals(2, robot[0]);
        assertEquals(2, robot[1]);
    }

    @Test
    void pushOneBox() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        map = day.pushBox(map, 3, 1, '>');
        assertEquals("#...OO.#", new String(map[1]));
    }

    @Test
    void pushTwoBoxes() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        map = day.pushBox(map, 3, 1, '>');
        map = day.pushBox(map, 4, 1, '>');
        assertEquals("#....OO#", new String(map[1]));
    }

    @Test
    void moveOneBox() {
        Day15 day = new Day15();
        String moves = "<^^>>>";
        char[][] map = day.parseMap(inputMap);
        map = day.moveRobot(map, moves);
        assertEquals("#...@OO#", new String(map[1]));
    }

    @Test
    void moveAllSmallInput() {
        Day15 day = new Day15();
        String expectedMap = "########\n" +
                "#....OO#\n" +
                "##.....#\n" +
                "#.....O#\n" +
                "#.#O@..#\n" +
                "#...O..#\n" +
                "#...O..#\n" +
                "########";
        char[][] map = day.parseMap(inputMap);
        map = day.moveRobot(map, inputMoves);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void moveAllLargeInput() {
        Day15 day = new Day15();
        String expectedMap = "##########\n" +
                "#.O.O.OOO#\n" +
                "#........#\n" +
                "#OO......#\n" +
                "#OO@.....#\n" +
                "#O#.....O#\n" +
                "#O.....OO#\n" +
                "#O.....OO#\n" +
                "#OO....OO#\n" +
                "##########";
        char[][] map = day.parseMap(largeInputMap);
        map = day.moveRobot(map, largeInputMoves);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void getSmallInputBoxGPS() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(inputMap);
        map = day.moveRobot(map, inputMoves);
        long sum = day.getBoxGPS(map);
        assertEquals(2028, sum);
    }

    @Test
    void getLargeInputBoxGPS() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(largeInputMap);
        map = day.moveRobot(map, largeInputMoves);
        long sum = day.getBoxGPS(map);
        assertEquals(10092, sum);
    }

    @Test
    void getFinalInputBoxGPS() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(finalInputMap);
        map = day.moveRobot(map, finalInputMoves);
        long sum = day.getBoxGPS(map);
        assertEquals(1486930, sum);
    }

    @Test
    void duplicateMap() {
        Day15 day = new Day15();
        String expectedMap =
                "####################\n" +
                        "##....[]....[]..[]##\n" +
                        "##............[]..##\n" +
                        "##..[][]....[]..[]##\n" +
                        "##....[]@.....[]..##\n" +
                        "##[]##....[]......##\n" +
                        "##[]....[]....[]..##\n" +
                        "##..[][]..[]..[][]##\n" +
                        "##........[]......##\n" +
                        "####################";
        char[][] map = day.parseMap(largeInputMap);
        char[][] newMap = day.duplicateMap(map);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : newMap) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void moveAllPart2() {
        Day15 day = new Day15();
        String input = "#######\n" +
                       "#...#.#\n" +
                       "#.....#\n" +
                       "#..OO@#\n" +
                       "#..O..#\n" +
                       "#.....#\n" +
                       "#######";
        String inputMoves = "<vv<<^^<<^^";
        String expectedDuplicatedMap = "##############\n" +
                                      "##......##..##\n" +
                                      "##..........##\n" +
                                      "##....[][]@.##\n" +
                                      "##....[]....##\n" +
                                      "##..........##\n" +
                                      "##############";
        String expectedMap = "##############\n" +
                             "##...[].##..##\n" +
                             "##...@.[]...##\n" +
                             "##....[]....##\n" +
                             "##..........##\n" +
                             "##..........##\n" +
                             "##############";

        char[][] map = day.parseMap(input);
        char[][] doubleMap = day.duplicateMap(map);

        List<String> actualMap = new ArrayList<>();
        for (char[] row : doubleMap) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedDuplicatedMap, actualMap.stream().collect(Collectors.joining("\n")));

        map = day.moveRobotInDuplicatedMap(doubleMap, inputMoves);
        actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void moveAllPart2temp() {
        Day15 day = new Day15();
        String duplicatedMap = "####################\n" +
                               "##[]..[]....[]..[]##\n" +
                               "##[].......@..[]..##\n" +
                               "##........[][][][]##\n" +
                               "##....[]..[]..[]..##\n" +
                               "##..##....[]......##\n" +
                               "##...[].......[]..##\n" +
                               "##.....[]..[].[][]##\n" +
                               "##........[]......##\n" +
                               "####################";
        String inputMoves = "v";
        String expectedMap = "####################\n" +
                             "##[]..[]....[]..[]##\n" +
                             "##[]..........[]..##\n" +
                             "##.........@[][][]##\n" +
                             "##....[]..[]..[]..##\n" +
                             "##..##....[]......##\n" +
                             "##...[]...[]..[]..##\n" +
                             "##.....[]..[].[][]##\n" +
                             "##........[]......##\n" +
                             "####################";

        char[][] map = day.parseMap(duplicatedMap);
        map = day.moveRobotInDuplicatedMap(map, inputMoves);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : map) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void moveAllLargePart2() {
        Day15 day = new Day15();
        String expectedMap = "####################\n" +
                             "##[].......[].[][]##\n" +
                             "##[]...........[].##\n" +
                             "##[]........[][][]##\n" +
                             "##[]......[]....[]##\n" +
                             "##..##......[]....##\n" +
                             "##..[]............##\n" +
                             "##..@......[].[][]##\n" +
                             "##......[][]..[]..##\n" +
                             "####################";

        char[][] map = day.parseMap(largeInputMap);
        char[][] doubleMap = day.duplicateMap(map);

        doubleMap = day.moveRobotInDuplicatedMap(doubleMap, largeInputMoves);
        List<String> actualMap = new ArrayList<>();
        for (char[] row : doubleMap) {
            actualMap.add(new String(row));
        }
        assertEquals(expectedMap, actualMap.stream().collect(Collectors.joining("\n")));
    }

    @Test
    void getLargeInputBoxGPSInDuplicatedMap() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(largeInputMap);
        char[][] doubleMap = day.duplicateMap(map);
        doubleMap = day.moveRobotInDuplicatedMap(doubleMap, largeInputMoves);
        long sum = day.getBoxGPSInDuplicatedMap(doubleMap);
        assertEquals(9021, sum);
    }

    @Test
    void getFinalInputBoxGPSInDuplicatedMap() {
        Day15 day = new Day15();
        char[][] map = day.parseMap(finalInputMap);
        char[][] doubleMap = day.duplicateMap(map);
        doubleMap = day.moveRobotInDuplicatedMap(doubleMap, finalInputMoves);
        long sum = day.getBoxGPSInDuplicatedMap(doubleMap);
        assertEquals(1492011, sum);
    }
}
