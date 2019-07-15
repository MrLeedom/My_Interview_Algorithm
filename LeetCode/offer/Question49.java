package offer;

/**
 * @author:leedom
 * @date:2019/7/11 23:21
 * Description:连续子数组的最大和
 * 例如：3，4，-6，8，-15，2，1，3
 * License: (C)Copyright 2019
 */
public class Question49 {
    public int findGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int val : array) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
