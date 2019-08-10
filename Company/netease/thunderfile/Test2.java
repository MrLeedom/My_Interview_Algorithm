package netease.thunderfile;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/***************************************************************************
 @description :     贪心策略
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-04 10:46  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static int[] findMax(int[] arr1, int[] arr2) {
        int sa = 0, sb = 0;
        for(int i = 1; i < arr1.length; i++) {
            sa += Math.abs(arr1[i] - arr1[i-1]);
        }
        for(int i = 1; i < arr2.length; i++) {
            sa += Math.abs(arr2[i] - arr2[i-1]);
        }
        return new int[]{sa, sb};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] array = sc.nextLine().split("\\s+");
        Deque<Integer> input = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            input.add(Integer.parseInt(array[i]));
        }
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        int times = (n % 2 == 0) ? n / 2 : (int) n / 2 + 1;

        for(int k = 0; k < times; k++) {
            if(k == 0) {
                if(input.peekFirst() >= input.peekLast()) {
                    listA.add(input.pollFirst());
                } else {
                    listA.add(input.pollLast());
                }
                if( input.size() == 0) {
                    break;
                }
                if(input.peekFirst() >= input.peekLast()) {
                    listB.add(input.pollFirst());

                } else {
                    listB.add(input.pollLast());
                }
            }else{
                int x1 = Math.abs(listA.get(listA.size()-1) - input.peekFirst());
                int y1 = Math.abs(listA.get(listA.size()-1) - input.peekLast());
                if(x1 >= y1) {
                    listA.add(input.pollFirst());
                }else{
                    listA.add(input.pollLast());
                }
                if(input.size() == 0) {
                    break;
                }
                int x2 = Math.abs(listB.get(listB.size()-1) -input.peekFirst());
                int y2 = Math.abs(listB.get(listB.size()-1) -input.peekLast());
                if(x2 >= y2) {
                    listB.add(input.pollFirst());

                }else{
                    listB.add(input.pollLast());
                }

            }
        }
        int sa = 0, sb = 0;
        if(listA.size() > 0) {
            sa = listA.get(0);
            for(int i =1; i < listA.size(); i++) {
                sa += Math.abs(listA.get(i) - listA.get(i-1));
            }
        }

        if(listB.size() > 0) {
            sb = listB.get(0);
            for(int j = 1; j < listB.size(); j++) {
                sb += Math.abs(listB.get(j) - listB.get(j-1));
            }
        }

        System.out.println(sa + " " + sb);

    }

}
