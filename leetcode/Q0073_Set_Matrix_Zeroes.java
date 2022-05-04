package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q0073_Set_Matrix_Zeroes {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        Output: [[1,0,1],[0,0,0],[1,0,1]]
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix1);
        printer(matrix1);

//        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(matrix2);
        printer(matrix2);
    }

    public static void printer(int[][] matrix){
        for (final int[] ints : matrix) {
            for (final int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public static class Solution {
        public void setZeroes(int[][] matrix) {
            List<Integer> row = new ArrayList<>();  //행
            List<Integer> col = new ArrayList<>();  //렬


            //1. 0 위치 구하기
            for(int i = 0; i < matrix.length ; i++){
                for(int j = 0; j < matrix[i].length ; j++){
                    if(matrix[i][j] == 0){
                        row.add(i);
                        col.add(j);
                    }
                }
            }
            //2. 0 으로 바꾸기
            for(int i = 0; i < matrix.length ; i++){
                for(int j = 0; j < matrix[i].length ; j++){
                    if(row.contains(i) || col.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }

}
