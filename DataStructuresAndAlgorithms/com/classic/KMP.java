package com.classic;

/**
 * @author:leedom
 * @date: 5/17/19 10:36 AM
 * Description:KMP算法,给定两个字符串str和match,长度分别为N和M,实现一个算法,如果字符串str中含有子串match,返回match在str中的位置,不含
 *          有则返回-1.
 * License: (C)Copyright 2019
 */
public class KMP {
    public int[] getNextArray(char[] ms) {
        if(ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        //跳到的位置
        int cur = 0;
        //前缀字符串和后缀字符串进行匹配
        while(pos < next.length) {
            if(ms[pos-1] == ms[cur]){
                next[pos++] = ++cur;
            }else if(cur > 0){
                cur = next[cur];
            }else{
                next[pos++] = 0;
            }
        }
        return next;
    }

    public int getIndexOf(String s, String m) {
        if(s == null || m == null || m.length() < 1 || s.length() < 1) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while(si < ss.length && mi < ms.length){
            if(ss[si] == ms[mi]) {
                si++;
                mi++;
            }else if(next[mi] == -1){
                si++;
            }else{
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi :-1;
    }
}
