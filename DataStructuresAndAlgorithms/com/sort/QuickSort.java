package com.sort;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 6/14/19 8:56 AM
 * Description:     经典排序      :     快速排序
 * 快排的思想：假如一组要排序的数组，下标是从p到r之间的一组数据，我们要选择p到r之间的任意一个数据作为分区点，将小于这个数的放在左侧，大于这个数的放在右侧，等于这个数放中间。
 * 接着了解一下快排的性能问题，首先快排是否稳定，因为分区点取的时候较为随机，当然有方法去避免，但是我们会打乱这组数据的顺序，所以他不是稳定的；
 * 第二是快排的时间复杂度，这里必须提一下， 假如分区点每次提取都会让我们的数据极其不平衡，这样会导致时间复杂度偏向于O(n^2),但是正常情况下我们
 * 的时间复杂度还是nO(logn);第三快排是原地排序算法，所以空间复杂度就不必说了。
 *      基准元素的选取是一大特点,本代码采用的是最左元素,也有最右元素,或者其他优化策略
 * License: (C)Copyright 2019
 */
public class QuickSort {
    /*********************************************  数组元素交换代码  ******************************************************/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*********************************************  数组开始快排的逻辑(设计重载)  *********************************************/
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(right <= left) {
            return;
        }else{
            //分为两部分之后的下标位置
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    /*********************************************  数组中进行合理的划分(基准元素,左右游标)  ************************************/
    public static  int partition(int[] array, int left, int right) {
        //为什么j加1,而i没有加1,是因为下面的循环判断是从--j和++i开始的
        //而基准元素选的是array[left],即第一个元素,所有左游标从第二个元素开始比较
        int i = left;
        int j = right + 1;
        //基准元素，选择了左侧的元素
        int pivot = array[left];
        while (true) {
            while(i < right && array[++i] < pivot ) {}
            while(j > 0 && array[--j] > pivot) {}
            //左右游标相遇时候停止,所以挑出while循环
            if(i >= j) {
                break;
            } else {
                //左右游标未相遇时停止,交换各自所指元素,循环继续
                swap(array, i, j);
            }
        }
        //基准元素和游标相遇时所指元素交换,为最后一次交换
        swap(array, left, j);
        //一趟排序完成,返回基准元素的位置(注意这里基准元素已经交换位置了)
        return j;
    }

    /**********************************************  测试部分  ********************************************************************/
    public static void main(String[] args){
        int testTimes = 2000;
        int size = 10;
        int value = 10;
        boolean succeed = true;
        for (int i = 0; i < testTimes ; i++) {
            int[] array = generateRandomArray(size, value);
            int[] rightResult = copyArray(array);
            quickSort(array);
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