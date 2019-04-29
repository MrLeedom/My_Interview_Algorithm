package com.leedom;

/**
 * @author:leedom
 * @date: 3/21/19 12:17 PM
 * Description:插入排序
 * 它跟数据状况有关系,不同的数据状态的时间复杂度
 * 1.假如数据是升序的话,时间复杂度big O(N)
 * 2.假如数据是逆序的话,时间复杂度big O(N^2)
 * 额外空间复杂度big O(1)
 * License: (C)Copyright 2019
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--){
                swap(arr, j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,6,3,75,3,7,96,0,45,2,74,5,86};
        insertionSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
