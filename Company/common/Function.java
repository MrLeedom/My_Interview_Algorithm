package common;

import java.util.*;

/***************************************************************************
 @description : 在使用过程中，注意去掉静态修饰static
 1.打印功能，打印数组为主
 2.元素交换顺序
 3.反转数组，列表，字符串
 4.输入准备
 5.对数器准备
 6.最大堆，最小堆定义和使用
 7.返回[a, b]结构
 8.截取数组局部元素
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-03 11:52  caoshipeng  create
 ****************************************************************************/
public class Function {
    /**
     * 输入功能准备
     */
    public static void inputReady() {
        Scanner sc = new Scanner(System.in);
        //1.如果输入的单个数字，接收
        int num = sc.nextInt();
        //2.如果输入的是一个字符串，接收
        String str = sc.nextLine();
        //3.如果输入的较为连续，采用while循环来做,弄成整形数组
        while(sc.hasNext()) {
            String[] tmp = sc.nextLine().split(" ");
            int[] arr = new int[tmp.length];
            //实现两个数组数据的生成
            for(int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(tmp[i]);
            }
        }
    }
    /**
     * 打印数组元素,打印效果：1 2 3 4 5，最后还有一句换行操作
     * @param array
     */
    public static void printArray(int[] array) {
        if(array==null){
            return;
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1) System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 打印一切可以迭代打印的对象
     * @param obj
     */
    public static void printObject(Object[] obj) {
        for (Object item: obj) {
            System.out.println(obj.toString());
        }
    }

    /**
     * 数组元素进行交换，利用位操作实现
     * @param arr
     * @param i
     * @param j
     */
    public  static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    /**
     * 字符串指定位置两元素交换
     * @param str
     * @param i
     * @param j
     * @return
     */
    public static String swapString(String str, int i, int j) {
        if(str == null || str.length() < 1) {
            return null;
        }
        int length = str.length();
        if(i >= length || j >= length) {
            try {
                throw new Exception("the index of string out of bound.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        char c1 = str.charAt(i);
        char c2 = str.charAt(j);

        //直接进行替换
        str = str.replace(c1, '-');
        str = str.replace(c2, c1);
        str = str.replace('-', c2);
        return str;
    }

    /**
     * 字符串反转操作
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 数组反转操作
     * @param array
     */
    public static void reverseArray(int[] array) {
        for(int i = 0; i < array.length/2 - 1; i++) {
            //for循环输出交换位置
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-1-i]=temp;
        }
    }

    /**
     * 列表反转操作
     * @param list
     */
    public static void reverseList(ArrayList list) {
        Collections.reverse(list);
    }

    /**
     * 根据数组个数和最大值返回生成自定义数组，用于对数器测试
     * @param maxSize
     * @param maxValue
     * @return
     */
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    /**
     * 生成和原数组一致的数组
     * @param arr
     * @return
     */
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

    /**
     * 判断两个数组是否为同一个数组
     * @param arr1
     * @param arr2
     * @return
     */
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

    /**
     * 对数器使用案例
     */
    public void equalDetector() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            mergeSort(arr1);等待测试的功能
//            comparator(arr2);原有功能实现，作为对比
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        mergeSort(arr);可视化两者区别
        printArray(arr);
    }

    /**
     * 最大堆和最小堆的定义，实现有序的树结构
     */
    public void defineHeap() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    }

    /**
     * 返回的结果格式为[a, b]
     * @param a
     * @param b
     * @return
     */
    public static List jointArray(int a, int b) {
        return new ArrayList<>(Arrays.asList(a, b));
    }

    /**
     * 截取从i位置到j位置的元素
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int[] localArray(int[] arr, int i, int j) {
        return Arrays.copyOfRange(arr,i,j + 1);
    }
    public static void main(String[] args) {
        System.out.println(jointArray(3, 89));
        int[] array = {1,9,3,4,5};
        printArray(localArray(array, 0, 3));
        printArray(array);
        reverseArray(array);
        printArray(array);
        Arrays.sort(array);//数组排序
        printArray(array);
        swap(array, 1, 2);
        printArray(array);

        ArrayList <String> list=new ArrayList <String>();
        list.add("1");
        list.add("95");
        reverseList(list);
        System.out.println(list.toString());

    }
}
