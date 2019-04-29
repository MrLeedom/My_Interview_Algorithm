import java.util.Arrays;

/**
 * @author:leedom
 * @date: 4/15/19 8:39 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class MyComparator {
    /**
     * 数组元素进行交换
     * @param arr
     * @param i
     * @param j
     */
    public  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组元素
     * @param array
     */
    public void printArray(int[] array) {
        if(array==null){
            return;
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue+1) * Math.random());
        }
        return arr;
    }

    public int[] copyArray(int[] arr) {
        if(arr==null) {
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public boolean isEqual(int[] arr1, int[] arr2) {
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
