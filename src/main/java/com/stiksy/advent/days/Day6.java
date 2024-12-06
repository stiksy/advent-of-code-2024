package com.stiksy.advent.days;

public class Day6 {
    public int[] findXY(String[] lines) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("^")) {
                x = lines[i].indexOf("^");
                y = i;
                break;
            }
            if (lines[i].contains(">")) {
                x = lines[i].indexOf(">");
                y = i;
                break;
            }
            if (lines[i].contains("v")) {
                x = lines[i].indexOf("v");
                y = i;
                break;
            }
            if (lines[i].contains("<")) {
                x = lines[i].indexOf("<");
                y = i;
                break;
            }
        }
        return new int[]{x, y};
    }

    public String walk(String input) {
        String[] lines = input.split("\n");
        int[] startPosition = findXY(lines);
        char startDirection = lines[startPosition[1]].charAt(startPosition[0]);
        int counter = 0;
        while (true) {
            int[] position = findXY(lines);
            int x = position[0];
            int y = position[1];
            if (lines[y].charAt(x) == '^') {
                if (y == 0) {
                    lines = stop(lines, x, y);
                    break;
                }
                if (lines[y - 1].charAt(x) == '#') {
                    lines = turn(lines, x, y);
                } else {
                    lines = walkUp(lines, x, y);
                }
            } else if (lines[y].charAt(x) == '>') {
                if (x == lines[y].length() - 1) {
                    lines = stop(lines, x, y);
                    break;
                }
                if (lines[y].charAt(x + 1) == '#') {
                    lines = turn(lines, x, y);
                } else {
                    lines = walkRight(lines, x, y);
                }
            } else if (lines[y].charAt(x) == 'v') {
                if (y == lines.length - 1) {
                    lines = stop(lines, x, y);
                    break;
                }
                if (lines[y + 1].charAt(x) == '#') {
                    lines = turn(lines, x, y);
                } else {
                    lines = walkDown(lines, x, y);
                }
            } else if (lines[y].charAt(x) == '<') {
                if (x == 0) {
                    lines = stop(lines, x, y);
                    break;
                }
                if (lines[y].charAt(x - 1) == '#') {
                    lines = turn(lines, x, y);
                } else {
                    lines = walkLeft(lines, x, y);
                }
            }
            if (x == startPosition[0] && y == startPosition[1] && lines[y].charAt(x) == startDirection) {
                break;
            }
            if (counter == 100000) {
                break;
            }
            counter++;
        }
        return String.join("\n", lines);
    }

    private String[] turn(String[] lines, int x, int y) {
        char[] line = lines[y].toCharArray();
        switch (lines[y].charAt(x)) {
            case '^':
                line[x] = '>';
                break;
            case '>':
                line[x] = 'v';
                break;
            case 'v':
                line[x] = '<';
                break;
            case '<':
                line[x] = '^';
                break;
        }
        lines[y] = new String(line);
        return lines;
    }

    private String[] walkLeft(String[] lines, int x, int y) {
        char[] line = lines[y].toCharArray();
        line[x] = 'X';
        lines[y] = new String(line);
        lines[y] = lines[y].substring(0, x - 1) + "<" + lines[y].substring(x);
        return lines;
    }

    private String[] walkDown(String[] lines, int x, int y) {
        char[] line = lines[y].toCharArray();
        line[x] = 'X';
        lines[y] = new String(line);
        lines[y + 1] = lines[y + 1].substring(0, x) + "v" + lines[y + 1].substring(x + 1);
        return lines;
    }

    private String[] walkRight(String[] lines, int x, int y) {
        char[] line = lines[y].toCharArray();
        line[x] = 'X';
        lines[y] = new String(line);
        lines[y] = lines[y].substring(0, x + 1) + ">" + lines[y].substring(x + 2);
        return lines;
    }

    private String[] walkUp(String[] lines, int x, int y) {
        char[] line = lines[y].toCharArray();
        line[x] = 'X';
        lines[y] = new String(line);
        lines[y - 1] = lines[y - 1].substring(0, x) + "^" + lines[y - 1].substring(x + 1);
        return lines;
    }

    private String[] stop(String[] lines, int x, int y) {
        char[] line = lines[y].toCharArray();
        line[x] = 'X';
        lines[y] = new String(line);
        return lines;
    }

    public int countX(String input) {
        String updatedInput = walk(input);
        int count = 0;
        for (int i = 0; i < updatedInput.length(); i++) {
            if (updatedInput.charAt(i) == 'X') {
                count++;
            }
        }
        return count;
    }

    public boolean isLoop(String input) {
        String updatedInput = walk(input);
        return updatedInput.contains("^") || updatedInput.contains(">") || updatedInput.contains("v") || updatedInput.contains("<");
    }

    public int countLoops(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            System.out.println("Position " + i + " of " + input.length());
            if (input.charAt(i) == '.') {
                String tempInput = input.substring(0, i) + "#" + input.substring(i + 1);
                if (isLoop(tempInput)) {
                    count++;
                }
            }
        }
        return count;
    }
}
