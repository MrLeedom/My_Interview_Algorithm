package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:leedom
 * @date:2019/7/7 19:43
 * Description:把二叉树打印成多行
 * 和前面一道题的思想基本一致
 * License: (C)Copyright 2019
 */
public class Question37 {
    public static ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
            if(list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }
}
