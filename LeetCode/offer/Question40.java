package offer;

import java.util.ArrayList;

/**
 * @author:leedom
 * @date:2019/7/7 20:25
 * Description:二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值和为输入整数的所有路径。路径定义为从树的根节点开始往下直到叶节点所经过的节点形成一条路径
 * License: (C)Copyright 2019
 */
public class Question40 {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if(node == null) {
            return;
        }
        path.add(node.value);
        target -= node.value;
        if(target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        }else{
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
