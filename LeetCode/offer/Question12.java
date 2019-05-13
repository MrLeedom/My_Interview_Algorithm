package offer;

/**
 * @author:leedom
 * @date: 5/12/19 9:56 PM
 * Description:一只青蛙一次可以跳1级台阶,也可以跳2级,求该青蛙跳上一个n级的台阶共有多少种方法
 * License: (C)Copyright 2019
 */
public class Question12 {
    public static int resolveQuestion(int n) {
        if(n <= 2) {
            return n;
        } else {
            return resolveQuestion(n-1) + resolveQuestion(n-2);
        }
    }
}
