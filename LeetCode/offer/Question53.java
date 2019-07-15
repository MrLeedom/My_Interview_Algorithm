package offer;

/**
 * @author:leedom
 * @date:2019/7/15 23:01
 * Description:把数字翻译成字符串
 * 给定一个数字，按照如下规则翻译成字符串：1翻译成'a'，2翻译成'b'...26翻译成'z'。一个数字有多种翻译可能，例如12258一共有5种，分别
 * abbeh,lbeh,aveh,abyh,lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * License: (C)Copyright 2019
 */
public class Question53 {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i-1, i));
            if(one != 0) {
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i-2, i));
            if(two <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        System.out.println(numDecodings("12258"));
    }
}
