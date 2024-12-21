package com.stiksy.advent.days;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day17Tests {
    String input = "Register A: 729\n" +
            "Register B: 0\n" +
            "Register C: 0\n" +
            "\n" +
            "Program: 0,1,5,4,3,0";

    String finalInput = "Register A: 50230824\n" +
            "Register B: 0\n" +
            "Register C: 0\n" +
            "\n" +
            "Program: 2,4,1,3,7,5,0,3,1,4,4,7,5,5,3,0";

    String part2Input = "Register A: 2024\n" +
            "Register B: 0\n" +
            "Register C: 0\n" +
            "\n" +
            "Program: 0,3,5,4,3,0";

    @Test
    void parseInput() {
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = day17.parseInput(input);
        assertEquals(729, debugger.registerA);
        assertEquals(0, debugger.registerB);
        assertEquals(0, debugger.registerC);
        assertEquals(6, debugger.instructions.size());
        assertEquals(0, debugger.instructions.get(0));
        assertEquals(1, debugger.instructions.get(1));
        assertEquals(5, debugger.instructions.get(2));
    }

    @Test
    void divisionOpcode0() {
        // The adv instruction (opcode 0) performs division.
        // The numerator is the value in the A register.
        // The denominator is found by raising 2 to the power of the instruction's combo operand.
        // (So, an operand of 2 would divide A by 4 (2^2); an operand of 5 would divide A by 2^B.)
        // The result of the division operation is truncated to an integer and then written to the A register.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerA = 8;
        debugger.instructions.add(0);
        debugger.instructions.add(2);
        debugger = day17.execute(debugger, null);
        assertEquals(2, debugger.registerA);
    }

    @Test
    void bitwiseXOROpcode1() {
        // The bxl instruction (opcode 1) calculates the bitwise XOR of register B
        // and the instruction's literal operand, then stores the result in register B.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerB = 8;
        debugger.instructions.add(1);
        debugger.instructions.add(4);
        debugger = day17.execute(debugger, null);
        assertEquals(12, debugger.registerB);
    }

    @Test
    void modulo8Opcode2() {
        // The bst instruction (opcode 2) calculates the value of its combo operand modulo 8
        // (thereby keeping only its lowest 3 bits), then writes that value to the B register.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.instructions.add(2);
        debugger.instructions.add(3);
        debugger = day17.execute(debugger, null);
        assertEquals(3, debugger.registerB);
    }

    @Test
    void jumpNotZeroOpcode3() {
        // The jnz instruction (opcode 3) does nothing if the A register is 0.
        // However, if the A register is not zero, it jumps by setting the instruction pointer
        // to the value of its literal operand; if this instruction jumps, the instruction pointer
        // is not increased by 2 after this instruction.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerA = 1;
        debugger.instructions.add(2);
        debugger.instructions.add(4);
        debugger.instructions.add(3);
        debugger.instructions.add(6);
        debugger.instructions.add(1);
        debugger.instructions.add(5);
        debugger.instructions.add(1);
        debugger.instructions.add(6);
        debugger = day17.execute(debugger, null);
        assertEquals(7, debugger.registerB);
    }

    @Test
    void jumpNotZeroOpcode3ShouldNotJump() {
        // The jnz instruction (opcode 3) does nothing if the A register is 0.
        // However, if the A register is not zero, it jumps by setting the instruction pointer
        // to the value of its literal operand; if this instruction jumps, the instruction pointer
        // is not increased by 2 after this instruction.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.instructions.add(2);
        debugger.instructions.add(4);
        debugger.instructions.add(3);
        debugger.instructions.add(6);
        debugger.instructions.add(1);
        debugger.instructions.add(5);
        debugger.instructions.add(1);
        debugger.instructions.add(6);
        debugger = day17.execute(debugger, null);
        assertEquals(3, debugger.registerB);
    }

    @Test
    void bitwiseXORBCOpcode4() {
        // The bxc instruction (opcode 4) calculates the bitwise XOR of register B and register C,
        // then stores the result in register B.
        // (For legacy reasons, this instruction reads an operand but ignores it.)
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerB = 8;
        debugger.registerC = 4;
        debugger.instructions.add(4);
        debugger.instructions.add(0);
        debugger = day17.execute(debugger, null);
        assertEquals(12, debugger.registerB);
    }

    @Test
    void modulo8OutputOpcode5() {
        // The out instruction (opcode 5) calculates the value of its combo operand modulo 8,
        // then outputs that value.
        // (If a program outputs multiple values, they are separated by commas.)
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.instructions.add(5);
        debugger.instructions.add(10);
        debugger = day17.execute(debugger, null);
        assertEquals("2", debugger.output);
        assertEquals(1, debugger.output.length());
    }

    @Test
    void divisionOpcode6() {
        // The bdv instruction (opcode 6) works exactly like the adv instruction
        // except that the result is stored in the B register.
        // (The numerator is still read from the A register.)
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerA = 8;
        debugger.instructions.add(6);
        debugger.instructions.add(2);
        debugger = day17.execute(debugger, null);
        assertEquals(8, debugger.registerA);
        assertEquals(2, debugger.registerB);
    }

    @Test
    void divisionOpcode7() {
        // The cdv instruction (opcode 7) works exactly like the adv instruction
        // except that the result is stored in the C register.
        // (The numerator is still read from the A register.)
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerA = 8;
        debugger.instructions.add(7);
        debugger.instructions.add(2);
        debugger = day17.execute(debugger, null);
        assertEquals(8, debugger.registerA);
        assertEquals(0, debugger.registerB);
        assertEquals(2, debugger.registerC);
    }

    @Test
    void example1() {
        // If register C contains 9, the program 2,6 would set register B to 1.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerC = 9;
        debugger.instructions.add(2);
        debugger.instructions.add(6);
        debugger = day17.execute(debugger, null);
        assertEquals(1, debugger.registerB);
    }

    @Test
    void example2() {
        // If register A contains 10, the program 5,0,5,1,5,4 would output 0,1,2.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerA = 10;
        debugger.instructions.add(5);
        debugger.instructions.add(0);
        debugger.instructions.add(5);
        debugger.instructions.add(1);
        debugger.instructions.add(5);
        debugger.instructions.add(4);
        debugger = day17.execute(debugger, null);
        assertEquals("0,1,2", debugger.output);
        assertEquals(5, debugger.output.length());
    }

    @Test
    void example3() {
        // If register A contains 2024, the program 0,1,5,4,3,0 would output 4,2,5,6,7,7,7,7,3,1,0 and leave 0 in register A.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerA = 2024;
        debugger.instructions.add(0);
        debugger.instructions.add(1);
        debugger.instructions.add(5);
        debugger.instructions.add(4);
        debugger.instructions.add(3);
        debugger.instructions.add(0);
        debugger = day17.execute(debugger, null);
        assertEquals("4,2,5,6,7,7,7,7,3,1,0", debugger.output);
        assertEquals(21, debugger.output.length());
        assertEquals(0, debugger.registerA);
    }

    @Test
    void example4() {
        // If register B contains 29, the program 1,7 would set register B to 26.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerB = 29;
        debugger.instructions.add(1);
        debugger.instructions.add(7);
        debugger = day17.execute(debugger, null);
        assertEquals(26, debugger.registerB);
    }

    @Test
    void example5() {
        // If register B contains 2024 and register C contains 43690,
        // the program 4,0 would set register B to 44354.
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = new Day8.Day17Debugger();
        debugger.registerB = 2024;
        debugger.registerC = 43690;
        debugger.instructions.add(4);
        debugger.instructions.add(0);
        debugger = day17.execute(debugger, null);
        assertEquals(44354, debugger.registerB);
    }

    @Test
    void runTestInput() {
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = day17.parseInput(input);
        debugger = day17.execute(debugger, null);
        assertEquals("4,6,3,5,6,3,5,2,1,0", debugger.output);
    }

    @Test
    void runFinalInput() {
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = day17.parseInput(finalInput);
        debugger = day17.execute(debugger, null);
        assertEquals("2,1,4,7,6,0,3,1,4", debugger.output);
    }

    @Test
    void runPart2Input() {
        Day17 day17 = new Day17();
        Day8.Day17Debugger originalDebugger = day17.parseInput(part2Input);
        Day8.Day17Debugger debugger = day17.parseInput(part2Input);
        debugger.registerA = 117440;
        debugger = day17.execute(debugger, null);
        assertEquals(originalDebugger.instructions.stream().map(String::valueOf).collect(Collectors.joining(",")), debugger.output);
    }

    @Test
    void checkPart2() {
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = day17.parseInput(part2Input);
        long registerA = day17.findSmallestRegisterA(debugger);
        assertEquals(117440, registerA);
    }

    @Test
    void checkPart2Final() {
        Day17 day17 = new Day17();
        Day8.Day17Debugger debugger = day17.parseInput(finalInput);
        long registerA = day17.findSmallestRegisterA(debugger);
        assertEquals(266932601404433L, registerA);
    }
}
