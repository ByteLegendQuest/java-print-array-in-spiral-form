package com.bytelegend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        List<Integer> spiralOrder = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                spiralOrder.add(matrix[top][col]);
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                spiralOrder.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    spiralOrder.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    spiralOrder.add(matrix[row][left]);
                }
                left++;
            }
        }

        int[] result = new int[spiralOrder.size()];
        for (int i = 0; i < spiralOrder.size(); i++) {
            result[i] = spiralOrder.get(i);
        }

        return result;
    }
}
