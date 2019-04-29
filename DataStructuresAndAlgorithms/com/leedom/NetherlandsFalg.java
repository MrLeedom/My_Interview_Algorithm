package com.leedom;

/**
 * @author:leedom
 * @date: 3/24/19 9:35 PM
 * Description:荷兰国旗问题
 * License: (C)Copyright 2019
 */
public class NetherlandsFalg {
    public static int[] partition(int[] arr, int L, int R, int p) {
        int less = L - 1;
        int more = R + 1;
        int current = L;
        while(current < more) {
            if(arr[L] < p){
                swap(arr, ++less, L++);
            }else if(arr[L] > p){
                swap(arr, --more, L);
            }else {
                L++;
            }
        }
        return new int[] {less + 1, more - 1};
    }
    public static void swap(int[] arr, int i, int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
