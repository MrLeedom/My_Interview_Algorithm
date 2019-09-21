package didi;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-19 20:25  caoshipeng  create
 ****************************************************************************/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int ans = array[0] + array[1] + array[2];
        int sum = ans;

        for(int i = 3; i < array.length; i++) {
            if(sum > 0) {
                sum += array[i];
            } else {
                sum = array[i];
            }
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);

    }
}
