package offer;

/**
 * @author:leedom
 * @date: 5/12/19 9:31 PM
 * Description:斐波那契数列
 * License: (C)Copyright 2019
 */
public class Question10 {
    public static int targetResult(int target) {
        if(target == 1){
            return 1;
        } else if(target == 0) {
            return 0;
        } else {
            return targetResult(target-1) + targetResult(target-2);
        }
    }

    /**
     * 动态规划的思想,将其中间过程保存下来
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    public static void main(String[] args){
        System.out.println(targetResult(6));
        System.out.println(Fibonacci(6));
    }
}
