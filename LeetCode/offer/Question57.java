package offer;

import java.util.BitSet;

/***************************************************************************
 @description :
 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 Input: abacc
 Output: b
 用第一个bs1来存所有第一次出现的数据；用bs2来存所有的第二次或者多次出现的数据，最后再判断一轮就可以啦
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-30 23:04  caoshipeng  create
 ****************************************************************************/
public class Question57 {
    public static int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);     // 0 0 -> 0 1
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);     // 0 1 -> 1 1
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("absbscdcd"));
    }
}
