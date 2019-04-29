package com.leedom;

/**
 * @author:leedom
 * @date: 3/28/19 2:09 PM
 * Description:     队列
 *  队列是一种特殊的线性表,特殊之处在于它只允许在表的前端front进行删除操作,而在表的后端rear进行插入操作,和栈一样,队列是一种操作受限制的线性表.
 *  进行插入操作的端称为队尾,进行删除操作的端称为队头.队列中没有元素时,称为空队列.
 * License: (C)Copyright 2019
 */
/************************************  采用数组来做单端队列  *******************************************************/
public class OneWayQueue {
    private Object[] queArray;
    //队列总大小
    private int maxSize;
    //前端
    private int front;
    //后端
    private int rear;
    //队列中元素的实际数目
    private int nItems;

    public OneWayQueue(int s){
        maxSize = s;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //队列中新增数据
    public void insert(int value){
        if(isFull()){
            System.out.println("队列已满！！！");
        }else{
            //如果队列尾部指向顶了，那么循环回来，执行队列的第一个元素
            if(rear == maxSize -1){
                rear = -1;
            }
            //队尾指针加1，然后在队尾指针处插入新的数据
            queArray[++rear] = value;
            nItems++;
        }
    }

    //移除数据
    public Object remove(){
        Object removeValue = null ;
        if(!isEmpty()){
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if(front == maxSize){
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }

    //查看对头数据
    public Object peekFront(){
        return queArray[front];
    }


    //判断队列是否满了
    public boolean isFull(){
        return (nItems == maxSize);
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return (nItems ==0);
    }

    //返回队列的大小
    public int getSize(){
        return nItems;
    }

    /***********************************  单端队列的测试部分  ***************************************************/
    public static void main(String[] args){
        OneWayQueue queue = new OneWayQueue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        //此时队列中已经存满了
        System.out.println(queue.peekFront());
        queue.remove();
        System.out.println(queue.peekFront());

        queue.insert(4);
        queue.insert(5);
    }
}
