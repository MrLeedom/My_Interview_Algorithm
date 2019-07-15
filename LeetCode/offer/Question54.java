package offer;

/**
 * @author:leedom
 * @date:2019/7/15 23:16
 * Description:礼物的最大值
 * 在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定价值（大于0）.从左上角开始拿礼物，每次向右或向左移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大值。
 *
 * 应该采用动态规划求解，而不是深度优先搜索，深度优先搜索过于复杂，不是最优解
 * License: (C)Copyright 2019
 */
public class Question54 {
    public static int getMost(int[][] values) {
        if(values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int n = values[0].length;
        int[] dp = new int[n];
        for(int[] value : values) {
            dp[0] += value[0];
            for(int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i], dp[i-1]) + value[i];
            }
        }
        return dp[n-1];
    }
}
