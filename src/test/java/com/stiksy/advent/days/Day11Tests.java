package com.stiksy.advent.days;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Tests {
    String input = "0 1 10 99 999";
    String input2 = "125 17";
    String finalInput = "475449 2599064 213 0 2 65 5755 51149";

    @Test
    void breakInput() {
        Day11 day11 = new Day11();
        var stones = day11.breakInput(input);
        assertEquals(5, stones.size());
        assertEquals(1, stones.get(0L).longValue());
    }

    @Test
    void blink() {
        Day11 day11 = new Day11();
        Map<Long, Integer> stones = day11.breakInput(input);
        Map<Long, Integer> afterBlink = day11.blink(stones, 1);
        assertEquals(5, afterBlink.size());
        assertEquals(1, afterBlink.get(0));
        assertEquals(2, afterBlink.get(1));
        assertEquals(2, afterBlink.get(9));
        assertEquals(1, afterBlink.get(2024));
        assertEquals(1, afterBlink.get(2021976));
    }

    @Test
    void blink2() {
        Day11 day11 = new Day11();
        Map<Long, Integer> stones = day11.breakInput(input2);
        Map<Long, Integer> afterBlink = day11.blink(stones, 1);
        assertEquals(3, afterBlink.size());
        assertEquals(253000, afterBlink.get(0));
        assertEquals(1, afterBlink.get(1));
        assertEquals(7, afterBlink.get(2));
    }

//    @Test
//    void blink6times() {
//        Day11 day11 = new Day11();
//        List<Long> stones = day11.breakInput(input2);
//        List<Long> afterBlink = day11.blink(stones);
//        for (int i = 0; i < 5; i++) {
//            afterBlink = day11.blink(afterBlink);
//        }
//        assertEquals(22, afterBlink.size());
//        assertEquals(2097446912, afterBlink.get(0));
//        assertEquals(14168, afterBlink.get(1));
//    }
//
//    @Test
//    void blink25times() {
//        Day11 day11 = new Day11();
//        List<Long> stones = day11.breakInput(input2);
//        List<Long> afterBlink = day11.blink(stones);
//        for (int i = 0; i < 24; i++) {
//            afterBlink = day11.blink(afterBlink);
//        }
//        assertEquals(55312, afterBlink.size());
//    }
//
//    @Test
//    void blink25timesFinal() {
//        Day11 day11 = new Day11();
//        List<Long> stones = day11.breakInput(finalInput);
//        List<Long> afterBlink = day11.blink(stones);
//        for (int i = 0; i < 24; i++) {
//            afterBlink = day11.blink(afterBlink);
//        }
//        assertEquals(193269, afterBlink.size());
//    }

//    @Test
//    void blink50timesFinal() {
//        Day11 day11 = new Day11();
//        List<Long> stones = day11.breakInput(finalInput);
//        List<Long> afterBlink = day11.blink(stones);
//        for (int i = 0; i < 49; i++) {
//            afterBlink = day11.blink(afterBlink);
//        }
//        assertEquals(193269, afterBlink.size());
//    }

//    @Test
//    void blink75timesFinal() {
//        Day11 day11 = new Day11();
//        List<String> stones = day11.breakInput(finalInput);
//        List<String> afterBlink = day11.blink(stones);
//        for (int i = 0; i < 24; i++) {
//            afterBlink = day11.blink(afterBlink);
//        }
//        assertEquals(193269, afterBlink.size());
//        long size = 0;
//        long counter = 0;
//        for (String stone : afterBlink) {
//            List<String> thisStoneInAList = new LinkedList<>();
//            thisStoneInAList.add(stone);
//            List<String> afterBlinkSingleStone = day11.blink(thisStoneInAList);
//            for (int i = 0; i < 24; i++) {
//                afterBlinkSingleStone = day11.blink(afterBlinkSingleStone);
//            }
//            size += afterBlinkSingleStone.size();
//            counter++;
//            if (counter % 1000 == 0) {
//                System.out.println("Counter: " + counter + " Total: " + size);
//            }
//        }
//    }
}
