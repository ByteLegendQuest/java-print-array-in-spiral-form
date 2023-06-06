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
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int rowCursor = 0, colCursor, cursor = 0, round = 0;
        while (cursor < row * col) {
            for (colCursor = round; colCursor <= col - (round + 1) && cursor < row * col; colCursor++) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            colCursor--;
            for (rowCursor = round + 1; rowCursor <= row - (round + 1) && cursor < row * col; rowCursor++) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            rowCursor--;
            for (colCursor--; colCursor >= round && cursor < row * col; colCursor--) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            colCursor++;
            for (rowCursor--; rowCursor >= round + 1 && cursor < row * col; rowCursor--) {
                result[cursor] = matrix[rowCursor][colCursor];
                cursor++;
            }
            round++;
            rowCursor = round;
        }
        return result;
    }
}
