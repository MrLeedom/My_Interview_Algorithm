package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:leedom
 * @date:2019/7/7 19:31
 * Description:从上往下打印二叉树
 *  从上往下打印出二叉树的每个节点，同层节点从左往右打印
 *  使用队列来进行层次遍历，不需要使用两个队列分别存储当前层的节点和下一层的节点，因为在开始遍历一层的节点时，当前队列中的节点数就是
 *  当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点
 * License: (C)Copyright 2019
 */
public class Question36 {
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode temp = queue.poll();
                if(temp == null) {
                    continue;
                }
                ret.add(temp.value);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return ret;
    }
}
