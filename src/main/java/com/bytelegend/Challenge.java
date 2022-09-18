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
        int[] arr = new int[16];
        int m = 0;
        int n = 0;
        int i = 0;
        for (m = 0, n = 0; n < 4; n++, i++) {
            arr[i] = matrix[m][n];
        }
        for (m = 1, n = 3; m < 4; m++, i++) {
            arr[i] = matrix[m][n];
        }
        for (m = 3, n = 2; n >= 0; n--, i++) {
            arr[i] = matrix[m][n];
        }
        for (m = 2, n = 0; m > 0; m--, i++) {
            arr[i] = matrix[m][n];
        }
        for (m = 1, n = 1; n < 3; n++, i++) {
            arr[i] = matrix[m][n];
        }
        for (m = 2, n = 2; n > 0; n--, i++) {
            arr[i] = matrix[m][n];
        }
        return arr;
    }
}
