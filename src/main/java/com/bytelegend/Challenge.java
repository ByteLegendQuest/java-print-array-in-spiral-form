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
        int[] newMatrix = new int[matrix.length * matrix[0].length];
        int iPlusCounter = 0;
        int jPlusCounter = 0;
        int iMinusCounter = 0;
        int jMinusCounter = 0;
        int index = 0;

        int i = 0;
        int j = 0;

        while (index < newMatrix.length) {
            while (j + jPlusCounter < matrix[i].length && index < newMatrix.length) {
                newMatrix[index] = matrix[i][j];
                index++;
                j++;
            }
            j--;
            i++;
            jPlusCounter++;

            while (i + iPlusCounter < matrix.length && index < newMatrix.length) {
                newMatrix[index] = matrix[i][j];
                index++;
                i++;
            }
            i--;
            j--;
            iPlusCounter++;

            while (j >= jMinusCounter && index < newMatrix.length) {
                newMatrix[index] = matrix[i][j];
                index++;
                j--;
            }
            j++;
            i--;
            jMinusCounter++;

            while (i > iMinusCounter && index < newMatrix.length) {
                newMatrix[index] = matrix[i][j];
                index++;
                i--;
            }
            i++;
            j++;
            iMinusCounter++;
        }

        return newMatrix;
    }
}
