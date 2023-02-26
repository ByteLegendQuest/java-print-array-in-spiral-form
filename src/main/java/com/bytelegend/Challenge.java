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
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int direction = 0; // 0: right, 1: down, 2: left, 3: up
        int count = 0;
        while (count < m * n) {
            if (direction == 0) { // 向右遍历
                for (int i = left; i <= right; i++) {
                    result[count++] = matrix[top][i];
                }
                top++;
            } else if (direction == 1) { // 向下遍历
                for (int i = top; i <= bottom; i++) {
                    result[count++] = matrix[i][right];
                }
                right--;
            } else if (direction == 2) { // 向左遍历
                for (int i = right; i >= left; i--) {
                    result[count++] = matrix[bottom][i];
                }
                bottom--;
            } else { // 向上遍历
                for (int i = bottom; i >= top; i--) {
                    result[count++] = matrix[i][left];
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
}
