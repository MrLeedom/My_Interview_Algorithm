package com.leedom;

/**
 * @author:leedom
 * @date: 3/27/19 8:07 PM
 * Description:
 *      在二叉树中,每个节点只有一个数据项,最多有两个子节点,如果允许每个节点可以有更多的数据项和更多的子节点,就是多叉树.
 *    1.有一个数据项的节点总是有两个子节点
 *    2.有两个数据项的节点总是有三个子节点
 *    3.有三个数据项的节点总是有四个子节点
 *    简而言之,非叶子节点的子节点个数总是会比它含有的数据项多1.
 *                         50
 *                     /          \
 *                  30          60   70    80
 *                 /   \       /    \      \     \
 *             10 20   40   55   62 64 68   75   83 86
 * License: (C)Copyright 2019
 */
/******************  数据项  **************************/
class DataItem234 {
    public long data;
    
    public DataItem234(long data) {
        this.data = data;
    }
    
    public void displayItem() {
        System.out.println("/" + data);
    }
}

/********************  节点  ***************************/
class Node234 {
    private static final int ORDER = 4;
    //表示该节点有多少个数据项
    private int numItems;
    //父节点
    private Node234 parent;
    //存储子节点的数组,最多有4个子节点
    private Node234[] childArray = new Node234[ORDER];
    //存放数据项的数组,一个节点最多有三个数据项
    private DataItem234[] itemArray = new DataItem234[ORDER - 1];
    
    //连接子节点
    public void connectChild(int childNum, Node234 child) {
        childArray[childNum] = child;
        if(child != null) {
            child.parent = this;
        }
    }
    
    //断开与子节点的连接,并返回该子节点
    public Node234 disconnectChild(int childNum) {
        Node234 tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }
    
    //得到节点的某个子节点
    public Node234 getChild(int childNum) {
        return childArray[childNum];
    }
    
    //得到父节点
    public Node234 getParent() {
        return parent;
    }
    
    //判断是都是叶节点
    public boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }
    
    //得到节点数据项的个数
    public int getNumItems() {
        return numItems;
    }
    
    //得到节点的某个数据项
    public DataItem234 getItem(int index) {
        return itemArray[index];
    }
    
    //判断节点的数据项是否满了(最多三个)
    public boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }
    
    //找到数据项在节点中的位置
    public int findItem(long key) {
        for(int j = 0; j < ORDER - 1; j++) {
            if(itemArray[j] == null) {
                break;
            } else if(itemArray[j].data == key) {
                return j;
            }
        }
        return -1;
    }
    
    //将数据项插入到节点
    public int insertItem(DataItem234 newItem) {
        numItems++;
        long newKey = newItem.data;
        for(int j = ORDER - 2; j >= 0; j--) {
            if(itemArray[j] == null) {
                //如果为空,继续向前循环
                continue;
            } else {
                //保存节点某个位置的数据项
                long itsKey = itemArray[j].data;
                //如果比新插入的数据项大
                if(newKey < itsKey) {
                    //将大数据项向后移动一位
                    itemArray[j+1] = itemArray[j];
                } else {
                    //如果比新插入的数据项小,则直接插入
                    itemArray[j+1] = newItem;
                    return j + 1;
                }
            }
        }
        //如果都为空,或者都比待插入的数据项大,则将待插入的数据项放在节点第一个位置
        itemArray[0] = newItem;
        return 0;
    }
    
    //移除节点的数据项
    public DataItem234 removeItem() {
        DataItem234 temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems-- ;
        return temp;
    }
    
    //打印节点的所有数据项
    public void displayNode() {
        for(int j = 0; j < numItems; j++) {
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }
    
}
/***********************  2-3-4 树  ***************************************/
public class Tree234 {
    private Node234 root = new Node234();

    //查找关键字值
    public int find(long key) {
        Node234 curNode = root;
        int childNumber;
        while(true) {
            if((childNumber = curNode.findItem(key)) != -1) {
                return childNumber;
            } else if(curNode.isLeaf()) {
                //节点是叶节点
                return -1;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public Node234 getNextChild(Node234 theNode, long theValue) {
        int j;
        int numItems = theNode.getNumItems();
        for(j = 0; j < numItems; j++) {
            if(theValue < theNode.getItem(j).data) {
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }

    //插入数据项
    public void insert(long value) {
        Node234 curNode = root;
        DataItem234 tempItem = new DataItem234((value));
        while (true) {
            if(curNode.isFull()) {
                //如果节点满数据项了,则分裂节点
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, value);
            } else if(curNode.isLeaf()) {
                //当前节点是叶节点
                break;
            } else {
                curNode = getNextChild(curNode, value);
            }
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node234 thisNode) {
        DataItem234 itemB, itemC;
        Node234 parent, child2, child3;
        int itemIndex;
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node234 newRight = new Node234();
        if(thisNode == root) {
            //如果当前节点是根节点,执行根分裂
            root = new Node234();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }
        //处理父节点
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for(int j = n-1; j > itemIndex; j--) {
            Node234 temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }
        parent.connectChild(itemIndex+1,newRight);

        //处理新建的右节点
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1,child3);
    }

    //打印树节点
    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node234 thisNode, int level, int childNumber) {
        System.out.println("level=" + level + "child="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for(int j = 0; j < numItems + 1; j++) {
            Node234 nextNode = thisNode.getChild(j);
            if(nextNode != null) {
                recDisplayTree(nextNode, level+1, j);
            } else {
                return;
            }
        }
    }
}
