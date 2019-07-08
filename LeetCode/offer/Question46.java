package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author:leedom
 * @date:2019/7/8 22:49
 * Description: 最小的K个数
 * 利用大小为k的最小堆
 * 复杂度：O(NlogK) + O(K)
 * License: (C)Copyright 2019
 */
public class Question46 {
    public ArrayList<Integer> getLeastNumbers_Solution(int[] nums, int k) {
        if(k > nums.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int num : nums) {
            maxHeap.add(num);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);

    }
}
