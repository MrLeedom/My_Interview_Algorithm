package offer;

import com.leedom.PriorityQueue;

/**
 * @author:leedom
 * @date:2019/7/8 23:14
 * Description:数据流的中位数
 * 如何得到一个数据流的中位数，如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * License: (C)Copyright 2019
 */
public class Question47 {
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)-> o2 - o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();

}
