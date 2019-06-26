package offer;

import util.MyComparator;
import util.MyTools;

/**
 * @author:leedom
 * @date:2019/6/26 22:50
 * Description:调整一个数组，使得奇数排在偶数前面
 *      例如：1 2 3 4 5
 *          ---> 1 3 5 2 4
 * License: (C)Copyright 2019
 */
public class Question25 {
    public static void reOrderArray(int[] nums) {
        //奇数个数
        int oddCount = 0;
        for(int x : nums) {
            if(!isEven(x)) {
                oddCount++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCount;
        for(int index : copy) {
            if(index % 2 == 1) {
                nums[i++] = index;
            }else{
                nums[j++] = index;
            }
        }
    }

    public static boolean isEven(int value) {
        if(value % 2 == 0) {
            return true;
        }else{
            return false;
        }
    }

    public static void reOrderArray_BubbleSort(int[] array) {
        int length = array.length;
        for(int i = length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(isEven(array[j]) && !isEven(array[j+1])) {
                    new MyTools().swap(array, j, j+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        new MyComparator().printArray(array);
        reOrderArray_BubbleSort(array);
        new MyTools().printArray(array);
//        reOrderArray(array);
//        new MyComparator().printArray(array);
    }
}
