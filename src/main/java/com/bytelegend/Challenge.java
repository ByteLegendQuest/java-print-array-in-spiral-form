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
        int index = 0;
        List<Map> list =new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] matrix1 = matrix[i];
            String str = "";
            Map map = new HashMap();
            for (int j = 0; j < matrix1.length; j++) {
                int matrix2 = matrix[i][j];
                str +=matrix2 +"   ";
                index++;
                map.put("x",i + 1);
                map.put("y",matrix[i].length);
            }
            list.add(map);
            System.out.println(str);
        }
        int [] ints =new int[index];


        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int x = i; //行数记录
            int y = i; //列数记录
            //x坐标向右移动
            for (int j = y; j < matrix[i].length - i; j++) {
                //记录当前坐标
                y = j;
                ints[count] = matrix[x][y];
                if (count == index - 1) {
                    return  ints;
                }
                count++;
            }

            //y坐标向下移动
            for (int j = i + 1; j < matrix.length - i; j++) {
                //记录当前坐标
                x = j;
                ints[count] = matrix[x][y];
                if (count == index - 1) {
                    return  ints;
                }
                count++;
            }

            //x坐标向左移动
            for (int j = matrix[x].length - 1; j > 0; j--) {
                //记录当前坐标
                y = y - 1;
                ints[count] = matrix[x][y];
                if (count == index - 1) {
                    return  ints;
                }
                count++;
            }

            //y坐标向上移动
            for(int j = x; j > i + 1; j--){
                //记录当前坐标
                x = x - 1;
                ints[count] = matrix[x][y];
                if (count == index - 1) {
                    return  ints;
                }
                count++;
            }
        }
        return ints;
    }
}
