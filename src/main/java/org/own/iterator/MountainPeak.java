package org.own.iterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MountainPeak {
    public static int findPeakAltitude(int[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        int altitude = grid[startRow][startCol];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] startingPoint = queue.poll();
            startRow = startingPoint[0];
            startCol = startingPoint[1];
            for (int[] dir : directions) {
                int newRow = startRow + dir[0];
                int newCol = startCol + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] > altitude) {
                    altitude = grid[newRow][newCol];
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return altitude;
    }

    public static int[] findNextPeak(int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // Define directions

        int currentHeight = matrix[row][col];

        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r > -1 && r < rows && c > -1 && c < cols && matrix[r][c] > currentHeight) { // Check if the new position is higher than the current
                return new int[]{r, c}; // Return coordinates of the next higher peak
            }
        }

        return new int[]{row, col}; // No higher peak, stay in place
    }

    public static List<Integer> trekPath(int[][] mountain, int startRow, int startCol) {
        // Write your code here
        List<Integer> path = new ArrayList<>();
        path.add(mountain[startRow][startCol]);
        var rows = mountain.length;
        var cols = mountain[0].length;
        Queue<int[]> queue = new LinkedList<>();
        var altitude = mountain[startRow][startCol];

        queue.offer(new int[]{startRow, startCol});
        int[][] fourDirections = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            var position = queue.poll();
            var row = position[0];
            var col = position[1];
            var maxHeight = -1;
            var maxRow = -1;
            var maxCol = -1;
            for (int[] dir : fourDirections) {
                var newRow = row + dir[0];
                var newCol = col + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && mountain[newRow][newCol] > altitude) {
                    if (altitude > maxHeight) {
                        maxHeight = altitude;
                        maxRow = newRow;
                        maxCol = newCol;
                    }
                    altitude = mountain[newRow][newCol];
                }
            }
            if (maxHeight > -1) {
                path.add(mountain[maxRow][maxCol]);
                queue.offer(new int[]{maxRow, maxCol});
            }

        }

        return path;
    }
}
