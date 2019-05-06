package basic;

import util.MyComparator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:leedom
 * @date: 4/15/19 8:25 PM
 * Description:给定一个整数数组nums和一个目标值target,请你在该数组中找出和为目标值的那两个整数,并返回他们的数组下标.
 *      要求:每种输入只会对应一个答案,不能利用这个数组中同样的元素.
 * License: (C)Copyright 2019
 */
public class TwoSum_1 {
    /**************************  暴力破解法  ************************************/
    public static int[] findTarget(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return null;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
               if( nums[i] + nums[j] == target ) {
                   return new int[] {i, j};
               }
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
    /***************************  哈希表  ***********************************/
    public static int[] findTargetBasedHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i] , i);
        }
        for(int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            if(map.containsKey(temp) && j != map.get(temp)) {
                return new int[] {j, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
    public static void main(String[] args){
        MyComparator my = new MyComparator();
        int[] array = my.generateRandomArray(10, 100);
        my.printArray(array);
        int target = (int) Math.random() * 100;
        int[] array1= {1,5,3,563,23,45};
        int target1 = 24;

        my.printArray(findTarget(array1, target1));
        my.printArray(findTargetBasedHashMap(array1, target1));
    }
}
