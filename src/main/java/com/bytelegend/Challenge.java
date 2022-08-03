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
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length, p = 0;
        int[] ans = new int[m * n];
        boolean[][] visited = new boolean[m][n];
        for (int idx = 0, x = 0, y = 0; idx < m * n; idx++) {
            ans[idx] = matrix[x][y];
            visited[x][y] = true;
            int[] dir = dirs[p];
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                p = (p + 1) % 4;
                dir = dirs[p];
                nx = x + dir[0];
                ny = y + dir[1];
            }
            x = nx;
            y = ny;
        }
        return ans;    }
}
