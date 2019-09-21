package Tencent;

import java.util.Scanner;

/***************************************************************************
 @description :
 1.判断字符串与11的大小，分成三类情况讨论
 2.对于第三种情况，主要关注8出现的位置，和字符串与11的差值比较大小
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-20 20:05  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i <  t; i++) {
            int tmp = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            judgeNumberEight(str, tmp);
        }
    }

    private static void judgeNumberEight(String str, int tmp) {
        if(tmp < 11) {
            System.out.println("NO");
        }else if(tmp == 11) {
            if(str.startsWith("8")) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }else{
            int gap = tmp - 11;
            int index = str.indexOf("8");
            if(gap >= index) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}
