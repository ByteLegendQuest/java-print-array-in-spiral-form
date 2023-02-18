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
        int i,j,m;
        m = 0;
        int[] arr = new int[16];
        for (i = 0;i < 2;i++) {
            for (j = i;j < 3 - i;j++) {
                arr[m++] = matrix[i][j];
            }
            for (j = i;j < 3 - i;j++) {
                arr[m++] = matrix[j][3 - i];
            }
            for (j = i;j < 3 - i;j++) {
                arr[m++] = matrix[3 - i][3 - j];
            }
            for (j = i;j < 3 - i;j++) {
                arr[m++] = matrix[3 - j][i];
            }
        }
        return arr;
    }
}
