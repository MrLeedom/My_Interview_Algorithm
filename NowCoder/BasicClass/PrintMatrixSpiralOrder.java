package BasicClass;

/**
 * @author:leedom
 * @date: 4/16/19 7:56 PM
 * Description:给定一个整形矩阵matrix,按照转圈的方式打印它
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 思维构造:
 *       b      d
 * a
 *
 * c
 * License: (C)Copyright 2019
 */
public class PrintMatrixSpiralOrder {
    public static void sprialOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    /**
     * 直接打印两点构造的矩阵进行画框
     * @param m
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if(tR == dR) {
            for(int i =tC; i <= dC; i++) {
                System.out.println(m[tR][i] + " ");
            }
        } else if(tC == dC) {
            for(int i = tR; i <= dR; i++) {
                System.out.println(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while(curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while(curR != dR) {{
                System.out.print(m[curR][dC] + " ");
                curR++;
            }}
            while(curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while(curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        sprialOrderPrint(matrix);
    }
}
