package com.leedom;

import java.lang.management.LockInfo;

/**
 * @author:leedom
 * @date: 3/27/19 12:53 PM
 * Description:哈希表
 *      将很大的区间映射到小范围中,开放地址法:往后挪动
 *          链地址法;数组中每个元素存放的是一个链表
 * License: (C)Copyright 2019
 */
class DataItem {
    private int data;
    public DataItem(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
}
/****************************************  采用开放地址法  ************************************************************/
public class HashTable {
    //DataItem类,表示每个数据项信息
    private DataItem[] hashArray;
    //数组的初始大小
    private int arraySize;
    //数组实际存储了多少项数据
    private int itemNum;
    //用于删除数据项
    private DataItem nonItem;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        //删除的数据项下标为-1
        nonItem = new DataItem(-1);
    }
    //判断数组是否存储满了
    public boolean isFull() {
        return (itemNum == arraySize);
    }
    //判断数组是否为空
    public boolean isEmpty() {
        return (itemNum == 0);
    }

    //打印数组内容
    public void display() {
        System.out.println("Table:");
        for(int i = 0; i < arraySize; i++) {
            if(hashArray[i] != null) {
                System.out.println(hashArray[i].getData() + " ");
            } else {
                System.out.println("** ");
            }
        }
    }

    //通过哈希函数转换得到数组下标
    public int hashFunction(int key) {
        return key % arraySize;
    }

    //插入数据项
    public void insert(DataItem item) {
        if(isFull()) {
            //扩展哈希表
            System.out.println("hashtable is full,please reload again!");
            extendHashTable();
        }
        int key = item.getData();
        int hashVal = hashFunction(key);
        while(hashArray[hashVal] != null && hashArray[hashVal].getData() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        itemNum ++ ;
    }
    /**
     * 数组有固定的大小,而且不能扩展,所以扩展哈希表只能另外创建一个更大的数组,然后把旧数组中的数据插到新数组中
     * 但是哈希表是根据数组大小计算给定数据的位置的,所以这些数据项不能再放在新数组中和老数组相同的位置上.
     * 因此不能直接拷贝,需要按顺序遍历老数组,并使用insert方法向新数组中插入每个数据项
     * 这个过程叫做重新哈希化.这是一个耗时的过程,但如果数组要进行扩展,这个过程是必须的.
     */
    public void extendHashTable() {
        int num = arraySize;
        //重新计数,因为下面要把原来的数据转移到新的扩张的数组中
        itemNum = 0;
        //数组大小翻倍
        arraySize *= 2;
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];
        for(int i = 0; i < num; i++) {
            insert(oldHashArray[i]);
        }
    }

    //删除数据项
    public DataItem delete(int key) {
        if(isEmpty()) {
            System.out.println("Hash Table is Empty!");
            return null;
        }
        int hashVal = hashFunction(key);
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getData() == key) {
                DataItem temp = hashArray[hashVal];
                //nonItem表示空item,其key为-1
                hashArray[hashVal] = nonItem;
                itemNum--;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    //查找数据项
    public DataItem find(int key) {
        int hashVal = hashFunction(key);
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getData() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    /*************************  测试  ***********************************/
    public static void main(String[] args){
        HashTable table = new HashTable(10);
        DataItem item = new DataItem(10);
        table.insert(item);
        table.display();

    }
}

/*********************************** 另外一种策略是链地址法  **********************************************/
class LinkNode {
    private int data;
    public LinkNode next;
    public LinkNode(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public void displayLink() {
        System.out.println(data + " ");
    }
}
class SortLink {
    private LinkNode first;
    public SortLink() {
        first = null;
    }
    public boolean isEmpty() {
        return (first == null);
    }
    /************************  插入节点  *****************************************/
    public void insert(LinkNode node) {
        int key = node.getData();
        LinkNode previous = null;
        LinkNode current = first;
        while(current != null && current.getData() < key) {
            previous = current;
            current = current.next;
        }
        if(previous == null) {
            first = node;
        } else {
            previous.next = node;
        }
        node.next = current;
    }
    /************************  删除节点  *****************************************/
    public void delete(int key) {
        LinkNode previous = null;
        LinkNode current = first;
        if(isEmpty()) {
            System.out.println("Linked is empty!");
            return;
        }
        
        while(current != null && current.getData() != key) {
            previous = current;
            current = current.next;
        }
        if(previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }
    
    /****************************  查询节点  ***************************************/
    public LinkNode find(int key) {
        LinkNode current = first;
        while(current != null && current.getData() <= key) {
            if(current.getData() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    /****************************  链接点展示  ******************************************/
    public void displayLink() {
        System.out.println("Link(first --->  last)");
        LinkNode current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}

class HashChain {
    //数组中存放链表
    private SortLink[] hashArray;
    private int arraySize;
    public HashChain(int size) {
        arraySize = size;
        hashArray = new SortLink[arraySize];
        //new出每个空链表初始化数组
        for(int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable() {
        for(int i = 0; i < arraySize; i++) {
            System.out.println(i + ": ");
            hashArray[i].displayLink();
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    public void insert(LinkNode node) {
        int key = node.getData();
        int hashVal = hashFunction(key);
        //直接往链表中添加即可
        hashArray[hashVal].insert(node);
    }

    public LinkNode delete(int key) {
        int hashVal = hashFunction(key);
        LinkNode temp = find(key);
        //从链表中找到要删除的数据项,直接删除
        hashArray[hashVal].delete(key);
        return temp;
    }

    public LinkNode find(int key) {
        int hashVal = hashFunction(key);
        LinkNode node = hashArray[hashVal].find(key);
        return node;
    }
}
