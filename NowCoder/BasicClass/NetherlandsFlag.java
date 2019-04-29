package BasicClass;

/**
 * @author:leedom
 * @date: 4/15/19 1:54 PM
 * Description:荷兰国旗问题
 * 描述:给定一个数组arr,和一个数num,请把小于num的数放在数组的左边,等于num的数放在数组的中间,大于num的数放在数组的右边
 *      要求:额外的空间复杂度O(1),时间复杂度O(N)
 *   思路流程:首先有两个仓库,存放小于num和大于num;接着我们开始从左边遍历,
 *      若这个数=num,直接跳下一个数;
 *      若这个数<num,将这个数与小于区域的下一个数交换,指针跳下一个数;
 *      若这个数>num,将这个数与大于区域的前一个数x交换,此时发现换来的数没做任何操作,也就是当前指针不跳动.
 * License: (C)Copyright 2019
 */
public class NetherlandsFlag {
    /**
     * 该函数功能扩充:任意一个区域进行划分都可以
     * @param arr
     * @param L
     * @param R
     * @param member,划分标准数
     * @return 整个等于member数组的左边界和右边界,也就是
     */
    public static int[] partition(int[] arr, int L, int R, int member) {
        if(arr==null){
            return new int[]{};
        }
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while(cur < more) {
            if(arr[cur] < member) {
                swap(arr, ++less, cur++);
            } else if(arr[cur] == member) {
                cur++;
            } else {
                swap(arr, cur, --more);
            }
        }
        printArray(arr);
        return new int[]{less+1, more-1};
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

    public static int[] generateArray(int size, int upper) {
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * upper);
        }
        return array;
    }
    public static void main(String[] args){
        int[] array = generateArray(10, 100);
        printArray(array);
        int[] output = partition(array,0,array.length-1, 50);
        printArray(output);
    }
}
