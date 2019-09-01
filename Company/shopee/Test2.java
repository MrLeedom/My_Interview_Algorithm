package shopee;

import java.util.Scanner;

/***************************************************************************
 @description :     出现了数组越界的情况？可能是第一个判断有问题？
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-10 18:58  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static String reverseString(String str) {
        if(str == null || str.length() == 0) {
            return "0";
        }
        Long number = Long.parseLong(str);
        if(number < Math.pow(-2, 31) || number > Math.pow(2, 31) - 1) {
            return "0";
        }
        char[] array = str.toCharArray();
        if(array[0] == '0' && array.length > 1) {
            return "0";
        }
        int length = array.length;
        int j = length - 1;

        int i = 0;
        int cur = 0;
        if(i >= 0 && j >= 0) {
            if(array[0] == '+' || array[0] == '-') {
                i++;
            }

            cur = j;
            while (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        str = String.valueOf(array);
        str = str.substring(0, cur+1);
        return str;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp =' ';
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(reverseString(line));
    }
}
