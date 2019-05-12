package offer;

import java.util.Stack;

/**
 * @author:leedom
 * @date: 5/12/19 9:13 PM
 * Description:用两个栈实现一个队列,完成队列的push和pop的操作
 * 先放到一个栈中,然后退栈的时候放到另外一个栈中
 * License: (C)Copyright 2019
 */
public class Question9 {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception{
        if(out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if(out.isEmpty()) {
            throw new Exception("queue is empty!");
        }

        return out.pop();
    }
}
