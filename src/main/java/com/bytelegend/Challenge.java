package com.bytelegend;

import java.util.ArrayList;
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
        int[] ans = new int[matrix.length * matrix[0].length];
        int iPlusCounter = 0;
        int jPlusCounter = 0;
        int iMinuxCounter = 0;
        int jMinuxCounter = 0;
        int index = 0;

        int i = 0;
        int j = 0;

        while (index < ans.length) {
            while (j + jPlusCounter < matrix[i].length && index < ans.length) {
                ans[index] = matrix[i][j];
                index++;
                j++;
            }
            j--;
            i++;
            jPlusCounter++;
            while (i + iPlusCounter < matrix.length && index < ans.length) {
                ans[index] = matrix[i][j];
                index++;
                i++;
            }
            i--;
            j--;
            iPlusCounter++;
            while (j >= jMinuxCounter && index < ans.length) {
                ans[index] = matrix[i][j];
                index++;
                j--;
            }
            j++;
            i--;
            jMinuxCounter++;
            while (i > iMinuxCounter && index < ans.length) {
                ans[index] = matrix[i][j];
                index++;
                i--;
            }
            i++;
            j++;
            iMinuxCounter++;
        }
        return ans;
    }
}
