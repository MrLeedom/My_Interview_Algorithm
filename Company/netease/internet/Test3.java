package netease.internet;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-03 11:48  caoshipeng  create
 ****************************************************************************/
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        String dfs = sc.next();
        System.out.println(dfs);
        System.out.println("-------");
        
        String g = sc.nextLine();
        System.out.println(g);
        
        System.out.println("==========");
//        int a = sc.nextInt();
        int b = Integer.parseInt(sc.nextLine());
        String tmp = sc.nextLine();
        String tmp2 = sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        for(String str : line) {
            System.out.println(str);
        }
//        while(sc.hasNext()) {
//
//            int[] array = new int[a];
//            for(int i = 0; i < a; i++) {
//                array[i] = Integer.parseInt(line[i]);
//            }
//        }
        System.out.println();
    }
}
