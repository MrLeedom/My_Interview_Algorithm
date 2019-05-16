package BasicClass;

/**
 * @author:leedom
 * @date: 5/16/19 1:42 PM
 * Description:
 * 给定一个数值sum,假设我们有m种不同类型的硬币{v1,v2,v3,...,vm},如果要组合成sum,那么所有的可能组合数
 * 递推思路:
 *      sum = x1 * v1 + x2 * v2 + ... + 0 * vm
 *      sum = x1 * v1 + x2 * v2 + ... + 1 * vm
 *      ...
 *      sum = x1 * v1 + x2 * v2 + ... + K * vm
 *      所以我们定义: k = sum / vm
 *           dp[i][sum] = 前i种硬币构成sum的所有组合数
 *       通过此公式,我们一步步缩小目标,那么初始情况是什么样尼? 如果sum = 0,那么只有一种可能,就是各个系数都等于0
 *            dp[i][0] = 1 //i=0,1,2,...,m
 * License: (C)Copyright 2019
 */
public class CoinCombination {
    public static int coinCOmbination(int[] coins, int coinKinds, int sum) {
        int[][] dp = new int[coinKinds+1][sum+1];
        for(int i = 0; i <= coinKinds; i++) {
            for(int j = 0; j <= sum; j++) {
                dp[i][j] = 0;
            }
            dp[i][0] = 1;
        }

        for(int i = 1; i <= coinKinds; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = 0;
                for(int k = 0; k <= j / coins[i-1]; k++) {
                    dp[i][j] += dp[i-1][j - k * coins[i-1]];
                    System.out.println("index:"+i);
                }
            }
        }
        return dp[coinKinds][sum];

    }
    public static void main(String[] args){
        int[] coins = {1, 5, 10, 25};
        System.out.println(coinCOmbination(coins, 4, 25));
    }

}
