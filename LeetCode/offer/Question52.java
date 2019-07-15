package offer;

import java.util.Arrays;

/**
 * @author:leedom
 * @date:2019/7/15 22:47
 * Description:把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组（3，32，321），则
 * 打印出这三个数字能排出的最小数字位321323
 *
 * 解题思路：可以看成是一个排序问题，在比较两个字符串s1和s2,再比较两个字符串s1和s2的大小时，应该比较s1+s2和s2+s1的大小
 * License: (C)Copyright 2019
 */
public class Question52 {
    public static String printMinNumber(int[] number) {
        if(number == null || number.length == 0) {
            return "";
        }
        int n = number.length;
        String[] nums = new String[n];
        for(int i = 0; i < n; i++) {
            nums[i] = number[i] + "";
        }
        Arrays.sort(nums, (s1,s2) -> (s1+s2).compareTo(s2+s1));
        String ret = "";
        for(String str : nums) {
            ret += str;
        }
        return ret;
    }
}
