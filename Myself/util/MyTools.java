package util;

import com.list.Node;

/**
 * @author:leedom
 * @date:2019/6/26 23:11
 * Description: 私人定制工具包文件，后期也将添加对数器等工具
 * License: (C)Copyright 2019
 */
public class MyTools {
    /**
     * 打印数组元素
     * @param array
     */
    public void printArray(int[] array) {
        if(array==null){
            return;
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 交换数组两个元素的值
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    /**
     * 生成链表
     */
    public Node generateList() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(9);
        Node node5 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    /**
     * 打印链表结果结构
     * @param head
     */
    public void printList(Node head) {
        if(head == null) {
            System.out.println("链表为空！！！");
        }
        while(head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print(head.value);
    }
}
