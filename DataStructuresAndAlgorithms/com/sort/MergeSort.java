package com.sort;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 3/21/19 2:09 PM
 * Description:       经典排序      :       归并排序
 *                              归并排序
 * 首先先写出一个大概数组传参数进去，然后在这个函数做小小处理去掉用核心的步骤函数；
 * 接着在主题中注明整个宏观的思维，左索引右索引，首先排序左侧，接着排序右侧，最后进行归并操作，终止条件是左右索引不过届；
 * 最后写核心的归并函数，采用一个辅助函数，然后用while循环来注入值，最后放回原始数组。
 * 主要提出来的一个思想是:
 *                  分治思想
 *  master公式的使用:
 *      T(N) = a * T(N/b) + O(N ^ b)
 *   1)  log(b,a) > d  ------复杂度为O(N ^ log(b, a))
 *   2)  log(b,a) = d  ------复杂度为O(N ^d * log N)
 *   3)  log(b,a) < d  ------复杂度为O(N ^ d)
 *所以这整个就是T(N) = 2 * T(N/2) + O(N)
 * License: (C)Copyright 2019
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length == 0) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int left, int right) {
        if(left == right){
            return;
        }
        //left 和 right中点位置索引
        int mid = left + ((right - left) >> 1);
        //T(N / 2)
        sortProcess(arr, left, mid);
        //T(N /2)
        sortProcess(arr, mid+1, right);
        //O(N)
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right-left+1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个必有 且 只有一个选择
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= right) {
            help[i++] = arr[p2++];
        }

        for(i = 0; i < help.length; i++) {
            arr[left+i] = help[i];
        }
    }

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
            mergeSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
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