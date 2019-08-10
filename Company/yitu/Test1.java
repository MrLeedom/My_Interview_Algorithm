package yitu;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
 @description :
 交朋友，朋友最多的那个人叫做依图，他有多少个朋友，朋友的定义是相同爱好超过K
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-09 18:56  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        int[][] array = new int[N][N];
        String[][] input = new String[N][M];

        for(int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for(int j = 0; j < tmp.length; j++) {
                input[i][j] = tmp[j];
            }
        }
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                int count = 0;
                for(int m = 0; m < M; m++) {
                    if(Arrays.asList(input[j]).contains(input[i][m])) {
                        count++;
                    }
                }
                if(count >= K){
                    array[i][j] = 1;
                    array[j][i] = 1;
                }

            }
        }
        int[] result = new int[N];

        for(int i = 0; i < array.length; i++) {
            int temp = 0;
            for(int j = 0; j < array[0].length; j++) {
                temp+=array[i][j];
            }
            result[i] = temp;
        }
        Arrays.sort(result);
        System.out.println(result[N-1]);

    }

}
