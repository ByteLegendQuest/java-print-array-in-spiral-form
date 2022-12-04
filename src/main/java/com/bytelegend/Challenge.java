package com.bytelegend;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> list = new ArrayList<>();
        int w = 0;
        int x = matrix.length-1;
        int y = 0;
        int z = matrix[0].length-1;
        while(w <= x && y <= z){
            for (int i = w; i <= z; i++) {
                list.add(matrix[w][i]);
                System.out.print(matrix[w][i] + " ");
            }
            for (int i = w+1; i <= x; i++) {
                list.add(matrix[i][z]);
                System.out.print(matrix[i][z] + " ");
            }
            if(w+1 <= x){
                for (int i = z-1; i >= y; i--) {
                    list.add(matrix[x][i]);
                    System.out.print(matrix[x][i] + " ");
                }
            }
            if(y+1 <= z){
                for (int i = x-1; i > w; i--) {
                    list.add(matrix[i][y]);
                    System.out.print(matrix[i][y] + " ");
                }
            }
            w++;
            x--;
            y++;
            z--;
        }

        int[] arr4 = list.stream().mapToInt(Integer::intValue).toArray();

//        List<List<Integer>> listOfLists = new ArrayList<>();
//        for (int[] ints : matrix) {
//            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
//            listOfLists.add(list);
//
//        }
//
//
//        List<Integer> listOfAllIntegers = listOfLists.stream()
//                .flatMap(x -> x.stream())
//                .collect(Collectors.toList());
//        int[] arr4 = listOfAllIntegers.stream().mapToInt(Integer::intValue).toArray();


        return arr4;
    }
}
