package BasicClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:leedom
 * @date: 5/1/19 2:32 PM
 * Description:打印字符串的所有子序列
 * License: (C)Copyright 2019
 */
public class Print_All_Subsquences {
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    public static void process(char[] chs, int i, List<Character> res) {
        if(i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i+1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(chs, i+1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list){
        return null;
    }

    /**
     * 第二种方法
     * @param str
     * @param i
     * @param res
     */
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i+1, res);
        printAllSub(str, i+1, res+String.valueOf(str[i]));
    }
    public static void main(String[] args) {
        String test = "abc";
        printAllSubsquence(test);
        printAllSub(test.toCharArray(), 0, "");
    }
}
