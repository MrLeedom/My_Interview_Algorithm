package offer;

import java.util.ArrayList;

/**
 * @author:leedom
 * @date:2019/7/7 19:02
 * Description:顺时针打印矩阵，想象成一张矩阵表，我们顺时针转
 * License: (C)Copyright 2019
 */
public class Question33 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length -1, c1 = 0, c2 = matrix[0].length - 1;
        while(r1 <= r2 && c1 <= c2) {
            for(int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            for(int i = r1+1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            for(int i = c2 - 1; i >= c1; i--) {
                ret.add(matrix[r2][i]);
            }
            for(int i = r2 - 1; i >= r1+1; i--) {
                ret.add(matrix[i][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ret;

    }
}
