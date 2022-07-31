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
        int m = matrix.length, n = matrix[0].length;
        boolean flag = true;
        int[] ans = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = flag ? 0 : n - 1; flag ? j < n : j >= 0; j += flag ? 1 : -1) {
                ans[idx++] = matrix[i][j];
            }
            flag = !flag;
        }
        return ans;
    }
}
