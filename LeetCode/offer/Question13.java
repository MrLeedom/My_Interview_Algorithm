package offer;

import java.util.Arrays;

/**
 * @author:leedom
 * @date: 5/12/19 10:00 PM
 * Description:超级变态的青蛙跳台阶
 * License: (C)Copyright 2019
 */
public class Question13 {
    public static int jumpFloor(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for(int i = 0; i < target;i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }

    /**
     * 等比数列的思想
     * f(n-1) = f(n-2) + ... + f(0)
     * f(n) = f(n-1) + ... + f(0)
     * f(n) = 2 * f(n-1)
     * @param target
     * @return
     */
    public static int jumpFloor2(int target) {
        return (int) Math.pow(2,target-1);
    }
}
