package BasicClass;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * @author:leedom
 * @date: 4/15/19 7:25 PM
 * Description:
 * 1.用数组实现栈,和队列
 * 2.实现一个特殊的栈,在实现栈的基础上,再返回栈中最小元素的操作,要求:pop,push,getMin操作的时间复杂度都是O(1)
 * License: (C)Copyright 2019
 */
public class Array_to_Stack_Queue {
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if(initSize < 0) {
                throw new IllegalArgumentException("the init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if(size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj) {
            if(size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the stack is full");
            }
            arr[size++] = obj;
        }

        public Integer pop() {
            if(size == 0) {
                throw new ArrayIndexOutOfBoundsException("the stack is empty");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer begin;
        private Integer end;

        public ArrayQueue(int initSize) {
            if(initSize < 0) {
                throw new IllegalArgumentException("the init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            begin = 0;
            end = 0;
        }

        public Integer peek() {
            if(size == 0) {
                return null;
            }
            return arr[begin];
        }

        public void push(int obj) {
            if(size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }
            size ++;
            arr[end] = obj;
            end = end == arr.length -1 ? 0 : end + 1;
        }

        public Integer poll() {
            if(size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            size--;
            int temp = begin;
            begin = begin == arr.length -1 ? 0 : begin + 1;
            return arr[temp];
        }
    }

    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if(this.stackMin.empty()) {
                this.stackMin.push(newNum);
            } else if(newNum < this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
        }

        public int pop() {
            if(this.stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }


        public int getmin() {
            if(this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
