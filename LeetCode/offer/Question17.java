package offer;

/**
 * @author:leedom
 * @date:2019/6/23 20:21
 * Description:     剪绳子问题
 *      动态规划加暴力遍历的一个思想，让它去尝试做所有的操作，我只用保存期间出现的最大值
 * License: (C)Copyright 2019
 */
public class Question17 {
    public static int integerBreak(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if(n - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timeOf2 = (n - timesOf3*3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int)(Math.pow(2, timeOf2));
    }

    //采用动态规划的思想来做
    public static int integerBreak2(int n) {
        if(n==1){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                //这一段很经典哈
                dp[i] = Math.max(dp[i], Math.max(j * (i-j),  dp[j] * (i-j)));
            }
        }
        return dp[n];
    }   
    
    public static void main(String[] args) {
        System.out.println(integerBreak(1));
        System.out.println(integerBreak2(1));
    }

}
