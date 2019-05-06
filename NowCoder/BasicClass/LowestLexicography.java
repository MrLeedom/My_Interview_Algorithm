package BasicClass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:leedom
 * @date: 5/1/19 12:34 PM
 * Description:贪心的思想,比较器,也就是排序策略的准确性问题
 * License: (C)Copyright 2019
 */
public class LowestLexicography {
    public static class MyComparator1 implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator1());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
