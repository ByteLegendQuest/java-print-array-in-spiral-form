package com.bytelegend;

import java.util.Arrays;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        spiralOrder(
                                new int[][]{
                                        {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
                                })));
    }

    /**
     * `spiralOrder(int[][] matrix)` print the matrix in spiral order.
     *
     * <p>For example, given the following matrix:
     *
     * <p>``` 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ```
     *
     * <p>Return `[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]`.
     */
    public static int[] spiralOrder(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] result = new int[rowLength * colLength];
        int rowCursor = 0, colCursor = 0, k = 0, l = 0, cursor = 0, round = 0;
        while (cursor < rowLength * colLength) {
            for (colCursor = round; colCursor <= colLength - (round + 1) && cursor < rowLength * colLength; colCursor++) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            colCursor--;
            for (rowCursor = round + 1; rowCursor <= rowLength - (round + 1) && cursor < rowLength * colLength; rowCursor++) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            rowCursor--;
            for (colCursor--; colCursor >= round && cursor < rowLength * colLength; colCursor--) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            colCursor++;
            for (rowCursor--; rowCursor >= round + 1 && cursor < rowLength * colLength; rowCursor--) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            rowCursor++;
            round++;
            rowCursor = round;
            colCursor = round;
        }
        return result;
    }
}
