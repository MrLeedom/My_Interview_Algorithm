package pdd;

import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************************
 @description :
 给定一个字符串数组（字符串长度和数组长度均大于1且小于1024），所有字符均为大写字母。请问，给定的字符串数组是否能通过更换数组中元素的顺序，从而首尾相连，形成一个环。
 链接：https://www.nowcoder.com/discuss/212692
 来源：牛客网
 看到牛客上po了一些回答，记录所有字符串头尾字母的出现次数，如果是全部出现偶数次即可形成环。这种思路其实是有问题的，例如["AA","BB"]，虽然字母A和B均出现偶数次，但是首尾不相等。
 题目本质上应该是一个排列问题，可用回溯列出所有排列，判断是否首尾相连。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-30 22:29  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] words = in.nextLine().split(" ");
            if(null == words || words.length < 2) System.out.println("false");
            boolean[] isUsed = new boolean[words.length];
            boolean flag = backtrack(words, new ArrayList<String>(), isUsed);
            if(flag) System.out.println("true");
            else System.out.println("false");
        }
    }

    private static boolean backtrack(String[] words, ArrayList<String> curList, boolean[] isUsed) {
        boolean flag = false;
        if(words.length == curList.size()) {
            String first = curList.get(0);
            String last = curList.get(curList.size()-1);
            return last.charAt(last.length()-1) == first.charAt(0);
        }
        for(int i = 0; i < words.length; ++i) {
            if(isUsed[i]) continue;
            if(curList.size() == 0) {
                curList.add(words[i]);
            } else {
                String prev = curList.get(curList.size()-1);
                if(prev.charAt(prev.length()-1) != words[i].charAt(0)) continue;
                curList.add(words[i]);
            }
            isUsed[i] = true;
            flag = backtrack(words, curList, isUsed);
            isUsed[i] = false;
            curList.remove(curList.size()-1);
            if(flag) break;
        }
        return flag;
    }
}
