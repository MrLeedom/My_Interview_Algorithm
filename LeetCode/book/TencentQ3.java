package book;

import java.util.Scanner;

/**
 * @author:leedom
 * @date: 6/22/19 2:45 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class TencentQ3 {
    private static int N = 10005;
    private static double inf = 1e9;
    private static P[] a = new P[N];

    private static int[] b = new int[N];
    private static int[] b2 = new int[N];
    private static int cnt, head, tail;
    private static int[] ans1 = new int[N];
    private static int[] ans2 = new int[N];
    private static node[] e = new node[N];
    static class P {
        int value;
        int pos;

        public P() {
            this.value = 0;
            this.pos = 0;
        }
    }

    static class node {
        int value;
        int next, pre;

        public node() {
            this.value = 0;
            this.next = 0;
            this.pre = 0;
        }
    }

    public static boolean cmp(P x, P y) {
        return x.value < y.value;
    }

    public static void init() {
        cnt = 2;
        head = 1;
        tail = 2;
        e[head].next = tail;
        e[tail].pre = head;
    }

    public static void ins(int pos, int x) {
        //在pos位置后面再加一个数x
        e[++cnt].value = x;
        e[cnt].next = e[pos].next;
        e[cnt].pre = pos;
        e[e[pos].next].pre = cnt;
        e[pos].next = cnt;
    }

    public static void del(int pos) {
        e[e[pos].next].pre = e[pos].pre;
        e[e[pos].pre].next = e[pos].next;
    }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
//            a[i].value = sc.nextInt();
            a[i].value = 4;
            a[i].pos = i;
        }
        //自定义排序算法实现根据某个属性排列
//        Arrays.sort(a,1,n+1,cmp);
        for(int k = 1; k <= n+1; k++) {
            for (int j = 1; j <= n+1-k; j++) {
                if(a[j].value > a[j+1].value) {
//                    swap(a,j,j+1);
                }
            }
        }
        init();
        for(int i = 1; i <= n; i++) {
            ins(e[tail].pre, a[i].value);
            b[a[i].pos] = cnt;
            b2[cnt] = a[i].pos;
        }

        for(int i = n; i >= 2; i--) {
            ans1[i] = (int)inf;
            if(e[b[i]].next != tail) {
                ans1[i] = Math.min(ans1[i], Math.abs(e[b[i]].value - e[e[b[i]].next].value));
                ans2[i] = b2[e[b[i]].next];
            }
            if(e[b[i]].pre !=head) {
                if(ans1[i] >= Math.abs(e[b[i]].value - e[e[b[i]].pre].value)) {
                    ans1[i] = Math.abs(e[b[i]].value - e[e[b[i]].pre].value);
                    ans2[i] = b2[e[b[i]].pre];
                }
            }
            del(b[i]);

        }
        for(int i = 2; i <= n; i++) {
            System.out.println(ans1[i] +", "+ans2[i]);
        }
        return;
    }
}
