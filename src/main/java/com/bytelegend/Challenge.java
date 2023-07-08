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
        int[] ans = new int[m * n];

        int left = 0, right = m - 1, top = 0, bottom = n - 1;
        int count = 0;

        while (count < m * n) {
            for (int i = left; i <= right && count < m * n; i++) {
                ans[count++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom && count < m * n; i++) {
                ans[count++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && count < m * n; i--) {
                ans[count++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && count < m * n; i--) {
                ans[count++] = matrix[i][left];
            }
            left++;
        }
        
        return ans;
    }
}
