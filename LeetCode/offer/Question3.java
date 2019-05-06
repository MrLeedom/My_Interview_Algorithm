package offer;

import util.MyComparator;

/**
 * @author:leedom
 * @date: 5/6/19 8:11 PM
 * Description:在一个长度为n数组里的所有数字都在0-n-1范围内.某些数字是重复的,但不知道有几个数字重复,也不知道重复多少次,
 *              请找出数组中任意一个重复的数字
 * input: {2,3,1,0,2,5}
 * output:2
 * License: (C)Copyright 2019
 */
public class Question3 {
    public static boolean duplicate(int[] nums, int length, int[] duplicates) {
        if(nums == null || nums.length < 1) {
            return false;
        }
        for(int i = 0; i < length; i++) {
            if(nums[i] != i) {
                if(nums[i] == nums[nums[i]]) {
                    duplicates[0] = nums[i];
                    return true;
                } else {
                    swap(nums, i, nums[i]);
                }
            }
        }
        return false;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        MyComparator my = new MyComparator();
        int[] array = my.generateRandomArray(10,10);
        my.printArray(array);
        int[] duplicates = new int[1];
        System.out.println(duplicate(array,array.length,duplicates));
        my.printArray(duplicates);
    }
}
