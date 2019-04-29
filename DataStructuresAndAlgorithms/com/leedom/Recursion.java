package com.leedom;

/**
 * @author:leedom
 * @date: 3/28/19 8:48 AM
 * Description:
 *          递归的思想可以和分治思想和起来使用
 * License: (C)Copyright 2019
 */
public class Recursion {
    /**************************************  汉诺塔问题  ****************************************************************/
    public static void move(int dish, String from, String temp, String to) {
        if(dish == 1) {
            System.out.println("please put the number"+dish + "from" + from + "to" + to);
        } else {
            move(dish-1, from, to, temp);
            System.out.println("please put the number"+dish + "from" + from + "to" + to);
            move(dish-1, temp, from, to);
        }
    }

    /*************************************  背包问题  **********************************************************************/
    static class Knapsack {
        //可供选择的重量
        private int[] weights;
        //记录是否被选择
        private boolean[] selected;

        public Knapsack(int[] weights) {
            this.weights = weights;
            selected = new boolean[weights.length];
        }

        /**
         * 找到符合承受重量的组合
         * @param total 总重量
         * @param index 可供选择的重量下标
         */
        public void knapsack(int total, int index) {
            if(total < 0 || total > 0 && index >=weights.length) {
                //没找到解决方案,直接返回
                return;
            }
            if(total == 0) {
                //总重量为0的话,则找到了解决方法
                for(int i = 0; i < index; i++) {
                    if(selected[i] == true) {
                        System.out.print(weights[i] + " ");
                    }
                }
                System.out.println("----------------------------");
                return;
            }
            selected[index] = true;
            knapsack(total - weights[index], index + 1);
            selected[index] = false;
            knapsack(total, index + 1);
        }
    }

    /***************************************  组合:选择一支队伍  *********************************************************/
    static class Combination {
        //组中所有可供选择的人员
        private char[] persons;
        //标记成员是否被选中,选中为True
        private boolean[] selected;

        public Combination(char[] persons) {
            this.persons = persons;
            selected = new boolean[persons.length];
        }

        public void showTeams(int teamNumber) {
            combination(teamNumber, 0);
        }
        /**
         * @param  teamNumber  需要选择的队员数
         * @param  index       从第几个队员开始选择
         */
        public void combination(int teamNumber, int index) {
            if(teamNumber == 0) {
                //当teamNumber为0时,找到一组
                for(int i = 0; i < selected.length; i++) {
                    if(selected[i] == true) {
                        System.out.println(persons[i] + " ");
                    }
                }
                System.out.println("--------------------------");
                return;
            }
            if(index >= persons.length){
                return;
            }
            selected[index] = true;
            combination(teamNumber - 1, index + 1);
            selected[index] = false;
            combination(teamNumber, index + 1);
        }
    }



    /*******************************************  测试部分  ************************************************************/
    public static void main(String[] args){
        move(3, "A", "B", "C");
        int[] array = {11, 9, 7, 6, 5};
        int total = 20;
        Knapsack back = new Knapsack(array);
        back.knapsack(total, 0);
        char[] persons = {'A', 'B', 'C', 'D', 'E'};
        Combination cb = new Combination(persons);
        cb.showTeams(3);
    }
}
