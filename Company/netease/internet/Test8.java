package netease.internet;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-21 16:40  caoshipeng  create
 ****************************************************************************/
public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i = 0 ; i < n; i++) {
            input[i] = sc.nextInt();
        }
        int sum = 0;
        for(int k = 0; k < input.length; k++) {
            for(int j = k; j < input.length; j++) {
                if(input[j] < input[k]) {
                    sum += j - k;
                }
            }
        }
        System.out.println(sum);
    }
    public static int merge(int[] array, int left, int right) {
        if(array.length == 0) {
            return 0;
        }
        int mid = left + (right - left) >> 2;
        int leftNumber = mergeNumber(array, left, mid);
        int rightNumber = mergeNumber(array, mid+1, right);
        int midNumber = distanceMid(array, left, mid, right);
        return leftNumber + rightNumber + midNumber;
    }
    public static int mergeNumber(int[] array, int left, int right) {
        int count = 0;
        return 0;
    }
    public static int distanceMid(int[] array, int left, int mid, int right) {
        int count = 0;
        for(int i = left; i <= mid; i++) {
            if(array[i] > array[mid+i-left+1]) {
                count++;
            }
        }
        return count;
    }
}
