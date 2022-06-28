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
        int h = matrix.length;
        int l = matrix[0].length;
        int[] a = new int[h * l];
        int b = 0;
        int left = 0, right = l - 1, top = 0, bottom = h - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                a[b++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                a[b++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    a[b++] = matrix[bottom][i];
                }
                for (int i = bottom; i > top; i--) {
                    a[b++] = matrix[i][left];
                }
            }
            right--;
            left++;
            top++;
            bottom--;
        }
        return a;
    }
}
