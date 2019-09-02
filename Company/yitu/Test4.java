package yitu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***************************************************************************
 @description :     数组的区间和为p的倍数，得到区间的组合。
 1.暴力破解, 双层for循环
 2.单层循环+HashMap存储
 s[i] = a[0] + a[1] + ... + a[i]
 s[n-m] = s[m] - s[n]
 s[n-m] % p == 0  ===>   (s[m] - s[n]) % p == 0   ===>  s[m] % p = s[n] % p
 反映到代码中就是我们采用一个hashmap存放余数和对应的索引值，最后根据这个sum和就可以判断在hashmap中是否存在
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-02 17:37  caoshipeng  create
 ****************************************************************************/
public class Test4 {
  public static void main(String[] args) {
     int[] arr = new int[]{23, 2, 4, 6, 7};
     checkSubarraySum(arr, 6);
  }
  public static void checkSubarraySum(int[] nums, int k) {
   if (nums == null || nums.length <= 1) {
     System.out.println("the array exists exception!");
   }
   Map<Integer, Integer> map = new HashMap<>(16);
   map.put(0, -1);
   final int LENGTH = nums.length;
   int sum = 0;
   for (int i = 0; i < LENGTH; i++) {
     sum += nums[i];
     if (k != 0) {
       sum %= k;
     }
     Integer preIndex = map.get(sum);
     if (preIndex != null) {
       if (i - preIndex > 1) {
        List<Integer> list = new ArrayList<>();
        for(int p = preIndex+1; p <= i; p++) {
         list.add(nums[p]);
         System.out.print(nums[p] + " ");
        }
        System.out.println();
        list.clear();
       }
     } else {
       map.put(sum, i);
     }
   }
   return;
  }
}
