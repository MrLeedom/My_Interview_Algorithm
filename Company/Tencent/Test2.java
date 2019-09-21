package Tencent;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-20 20:37  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        while(k > 0) {
            int tmp = firstNoZeroNumber(array);
            System.out.println(tmp);
            removeTarget(array, tmp);
            k--;
        }
    }

    private static void removeTarget(int[] array, int target) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                continue;
            }else{
                array[i] -= target;
            }
        }
    }

    private static int firstNoZeroNumber(int[] array) {
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                continue;
            }else{
                return array[i];
            }
        }
        return 0;
    }
}
