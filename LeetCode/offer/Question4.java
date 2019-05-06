package offer;

/**
 * @author:leedom
 * @date: 5/6/19 8:25 PM
 * Description:给定一个二维数组,其每一行从左往右递增排序,从上到下也是递增排序,给定一个数,判定这个数是否在该二维数组中
 * 要求时间复杂度O(M+N),空间复杂度O(1)
 * License: (C)Copyright 2019
 */
public class Question4 {
    public static boolean findTarget(int[][] nums, int target) {
        if(nums == null || nums.length <1 || nums[0].length < 1) {
            return false;
        }
        int row = 0;
        int col = nums[0].length-1;
        while(row < nums.length && col >= 0){
            if(target < nums[row][col]) {
                col--;
            }else if(target > nums[row][col]) {
                row++;
            } else {
                System.out.println("row:"+String.valueOf(row)+",column:"+String.valueOf(col));
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(findTarget(array,10));
    }
}
