package offer;

/**
 * @author:leedom
 * @date:2019/6/23 10:20
 * Description:机器人的运动范围，机器人只能向左右上下四个方向移动一格，但是不能进入行列坐标数位之和大于k的格子
 *      采用深度优先搜索，也是回溯的一种特例。再一次搜索过程中设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态
 * License: (C)Copyright 2019
 */
public class Question16 {
    private static final int[][] next = {{0,-1}, {0,1},{-1,0},{1,0}};
    private static int cnt = 0;
    private static int rows;
    private static int cols;
    private static int threshold;
    private static int[][] digitSum;

    public static int movingCount(int threshold, int rows, int cols) {
        Question16.rows = rows;
        Question16.cols = cols;
        Question16.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return Question16.cnt;
    }

    private static void dfs(boolean[][] marked,int r, int c) {
        if(r < 0||r>=Question16.rows || c<0 ||c>=Question16.cols||marked[r][c]) {
            return;
        }
        marked[r][c] = true;
        if(Question16.digitSum[r][c] > Question16.threshold) {
            return;
        }
        Question16.cnt++;
        for(int[] n : Question16.next) {
            dfs(marked, r+n[0], c+n[1]);
        }
    }

    private static void initDigitSum() {
        int[] digitSumOne = new int[Math.max(Question16.rows, Question16.cols)];
        for(int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while(n>0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        Question16.digitSum = new int[Question16.rows][Question16.cols];
        for(int i = 0; i < Question16.rows; i++) {
            for(int j = 0; j < Question16.cols; j++) {
                Question16.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(movingCount(18,40,40));
    }
}
