package offer;

/**
 * @author:leedom
 * @date: 5/12/19 9:43 PM
 * Description:矩形覆盖问题
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形.请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形,总共有多少种方法?
 * 解法思路:反过来考虑,想成汉诺塔问题,分解来看
 * License: (C)Copyright 2019
 */
public class Question11 {
    public static int rectCover(int n) {
        if(n <= 2) {
            return n;
        } else {
            //其实这一块确定下来了,只能由这两种情况构成的,最后一个组成要么是横,要么不是横
            return rectCover(n-1) + rectCover(n-2);
        }
    }
    public static int rectCover2(int n) {
        if(n <= 2) {
            return n;
        }
        int pre2 =1, pre1 = 2;
        int result = 0;
        for(int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(rectCover(9));
        System.out.println(rectCover2(9));
    }
}
