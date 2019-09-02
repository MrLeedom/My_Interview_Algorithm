package BasicClass;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 4/15/19 2:35 PM
 * Description:
 * 经典快排问题:
 *      存在打偏的问题,我们每次拿最后一个数进行划分,这个很明显跟我们的数据状况有关系,当我们的排序是有序的,经常出现N^2这种时间复杂度
 * 随机快排问题:
 *      时间复杂度为O(NlogN),随机快排的空间复杂度为O(logN),主要是在断点处造成了空间浪费,最差的情况是O(N)
 *      就是将拿的最后一个数每次进行随机变换,这样一来就是一个概率事件,我们无法判断好与坏,只能从数学期望的角度来说,这个结果被证明为O(Nlog(N))
 * License: (C)Copyright 2019
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if(arr==null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length -1);
    }
    /**
     * 这个more最后交换是因为一开始我拿最后一个数作为member,所以最后交换一下,导致more的不同,可以画图去理解
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] partition(int[] arr, int L, int R) {
        if(arr==null){
            return new int[]{};
        }
        int less = L - 1;
        int more = R;
        int cur = L;
        while(cur < more) {
            if(arr[cur] < arr[R]) {
                swap(arr, ++less, cur++);
            } else if(arr[cur] == arr[R]) {
                cur++;
            } else {
                swap(arr, cur, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less+1, more};
    }

    /**
     * 快排核心代码
     * @param arr
     * @param L
     * @param R
     */
    public static void quickSort(int[] arr, int L, int R) {
        if(L < R){
            swap(arr, L+(int)(Math.random()*(R-L+1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] -1);
            quickSort(arr, p[1]+1, R);
        }
    }

    /**
     * 数组元素进行交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    public static void main(String[] args){
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "nice!" : "fucked!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
