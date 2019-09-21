package didi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-19 19:53  caoshipeng  create
 ****************************************************************************/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[2*m];
        int begin = 0;
        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            array[begin++] = a;
            array[begin++] = b;
        }
        System.out.println(n/2 * 2);
        System.out.println(2 * maxThings(array, n) > n / 2 ? n / 2 * 2 : 2 * maxThings(array, n));
    }

    public static int maxThings(int[] array, int target) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int cur = 0;
        int count = 0;
        for(int i = 0; i < array.length / 2; i++) {
            if(!set1.contains(array[cur])) {
                set1.add(array[cur]);
            }else if(!set2.contains(array[cur])) {
                set2.add(array[cur]);
            }else{
                set1.remove(array[cur]);
                set2.remove(array[cur]);
            }
            if(!set2.contains(array[++cur])) {
                set2.add(array[cur]);
            }else if(!set1.contains(array[cur])) {
                set1.add(array[cur]);
            }else{
                set1.remove(array[cur]);
                set2.remove(array[cur]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= target; i++) {
            if(!set1.contains(i) && !set2.contains(i)) {
                list.add(i);
            }
        }
        int result = list.size() / 2;
        return set1.size() > set2.size() ? set1.size() + result: set2.size() + result;
    }
}
