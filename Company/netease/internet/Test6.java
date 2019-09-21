package netease.internet;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-21 15:45  caoshipeng  create
 ****************************************************************************/
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i = 0; i < number; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            int count = 1;
            while(true) {
                if(a + p * Math.pow(q, count - 1) >= b) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
        }
    }
}
