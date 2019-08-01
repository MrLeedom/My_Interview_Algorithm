package offer;

import java.util.ArrayList;

/***************************************************************************
 @description :     输出所有和为 S 的连续正数序列。

 例如和为 100 的连续序列有：
 [9, 10, 11, 12, 13, 14, 15, 16]
 [18, 19, 20, 21, 22]。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-01 23:18  caoshipeng  create
 ****************************************************************************/
public class Question65 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
