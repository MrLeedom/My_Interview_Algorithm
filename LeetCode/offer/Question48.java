package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:leedom
 * @date:2019/7/11 23:01
 * Description:请实现一个函数用来找出字符流只出现一次的字符。例如，当从字符流中只读出前两个字符“go”时，第一个只出现一次的字符
 *      是“g”。当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是“l”
 * License: (C)Copyright 2019
 */
public class Question48 {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while(!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char firstAppearingOne() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
