package BasicClass;

/**
 * @author:leedom
 * @date: 4/15/19 6:41 PM
 * Description:桶排序问题
 *      给定一个数组,求如果排序之后,相邻两数的最大差值,要求时间复杂度O(n),且要求不能使用基于比较的排序.
 *      N个数,用N+1个桶来存,空桶杀死来自同一个桶内部的可能性,但没有针对不同桶的探讨
 * License: (C)Copyright 2019
 */
public class MaxGap {
    public static int maxGap(int[] nums) {
        if(nums == null || nums.length < 2) {
            return  0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max == min) {
            return 0;
        }
        boolean[] hasNum = new boolean[len+1];
        int[] maxs = new int[len+1];
        int[] mins = new int[len+1];
        int bid = 0;
        for(int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 0;

        //找到一个空桶的右边桶和左边桶,两者之间的差值
        for(; i <= len; i++) {
            if(hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
