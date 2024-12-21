package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day19 {
    public static void main(String[] args) {
        String fileName = "/Users/fernando.marquardt/Projects/advent/AOC2024/src/main/java/examples/day19input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            String[] towels = line.split(", ");
            Set<String> towelSet = new HashSet<>(Arrays.asList(towels));
            String blank = br.readLine(); // Blank line

            long possible = 0;
            while ((line = br.readLine()) != null) {
//                if (solvePart1(towelSet, line, 1)) {
//                    possible++;
//                }
                possible += solvePart2(towelSet, line, 1);
            }

            System.out.println("Possible towels: " + possible);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // If it can be formed or not
    private static boolean solvePart1(Set<String> towelSet, String line, int end) {
        if (end > line.length()) { // Couldn't find towel to match suffix of line
            return false;
        }

        if (towelSet.contains(line)) { // Found towel to match entire line
            return true;
        }

        if (towelSet.contains(line.substring(0, end))) { // Found towel to match prefix of line
            return solvePart1(towelSet, line.substring(end), 1) || solvePart1(towelSet, line, end+1);
        }

        return solvePart1(towelSet, line, end+1);
    }

    static Map<String, Long> dp = new HashMap<>();

    // How many towels can be formed
    private static long solvePart2(Set<String> towelSet, String line, int end) {
        if (dp.containsKey(line)) {
            return dp.get(line);
        }

        if (line.isEmpty()) { // Found towel to match entire line
            return 1;
        }

        if (end > line.length()) { // Couldn't find towel to match suffix of line
            return 0;
        }

        if (towelSet.contains(line.substring(0, end))) { // Found towel to match prefix of line
            long total = solvePart2(towelSet, line.substring(end), 1) + solvePart2(towelSet, line, end+1);
            dp.put(line, total);
            return total;
        }

        long total = solvePart2(towelSet, line, end+1);
        dp.put(line, total);
        return total;
    }
}