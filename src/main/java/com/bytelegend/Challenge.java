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
        int[] spiralOrderArray = new int[matrix.length * matrix[0].length];
        int index = 0;
        takeFirstRowAndRotateMatrix(spiralOrderArray, index, matrix);
        return spiralOrderArray;
    }

    public static void takeFirstRowAndRotateMatrix(int[] spiralOrderArray, int index, int[][] matrix) {
        int current = index;
        if (matrix != null && matrix.length != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                spiralOrderArray[current++] = matrix[0][i];
            }
            takeFirstRowAndRotateMatrix(spiralOrderArray, current, removeFirstRowAndRotateMatrixAnd(matrix));
        }
    }

    public static int[][] removeFirstRowAndRotateMatrixAnd(int[][] matrix) {
        if (matrix.length == 1) {
            return null;
        }
        int x = matrix[0].length;
        int y = matrix.length - 1;
        int[][] newMatrix = new int[x][y];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[j + 1][x - i - 1];
            }
        }
        return newMatrix;
    }
}
