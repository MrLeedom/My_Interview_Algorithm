package offer;

/**
 * @author:leedom
 * @date:2019/6/23 21:00
 * Description:位运算问题（n&n-1 该位运算除去n的位级表示中最低的那一位）
 *      另外一个是记住Integer.bitCount(int n)的1的个数
 *      函数的输入是十进制数字。
 * License: (C)Copyright 2019
 */
public class Question18 {
    public static int NumberOf1(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt ++;
            n &= (n-1);
        }
        return cnt;
    }
    
    public static int NumberOf2(int n) {
        return Integer.bitCount(n);
    }
    
    public static void main(String[] args) {
        System.out.println(NumberOf1(7));
        System.out.println(NumberOf2(7));
    }
}
