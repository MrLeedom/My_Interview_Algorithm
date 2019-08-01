package offer;

import java.util.Arrays;

/***************************************************************************
 @description :     扑克牌顺子
 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 1 0 3 4 5
 2 0 0 5 6
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-01 23:46  caoshipeng  create
 ****************************************************************************/
public class Question69 {
    public boolean isContinuous(int[] nums) {

        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }
}
