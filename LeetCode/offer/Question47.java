package offer;


import java.util.PriorityQueue;

/**
 * @author:leedom
 * @date:2019/7/8 23:14
 * Description:数据流的中位数
 * 如何得到一个数据流的中位数，如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * License: (C)Copyright 2019
 */
public class Question47 {
    /*大根堆，存储左半边元素*/
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2)-> o2 - o1);
    /*小根堆，存储右半边元素，并且右半边元素都大于左半边*/
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /*当前数据流流入的元素个数*/
    private int N = 0;

    public void insert(Integer val) {
        /*插入要保证两个堆存入平衡状态*/
        if(N%2==0){
            /*
            N为偶数的情况下插入到右半边。
            因为右半边元素都要大于左半边，但是新插入的元素不一定要比左半边元素大
            因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边
             */
            left.add(val);
            right.add(left.poll());
        }else{
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double getMedian() {
        if(N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        }else{
            return (double) right.peek();
        }
    }
}
