package com.leedom;

/**
 * @author:leedom
 * @date: 3/25/19 7:47 PM
 * Description:
 * License: (C)Copyright 2019
 */
//class Node {
//    //左节点
//    private Node left;
//    //右节点
//    private Node right;
//    //节点值
//    private int value;
//
//    private boolean isDelete;
//
//    public Node() {
//        super();
//    }
//    public Node(int value) {
//        this(null, null, value, false);
//    }
//
//    public Node(Node left, Node right, int value, boolean isDelete) {
//        super();
//        this.left = left;
//        this.right = right;
//        this.value = value;
//        this.isDelete = isDelete;
//    }
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//
//    public boolean isDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(boolean delete) {
//        isDelete = delete;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
//    public void setRight(Node right) {
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return "BinaryTree{" +
//                "left=" + left +
//                ", right=" + right +
//                ", value=" + value +
//                ", isDelete=" + isDelete +
//                '}';
//    }
//}
//
//public class BinaryTree {
//    //根节点
//    private Node root;
//
//    public Node getRoot(){
//        return root;
//    }
//
//    /* 插入操作 */
//    public void insert(int value) {
//        Node newNode = new Node(value);
//
//        if(root == null) {
//            root = newNode;
//            root.setLeft(null);
//            root.setRight(null);
//        } else {
//            Node currentNode = root;
//            Node parentNode;
//            while(true) {
//                parentNode = currentNode;
//                //往右放
//                if(newNode.getValue() > currentNode.getValue()) {
//                    currentNode = currentNode.getRight();
//                    if(currentNode == null) {
//                        parentNode.setRight(newNode);
//                        return;
//                    }
//                } else {
//                   //往左边放
//                   currentNode = currentNode.getLeft();
//                   if(currentNode == null) {
//                       parentNode.setLeft(newNode);
//                       return;
//                   }
//                }
//            }
//        }
//    }
//
//
//    /*****************   查找    *********************/
//    public Node find(int key) {
//        Node currentNode = root;
//        if(currentNode != null) {
//            while(currentNode.getValue() != key) {
//                if(currentNode.getValue() > key) {
//                    currentNode = currentNode.getLeft();
//                } else {
//                    currentNode = currentNode.getRight();
//                }
//                if(currentNode == null) {
//                    return null;
//                }
//            }
//            if(currentNode.isDelete()) {
//                return null;
//            } else {
//                return currentNode;
//            }
//        } else {
//            return null;
//        }
//    }
//
//    /***********************  中序遍历  ******************************/
//    public void inOrder(Node currentNode) {
//        if(currentNode != null && currentNode.isDelete() == false) {
//            inOrder(currentNode.getLeft());
//            System.out.println("--" + currentNode.getValue());
//            inOrder(currentNode.getRight());
//        }
//    }
//
//    /**************************  测试  *************************************/
//    public static void main(String[] args){
//        BinaryTree tree = new BinaryTree();
//        //添加数据测试
//        tree.insert(10);
//        tree.insert(40);
//        tree.insert(20);
//        tree.insert(3);
//        tree.insert(49);
//        tree.insert(13);
//        tree.insert(123);
//        
//        System.out.println("root" + tree.getRoot().getValue());
//        
//        //排序测试
//        tree.inOrder(tree.getRoot());
//        //查找测试
//        if(tree.find(10) != null) {
//            System.out.println("found!");
//        } else {
//            System.out.println("no found!");
//        }
//        //删除测试
//        tree.find(40).setDelete(true);
//        if(tree.find(40) != null) {
//            System.out.println("found");
//        } else {
//            System.out.println("no found");
//        }
//    }
//}


import java.util.Stack;

/************************************  二叉搜索树  ***************************************/
class Node {
    //节点数据
    int data;
    //左子节点的引用
    Node left;
    //右子节点的引用
    Node right;
    //表示节点是否被删除
    boolean isDelete;

    public Node(int data) {
        this.data = data;
    }
    //打印节点信息
    public void display() {
        System.out.println("Node:"+data);
    }
}

interface Tree {
    //查找节点
    public Node find(int key);

    //插入新节点
    public boolean insert(int key);

    //中序遍历
    public void infixOrder(Node current);

    //前序遍历
    public void preOrder(Node current);

    //后序遍历
    public void postOrder(Node current);

    //非递归方式中序遍历
    public void infixOrderUnRecur(Node current);
    //非递归方式前序遍历
    public void preOrderUnRecur(Node current);
    //非递归遍历后序遍历
    public void postOrderUnRecur(Node current);

    //查找最大值
    public Node findMax();

    //查找最小值
    public Node findMin();

    //删除节点
    public boolean delete(int key);
    //other methods
}

public class BinaryTree implements Tree {
    //表示根节点
    private Node root;

    //查找节点
    @Override
    public Node find(int key) {
        Node current = root;
        while(current != null) {
            if(current.data > key) {
                current = current.left;
            } else if(current.data < key) {
                current = current.right;
            } else {
                return current;
            }
        }
        //遍历完整个树没找到,返回NULL
        return null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(root == null) {
            //当前树为空树,没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while(current != null) {
                parentNode = current;
                if(current.data > data) {
                    //当前值比插入值大,搜索左子节点
                    current = current.left;
                    if(current == null) {
                        parentNode.left = newNode;   
                        return true;
                    }
                }else{
                    current = current.right;
                    if(current == null) {
                        parentNode.right = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //中序遍历
    @Override
    public void infixOrder(Node current) {
        if(current != null) {
            infixOrder(current.left);
            System.out.println(current.data + " ");
            infixOrder(current.right);
        }
    }
    
    //前序遍历
    @Override
    public void preOrder(Node current) {
        if(current != null){
            System.out.println(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }
    
    //后序遍历
    @Override
    public void postOrder(Node current) {
        if(current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.data + " ");
        }
    }
    
    @Override
    public void preOrderUnRecur(Node current) {
        System.out.println("pre-order");
        if(current != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(current);
            while(!stack.isEmpty()) {
                current = stack.pop();
                System.out.println(current.data + " ");
                if(current.right != null) {
                    stack.push(current.right);
                }
                if(current.left != null) {
                    stack.push(current.left);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void infixOrderUnRecur(Node current) {
        System.out.println("infix-order:");
        if(current != null) {
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty() || current!=null) {
                if(current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    System.out.println(current.data + " ");
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void postOrderUnRecur(Node current) {
        System.out.println("pre-order");
        if(current != null) {
            Stack<Node> stack = new Stack<Node>();
            Stack<Node> outstack = new Stack<Node>();
            stack.add(current);
            while(!stack.isEmpty()) {
                current = stack.pop();
                outstack.push(current);
                if(current.left != null) {
                    stack.push(current.left);
                }
                if(current.right != null) {
                    stack.push(current.right);
                }
            }
            while(!outstack.isEmpty()) {
                System.out.println(outstack.pop() + " ");
            }
        }
        System.out.println();
    }


    //找到最大值
    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while(current != null) {
            maxNode = current;
            current = current.right;
        }
        return maxNode;
    }

    //找到最小值
    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while(current != null) {
            minNode = current;
            current = current.left;
        }
        return minNode;
    }

    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值,找不到直接返回false
        while(current.data != key){
            parent = current;
            if(current.data > key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if(current == null){
                return false;
            }
        }

        //如果当前节点没有子节点
        if(current.left == null && current.right == null) {
            if(current == root){
                root = null;
            } else if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;

            }
            return true;
        } else if(current.left == null && current.right != null) {
            if(current == root) {
                root = current.right;
            } else if(isLeftChild) {
                parent.left = current.right;
            } else{
                parent.right = current.right;
            }
            return true;
        } else if (current.left != null && current.right == null) {
            if(current == root) {
                root = current.left;
            } else if(isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            return true;
        } else {
            //当前节点存在两个子节点
            Node successor = getSucccessor(current);
            if(current == root) {
                root = successor;
            }else if(isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return false;
    }
    
    public Node getSucccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //后继节点不是删除节点的右子节点,将后继节点替换删除节点
        if(successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }
    
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.insert(10);
        bt.insert(30);
        bt.insert(80);
        bt.delete(10);
        bt.delete(30);
        bt.delete(80);
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
    }
}