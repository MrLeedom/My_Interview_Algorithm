package com.leedom;

/**
 * @author:leedom
 * @date: 3/20/19 10:09 PM
 * Description:选择排序
 * 时间复杂度是big O(N)
 * 额外空间复杂度big O(1)
 * License: (C)Copyright 2019
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public  static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,6,3,75,3,7,96,0,45,2,74,5,86};
        selectionSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
