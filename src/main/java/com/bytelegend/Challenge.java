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
        if (matrix.length == 1) {
            return matrix[0];
        }
        int[] arr = matrix[0];
        int[][] subMatrix = new int[arr.length][matrix.length-1];
        int subMI = 0;
        int subMJ = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 1; i < matrix.length; i++) {
                subMatrix[subMI][subMJ++] = matrix[i][j];
            }
            subMI++;
            subMJ = 0;
        }
        int[] subArr = spiralOrder(subMatrix);
        int[] reArr = new int[arr.length + subArr.length];
        int i = 0;
        for (int e: arr) {
            reArr[i++] = e;
        }
        for (int e: subArr) {
            reArr[i++] = e;
        }
        return reArr;
    }
}
