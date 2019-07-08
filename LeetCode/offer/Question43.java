package offer;

/**
 * @author:leedom
 * @date:2019/7/8 21:59
 * Description:序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列二叉树
 * License: (C)Copyright 2019
 */
public class Question43 {
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if(root == null) {
            return "#";
        }
        return root.value + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    public TreeNode Deserialize() {
        if(deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index+1);
        if(node.equals("#")){
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

}
