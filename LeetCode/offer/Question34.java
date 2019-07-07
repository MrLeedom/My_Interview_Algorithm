package offer;

import java.util.Stack;

/**
 * @author:leedom
 * @date:2019/7/7 19:11
 * Description:定义一个栈的数据结构，请再改类型中实现一个能够得到栈中所含最小元素的min函数，时间复杂度为O(1)
 * License: (C)Copyright 2019
 */
public class Question34 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public  void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public void top() {
        dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
