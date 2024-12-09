package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.List;

public class Day9 {
    public List<String> createMap(String input) {
        char[] inputArray = input.toCharArray();
        List<String> map = new ArrayList<>();
        int fileCounter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            int fileSize = Character.getNumericValue(inputArray[i]);
            for (int j = 0; j < fileSize; j++) {
                map.add(String.valueOf(fileCounter));
            }
            i++;
            fileCounter++;
            if (i < inputArray.length) {
                int spaceSize = Character.getNumericValue(inputArray[i]);
                for (int j = 0; j < spaceSize; j++) {
                    map.add(".");
                }
            }
        }
        return map;
    }

    public List<String> organiseMap(List<String> map) {
        int lastItem = Integer.parseInt(map.get(map.size() - 1));
        for (int i = map.size() - 1; i >= 0; i--) {
            int nextSpace = -1;
            for (int j = 0; j < map.size(); j++) {
                if (map.get(j) == ".") {
                    nextSpace = j;
                    break;
                }
            }
            if (nextSpace > i) {
                break;
            }
            String thisItem = map.get(i);
            if (thisItem.equals(".") || Integer.parseInt(thisItem) > lastItem) {
                continue;
            }
            int fileBlocks = 1;
            while (i > 0 && map.get(i - 1).equals(thisItem)) {
                fileBlocks++;
                i--;
            }
            boolean foundPlacement = false;
            for (int j = 0; j < i; j++) {
                if (foundPlacement) {
                    break;
                }
                if (map.get(j).equals(".")) {
                    int initialFileBlock = i;
                    int initialSpace = j;
                    int availableSpaces = 1;
                    while (availableSpaces <= fileBlocks && j + availableSpaces < map.size()) {
                        if (availableSpaces == fileBlocks) {
                            for (int k = 0; k < fileBlocks; k++) {
                                map.set(initialSpace, map.get(initialFileBlock));
                                map.set(initialFileBlock, ".");
                                initialSpace++;
                                initialFileBlock++;
                            }
                            foundPlacement = true;
                            break;
                        }
                        if (map.get(j + availableSpaces).equals(".")) {
                            availableSpaces++;
                        } else {
                            break;
                        }
                    }
                }
            }
            lastItem = Integer.parseInt(thisItem);
        }
        return map;
    }

    public long createChecksum(List<String> map) {
        long checksum = 0;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) == ".") {
                continue;
            }
            checksum += Integer.parseInt(map.get(i)) * i;
        }
        return checksum;
    }
}
