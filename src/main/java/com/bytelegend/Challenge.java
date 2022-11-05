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
        int maCol = matrix[0].length;
        int maRow = matrix.length;
        int res[] = new int[maRow*maCol];
        int tmpMinCol = 0,tmpMinRow = 0;
        int tmpMaxCol = maCol - 1, tmpMaxRow = maRow - 1;
        int forward = 0;
        int x = 0, y = 0;
        int newX = 0, newY = 0;
        for (newX = 0; newX < maRow; ++newX) {
            for (newY = 0; newY < maCol; ++newY) {
                res[newX*maCol+newY] = matrix[x][y];
                //先判断是否转向
                if (forward % 4 == 0) {
                    if (y>= tmpMaxCol) {
                        forward++;
                        tmpMinRow++;
                    }
                } else if (forward % 4 == 1) {
                    if (x>= tmpMaxRow) {
                        forward++;
                        tmpMaxCol--;
                    }
                } else if (forward % 4 == 2) {
                    if (y<= tmpMinCol) {
                        forward++;
                        tmpMaxRow--;
                    }

                } else if (forward % 4 == 3) {
                    if (x<= tmpMinRow) {
                        forward++;
                        tmpMinCol++;
                    }
                }
                if (forward % 4 == 0) {
                    y++;
                } else if (forward % 4 == 1) {
                    x++;
                } else if (forward % 4 == 2) {
                    y--;
                } else if (forward % 4 == 3) {
                    x--;
                }
            }
        }
        return res;
    }
}
