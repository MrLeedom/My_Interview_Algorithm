package offer;

import java.util.Stack;

/**
 * @author:leedom
 * @date:2019/7/7 19:19
 * Description:栈的压入和弹出序列
 *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假如压入栈的所有数字均不相等
 *  这个题型我们经常在选择题中遇到，所以此处设计一个栈来模拟栈压入和弹出操作
 * License: (C)Copyright 2019
 */
public class Question35 {
    public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for(int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex ++) {
            stack.push(pushSequence[pushIndex]);
            while(popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
