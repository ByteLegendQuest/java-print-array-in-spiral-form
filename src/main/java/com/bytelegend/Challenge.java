package com.bytelegend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> arr = new ArrayList<>();

        int left = 0, right = matrix[0].length - 1;
        int top = 0, down = matrix.length - 1;

        while (true) {
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }

            top++;
            if (top > down) {
                break;
            }

            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }

            right--;
            if (left > right) {
                break;
            }
            ;

            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }

            down--;
            if (top > down) {
                break;
            }

            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }

            left++;
            if (left > right) {
                break;
            }

        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}
