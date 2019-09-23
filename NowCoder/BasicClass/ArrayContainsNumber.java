package BasicClass;

/**
 * @author:leedom
 * @date: 4/29/19 11:02 PM
 * Description:
 * 一个二维数组,行递增,列递增,完成一个这样的二维数组,且在其中进行某个整数的搜寻
 * License: (C)Copyright 2019
 */
public class ArrayContainsNumber {
    public static boolean isContainsNumber(int[][] array, int target) {
        int row = 0;
        int column = array[0].length -1;
        while(row < array.length && column > -1) {
            if(array[row][column] == target) {
                return true;
            } else if (array[row][column] > target) {
                column -- ;
            } else {
                row ++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(isContainsNumber(matrix, K));
    }
}
