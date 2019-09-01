package shopee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***************************************************************************
 @description :     时间复杂度过大，通过66.67%
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-10 18:58  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < num; i++) {
            int index = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < index; j++) {
                arr.add(sc.nextInt());
            }
            map.put(i+1, arr);
        }
        int na = sc.nextInt();
        int[] input = new int[na];
        for(int i = 0; i < na; i++) {
            input[i] = sc.nextInt();
        }

        int result = 0;
        int candidate = Integer.MIN_VALUE;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            int count = 0;
            if(candidate >= entry.getValue().size()) {
                continue;
            }
            for(int key : input) {
                if(entry.getValue().contains(key)) {
                    count++;
                }
            }
            if(count >= na) {
                result = entry.getKey();
                break;
            }else{
                if(candidate < count) {
                    candidate = count;
                    result = entry.getKey();
                }
            }
        }
        System.out.println(result);
    }
}
