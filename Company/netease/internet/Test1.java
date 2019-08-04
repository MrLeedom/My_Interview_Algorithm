package netease.internet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
 @description :     多定义一些方法来解决，将宏观化为局部的思想，加油！！！
 求同学成绩的百分比，计算公式是：（不超过成绩s的人数 - 1）/ 总人数
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-03 11:48  caoshipeng  create
 ****************************************************************************/
public class Test1 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        //班级总人数
        int n = sc.nextInt();
        //分数情况
        int[] score = new int[n];
        for(int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        //查询编号
        int q = sc.nextInt();
        int[] question = new int[q];
        for(int j = 0; j < q; j++) {
            question[j] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int stu: question) {
            //拿到该学生的成绩
            int tmp = score[stu-1];
            list.add(tmp);
        }
        Arrays.sort(score);

        ArrayList<Integer> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++) {
            int count = 0;
            for(int m = 0; m < score.length; m++) {
                if(score[m]<= list.get(k)) {
                    count++;
                }
            }
            result.add(count);
        }

        for (int item: result) {
            double temp = (item -1) / (double)n;
            System.out.println(String.format("%.6f", temp * 100));
        }


    }
}
