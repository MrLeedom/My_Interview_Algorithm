package bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-22 09:42  caoshipeng  create
 ****************************************************************************/
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i < 6; i++) {
            String str = sc.nextLine();
            String[] array = str.split(" ");
            int cur = Integer.parseInt(array[0]);
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 1; j < array.length; j++) {
                list.add(Integer.parseInt(array[j]));
            }

        }
    }
}
