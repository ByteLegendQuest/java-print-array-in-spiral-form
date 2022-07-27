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
        int[] answer = new int[matrix.length * matrix[0].length];
        int istart = 0;
        int jstart = 0;
        int ilim = matrix.length - 1;
        int jlim = matrix[0].length - 1;
        int a = 1;
        int k = 0;
        while (k < answer.length) {
            for (int j = jstart; j != (jlim + a); j += a) {
                answer[k++] = matrix[istart][j];
            }
            istart += a;
            for (int i = istart; i != (ilim + a); i += a) {
                answer[k++] = matrix[i][jlim];
            }
            jlim -= a;
            a *= -1;
            int tmp = istart;
            istart = ilim;
            ilim = tmp;
            tmp = jstart;
            jstart = jlim;
            jlim = tmp;
        }
        return answer;
    }
}
