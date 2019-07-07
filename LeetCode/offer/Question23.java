package offer;

/**
 * @author:leedom
 * @date: 6/24/19 3:31 PM
 * Description:字符串匹配
 *      函数实现匹配包括'.'和'*'的正则表达式.模式中的字符'.'表示任意一个字符,'*'表示前面的字符可以出现任意次(包括0次)
 * License: (C)Copyright 2019
 */
public class Question23 {
    public static boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int i = 1; i <= n; i++) {
            if(pattern[i-1] == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str[i-1] == pattern[j-1] || pattern[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern[j-1] == '*') {
                    if(pattern[j-2] == str[i-1] || pattern[j-2] == '.') {
                        dp[i][j] |= dp[i][j-1]; //a* counts as single a
                        dp[i][j] |= dp[i-1][j]; //a* counts as multiple a
                        dp[i][j] |= dp[i][j-2]; //a* counts as empty
                    }else{
                        dp[i][j] = dp[i][j-2]; // a* only counts as empty
                    }
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args){
        System.out.println(match("a".toCharArray(),"b".toCharArray()));
    }
}
