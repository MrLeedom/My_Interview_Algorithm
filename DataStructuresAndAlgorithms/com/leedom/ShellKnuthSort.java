package com.leedom;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 3/27/19 8:38 AM
 * Description:希尔排序,是在插入排序的基础上增大间隔来进行排序的一种算法
 *      这里便有一个问题,间隔的大小如何来划分和确定,这里边有一个knuth方法来操作
 * License: (C)Copyright 2019
 */
public class ShellKnuthSort {
    /****************************************  希尔排序(基于插入排序,间隔的不同)  ******************************************************/
    //希尔排序knuth间隔序列为3h+1
    public static void shellKnuthSort(int[] array) {
        System.out.println("origin array:" + Arrays.toString(array));
        int step = 1;
        int length = array.length;
        while(step <= length / 3) {
            step = step * 3 + 1;
        }
        while(step > 0) {
            //分别对每个增量间隔进行排序
            for(int i = step; i < length; i++) {
                //记录要插入的数据
                int temp = array[i];
                int j = i;
                //从已经排序的序列最右边的开始比较,找到比其小的数
                while(j > step - 1 && temp <= array[j-step]) {
                    //向后挪动
                    array[j] = array[j - step];
                    j -= step;
                }
                //存在比其小的数,插入
                array[j] = temp;
             }
            System.out.println("step:"+step+"result:"+Arrays.toString(array));
            step = (step - 1) / 3;
        }
        System.out.println("final result:" + Arrays.toString(array));
    }

    /**********************************************  测试部分  ********************************************************************/
    public static void main(String[] args){
        int testTimes = 2;
        int size = 100;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes ; i++) {
            int[] array = generateRandomArray(size, value);
            int[] rightResult = copyArray(array);
            shellKnuthSort(array);
            comparator(rightResult);
            if(!isEqual(array, rightResult)) {
                printArray(array);
                printArray(rightResult);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Good" : "Fucked!");
    }

    //比较器
    public static  void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int size, int value) {
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
