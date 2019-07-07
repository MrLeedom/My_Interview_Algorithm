package offer;

/**
 * @author:leedom
 * @date:2019/7/7 19:56
 * Description: 二叉搜索树的后序遍历序列
 * 请输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * 例如，下图是后序遍历序列1，3，2所对应的二叉搜索树
 *      2
 *     / \
 *    1  3
 * License: (C)Copyright 2019
 */
public class Question39 {
    public static boolean verifySequenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] sequence, int first, int last) {
        if(last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int cutIndex = first;
        //注意题目，这是一颗二叉搜索树
        while(cutIndex < last && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        for(int i = cutIndex; i < last; i++) {
            if(sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, cutIndex -1) && verify(sequence, cutIndex, last-1);
    }
}
