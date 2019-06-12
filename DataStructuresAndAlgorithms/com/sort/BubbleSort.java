package com.sort;

/**
 * @author:leedom
 * @date: 6/12/19 9:37 AM
 * Description:     经典排序    :      冒泡排序
 *      冒泡排序可以优化,当发现没有元素可以交换时可以直接终止冒泡的过程
 * License: (C)Copyright 2019
 */
public class BubbleSort {
    /*
    两个元素交换的函数
     */
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }
    public static void bubbleSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        //外层循环控制排序趟数
        for(int i = 0; i < array.length -1; i++) {
            //提前退出冒泡排序的循环标志位
            boolean flag = false;
            //内层循环控制每一趟排序多少次
            for(int j = 0; j< array.length - i - 1; j++) {
                if(array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    //表示有数据交换
                    flag = true;
                }
            }
            //表示没有数据可以交换,已经有序了,提前结束
            if(!flag) {
                break;
            }
        }
        for(int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
    public static void main(String[] args){
        int[] array = {1,5,22,7,3,8,3,64};
        bubbleSort(array);
    }
}
