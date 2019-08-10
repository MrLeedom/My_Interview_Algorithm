package yitu;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
 @description :
 这道题是说删除最少列数，使得一个二维矩阵每一行非递减
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-09 18:56  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] input = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int[] arr = new int[M];
        int count = 0;
        arr = num(input);
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
//        while(true){
//            count++;
//            arr = num(input);
//            if(arr.length == 1 || isZero(arr)){
//                break;
//            }
//            Arrays.sort(arr);
//            int number = arr[arr.length-1];
//            int[][] temp = new int[input.length][arr.length-1];
//
//            arr = new int[arr.length];
//
//        }

//        System.out.println(count);
    }
    public static boolean isZero(int[] arr) {
        boolean flag = true;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        if(flag) {
            return true;
        }
        return false;
    }
    public static int[] num(int[][] arr1) {
        int n = arr1.length;
        int m = arr1[0].length;
        int[] arr2 = new int[m];
        for(int j = 0; j < m; j++) {
            if(j==0){
                for(int i = 0; i < n-1; i++) {
                    if(arr1[i][j] > arr1[i][j+1]) {
                        arr2[j]++;
                    }
                }
            }else if(j == m) {
                for(int i = 1; i < n; i++) {
                    if(arr1[i][j-1] > arr1[i][j]) {
                        arr2[j]++;
                    }
                }
            }else{
                for(int i = 1; i < n-1; i++) {
                    if(arr1[i][j-1] > arr1[i][j]) {
                        arr2[j]++;
                    }
                }
            }
        }
        return arr2;
    }
}
