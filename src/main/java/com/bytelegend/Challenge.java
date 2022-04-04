package com.bytelegend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}})));
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
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int tal = matrix.length * matrix[0].length;
        int x = 0, y = 0;
        list.add(matrix[x][y]);
        visited[x][y] = true;
        cnt++;
        int direction = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (cnt < tal) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            while (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || visited[nx][ny]) {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            cnt++;
            visited[nx][ny] = true;
            list.add(matrix[nx][ny]);
            x = nx;
            y = ny;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
