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
        int[][] resmatrix = new int[matrix.length][matrix[0].length]; //n*n的二维数组，初始元素值都为0
        String resStr = "";
        int right = 1, down = 2, left = 3, up = 4; //分别表示右下左上四个方向
        int direction = right;
        int numb = matrix.length * matrix[0].length; //n阶矩阵，共有n×n个数
        int i = 0, j = 0;
        for (int p = 1; p <= numb; p++) {
            resmatrix[i][j] = matrix[i][j];
            resStr += matrix[i][j] + ",";
            if (direction == right) { //如果当前位置的右面位置在右边界内且值还是初始值，则行不变，列号向右移动一位
                if (j + 1 < resmatrix[0].length && resmatrix[i][j + 1] == 0) {
                    j++;
                } else { //如果超出右边边界，或者右面的元素已经被修改过，则向下移动一行，且将方向改为向下
                    i++;
                    direction = down;
                    continue;
                }
            }
            if (direction == down) { //如果当前位置的下面位置在下边界内且值还是初始值，则列不变，行号向下移动一位
                if (i + 1 < resmatrix.length && resmatrix[i + 1][j] == 0) {
                    i++;
                } else { //如果超出下边界，或者下面的元素已经被修改过，则向左移动一行，且将方向改为向左
                    j--;
                    direction = left;
                    continue;
                }
            }
            if (direction == left) { //如果当前位置的左面位置在左边界内且值还是初始值，则行不变，列号向左移动一位
                if (j - 1 >= 0 && resmatrix[i][j - 1] == 0) {
                    j--;
                } else { //如果超出左边界，或者左面的元素已经被修改过，则向上移动一行，且将方向改为向上
                    i--;
                    direction = up;
                    continue;
                }
            }
            if (direction == up) { //如果当前位置的上面位置在上边界内且值还是初始值，则列不变，行号向左移动一位
                if (i - 1 >= 0 && resmatrix[i - 1][j] == 0) {
                    i--;
                } else { //如果超出上边界，或者上面的元素已经被修改过，则向右移动一列，且将方向改为向右
                    j++;
                    direction = right;
                    continue;
                }
            }
        }
        String[] s = resStr.split(",");
        int[] resInt = new int[s.length];
        for (int k = 0; k < s.length; k++) {
            resInt[k] = Integer.parseInt(s[k]);
        }
        return resInt;
    }
}
