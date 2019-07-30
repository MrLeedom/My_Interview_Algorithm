package offer;

import java.util.Arrays;

/***************************************************************************
 @description:
 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 @author:  caoshipeng
 @版权信息： 华为技术有限公司（C），版权所有 2019-2020
 @modified: 2019-07-27 12:44  caoshipeng  create
 ****************************************************************************/
public class Question55 {
    public static int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubStringWithoutDuplication("arabcacfr"));
    }
}
