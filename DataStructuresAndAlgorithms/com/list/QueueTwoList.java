package com.list;

import java.util.Stack;

/**
 * @author:leedom
 * @date: 6/10/19 9:01 PM
 * Description:利用两个栈,实现队列(栈的特点是先进后出,队列的特点是先进先出,使用两个栈正好能将顺序反过来实现类似队列的操作)
 * License: (C)Copyright 2019
 */
public class QueueTwoList {
    private Stack<Object> stackPush;
    private Stack<Object> stackPop;

    public QueueTwoList(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    //队列的入队操作,主要是进stackPush栈
    public void add(Object obj){
        stackPush.add(obj);
    }

    //队列的poll方法,主要是stackPop栈进行弹出
    public Object poll() {
        if(stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()) {
                stackPop.add(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    //队列的peek方法
    public Object peek() {
        if(stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()) {
                stackPop.add(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
    
    public static void main(String[] args){
        QueueTwoList queue = new QueueTwoList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
