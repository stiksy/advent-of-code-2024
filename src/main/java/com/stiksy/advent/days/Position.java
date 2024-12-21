package com.stiksy.advent.days;

import java.util.Set;

class Position {
    int line;
    int column;
    char direction;
    int currentCost;
    Set<String> history;

    public Position(int line, int column, char direction, int currentCost, Set<String> history) {
        this.line = line;
        this.column = column;
        this.direction = direction;
        this.currentCost = currentCost;
        this.history = history;
    }
}
