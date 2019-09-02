package yitu;

import java.util.Scanner;

/***************************************************************************
 @description :     螺旋式的二维矩阵
 18 17 6 12 19
 9 8 7 11 10
 2 3 4 0 1
 15 16 5 13 14
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-02 16:31  caoshipeng  create
 ****************************************************************************/
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = 2, y = 3;
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }
        shuttle(arr, x, y);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void shuttle(int[][] arr, int x, int y) {
        int width = arr[0].length;
        int length = arr.length;
        int count = 0;
        y = y -1;
        while(true) {
            if(count >= width * length -1) {
                break;
            }
            /*向右走*/
            for(int i = y + 1; i <= width; i++) {
                if(i == width) {
                    i = -1;
                    continue;
                }
                if(arr[x][i] != -1) {
                    y = i - 1 >= 0 ? i - 1 : 0;
                    break;
                }else{
                    arr[x][i] = count++;
                }
            }
            /*向下走*/
            for(int j = x+1; j <= length; j++) {
                if(j == length) {
                    j = -1;
                    continue;
                }
                if(arr[j][y] != -1) {
                    x = j - 1 >= 0 ? j - 1 : 0;
                    break;
                }else{
                    arr[j][y] = count++;
                }
            }
            /*向左走*/
            for(int d = y-1; d >= -1; d--) {
                if(d == -1) {
                    d = width;
                    continue;
                }
                if(arr[x][d] != -1) {
                    y = d + 1 <= width - 1 ? d + 1 : width - 1;
                    break;
                }else{
                    arr[x][d] = count++;
                }
            }
            /*向上走*/
            for(int f = x-1; f >= -1; f--) {
                if(f == -1) {
                    f = length;
                    continue;
                }
                if(arr[f][y] != -1) {
                    x = f + 1 <= length - 1 ? f + 1 : length-1;
                    break;
                }else{
                    arr[f][y] = count++;
                }
            }
        }
    }
}
