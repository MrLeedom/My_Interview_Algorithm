package com.leedom;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 3/20/19 9:52 PM
 * Description:冒泡排序
 * 时间复杂度是big O(N)
 * 额外空间复杂度big O(1)
 * License: (C)Copyright 2019
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        //一次次将最小值放置到前面
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

    }

//    public static void main(String[] args){
//        int[] array = new int[]{1,2,6,3,75,3,7,96,0,45,2,74,5,86};
//        bubbleSort(array);
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i] + " ");
//        }
//    }
    /**************************************  对数器  ************************************************************/
    //准备一个绝对正确的方法,进行大样本测试
    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    //比较器
    public static  void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int size, int value) {
        //Math.random()  ---->  double[0,1)
        //(int)((size+1) * Math.random())  ---->[0, size]  整数
        //size = 6, size+1 = 7
        //Math.random()  --->[0, 1) * 7  -->[0,7) double
        //double  ---> int[0, 6] ---->int

        //生成长度随机的数组
        int[] arr = new int[(int)((size+1) * Math.random())];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
        }
        return arr;
    }

    //for test
    public static  int[] copyArray(int[] arr) {
        if(arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
    
    public static  boolean isEqual(int[] arr1, int[] arr2) {
        boolean required = (arr1 == null && arr2 != null) || (arr1 != null && arr2 == null);
        if(required){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return true;
        }
        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
