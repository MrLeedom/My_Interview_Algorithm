package offer;

/**
 * @author:leedom
 * @date:2019/7/8 22:36
 * Description:数组中出现次数超过一半的数字，要求时间复杂度为O(N)
 *  多数投票问题
 * License: (C)Copyright 2019
 */
public class Question45 {
    public int moreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for(int i = 1,cnt=1; i < nums.length; i++ ) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if(cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for(int val : nums) {
            if(val == majority) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? majority : 0;
    }
}
