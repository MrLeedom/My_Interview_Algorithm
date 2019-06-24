package book;

import java.util.Scanner;

/**
 * @author:leedom
 * @date: 6/22/19 1:46 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class TencentQ2 {
    public static void main(String[] args){
        long[] x = new long[8];
        long[] y = new long[8];
        int T;
        long n, m, black, white, a, b, c, d, e;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T != 0) {
            T -= 1;
            n = sc.nextLong();
            m = sc.nextLong();
            black = n * m / 2;
            white = n * m - black;
            for(int i = 0; i <= 3; i++) {
                x[i] = sc.nextLong();
                y[i] = sc.nextLong();
            }
            if((x[0] +y[0]) % 2 == 1) {
                d = ((x[1]-x[0] + 1) * (y[1]-y[0]+1) + 1) / 2;
            }else{
                d = ((x[1]-x[0]+1) * (y[1]-y[0]+1)) / 2;
            }
            white += d;
            black -= d;
            if((x[2] + y[2]) % 2 == 1) {
                d = (x[3]-x[2]+1)*(y[3]-y[2]+1) / 2;
            }else {
                d = ((x[3]-x[2]+1)*(y[3]-y[2]+1) + 1) / 2;
            }
            white -= d;
            black += d;
            a = Math.max(x[0], x[2]);
            b = Math.max(y[0], y[2]);
            c = Math.min(x[1], x[3]);
            d = Math.max(y[1], y[3]);
            if(c < a || d < b) {
                e = 0L;
            }else{
                if((a+b) % 2 == 1) {
                    e = ((c-a+1) * (d-b+1) + 1) / 2;
                }else{
                    e = (c-a+1) * (d-b+1) / 2;
                }

            }
            white -=e;
            black +=e;
            System.out.println(white+" , "+black);
        }
        return;
    }
}
