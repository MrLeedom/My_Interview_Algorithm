package com.leedom;

/**
 * @author:leedom
 * @date: 3/27/19 11:57 AM
 * Description:堆
 *      最大堆 和 最小堆
 *    堆是弱序的,想要遍历堆是很困难的,基本上,堆不支持遍历的.
 *    在查找的过程中,也没有足够的信息支撑选择通过节点的两个子节点中的哪一个来选择走向下一层,所以也很难在堆中查找元素
 *    但是,快速的删除和插入一个元素对于堆来说又是非常方便的.
 * License: (C)Copyright 2019
 */
class KeyNode {
    private int data;
    public KeyNode(int key) {
        data = key;
    }

    public int getKey() {
        return data;
    }

    public void setKey(int key) {
        data = key;
    }
}
public class Heap {
    /**
     * 删除的话删除根,再跟最大的子节点值交换
     * 添加的话加入到最后一个子节点上,再一步步往上交换
     * 节点的左子节点:2 * index + 1
     * 节点的右子节点:2 * index + 2
     * 节点的父节点: (index - 1) / 2
     */
    private KeyNode[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int max) {
        maxSize = max;
        currentSize = 0;
        heapArray = new KeyNode[maxSize];
    }

    public boolean isEmpty() {
        return (currentSize == 0 ? true : false);
    }

    public boolean isFull() {
        return (currentSize == maxSize ? true : false);
    }

    public boolean insert(int key) {
        if(isFull()) {
            return false;
        }
        KeyNode newNode = new KeyNode(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    /***************************************  向上调整  *******************************************************************/
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        KeyNode bottom = heapArray[index];
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    /******************************************  删除操作  *****************************************************************/
    public KeyNode remove() {
        KeyNode root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        tickleDown(0);
        return root;
    }

    /********************************************  向下调整  ****************************************************************/
    public void tickleDown(int index) {
        KeyNode top = heapArray[index];
        int largeChildIndex;
        while (index < currentSize ) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            //find larger child
            if(rightChildIndex < currentSize && heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }

            if(top.getKey() >= heapArray[largeChildIndex].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = top;
    }

    /******************************************  修改堆中某元素的值  **************************************************************/
    public boolean change(int index, int newValue) {
        if(index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if(oldValue < newValue) {
            trickleUp(index);
        } else {
            tickleDown(index);
        }
        return true;
    }

    /********************************************  展示堆中的数据  ************************************************************/
    public void displayHeap() {
        System.out.println("heapArray(array format):");
        for(int i = 0; i < currentSize; i++) {
            if(heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.println("--");
            }
        }
    }


    /**********************************************  测试  *************************************************************************/
    public static void main(String[] args){
        Heap heap = new Heap(12);
        System.out.println("=================");
        heap.insert(55);
        heap.insert(37);
        heap.insert(10);
        heap.insert(43);
        heap.insert(82);
        heap.insert(70);
        heap.insert(51);
        heap.insert(63);

        heap.insert(27);
        heap.insert(30);
        heap.insert(34);
        heap.displayHeap();
    }
}
