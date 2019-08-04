package netease.internet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-03 11:48  caoshipeng  create
 ****************************************************************************/
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < q; i++) {
            int tmp = sc.nextInt();
            int count = 0;
            for(int k = 0; k < n; k++) {
                if(arr[k] >= tmp) {
                    arr[k]--;
                    count++;
                }
            }
            list.add(count);
            Arrays.sort(arr);
        }
        for (int item:list
             ) {
            System.out.println(item);
        }
    }
}
