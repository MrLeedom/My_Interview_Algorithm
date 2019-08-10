package dji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-04 18:45  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static Map<Integer, ArrayList<Integer>> mapTable() {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList temp = new ArrayList();
        temp.add(0);
        temp.add(3000);
        map.put(3,temp);
        temp = new ArrayList();
        temp.add(3000);
        temp.add(12000);
        map.put(10,temp);
        temp = new ArrayList();
        temp.add(12000);
        temp.add(25000);
        map.put(20, temp);
        temp = new ArrayList();
        temp.add(25000);
        temp.add(35000);
        map.put(25,temp);
        temp = new ArrayList();
        temp.add(35000);
        temp.add(55000);
        map.put(30,temp);
        temp = new ArrayList();
        temp.add(55000);
        temp.add(80000);
        map.put(35,temp);
        temp = new ArrayList();
        temp.add(80000);
        temp.add(Integer.MAX_VALUE);
        map.put(45,temp);
        return map;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc .nextInt();
        int[] input = new int[num];
        for(int i =0 ; i < num; i++) {
            input[i] = sc.nextInt();
        }
        Map<Integer, ArrayList<Integer>> map = mapTable();
        int[] array = {3, 10, 20, 25, 30, 35, 45};
        for(int i = 0; i < input.length; i++) {
            if(input[i] <= 5000) {
                System.out.println(0);
            }else{
                int balance = input[i] - 5000;
                double money = 0;
                int count = 0;
                for(int k = 0; k < array.length; k++) {
                    ArrayList<Integer> list = map.get(array[k]);
                    if(balance <= list.get(1)) {
                        count ++;
                        money += (balance - list.get(0)) * array[k] / (double)100;
                        break;
                    }else{
                        count++;
                        money += (list.get(1) - list.get(0)) * array[k] / (double)100;
                    }
                }
                System.out.println((int)Math.round(money));
            }
        }
    }
}
