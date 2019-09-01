package kuaishou;

import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************************
 @description :     判断谁的版本更高，更高的话就返回True，否则返回False！
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-25 16:50  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static boolean isBetter(String str1, String str2) {
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        if(str1.contains(".")){
            System.out.println(str1.split("."));
            for (String item: str1.split("\\.")) {
                arr1.add(item);
            }
        }else{
            arr1.add(str1);
        }
        if(str2.contains(".")) {
            for (String item: str2.split("\\.")) {
                arr2.add(item);
            }
        }else{
            arr2.add(str2);
        }

        int[] num1 = new int[arr1.size()];
        int[] num2 = new int[arr2.size()];
        int total1 = 0;
        int total2 = 0;
        for(int i = 0; i < arr1.size(); i++) {
                num1[i] = Integer.parseInt(arr1.get(i));
                total1 += num1[i];
        }
        for(int j = 0; j < arr2.size(); j++) {
                num2[j] = Integer.parseInt(arr2.get(j));
                total2 += num2[j];
        }
        int lower = num1.length <= num2.length ? num1.length : num2.length;
        boolean flag = true;
        for(int k = 0; k < lower; k++) {
            if(num1[k] != num2[k]) {
                flag = false;
                break;
            }
            if(k == lower - 1) {
                flag = true;
            }
        }
        if(total1 != total2) {
            return true;
        }else if(flag && total1 == total2) {
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < number; i++) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            boolean result = isBetter(arr[0], arr[1]);
            System.out.println(result);
        }
    }
}
