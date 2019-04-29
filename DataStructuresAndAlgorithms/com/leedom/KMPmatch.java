package com.leedom;

/**
 * @author:leedom
 * @date: 4/1/19 9:42 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class KMPmatch {
    public static int[] getNextArray(char[] chs){
        int[] next = new int[chs.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < chs.length - 1) {
            //p[k]表示前缀,p[j]表示后缀
            if(k == -1 || chs[j] == chs[k]) {
                ++k;
                ++j;
                if(chs[j] != chs[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }

            } else {
                k = next[k];
            }
        }
        for (int m = 0; m < next.length; m++) {
            System.out.print(next[m]+" ");
            
        }
        return next;
    }
    public static int kmp(String str, String dest, int[] next) {
        int i= 0, j =0;
        while(i < str.length() && j < dest.length()){
            if(j == -1 || str.charAt(i) == dest.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == dest.length()){
            return i-j;
        }else{
            return -1;
        }

    }
    public static void main(String[] args){
        String str = "ABCDABD";
        int[] next = getNextArray(str.toCharArray());
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        System.out.println("-----------------");
        System.out.println(kmp(str1,str,next));

    }
}
