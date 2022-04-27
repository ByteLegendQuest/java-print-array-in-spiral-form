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
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0, i = 0, j = -1, rowRe = 0, colRe = 0;
        boolean row = true, rowAdd = true, colAdd = true;
        while (index < result.length) {
            if (row) {
                j = rowAdd ? j + 1 : j - 1;
                if (rowAdd ? j == matrix[i].length - 1 - rowRe / 2 : j == rowRe / 2) {
                    row = false;
                    rowAdd = !rowAdd;
                    rowRe++;
                }
            } else {
                i = colAdd ? i + 1 : i - 1;
                if (colAdd ?
                        i == matrix.length - 1 - (colRe > 1 ? colRe - 1 : colRe) :
                        i == (colRe > 1 ? colRe - 1 : colRe)) {
                    row = true;
                    colAdd = !colAdd;
                    colRe++;
                }
            }
            result[index++] = matrix[i][j];
        }
        return result;
    }
}
