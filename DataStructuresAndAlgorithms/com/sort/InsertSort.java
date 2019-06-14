package com.sort;

/**
 * @author:leedom
 * @date: 6/12/19 10:01 AM
 * Description:     经典排序    :      插入排序
 *      此处将介绍插入排序最原始的版本,希尔排序是基于插入排序的一种优化方法!!!
 * License: (C)Copyright 2019
 */
public class InsertSort {
    public static void insertSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        for(int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for(; j >= 0 && array[j] > value; j--) {
                //数据搬移
                array[j+1] = array[j];
            }
            array[j+1] = value;
        }
        for(int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
    public static void main(String[] args){
        int[] array = {1,5,22,7,3,8,3,64};
        insertSort(array);
    }
}
