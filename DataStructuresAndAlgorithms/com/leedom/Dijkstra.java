package com.leedom;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:leedom
 * @date: 4/23/19 1:19 PM
 * Description:迪杰特斯拉
 * 首先就是创建一个宏观概念,遍历整个节点,并且在遍历过程中,创建一张表,上面记录着合法被遍历过的节点,一旦该节点走过便不再走,否则找到个最短的路径为
 * 起点,反复从该点出发进行规划,这样遍历完所有节点,自然会有收获
 * License: (C)Copyright 2019
 */
public class Dijkstra{
    /**
     * dijkstra最短路径算法
     */
    public static int[] dijkstra(Graph graph, int startIndex) {
        //图的顶点数量
        int size = graph.vertexes.length;
        //创建距离表,存储从起点到每一个顶点的临时距离
        int[] distances = new int[size];
        //创建前置顶点表,存储从起点到每一个顶点的已知最短路径的前置节点
        int[] prevs = new int[size];
        //创建顶点遍历状态
        boolean[] access = new boolean[size];

        //初始化最短路径表,到达每个顶点的路径代价默认为无穷大
        for(int i=0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        //遍历起点,刷新距离表
        access[0] = true;
        List<Edge> edgesFromStart = graph.adj[startIndex];
        for(Edge edge : edgesFromStart) {
            distances[edge.index] = edge.weight;
            prevs[edge.index] = 0;
        }

        //主循环,重复遍历最短距离顶点和刷新距离表的操作
        for(int i = 1; i < size; i++) {
            //寻找最短距离顶点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for(int j = 1; j < size; j++) {
                if(!access[j] && distances[j] < minDistanceFromStart) {
                    minDistanceFromStart = distances[j];
                    minDistanceIndex = j;
                }
            }
            if(minDistanceIndex==-1){
                break;
            }
            //遍历顶点,刷新距离表
            access[minDistanceIndex] = true;
            for(Edge edge: graph.adj[minDistanceIndex]) {
                if(access[edge.index]) {
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distances[edge.index];
                if(weight != Integer.MAX_VALUE && (minDistanceFromStart + weight < preDistance)) {
                    distances[edge.index] = minDistanceFromStart + weight;
                    prevs[edge.index] = minDistanceIndex;
                }
            }
        }
        return prevs;
    }

    public static void main(String[] args){
        Graph graph = new Graph(7);
        initGraph(graph);
        int[] prevs = dijkstra(graph, 0);
        printPrevs(graph.vertexes, prevs, graph.vertexes.length-1);
    }

    private static void printPrevs(Vertex[] vertexes, int[] prev, int i) {
        if(i > 0) {
            printPrevs(vertexes, prev, prev[i]);
        }
        System.out.println(vertexes[i].data);
    }

    /**
     * 图的顶点
     */
    private static class Vertex {
        String data;
        Vertex(String data) {
            this.data = data;
        }
    }
    /**
     * 图的边
     */
    private static class Edge {
        int index;
        int weight;
        Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
    /**
     * 图
     */
    private static class Graph {
        private Vertex[] vertexes;
//        这个关系比较妙
        private LinkedList<Edge> adj[];
        Graph(int size) {
            //初始化顶点和邻接矩阵
            vertexes = new Vertex[size];
            adj = new LinkedList[size];
            for(int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<Edge>();
            }
        }
    }

    private static void initGraph(Graph graph) {
        graph.vertexes[0] = new Vertex("A");
        graph.vertexes[1] = new Vertex("B");
        graph.vertexes[2] = new Vertex("C");
        graph.vertexes[3] = new Vertex("D");
        graph.vertexes[4] = new Vertex("E");
        graph.vertexes[5] = new Vertex("F");
        graph.vertexes[6] = new Vertex("G");

        graph.adj[0].add(new Edge(1, 5));
        graph.adj[0].add(new Edge(2,2));
        graph.adj[1].add(new Edge(0,5));
        graph.adj[1].add(new Edge(3,1));
        graph.adj[1].add(new Edge(4,6));
        graph.adj[2].add(new Edge(0,2));
        graph.adj[2].add(new Edge(3,6));
        graph.adj[2].add(new Edge(5,8));
        graph.adj[3].add(new Edge(1,1));
        graph.adj[3].add(new Edge(2,6));
        graph.adj[3].add(new Edge(4,1));
        graph.adj[3].add(new Edge(5,2));
        graph.adj[4].add(new Edge(1,6));
        graph.adj[4].add(new Edge(3,1));
        graph.adj[4].add(new Edge(6,7));
        graph.adj[5].add(new Edge(2,8));
        graph.adj[5].add(new Edge(3,2));
        graph.adj[5].add(new Edge(6,3));
        graph.adj[6].add(new Edge(4,7));
        graph.adj[6].add(new Edge(5,3));
    }
}