package com.leedom;

/**
 * @author:leedom
 * @date: 3/27/19 9:20 AM
 * Description:图
 * 邻接矩阵 和 邻接表
 * 主要探究的点是深度优先遍历(栈) 和 广度优先遍历(队列)
 * License: (C)Copyright 2019
 */

/**
 * 顶点类
 * (此处顶点内只存放一个字母来标识顶点,同时还有一个标志位,用来判断该顶点有没有被访问过)
 */
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
}

/**
 * 栈结构:实现深度优先遍历搜索的栈
 * 规则1:如果可能,访问一个邻接的未访问的顶点,标记它,并将它放入栈中
 * 规则2:当不能执行规则1时,如果栈不为空,就从栈中弹出一个顶点
 * 规则3:如果不能执行规则1和规则2时,就完成了整个搜索过程
 */
class Stack {
    private final int SIZE = 20;
    private int[] data;
    private int top;

    public Stack() {
        data = new int[SIZE];
        top = -1;
    }

    public void push(int i) {
        data[++top] = i;
    }

    public int pop() {
        return data[top--];
    }

    public int peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

/**
 * 队列:实现广度优先遍搜索的队列
 * 规则1:访问下一个未访问的邻接点(如果存在),这个顶点必须是当前顶点的邻接点,标记它,并把它插入到队列中
 * 规则2:如果已经美誉未访问的邻接点而不能执行规则1时,那么从队列列头取出一个顶点(如果存在),并使其称为当前顶点
 * 规则3:如果因为队列为空而不能执行规则2,则搜索结束
 */
class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        this.queArray = new int[SIZE];
        this.front = 0;
        this.rear = -1;
    }

    /****************************  这两处依然用到了类似循环队列的知识  *****************************************/
    public void insert(int i) {
        if(rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = i;
    }

    public int remove() {
        int temp = queArray[front++];
        if(front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front + SIZE - 1 == rear);
    }
}
public class Graph {
    //表示顶点的个数
    private final int MAX_VERTS = 20;
    //用来存储顶点的数组
    private Vertex vertexList[];
    //用邻接矩阵来存储,边,数组元素0表示没有边界,1表示有边界
    private int adjMat[][];
    //顶点个数
    private int nVerts;
    //用栈实现深度优先搜索
    private Stack theStack;
    //用队列实现广度优先搜索
    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        //初始化顶点个数为0
        nVerts = 0;
        //初始化邻接矩阵所有元素都为0,即所有顶点都没有边
        for(int i = 0; i < MAX_VERTS; i++) {
            for(int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new Stack();
        queue = new Queue();
    }

    //将顶点添加到数组中,是否访问标志置为wasVisited=false(访问)
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    //注意用邻接矩阵表示边,是对称的,两部分都要赋值
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //打印某个顶点表示的值
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /**
     * 深度优先搜索算法
     * 1.用peek方法检查栈顶的元素
     * 2.用getAdjUnvisitedVertex方法找到当前的栈顶点邻接点且未被访问的顶点
     * 3.第二步方法返回值不等于-1则找到下一个未访问的邻接点,访问这个顶点,并入栈
     *      如果第二步方法返回值为-1,则没有找到,出栈
     */
    public void depthFirstSearch() {
        //从第一个顶点开始访问
        vertexList[0].wasVisited = true;
        //打印访问的第一个节点
        displayVertex(0);
        //将第一个顶点放入栈中
        theStack.push(0);

        while(!theStack.isEmpty()) {
            //找到栈当前顶点邻接且未被访问的顶点
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1) {
                //如果当前顶点值为-1,则表示没有邻接且未被访问的顶点,那么将该店出栈
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        //栈访问完毕,重置所有标记为wasVisited = false
        for(int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    //找到与某一顶点邻接且未被访问的顶点
    public int getAdjUnvisitedVertex(int v) {
        for(int i = 0; i < nVerts; i++) {
            //v顶点与i顶点相邻(邻接矩阵值为1)且未被访问wasVisited=false
            if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 广度优先搜索算法
     * 1.用remove方法检查队列的顶点
     * 2.试图找到这个顶点还未访问的邻节点
     * 3.如果没有找到,将该顶点出列
     * 4.如果找到这样的顶点,访问这个顶点并把它放入队列中
     */
    public void breadthFirstSearch() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);

        int v2;

        while(!queue.isEmpty()) {
            int v1 = queue.remove();
            while (((v2 = getAdjUnvisitedVertex(v1)) != -1)) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }
        //搜索完毕,初始化,以便于下次搜索
        for(int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /**
     * 利用深度优先搜索找到最小生成树
     *
     */
    public void minSpanningTree() {
        vertexList[0].wasVisited = true;
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if(v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }

        //搜索完毕,初始化,以便下次搜索
        for(int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /*************************************************  测试部分  *******************************************************************/
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);

        System.out.println("depth traverse:");
        graph.depthFirstSearch();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("breadth traverse:");
        graph.breadthFirstSearch();
        System.out.println();
        graph.minSpanningTree();

    }

}
