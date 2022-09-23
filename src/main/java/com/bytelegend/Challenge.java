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
        int index = 0;
        int count = matrix.length * matrix[0].length;
        int[] ret = new int[count];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (index < count) {
            for (int i = left; i <= right; i++) {
                ret[index] = matrix[top][i];
                index++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ret[index] = matrix[i][right];
                index++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ret[index] = matrix[bottom][i];
                index++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ret[index] = matrix[i][left];
                index++;
            }
            left++;
        }
        return ret;
    }
}
