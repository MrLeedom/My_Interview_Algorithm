package dji;

import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-04 21:10  caoshipeng  create
 ****************************************************************************/
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            char[] array = str.toCharArray();
            if (array.length == 1) {
                result.add(str);
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < array.length; j++) {
                int tmp = array[j] - array[j - 1];
                if (tmp == 1) {
//                    if(min > array[j-1]) {
//                        min = array[j-1];
//                    }
//                }else{
//                    min = array[j];
//                }
                }
//            result.add(min);
            }
        }
    }
}
