package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:leedom
 * @date:2019/7/7 19:51
 * Description:按之字形顺序打印二叉树
 *  请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右往左的顺序打印，第三行按照从左往右的顺序打印，
 *  其他行以此类推
 *
 *  这道题的思想很简单，根据前面一道题的思想去处理就好
 * License: (C)Copyright 2019
 */
public class Question38 {
    public static ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-- > 0) {
                TreeNode node = queue.poll();
                if(node == null) {
                    continue;
                }
                list.add(node.value);
                queue.add(node.left);
                queue.add(node.right);
            }

            //关键点在此
            if(reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            if(list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }
}
