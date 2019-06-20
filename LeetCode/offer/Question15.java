package offer;

/**
 * @author:leedom
 * @date:2019/6/20 21:01
 * Description:
 *      判断在一个矩阵中是否存在包含某字符串所有字符的路径？
 *      要求：路径可以从矩阵中的任意一个格子出发，每一步可以在矩阵中向上下左右移动一个格子。每个格子最多只能进入一次。
 *      做法：无技巧，主要就是采用回溯法来进行求解，这也是一种暴力破解的策略！
 * License: (C)Copyright 2019
 */
public class Question15 {
    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private static int rows=3;
    private static int cols=4;

    public static void main(String[] args) {
        char[] array = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        System.out.println(hasPath(array,rows,cols,str));

    }

    public static void printArray(char[][] array) {
        if(array==null){
            return;
        }
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if(rows == 0 || rows == 0){
            return false;
        }

        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        printArray(matrix);
        for(int i=0; i <rows; i++) {
            for(int j=0; j <cols; j++) {
                if(backtracking(matrix, str, marked, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        if(pathLen == str.length) {
            return true;
        }
        if(r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;
        for(int[] n : next) {
            if(backtracking(matrix, str, marked, pathLen+1, r+n[0],c+n[1])){
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    public static char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for(int r = 0, idx = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                matrix[r][c] = array[idx++];
            }
        }
        return matrix;
    }
}
