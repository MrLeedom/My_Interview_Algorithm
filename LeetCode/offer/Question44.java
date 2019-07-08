package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:leedom
 * @date:2019/7/8 22:11
 * Description:字符串的排列
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出有字符a,b,c所能排列出来的所有字符串abc,acb,
 * bac,bca,cab和cba
 * License: (C)Copyright 2019
 */
public class Question44 {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if(str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backstracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backstracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if(s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for(int i = 0; i < chars.length; i++) {
            if(hasUsed[i]){
                continue;
            }
            if(i != 0 && chars[i] == chars[i-1] && !hasUsed[i-1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backstracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }
}
