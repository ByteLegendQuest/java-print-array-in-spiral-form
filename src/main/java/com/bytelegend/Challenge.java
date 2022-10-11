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
        if (matrix == null || matrix[0] == null) {
            return null;
        }
        int mi = matrix.length;
        int mj = matrix[0].length;
        int i = 0, j = 0;
        int[] r = new int[mi * mj];
        Set<String> set = new HashSet<>();
        int cnt = 0;
        set.add(i + "_" + j);
        r[cnt++] = matrix[i][j];
        while (true) {
            int cntBefore = cnt;
            while(canVisit(set, i, j + 1, mi, mj)) {
                set.add(i + "_" + (j + 1));
                r[cnt++] = matrix[i][j + 1];
                j++;
            }
            while (canVisit(set, i + 1, j, mi, mj)) {
                set.add((i + 1) + "_" + j);
                r[cnt++] = matrix[i + 1][j];
                i++;
            }
            while (canVisit(set, i, j - 1, mi, mj)) {
                set.add(i + "_" + (j - 1));
                r[cnt++] = matrix[i][j - 1];
                j--;
            }
            while (canVisit(set, i - 1, j, mi, mj)) {
                set.add((i - 1) + "_" + j);
                r[cnt++] = matrix[i - 1][j];
                i--;
            }
            if (cnt == cntBefore) {
                break;
            }
        }
        return r;
    }

    private static boolean canVisit(Set<String> set, int i, int j, int imax, int jmax) {
        return (i < imax && j < jmax && i >= 0 && j >= 0) && !set.contains(i + "_" + j);
    }
}
