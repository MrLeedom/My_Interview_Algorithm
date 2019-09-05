package com.sort;

import java.util.Arrays;

/***************************************************************************
 @description :      经典排序，堆排序
 堆是一棵完全二叉树；
 堆中每个节点的值都必须大于等于（或小于等于）其子树中每个节点的值
 完全二叉树比较适合用数组来存储，用数组来存储完全二叉树是非常节省存储空间的，因为我们不需要存储左右子节点的指针，单纯地通过数组的下标，就可以找到一个节点的左右节点和父节点。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-04 17:46  caoshipeng  create
 ****************************************************************************/
class Heap {
    //数组，从小标1开始存储数据
    private int[] a;
    //堆可以存储的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入一个元素到堆中，从下往上
     */
    public void insert(int data) {
        if(count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while(i/2 > 0 && a[i] > a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素
     */
    public void removeMax() {
        if(count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 从上往下堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while(true) {
            int maxPos = i;
            if(i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if(i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2 + 1;
            if(maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 堆排序，它包含两个过程，建堆和排序。我们将下标从n/2到1的节点，依次进行从上到下
     * 的堆化操作，然后就可以将数组中的数据组织成堆这种数据结构。接下来，我们迭代地将
     * 堆顶元素放到堆末尾，并将堆的大小减一，然后再堆化，重复这个过程，直到堆中只剩下一个
     * 元素，整个数组中的数据就都有序排列了。
     */
    public void buildHeap(int[] a, int n) {
        for(int i = n/2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    /**
     * n表示数据的个数，数组a中的数据从下标1到n的位置
     * @param a
     * @param n
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
public class HeapSort {
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            //建立0~i之间的大根堆
            heapInsert(arr, i);
        }
        printArray(arr);
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
//        int testTime = 5000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for(int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            heapSort(arr1);
//            comparator(arr2);
//            if(!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "nice!" : "fucked!");
//        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arr = generateRandomArray(20, 10);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}

