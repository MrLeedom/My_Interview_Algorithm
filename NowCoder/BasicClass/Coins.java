package BasicClass;

/**
 * @author:leedom
 * @date: 5/16/19 1:31 PM
 * Description:有数量不限的硬币,币值为25,10,5,1,请编写代码计算n分有几种表示法
 * 给定一个int n,请返回n分有几种表示法.保证n小于等于100000
 * License: (C)Copyright 2019
 */
public class Coins {
    public static int countWays(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[100001];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 0;
        }
        dp[0] = 1;
        for(int m = 0; m < coins.length; m++) {
            for(int k = coins[m]; k <= n; k++) {
                dp[k] += dp[k - coins[m]];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(countWays(25));
    }
}
