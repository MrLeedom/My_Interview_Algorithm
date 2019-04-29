package com.leedom;

/**
 * @author:leedom
 * @date: 3/28/19 9:24 AM
 * Description:
 *      链表是一种常见的基础数据结构,是一种线性表,但是并不会按线性的顺序存储数据,而是在每一个节点里存到下一个节点的指针
 *      使用链表结构可以克服数组链表需要预先知道数据大小的缺点,链表结构可以充分利用计算机内存空间,实现灵活的内存动态管理.
 *      但是链表失去了数组随机读取的优点,同时链表由于增加了节点的指针域,空间开销比较大.
 *  双端链表和双向链表的区别:其中双端是指对两端进行不同的操作,类似队列的感觉,双向是指节点有两个指针,一个指向前节点,一个指向后节点
 * License: (C)Copyright 2019
 */
public class LinkedList {
    /***************************************  单向链表  *****************************************************/
    static class SingleLinkedList {
        //链表节点的个数
        private int size;
        //头节点
        private Node head;

        public SingleLinkedList(){
            size = 0;
            head = null;
        }

        //链表的每个节点类
        private class Node{
            //每个节点的数据
            private Object data;
            //每个节点指向下一个节点的连接
            private Node next;

            public Node(Object data){
                this.data = data;
            }
        }

        //在链表头添加元素
        public Object addHead(Object obj){
            Node newHead = new Node(obj);
            if(size == 0){
                head = newHead;
            }else{
                newHead.next = head;
                head = newHead;
            }
            size++;
            return obj;
        }

        //在链表头删除元素
        public Object deleteHead(){
            Object obj = head.data;
            head = head.next;
            size--;
            return obj;
        }

        //查找指定元素，找到了返回节点Node，找不到返回null
        public Node find(Object obj){
            Node current = head;
            int tempSize = size;
            while(tempSize > 0){
                if(obj.equals(current.data)){
                    return current;
                }else{
                    current = current.next;
                }
                tempSize--;
            }
            return null;
        }

        //删除指定的元素，删除成功返回true
        public boolean delete(Object value){
            if(size == 0){
                return false;
            }
            Node current = head;
            Node previous = head;
            while(current.data != value){
                if(current.next == null){
                    return false;
                }else{
                    previous = current;
                    current = current.next;
                }
            }
            //如果删除的节点是第一个节点
            if(current == head){
                head = current.next;
                size--;
            }else{
                //删除的节点不是第一个节点
                previous.next = current.next;
                size--;
            }
            return true;
        }

        //判断链表是否为空
        public boolean isEmpty(){
            return (size == 0);
        }

        //显示节点信息
        public void display(){
            if(size >0){
                Node node = head;
                int tempSize = size;
                //当前链表只有一个节点
                if(tempSize == 1){
                    System.out.println("["+node.data+"]");
                    return;
                }
                while(tempSize>0){
                    if(node.equals(head)){
                        System.out.print("["+node.data+"->");
                    }else if(node.next == null){
                        System.out.print(node.data+"]");
                    }else{
                        System.out.print(node.data+"->");
                    }
                    node = node.next;
                    tempSize--;
                }
                System.out.println();
            }else{//如果链表一个节点都没有，直接打印[]
                System.out.println("[]");
            }

        }

    }
    /******************************************  使用单向链表实现栈  *****************************************************/
    static class StackSingleLink {
        private SingleLinkedList link;

        public StackSingleLink() {
            link = new SingleLinkedList();
        }
        //添加元素
        public void push(Object obj) {
            link.addHead(obj);
        }
        //移除栈顶元素
        public Object pop() {
            Object obj = link.deleteHead();
            return obj;
        }

        //判断是否为空
        public boolean isEmpty() {
            return link.isEmpty();
        }

        //打印栈内元素信息
        public void display() {
            link.display();
        }
    }
    /****************************************** 双端链表  **************************************************************/
    class DoublePointLinkedList {
        //头节点
        private Node head;
        //尾节点
        private Node tail;
        //节点的个数
        private int size;

        private class Node{
            private Object data;
            private Node next;

            public Node(Object data){
                this.data = data;
            }
        }

        public DoublePointLinkedList(){
            size = 0;
            head = null;
            tail = null;
        }

        //链表头新增节点
        public void addHead(Object data){
            Node node = new Node(data);
            if(size == 0){
                //如果链表为空，那么头节点和尾节点都是该新增节点
                head = node;
                tail = node;
                size++;
            }else{
                node.next = head;
                head = node;
                size++;
            }
        }

        //链表尾新增节点
        public void addTail(Object data){
            Node node = new Node(data);
            if(size == 0){
                //如果链表为空，那么头节点和尾节点都是该新增节点
                head = node;
                tail = node;
                size++;
            }else{
                tail.next = node;
                tail = node;
                size++;
            }
        }

        //删除头部节点，成功返回true，失败返回false
        public boolean deleteHead(){
            if(size == 0){
                //当前链表节点数为0
                return false;
            }
            if(head.next == null){
                //当前链表节点数为1
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
            size--;
            return true;
        }
        //判断是否为空
        public boolean isEmpty(){
            return (size ==0);
        }
        //获得链表的节点个数
        public int getSize(){
            return size;
        }

        //显示节点信息
        public void display(){
            if(size >0){
                Node node = head;
                int tempSize = size;
                if(tempSize == 1){
                    //当前链表只有一个节点
                    System.out.println("["+node.data+"]");
                    return;
                }
                while(tempSize>0){
                    if(node.equals(head)){
                        System.out.print("["+node.data+"->");
                    }else if(node.next == null){
                        System.out.print(node.data+"]");
                    }else{
                        System.out.print(node.data+"->");
                    }
                    node = node.next;
                    tempSize--;
                }
                System.out.println();
            }else{//如果链表一个节点都没有，直接打印[]
                System.out.println("[]");
            }
        }

    }

    /**************************************  使用双端链表实现队列  ******************************************************************/
    class QueueLinkedList {
        private DoublePointLinkedList dp;

        public QueueLinkedList() {
            dp = new DoublePointLinkedList();
        }

        public void insert(Object data) {
            dp.addTail(data);
        }

        public void delete() {
            dp.deleteHead();
        }

        public boolean isEmpty() {
            return dp.isEmpty();
        }

        public int getSize() {
            return dp.getSize();
        }

        public void display() {
            dp.display();
        }
    }

    /*************************************  有序链表  ************************************************************/
    class OrderLinkedList {
        private Node head;

        private class Node{
            private int data;
            private Node next;

            public Node(int data){
                this.data = data;
            }
        }

        public OrderLinkedList(){
            head = null;
        }

        //插入节点，并按照从小大到的顺序排列
        public void insert(int value){
            Node node = new Node(value);
            Node pre = null;
            Node current = head;
            while(current != null && value > current.data){
                pre = current;
                current = current.next;
            }
            if(pre == null){
                head = node;
                head.next = current;
            }else{
                pre.next = node;
                node.next = current;
            }
        }

        //删除头节点
        public void deleteHead(){
            head = head.next;
        }

        public void display(){
            Node current = head;
            while(current != null){
                System.out.print(current.data+" ");
                current = current.next;
            }
            System.out.println(" ");
        }

    }
    /******************************************** 双向链表  *************************************************************/
    class TwoWayLinkedList {
        //表示链表头
        private Node head;
        //表示链表尾
        private Node tail;
        //表示链表的节点个数
        private int size;

        private class Node{
            private Object data;
            private Node next;
            private Node prev;

            public Node(Object data){
                this.data = data;
            }
        }

        public TwoWayLinkedList(){
            size = 0;
            head = null;
            tail = null;
        }

        //在链表头增加节点
        public void addHead(Object value){
            Node newNode = new Node(value);
            if(size == 0){
                head = newNode;
                tail = newNode;
                size++;
            }else{
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
                size++;
            }
        }

        //在链表尾增加节点
        public void addTail(Object value){
            Node newNode = new Node(value);
            if(size == 0){
                head = newNode;
                tail = newNode;
                size++;
            }else{
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
                size++;
            }
        }

        //删除链表头
        public Node deleteHead(){
            Node temp = head;
            if(size != 0){
                head = head.next;
                head.prev = null;
                size--;
            }
            return temp;
        }

        //删除链表尾
        public Node deleteTail(){
            Node temp = tail;
            if(size != 0){
                tail = tail.prev;
                tail.next = null;
                size--;
            }
            return temp;
        }

        //获得链表的节点个数
        public int getSize(){
            return size;
        }
        //判断链表是否为空
        public boolean isEmpty(){
            return (size == 0);
        }

        //显示节点信息
        public void display(){
            if(size >0){
                Node node = head;
                int tempSize = size;
                if(tempSize == 1){//当前链表只有一个节点
                    System.out.println("["+node.data+"]");
                    return;
                }
                while(tempSize>0){
                    if(node.equals(head)){
                        System.out.print("["+node.data+"->");
                    }else if(node.next == null){
                        System.out.print(node.data+"]");
                    }else{
                        System.out.print(node.data+"->");
                    }
                    node = node.next;
                    tempSize--;
                }
                System.out.println();
            }else{//如果链表一个节点都没有，直接打印[]
                System.out.println("[]");
            }

        }
    }

    public static void main(String[] args){
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead('A');
        singleList.addHead('B');
        singleList.addHead('C');
        singleList.addHead('D');
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete('C');
        singleList.display();
        //查找B
        System.out.println(singleList.find('B'));
    }

}
