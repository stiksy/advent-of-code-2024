package com.stiksy.advent.days;

import java.util.stream.Collectors;

public class Day17 {
    public Day8.Day17Debugger execute(Day8.Day17Debugger debugger, String desiredOutput) {
        int instructionNumber = 0;
        while (instructionNumber < debugger.instructions.size()) {
            int opcode = debugger.instructions.get(instructionNumber);
            int operand = debugger.instructions.get(instructionNumber + 1);
            long comboOperand = switch (operand) {
                case 4 -> debugger.registerA;
                case 5 -> debugger.registerB;
                case 6 -> debugger.registerC;
                default -> operand;
            };
            boolean jumped = false;
            switch (opcode) {
                case 0:
                    debugger.registerA /= Math.pow(2, comboOperand);
                    break;
                case 1:
                    debugger.registerB ^= operand;
                    break;
                case 2:
                    debugger.registerB = comboOperand % 8;
                    break;
                case 3:
                    if (debugger.registerA != 0) {
                        instructionNumber = operand;
                        jumped = true;
                        break;
                    }
                    break;
                case 4:
                    debugger.registerB ^= debugger.registerC;
                    break;
                case 5:
                    if (debugger.output.isEmpty()) {
                        debugger.output = String.valueOf(comboOperand % 8);
                    } else {
                        debugger.output += "," + comboOperand % 8;
                    }
                    if (desiredOutput != null && !desiredOutput.startsWith(debugger.output)) {
                        return debugger;
                    }
                    break;
                case 6:
                    debugger.registerB = (long) (debugger.registerA / Math.pow(2, comboOperand));
                    break;
                case 7:
                    debugger.registerC = (long) (debugger.registerA / Math.pow(2, comboOperand));
                    break;
            }
            if (!jumped) {
                instructionNumber += 2;
            }
        }
        return debugger;
    }

    public long findSmallestRegisterA(Day8.Day17Debugger debugger) {
        String instructionSet = debugger.instructions.stream().map(String::valueOf).collect(Collectors.joining(","));
        for (long newRegisterA = 266932601404433L; newRegisterA < 266932601404434L; newRegisterA++) {
            if (newRegisterA % 10000000 == 0) {
                System.out.println("Checking value " + String.format("%,d", newRegisterA));
            }
            debugger.registerA = newRegisterA;
            debugger.registerB = 0;
            debugger.registerC = 0;
            debugger.output = "";
            debugger = execute(debugger, instructionSet);
            System.out.println("Output: " + debugger.output);
            if (debugger.output.equals(instructionSet)) {
                return newRegisterA;
            }
        }
        return -1;
    }

    public Day8.Day17Debugger parseInput(String input) {
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        String[] lines = input.split("\n");
        for (String line : lines) {
            if (line.startsWith("Register A: ")) {
                debugger.registerA = Long.parseLong(line.substring(12));
            } else if (line.startsWith("Register B: ")) {
                debugger.registerB = Long.parseLong(line.substring(12));
            } else if (line.startsWith("Register C: ")) {
                debugger.registerC = Long.parseLong(line.substring(12));
            } else if (line.startsWith("Program: ")) {
                String[] instructions = line.substring(9).split(",");
                for (String instruction : instructions) {
                    debugger.instructions.add(Integer.parseInt(instruction));
                }
            }
        }
        return debugger;
    }

//    public static void main(String[] args) {
//        String finalInput = "Register A: 50230824\n" +
//                "Register B: 0\n" +
//                "Register C: 0\n" +
//                "\n" +
//                "Program: 2,4,1,3,7,5,0,3,1,4,4,7,5,5,3,0";
//        Day17 day17 = new Day17();
//        Day17Debugger debugger = day17.parseInput(finalInput);
//        long registerA = day17.findSmallestRegisterA(debugger);
//        System.out.println("Register A: " + registerA);
//    }
}
