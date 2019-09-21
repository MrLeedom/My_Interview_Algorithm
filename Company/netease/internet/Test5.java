package netease.internet;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-21 15:29  caoshipeng  create
 ****************************************************************************/
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i <t; i++) {
            int input = sc.nextInt();
            if(input < 10) {
                System.out.println(input);
            }else{
                int first = input % 9;
                int last = input / 9;
                StringBuilder str = new StringBuilder();
                if(first != 0) {
                    str.append(first);
                }

                while(last > 0) {
                    str.append(9);
                    last--;
                }

                System.out.println(str);
            }
        }
    }
}
