package com.leedom;

/**
 * @author:leedom
 * @date: 4/2/19 9:01 AM
 * Description:
 * License: (C)Copyright 2019
 */
public class BM {
    public static int pattern(String pattern, String target) {
        int tLen = target.length();
        int pLen = pattern.length();

        if(pLen > tLen){
            return -1;
        }

        int[] bad_table = build_bad_table(pattern);
        int[] good_table = build_good_table(pattern);

        for(int i = pLen-1,j; i < tLen;) {
            System.out.println("skip position:" + i);
            for(j=pLen-1;target.charAt(i) == pattern.charAt(j);i--,j--) {
                if(j == 0) {
                    System.out.println("succeed!position:"+i);
                    return i;
                }
            }
            i += Math.max(good_table[pLen-j-1], bad_table[target.charAt(i)]);
        }
        return -1;
    }

    public static int[] build_bad_table(String pattern) {
        final int table_size = 256;
        int[] bad_table = new int[table_size];
        int pLen = pattern.length();

        for(int i = 0; i < bad_table.length; i++) {
            //默认初始化全部为匹配字符串长度
            bad_table[i] = pLen;
        }
        for(int i = 0; i < pLen-1; i++) {
            int k = pattern.charAt(i);
            bad_table[k] = pLen - 1 - i;
        }
        return bad_table;
    }

    public static int[] build_good_table(String pattern) {
        int pLen = pattern.length();
        int[] good_table = new int[pLen];
        int lastPrefixPosition = pLen;

        for(int i = pLen - 1; i >= 0; i--) {
            if(isPrefix(pattern, i+1)){
                lastPrefixPosition = i + 1;
            }
            good_table[pLen-1-i] = lastPrefixPosition - i + pLen -1;
        }

        for(int i = 0; i <pLen -1; i++) {
            int sLen = suffixLength(pattern, i);
            good_table[sLen] = pLen - 1 -i + sLen;
        }
        return good_table;
    }

    private static boolean isPrefix(String pattern, int p) {
        int patternLength = pattern.length();
        for(int i = p,j=0; i <patternLength; i++,j++) {
            if(pattern.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static int suffixLength(String pattern, int p) {
        int pLen = pattern.length();
        int len = 0;
        for(int i = p, j=pLen-1;i>=0 && pattern.charAt(i) == pattern.charAt(j); i--,j--){
            len += 1;
        }
        return len;
    }
}
