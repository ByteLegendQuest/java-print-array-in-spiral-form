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
        int[] arr = new int[matrix.length * matrix[0].length];
        int a = 0;
        int x = 0;
        int y = 0;
        int xend = matrix[0].length - 1;
        int yend = matrix.length - 1;

        while(x <= xend && y <= yend) {
            for (int i = x; i <= xend; i++) {
                arr[a] = matrix[x][i];
                a++;
            }
            for (int i = y + 1; i < yend + 1; i++) {
                arr[a] = matrix[i][xend];
                a++;
            }
            for (int i = xend - 1; i >= x; i--) {
                arr[a] = matrix[yend][i];
                a++;
            }
            for (int i = yend - 1; i >= y + 1; i--) {
                arr[a] = matrix[i][x];
                a++;
            }
            x++;
            y++;
            xend--;
            yend--;
        }
        return arr;
    }
}
