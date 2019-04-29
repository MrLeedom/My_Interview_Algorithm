package BasicClass;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 4/15/19 3:41 PM
 * Description:堆   超级重要!!!!被火车撞掉也不能忘记!
 *      堆是一颗完全二叉树,但不是满二叉树
 *      可以用数组实现,i的左孩子2*i+1,父节点(i-1)/2
 *      分成大根堆和小根堆,如何建立大根堆?
 *      完全二叉树的高度是logN,调整代价log1+log2+...+logN-1 ~ O(N)
 * License: (C)Copyright 2019
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            //建立0~i之间的大根堆
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while(size > 0) {
            heapify(arr,0,size);
            swap(arr, 0, --size);
        }
    }

    /**
     *
     * @param arr
     * @param index  该处元素值变小
     * @param heapSize  0~heapSize范围生成了最大堆
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while(left < heapSize) {
            int largest = left + 1 < heapSize && arr[left+1] > arr[left]
                            ? left + 1
                            : left;
            largest = arr[index] < arr[largest] ? largest : index;
            if(largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
    /**
     * 生成最大堆,一个节点一个节点的新增
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index-1) / 2);
            index = (index - 1) /2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
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
            heapSort(arr1);
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
        heapSort(arr);
        printArray(arr);
    }
}
