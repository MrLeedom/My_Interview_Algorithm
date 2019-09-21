package Tencent;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

/***************************************************************************
 @description :
 贪心策略
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-20 20:58  caoshipeng  create
 ****************************************************************************/
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int key = sc.nextInt();
            if(map.containsKey(key)) {
                map.replace(key, map.get(key) + value);
            }else{
                map.put(key, value);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int tmp: map.keySet()) {
            list.add(tmp);
        }
        int result = Integer.MIN_VALUE;
        while (!list.isEmpty()) {
            int num1 = list.getLast();
            int people1 = map.get(num1);
            while(people1 > 0) {
                people1 -= 1;
                map.replace(num1, people1-1);
                int num2 = list.getFirst();
                if(num1 == num2) {
                    int people3 = map.get(num2);
                    map.replace(num2, people3-1);
                    if(num1 * 2 > result) {
                        result = num1 * 2;
                    }
                    if(map.get(num1) <= 0) {
                        list.remove(0);

                    }
                    if(list.size() > 0) {
                        list.remove(num1);
                    }

                    break;
                }
                if(map.get(num2) <= 0) {
                    list.remove(0);
                    continue;
                }else{

                    int people2 = map.get(num2);
                    map.replace(num2, people2-1);
                    if(map.get(num2) <= 0) {
                        list.remove(0);
                    }
                }

                if(num1 + num2 > result) {
                    result = num1 + num2;
                }
            }
            if(list.size() > 1) {
                list.removeLast();
            }
        }
        System.out.println(result);
    }
}
