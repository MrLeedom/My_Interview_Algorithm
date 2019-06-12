package com.sort;

/**
 * @author:leedom
 * @date: 6/12/19 2:39 PM
 * Description:     经典排序    :     选择排序
 *      其实就是找到最小的那个,然后大的循环中置换一次
 * License: (C)Copyright 2019
 */
public class SelectionSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void selectionSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            swap(array,i,minIndex);
        }
        for(int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
    public static void main(String[] args){
        int[] array = {1,5,22,7,3,8,3,64};
        selectionSort(array);
    }
}
