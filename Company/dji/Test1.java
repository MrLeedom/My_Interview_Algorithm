package dji;

import java.util.Scanner;

/***************************************************************************
 @description :
 对于最长公共字串问题，我们可以采用经典的动态规划方法来做。
 第一步：生成动态规划表，生成大小为m*n,dp[i][j]是指把str1和str2的第i个和第j个做为最后一个字符的情况，公共字符串有多长。
 第二步：利用生成的动态规划表，寻找最长公共字串
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-04 18:45  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    /**
     * 生成动态规划表，用来存放二维表
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] getdynamicpro(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for(int i = 0; i <str1.length; i++) {
            if(str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for(int j = 1; j < str2.length; j++) {
            if(str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }
        for(int i =1; i < str1.length; i++) {
            for(int j = 1; j < str2.length; j++) {
                if(str1[i] == str2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }

    /**
     * 根据动态规划表，去寻求最长公共字串，同时满足是小字串进行截取
     * @param str1
     * @param str2
     * @return
     */
    public static String longCommString(String str1, String str2) {
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdynamicpro(chs1, chs2);
        int end1 = 0, end2 = 0;
        int maxNum = 0;
        for(int i = 0; i < chs1.length; i++) {
            for(int j = 0; j < chs2.length; j++) {
                if(dp[i][j] > maxNum) {
                    end1 = i;
                    end2 = j;
                    maxNum = dp[i][j];
                }
            }
        }
        String str = minString(str1, str2) == 1 ? str1.substring(end1 - maxNum + 1, end1 + 1) : str2.substring(end2 - maxNum + 1, end2 + 1);
        return str;
    }

    /**
     * 得到两个字符串谁属于长度比较小的哪一位，用1和0标识
     * @param str1
     * @param str2
     * @return
     */
    public static int minString(String str1, String str2) {
        return str1.length() - str2.length() >= 0 ? 1 : 0;
    }

    /**
     * 主程序入口
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().trim();
        String str2 = sc.nextLine().trim();
        System.out.println(longCommString(str1, str2));
        
    }
}
