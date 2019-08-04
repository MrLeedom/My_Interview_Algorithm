package netease.internet;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-03 11:48  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++) {
            int length = sc.nextInt();
            int[] array = new int[length];
            for(int j = 0; j < length; j++) {
                array[j] = sc.nextInt();
            }
            boolean flag = true;

            for(int k =  0; k < length; k++) {
                if(k == 0) {
                    if(array[k] > array[k+1]+array[length-1]) {
                        flag = false;
                        System.out.println("NO");
                        break;
                    }
                    continue;
                }
                if(k==length -1) {
                    if(array[k] > array[0] + array[k-1]) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                    continue;
                }
                if(array[k] > array[k-1] + array[k+1]) {
                    System.out.println("NO");
                    flag =  false;
                    break;
                }
            }
            if(flag == true) {
                System.out.println("YES");
            }
        }
    }
}
