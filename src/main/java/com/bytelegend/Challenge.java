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
        int[] result = new int[matrix.length * matrix[0].length];
        int j = 0;
        int w = 0;
        int x = matrix.length - 1;
        int y = 0;
        int z = matrix[0].length - 1;
        while (w <= x && y <= z) {
            for (int i = w; i <= z; i++) {
                result[j++] = matrix[w][i];
            }
            for (int i = w + 1; i <= x; i++) {
                result[j++] = matrix[i][z];
            }
            if (w + 1 <= x) {
                for (int i = z - 1; i >= y; i--) {
                    result[j++] = matrix[x][i];
                }
            }
            if (y + 1 <= z) {
                for (int i = x - 1; i > w; i--) {
                    result[j++] = matrix[i][y];
                }
            }
            w++;
            x--;
            y++;
            z--;
        }
        return result;
    }
}
