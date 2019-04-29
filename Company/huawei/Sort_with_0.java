
/**
 * @author:leedom
 * @date: 4/10/19 1:57 PM
 * Description:
 *      要点:长度为NDE的数组乱序存放着0到n-1,现在只能进行0与其他数的交换,完成以下代码,实现排序
 *      其实思想就是每一次首先将最后一位置为0,然后将当前最大索引交换过来,循环下去,会实现友好排序
 * License: (C)Copyright 2019
 */
public class Sort_with_0 {
    public static void swapWithZero(int[] array, int len, int n) {
        int zIndex = -1;
        int nIndex = -1;
        for(int i = 0; i < len; i++) {
            if(array[i] == 0) {
                zIndex = i;
            }
            if(array[i] == n) {
                nIndex = i;
            }
        }
        int temp = array[zIndex];
        array[zIndex] = array[nIndex];
        array[nIndex] = temp;
    }
    public static void sort(int[] array, int len) {
        for(int i = len - 1; i > 0; i--) {
            if(array[i] == i) {
                continue;
            }
            swapWithZero(array, len, array[i]);
            swapWithZero(array, len, i);
        }
    }
    public static void main(String[] args){
        int[] array = {1, 0, 4, 3, 2};
        sort(array, array.length);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
