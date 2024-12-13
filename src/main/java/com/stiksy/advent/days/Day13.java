package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.List;

public class Day13 {
    class Button {
        int x;
        int y;
    }

    class Prize {
        long x;
        long y;
    }

    class Machine {
        Button buttonA;
        Button buttonB;
        Prize prize;
    }

    public List<Machine> processInput(String input) {
        String[] lines = input.split("\n");
        List<Machine> machines = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            Machine machine = new Machine();

            String line = lines[i].replace(",", "");
            String[] parts = line.split(" ");
            Button button = new Button();
            button.x = Integer.parseInt(parts[2].substring(2));
            button.y = Integer.parseInt(parts[3].substring(2));
            machine.buttonA = button;

            i++;

            line = lines[i].replace(",", "");
            parts = line.split(" ");
            button = new Button();
            button.x = Integer.parseInt(parts[2].substring(2));
            button.y = Integer.parseInt(parts[3].substring(2));
            machine.buttonB = button;

            i++;

            line = lines[i].replace(",", "");
            parts = line.split(" ");
            Prize prize = new Prize();
            prize.x = Integer.parseInt(parts[1].substring(2)) + 10000000000000L;
            prize.y = Integer.parseInt(parts[2].substring(2)) + 10000000000000L;
            machine.prize = prize;

            i++;
            machines.add(machine);
        }
        return machines;
    }

    public long play(Machine machine) {
        long bPresses = (machine.buttonA.y * machine.prize.x - machine.buttonA.x * machine.prize.y) /
                (machine.buttonA.y * machine.buttonB.x - machine.buttonA.x * machine.buttonB.y);
        long aPresses = (machine.prize.x - bPresses * machine.buttonB.x) / machine.buttonA.x;
        if ((aPresses * machine.buttonA.x) + (bPresses * machine.buttonB.x) == machine.prize.x &&
                (aPresses * machine.buttonA.y) + (bPresses * machine.buttonB.y) == machine.prize.y) {
            return (3 * aPresses) + bPresses;
        }
        return -1;
    }

    public long playAllMachines(String input) {
        List<Machine> machines = processInput(input);
        long totalCost = 0;
        for (Machine machine : machines) {
            long tokenCost = play(machine);
            if (tokenCost == -1) continue;
            totalCost += tokenCost;
        }
        return totalCost;
    }
}
