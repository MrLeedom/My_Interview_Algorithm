package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:leedom
 * @date:2019/6/20 18:38
 * Description:旋转数组的最小数字
 *      把一个递增数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。目标是找到旋转数组的最小元素。
 *      做法是：最好采用案例来分析，其实就两个点
 *          情况一：
 *          {1，2，3，4，5}---->{3,4,5,| 1,2}也就是说旋转后的数组通常是由两个非递减小数组构成
 *              采用两个指针来做，最终两个指针第一个指针指向第一个数组末尾，第二个指针指向数组的开头，取指向开头的那个指针
 *          情况二：
 *          {0，1，1，1，1}----->{1,0,1,1,1} or {1,1,1,0,1}必须要遍历才能得到
 *
 *      时间复杂度分析：
 *
 * License: (C)Copyright 2019
 */
public class Question14 {
    public static int minNumberInRotateArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length -1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                return minNumber(nums,start,end);
            }else if(nums[mid] <= nums[end]) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return nums[start];
    }

    private static int minNumber(int[] nums, int start, int end) {
        /*顺序遍历
        int min = nums[start];
        for(int i = start; i <= end; i++) {
            if(min > nums[i]){
                min = nums[i];
            }
        }
        return min;
        */
        //找到冲突点
        for(int i = start; i <= end; i++) {
            if(nums[i] > nums[i+1]){
                return nums[i+1];
            }
        }
        return nums[start];
    }
    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            
            System.out.println("乱数组：");
            printArray(arr1);
            comparator(arr1);
            System.out.println("原数组：");
            printArray(arr1);
            if(arr1.length == 0){
                System.out.println("空数组");
                return;
            }
            int result1 = arr1[0];
            int mobile = (int)((arr1.length + 1) * Math.random());
            int[] first = Arrays.copyOfRange(arr1,0,mobile);
            int[] second = Arrays.copyOfRange(arr1,mobile,arr1.length);
            int[] sample = linkArray(first,second);
            System.out.println("旋转数组：");

            printArray(sample);

            int result2 = minNumberInRotateArray(sample);

            if(result1 != result2) {
                succeed = false;
                System.out.println(result1);
                System.out.println(result2);
                break;
            }
        }
        System.out.println(succeed ? "nice!" : "fucked!");
    }

    public static int[] linkArray(int[] array1, int[] array2) {
        if (array1 == null) {
            return array2;
        }
        if (array2 == null) {
            return array1;
        }
        List list = new ArrayList();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            list.add(array2[i]);
        }
        Object[] array = list.toArray();
        int[] newArray = new int[array.length];
        for(int i = 0; i < array.length;i++){
            newArray[i] = Integer.parseInt(String.valueOf(array[i]));
        }
        return newArray;
    }

    /**
     * 打印数组元素
     * @param array
     */
    public static void printArray(int[] array) {
        if(array==null){
            return;
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static  int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue+1) * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if(arr==null) {
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if(arr1 == null && arr2 == null) {
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
}
