package book;

import java.util.Scanner;

/**
 * @author:leedom
 * @date: 6/22/19 1:27 PM
 * Description:这类问题就不要想太多,从宏观出发,考虑到它是由那几部分构成,每一部分都是这样,就不要陷进去思考局部!
 *      构造表达式是第一步!!
 *      两种情况:
 *          1.到达第i层的方式是爬
 *              p[i] = min{p[i-1,t[i-1} + x
 *          2.到达第i层的方式是跳
 *              p[i] = min{p[i-1, p[i-2}
 * License: (C)Copyright 2019
 */
public class TencentQ1 {
    public static void main(String[] args){
        int[] p = new int[10005];
        int[] t = new int[10005];
        int n,m,x;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i <= n; i++) {
            x = sc.nextInt();
            p[i] = Math.min(p[i-1], t[i-1]) + x;
            if(i==1) {
                continue;
            }
            t[i] = Math.min(p[i-1], p[i-2]);
        }
        System.out.println(Math.min(p[n], t[n]));
    }
}
