package com.stiksy.advent.days;

public class Day15 {
    public char[][] parseMap(String inputMap) {
        String[] lines = inputMap.split("\n");
        char[][] map = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[0].length(); j++) {
                map[i][j] = lines[i].charAt(j);
            }
        }
        return map;
    }

    public int[] findRobot(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '@') {
                    return new int[]{j, i};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public char[][] moveRobot(char[][] map, String moves) {
        for (char move : moves.toCharArray()) {
            map = moveRobot(map, move);
        }
        return map;
    }

    public char[][] moveRobot(char[][] map, char move) {
        int[] robot = findRobot(map);
        int x = robot[0];
        int y = robot[1];
        switch (move) {
            case '>':
                if (map[y][x + 1] == '#') {
                    break;
                }
                if (map[y][x + 1] == 'O') {
                    map = pushBox(map, x + 1, y, '>');
                }
                if (map[y][x + 1] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y][x + 1] = '@';
                break;
            case '<':
                if (map[y][x - 1] == '#') {
                    break;
                }
                if (map[y][x - 1] == 'O') {
                    map = pushBox(map, x - 1, y, '<');
                }
                if (map[y][x - 1] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y][x - 1] = '@';
                break;
            case '^':
                if (map[y - 1][x] == '#') {
                    break;
                }
                if (map[y - 1][x] == 'O') {
                    map = pushBox(map, x, y - 1, '^');
                }
                if (map[y - 1][x] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y - 1][x] = '@';
                break;
            case 'v':
                if (map[y + 1][x] == '#') {
                    break;
                }
                if (map[y + 1][x] == 'O') {
                    map = pushBox(map, x, y + 1, 'v');
                }
                if (map[y + 1][x] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y + 1][x] = '@';
                break;
        }
        return map;
    }

    public char[][] pushBox(char[][] map, int x, int y, char move) {
        switch (move) {
            case '>':
                if (map[y][x + 1] == '#') {
                    break;
                }
                if (map[y][x + 1] == 'O') {
                    pushBox(map, x + 1, y, '>');
                }
                if (map[y][x + 1] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y][x + 1] = 'O';
                break;
            case '<':
                if (map[y][x - 1] == '#') {
                    break;
                }
                if (map[y][x - 1] == 'O') {
                    pushBox(map, x - 1, y, '<');
                }
                if (map[y][x - 1] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y][x - 1] = 'O';
                break;
            case '^':
                if (map[y - 1][x] == '#') {
                    break;
                }
                if (map[y - 1][x] == 'O') {
                    pushBox(map, x, y - 1, '^');
                }
                if (map[y - 1][x] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y - 1][x] = 'O';
                break;
            case 'v':
                if (map[y + 1][x] == '#') {
                    break;
                }
                if (map[y + 1][x] == 'O') {
                    pushBox(map, x, y + 1, 'v');
                }
                if (map[y + 1][x] == 'O') {
                    break;
                }
                map[y][x] = '.';
                map[y + 1][x] = 'O';
                break;
        }
        return map;
    }

    public long getBoxGPS(char[][] map) {
        long sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'O') {
                    sum += (i * 100) + j;
                }
            }
        }
        return sum;
    }

    public char[][] duplicateMap(char[][] map) {
        char[][] newMap = new char[map.length][map[0].length * 2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                //If the tile is #, the new map contains ## instead.
                //If the tile is O, the new map contains [] instead.
                //If the tile is ., the new map contains .. instead.
                //If the tile is @, the new map contains @. instead.
                switch (map[i][j]) {
                    case '#':
                        newMap[i][j * 2] = '#';
                        newMap[i][(j * 2) + 1] = '#';
                        break;
                    case 'O':
                        newMap[i][j * 2] = '[';
                        newMap[i][(j * 2) + 1] = ']';
                        break;
                    case '.':
                        newMap[i][j * 2] = '.';
                        newMap[i][(j * 2) + 1] = '.';
                        break;
                    case '@':
                        newMap[i][j * 2] = '@';
                        newMap[i][(j * 2) + 1] = '.';
                        break;
                }
            }
        }
        return newMap;
    }

    public char[][] moveRobotInDuplicatedMap(char[][] map, String moves) {
        for (char move : moves.toCharArray()) {
//            List<String> actualMap = new ArrayList<>();
//            for (char[] row : map) {
//                actualMap.add(new String(row));
//            }
//            System.out.println(actualMap.stream().collect(Collectors.joining("\n")));
//            System.out.println("Will move " + move);
            map = moveRobotInDuplicatedMap(map, move);
        }
        return map;
    }

    public char[][] moveRobotInDuplicatedMap(char[][] map, char move) {
        int[] robot = findRobot(map);
        int x = robot[0];
        int y = robot[1];
        switch (move) {
            case '>':
                if (map[y][x + 1] == '#') {
                    break;
                }
                if (map[y][x + 1] == '[') {
                    map = pushBoxInDuplicatedMap(map, x + 1, y, '>');
                }
                if (map[y][x + 1] == '[') {
                    break;
                }
                map[y][x] = '.';
                map[y][x + 1] = '@';
                break;
            case '<':
                if (map[y][x - 1] == '#') {
                    break;
                }
                if (map[y][x - 1] == ']') {
                    map = pushBoxInDuplicatedMap(map, x - 2, y, '<');
                }
                if (map[y][x - 1] == ']') {
                    break;
                }
                map[y][x] = '.';
                map[y][x - 1] = '@';
                break;
            case '^':
                if (map[y - 1][x] == '#') {
                    break;
                }
                if (map[y - 1][x] == '[') {
                    map = pushBoxInDuplicatedMap(map, x, y - 1, '^');
                }
                if (map[y - 1][x] == ']') {
                    map = pushBoxInDuplicatedMap(map, x - 1, y - 1, '^');
                }
                if (map[y - 1][x] == '[' || map[y - 1][x] == ']') {
                    break;
                }
                map[y][x] = '.';
                map[y - 1][x] = '@';
                break;
            case 'v':
                if (map[y + 1][x] == '#') {
                    break;
                }
                if (map[y + 1][x] == '[') {
                    map = pushBoxInDuplicatedMap(map, x, y + 1, 'v');
                }
                if (map[y + 1][x] == ']') {
                    map = pushBoxInDuplicatedMap(map, x - 1, y + 1, 'v');
                }
                if (map[y + 1][x] == '[' || map[y + 1][x] == ']') {
                    break;
                }
                map[y][x] = '.';
                map[y + 1][x] = '@';
                break;
        }
        return map;
    }

    private char[][] pushBoxInDuplicatedMap(char[][] map, int x, int y, char move) {
        switch (move) {
            case '>':
                if (map[y][x + 2] == '#') {
                    break;
                }
                if (map[y][x + 2] == '[') {
                    pushBoxInDuplicatedMap(map, x + 2, y, '>');
                }
                if (map[y][x + 2] == '[') {
                    break;
                }
                map[y][x] = '.';
                map[y][x + 1] = '[';
                map[y][x + 2] = ']';
                break;
            case '<':
                if (map[y][x - 1] == '#') {
                    break;
                }
                if (map[y][x - 2] == '[') {
                    pushBoxInDuplicatedMap(map, x - 2, y, '<');
                }
                if (map[y][x - 2] == '[') {
                    break;
                }
                map[y][x + 1] = '.';
                map[y][x - 1] = '[';
                map[y][x] = ']';
                break;
            case '^':
                if (!canMoveBoxUp(map, x, y)) {
                    break;
                }
                if (map[y - 1][x] == '[') {
                    pushBoxInDuplicatedMap(map, x, y - 1, '^');
                    if (map[y - 1][x] == '[') {
                        break;
                    }
                }
                if (map[y - 1][x] == ']' && map[y - 1][x + 1] == '.') {
                    pushBoxInDuplicatedMap(map, x - 1, y - 1, '^');
                    if (map[y - 1][x] == ']') {
                        break;
                    }
                }
                if (map[y - 1][x] == '.' && map[y - 1][x + 1] == '[') {
                    pushBoxInDuplicatedMap(map, x + 1, y - 1, '^');
                    if (map[y - 1][x + 1] == '[') {
                        break;
                    }
                }
                if (map[y - 1][x] == ']' && map[y - 1][x + 1] == '[') {
                    if (!canMoveBoxUp(map, x + 1, y - 1) || !canMoveBoxUp(map, x - 1, y - 1)) {
                        break;
                    }
                    pushBoxInDuplicatedMap(map, x - 1, y - 1, '^');
                    pushBoxInDuplicatedMap(map, x + 1, y - 1, '^');
                }
                map[y][x] = '.';
                map[y][x + 1] = '.';
                map[y - 1][x] = '[';
                map[y - 1][x + 1] = ']';
                break;
            case 'v':
                if (!canMoveBoxDown(map, x, y)) {
                    break;
                }
                if (map[y + 1][x] == '[') {
                    pushBoxInDuplicatedMap(map, x, y + 1, 'v');
                    if (map[y + 1][x] == '[') {
                        break;
                    }
                }
                if (map[y + 1][x] == ']' && map[y + 1][x + 1] == '.') {
                    pushBoxInDuplicatedMap(map, x - 1, y + 1, 'v');
                    if (map[y + 1][x] == ']') {
                        break;
                    }
                }
                if (map[y + 1][x] == '.' && map[y + 1][x + 1] == '[') {
                    pushBoxInDuplicatedMap(map, x + 1, y + 1, 'v');
                    if (map[y + 1][x + 1] == '[') {
                        break;
                    }
                }
                if (map[y + 1][x] == ']' && map[y + 1][x + 1] == '[') {
                    if (!canMoveBoxDown(map, x + 1, y + 1) || !canMoveBoxDown(map, x - 1, y + 1)) {
                        break;
                    }
                    pushBoxInDuplicatedMap(map, x - 1, y + 1, 'v');
                    pushBoxInDuplicatedMap(map, x + 1, y + 1, 'v');
                }
                map[y][x] = '.';
                map[y][x + 1] = '.';
                map[y + 1][x] = '[';
                map[y + 1][x + 1] = ']';
                break;
        }
        return map;
    }

    private static boolean canMoveBoxUp(char[][] map, int x, int y) {
        if (map[y - 1][x] == '.' && map[y - 1][x + 1] == '.') {
            return true;
        }
        if (map[y - 1][x] == '[' && map[y - 1][x + 1] == ']') {
            return canMoveBoxUp(map, x, y - 1);
        }
        if (map[y - 1][x] == ']' && map[y - 1][x + 1] == '.') {
            return canMoveBoxUp(map, x - 1, y - 1);
        }
        if (map[y - 1][x] == '.' && map[y - 1][x + 1] == '[') {
            return canMoveBoxUp(map, x + 1, y - 1);
        }
        if (map[y - 1][x] == ']' && map[y - 1][x + 1] == '[') {
            return canMoveBoxUp(map, x - 1, y - 1) && canMoveBoxUp(map, x + 1, y - 1);
        }
        return false;
    }

    private static boolean canMoveBoxDown(char[][] map, int x, int y) {
        if (map[y + 1][x] == '.' && map[y + 1][x + 1] == '.') {
            return true;
        }
        if (map[y + 1][x] == '[' && map[y + 1][x + 1] == ']') {
            return canMoveBoxDown(map, x, y + 1);
        }
        if (map[y + 1][x] == ']' && map[y + 1][x + 1] == '.') {
            return canMoveBoxDown(map, x - 1, y + 1);
        }
        if (map[y + 1][x] == '.' && map[y + 1][x + 1] == '[') {
            return canMoveBoxDown(map, x + 1, y + 1);
        }
        if (map[y + 1][x] == ']' && map[y + 1][x + 1] == '[') {
            return canMoveBoxDown(map, x - 1, y + 1) && canMoveBoxDown(map, x + 1, y + 1);
        }
        return false;
    }

    public long getBoxGPSInDuplicatedMap(char[][] map) {
        long sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '[') {
                    sum += (i * 100) + j;
                }
            }
        }
        return sum;
    }
}
