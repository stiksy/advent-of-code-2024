package com.stiksy.advent.days;

import java.util.HashMap;
import java.util.Map;

public class Day11 {
    public static Map<Long, Integer> cache = new HashMap<>();

    public Map<Long, Integer> breakInput(String input) {
        String[] s = input.split(" ");
        Map<Long, Integer> stones = new HashMap<>();
        for (String stone : s) {
            stones.put(Long.parseLong(stone), 1);
        }
        return stones;
    }

    public Map<Long, Integer> blink(Map<Long, Integer> map, int times) {
        Map<Long, Integer> tempMap = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 0L) {
                tempMap.put(1L, tempMap.containsKey(1L) ? tempMap.get(1L) + 1 : 1);
            } else {
                String stoneString = String.valueOf(entry.getKey());
                int length = stoneString.length();
                if (length % 2 == 0) {
                    long e = Long.parseLong(stoneString.substring(0, length / 2));
                    tempMap.put(e, tempMap.containsKey(e) ? tempMap.get(e) + 1 : 1);
                    long f = Long.parseLong(stoneString.substring(length / 2));
                    tempMap.put(f, tempMap.containsKey(f) ? tempMap.get(f) + 1 : 1);
                } else {
                    tempMap.put(entry.getKey() * 2024, tempMap.containsKey(entry.getKey() * 2024) ? tempMap.get(entry.getKey() * 2024) + 1 : 1);
                }
            }
        }
        map = addToCache(tempMap);
        return map;
    }
//    public List<Long> blink(List<Long> stones) {
//        List<Long> afterBlink = new LinkedList<>();
//        for (Long stone : stones) {
//            if (stone.equals(0L)) {
//                afterBlink.add(1L);
//            } else {
//                if (cache.containsKey(stone)) {
//                    Long[] cached = cache.get(stone);
//                    afterBlink.add(cached[0]);
//                    afterBlink.add(cached[1]);
//                } else {
//                    String stoneString = String.valueOf(stone);
//                    int length = stoneString.length();
//                    if (length % 2 == 0) {
//                        long e = Long.parseLong(stoneString.substring(0, length / 2));
//                        afterBlink.add(e);
//                        long f = Long.parseLong(stoneString.substring(length / 2));
//                        afterBlink.add(f);
//                        cache.put(stone, new Long[]{e, f});
//                    } else {
//                        afterBlink.add(stone * 2024);
//                    }
//                }
//            }
//        }
//        return afterBlink;
//    }

    public Map<Long, Integer> addToCache(Map<Long, Integer> map) {
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            cache.put(entry.getKey(), entry.getValue() + 1);
        }
        return map;
    }

//    public static void main(String[] args) {
//        Day11 day11 = new Day11();
//        String finalInput = "475449 2599064 213 0 2 65 5755 51149";
//        List<Long> stones = day11.breakInput(finalInput);
//        List<Long> afterBlink = day11.blink(stones);
//        System.out.println(afterBlink.size());
//        for (int i = 0; i < 24 ; i++) {
//            afterBlink = day11.blink(afterBlink);
//            System.out.println(afterBlink.size() + " " + i + " " + cache.size());
//        }
//        System.out.println("Breaking list of " + afterBlink.size() + " stones");
//        long size = 0;
//        long counter = 0;
//        for (Long stone : afterBlink) {
//            List<Long> thisStoneInAList = new LinkedList<>();
//            thisStoneInAList.add(stone);
//            List<Long> afterBlinkSingleStone = day11.blink(thisStoneInAList);
//            for (int i = 0; i < 24; i++) {
//                afterBlinkSingleStone = day11.blink(afterBlinkSingleStone);
//            }
//            System.out.println("Breaking sublist of " + afterBlinkSingleStone.size() + " stones");
//            for (Long anotherStone : afterBlinkSingleStone) {
//                List<Long> thisOtherStoneInAList = new LinkedList<>();
//                thisOtherStoneInAList.add(anotherStone);
//                List<Long> afterBlinkOtherSingleStone = day11.blink(thisOtherStoneInAList);
//                for (int j = 0; j < 24; j++) {
//                    afterBlinkOtherSingleStone = day11.blink(afterBlinkOtherSingleStone);
//                }
//                size += afterBlinkOtherSingleStone.size();
//            }
//            counter++;
//            System.out.println("Counter: " + counter + " Total: " + size);
//        }
//        System.out.println("Done, size is " + size);
//    }
}
