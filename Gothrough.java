package com.exercise;

public class Gothrough {
    //30ms
    /*public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i < matrix.length-1;i++){
            for(int j = 0;j < matrix[0].length-1;j++){
                if(target == matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }*/
    //13ms
/*    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }*/

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int x = 0;
        int y = matrix[0].length -1;
        while(x < matrix.length && y >= 0) {
            if(target == matrix[x][y]) return true;
            else if(target > matrix[x][y]) x++;
            else y--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {{ 1,  2,  3,  4},
                        {5,  6,  7,  8},
                        {9,  10, 11, 12},
                        {13, 14, 15, 16}};
        //int[][] arr = {{-5}};
        boolean a = searchMatrix(arr,-5);
        System.out.println(a);
    }
}
