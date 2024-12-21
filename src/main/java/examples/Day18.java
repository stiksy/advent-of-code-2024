package examples;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Day18 {
    public static final int INF = Integer.MAX_VALUE / 2;
    public static final int[] DY = {0, -1, 0, 1};
    public static final int[] DX = {1, 0, -1, 0};

    // input
    public static final int NUM_ROWS = 71;
    public static final int NUM_COLUMNS = 71;
    public static final int FIRST_COORDINATES = 1024;

    // sample
//    public static final int NUM_ROWS = 7;
//    public static final int NUM_COLUMNS = 7;
//    public static final int FIRST_COORDINATES = 12;


    public static void main(String[] args) throws IOException {
        final File file = new File("/Users/fernando.marquardt/Projects/advent/AOC2024/src/main/resources/day18input.txt");
        final List<String> coordinates = Files.readAllLines(Path.of(file.getPath()), StandardCharsets.UTF_8);

        final List<String> firstCoordinates = coordinates.subList(0, FIRST_COORDINATES);
        final int part1 = solvePart1(firstCoordinates);
        System.out.println("part1 = " + part1);

        final String part2 = solvePart2(coordinates);
        System.out.println("part2 = " + part2);



    }

    private static String solvePart2(final List<String> coordinates) {
        for (int i = FIRST_COORDINATES; i < coordinates.size() - 1; i++) {
            final String addedByte = coordinates.get(i - 1);

            final List<String> extendedBytes = coordinates.subList(0, i);
            final int distance = solvePart1(extendedBytes);
            if (distance == INF) {
                return addedByte;
            }
        }

        return "Error! Could not find coordinates";
    }

    private static int solvePart1(final List<String> coordinates) {
        final char[][] map = createMap(coordinates);

        final int numRows = NUM_ROWS;
        final int numColumns = NUM_COLUMNS;

        final int[][] distances = new int[numRows][numColumns];
        Arrays.stream(distances)
                .forEach(distanceRow -> Arrays.fill(distanceRow, INF));

        final PairIntInt startPosition = new PairIntInt(0, 0);
        final PairIntInt endPosition = new PairIntInt(numRows - 1, numColumns - 1);

        final Queue<PairIntInt> queue = new ArrayDeque<>();
        queue.add(startPosition);
        distances[startPosition.getFirst()][startPosition.getSecond()] = 0;

        while (!queue.isEmpty()) {
            final PairIntInt node = queue.poll();
            if (node.equals(endPosition)) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                final int neighborY = node.getFirst() + DY[i];
                final int neighborX = node.getSecond() + DX[i];

                if (isValidRange(neighborX, 0, numColumns - 1) && isValidRange(neighborY, 0, numRows - 1)
                        && isIsSafe(map, neighborY, neighborX)) {

                    final PairIntInt neighbor = new PairIntInt(neighborY, neighborX);
                    final int currentDistance = distances[node.getFirst()][node.getSecond()];
                    final int currentNeighborDistance = distances[neighborY][neighborX];

                    final boolean isDistanceReduced = (currentDistance + 1 < currentNeighborDistance);
                    if (isDistanceReduced) {
                        queue.add(neighbor);
                        distances[neighborY][neighborX] = currentDistance + 1;
                    }
                }

            }

        }

        return distances[endPosition.getFirst()][endPosition.getSecond()];
    }

    private static char[][] createMap(final List<String> coordinates) {
        final char[][] map = new char[NUM_ROWS][NUM_COLUMNS];

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int k = 0; k < NUM_COLUMNS; k++) {
                map[i][k] = '.';
            }
        }

        coordinates.stream()
                .map(s -> {
                    final int x = Integer.parseInt(s.split(",")[0]);
                    final int y = Integer.parseInt(s.split(",")[1]);
                    return new PairIntInt(x, y);
                })
                .forEach(pair -> map[pair.getSecond()][pair.getFirst()] = '#');

        return map;
    }

    private static boolean isIsSafe(final char[][] map, final int neighborY, final int neighborX) {
        return map[neighborY][neighborX] == '.';
    }

    private static boolean isValidRange(final int value, final int inclusiveMin, final int inclusiveMax) {
        return inclusiveMin <= value && value <= inclusiveMax;
    }

    public static class PairIntInt {
        private final int first;
        private final int second;

        public PairIntInt(final int first, final int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            final Day18.PairIntInt that = (Day18.PairIntInt) o;
            return first == that.first && second == that.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}