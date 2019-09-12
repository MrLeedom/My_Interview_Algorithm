package kuangshi;

import java.util.HashSet;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-09 21:05  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(maxLength(k, str));
    }
    public static int maxLength(int number, String str) {
        char[] array = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        if(str.length() <= number) {
            return str.length();
        }else{
            int result = 0;
            for(int i = 0; i < array.length; i++){
                if(result > maxLen) {
                    maxLen = result;
                }
                result = 0;
                for (int j = i; j < array.length; j++) {
                    if(set.size() > number) {
                        result--;
                        set.remove(array[j]);
                        break;
                    }
                    set.add(array[j]);
                    result++;
                }

                if(set.size()>number){
                    result--;
                }
                set.clear();
            }
            if(result > maxLen) {
                maxLen = result;
            }
            return maxLen;

        }
    }
}
