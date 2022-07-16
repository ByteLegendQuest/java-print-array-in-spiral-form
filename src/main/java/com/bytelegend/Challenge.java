package com.bytelegend;

import java.util.Arrays;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        spiralOrder(
                                new int[][] {
                                        {1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12},
                                        {13, 14, 15, 16}
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
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int outPos = 0;
        int maxLoops = Math.min((rows + 1) / 2, (cols + 1) / 2);
        for (int loop = 0; loop < maxLoops; loop++) {
            // 输出上方
            for (int i = loop; i < cols - loop; i ++) {
                checkAndPrint(res, outPos, matrix[loop][i]);
                outPos++;
            }
            // 输出右边
            for (int i = loop + 1; i < rows - loop; i++) {
                checkAndPrint(res, outPos, matrix[i][cols - loop - 1]);
                outPos++;
            }
            // 输出下边
            for (int i = cols - loop - 2; i >= loop; i--) {
                checkAndPrint(res, outPos, matrix[rows - loop - 1][i]);
                outPos++;
            }
            // 输出左边
            for (int i = rows - loop - 2; i > loop; i--) {
                checkAndPrint(res, outPos, matrix[i][loop]);
                outPos++;
            }
        }
        return res;
    }

    private static void checkAndPrint(int[] array, int outPos, int value) {
        if (outPos < array.length) {
            array[outPos] = value;
        }
    }
}
