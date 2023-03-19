package com.bytelegend;

import java.util.Arrays;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        spiralOrder(
                                new int[][] {
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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows * cols;
        int[] result = new int[size];

        int top  = 0;
        int right = cols - 1;
        int bottom = rows - 1;
        int left = 0;

        int direction = 0; // 0 for right, 1 for down, 2 for left, 3 for up

        int row = top;
        int col = left; // current point

        int currentResultIndex = 0;
        while (top <= bottom && left <= right) {
            result[currentResultIndex] = matrix[row][col];
            currentResultIndex++;

            switch (direction) {
                case 0: // for right
                    // move to right gird
                    col++;
                    if (col > right) {
                        // touch right bound
                        direction++; // change move direction
                        top++; // make top bound move down;
                        row++; // move down
                        col--;
                    }
                    break;
                case 1:
                    // move to down gird
                    row++;
                    if (row > bottom) {
                        // touch bottom bound
                        direction++; // change move direction
                        right--; // make right bound move left
                        col--; // move right
                        row--;
                    }
                    break;
                case 2:
                    // move to left gird
                    col--;
                    if (col < left) {
                        // touch left bound
                        direction++; // change move direction
                        bottom--; // make bottom bound move up;
                        row--; // move up
                        col++;
                    }
                    break;
                case 3:
                    // move to up gird
                    row--;
                    if (row < top) {
                        // touch top bound
                        direction = 0; // change move direction
                        left++; // make left bound move right
                        col++; // move right
                        row++;
                    }
                    break;
            }
        }
        return result;
    }
}
