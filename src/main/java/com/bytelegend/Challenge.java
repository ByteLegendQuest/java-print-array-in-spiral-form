package com.bytelegend;

import java.util.Arrays;
import java.util.*;


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
        List<Integer> finish = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length;
        int startCol = 0;
        int endCol = matrix[0].length;


        while (startRow < endRow && startCol < endCol) {

            for (int i = startCol; i < endCol; i++) {
                finish.add(matrix[startRow][i]);
            }
            startRow++;

            for (int i = startRow; i < endRow; i++) {
                finish.add(matrix[i][endCol - 1]);
            }
            endCol--;

            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    finish.add(matrix[endRow - 1][i]);
                }
                endRow--;
            }

            if (startCol < endCol) {
                for (int i = endRow - 1; i >= startRow; i--){
                    finish.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        int [] answer = finish.toArray();
    }
}

