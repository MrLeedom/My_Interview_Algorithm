package netease.thunderfile;

import java.util.*;

/***************************************************************************
 @description :
 随机数生成函数：Math.random()生成0-1之间的一个小数

 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-04 10:46  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        //窗体实际上是一个栈的操作，找到了之后，调整顺序
        Stack<Map<Integer, String>> stack = new Stack();
        for(int i = 0; i < N; i++) {
            String line = sc.nextLine().replace(" ", "_");
            Map<Integer, String> window = new HashMap<>();
            window.put(i+1, line);
            stack.push(window);
        }
        int[] array = new int[M * 2];
        int index = 0;
        for(int j = 0; j < M; j++) {
            String[] arrLine = sc.nextLine().split("\\s+");
            array[index++] = Integer.parseInt(arrLine[0]);
            array[index++] = Integer.parseInt(arrLine[1]);
        }


        /*****  结果的处理开始  *******/
        ArrayList<Integer> result = new ArrayList<>();
        //暂存窗体的一些操作
        Stack<Map<Integer, String>> tmp = new Stack();

        for(int k = 0; k < M; k++) {
            //拿到鼠标点击的位置
            int x = array[2 * k];
            int y = array[2 * k+1];
            if(x < 0 || y <0 || x > 3839 || y > 2159) {
                result.add(-1);
                continue;
            }

            boolean flag = false;
            //遍历窗体，看哪个窗体满足
            Map<Integer, String> temp = new HashMap<>();
            while(!stack.isEmpty()) {
                Map<Integer, String> map = stack.pop();
                String str = (String)map.values().toArray()[0];
                String[] cur_str = str.split("_");
                int cur_x = Integer.parseInt(cur_str[0]);
                int cur_y = Integer.parseInt(cur_str[1]);
                int cur_w = Integer.parseInt(cur_str[2]);
                int cur_h = Integer.parseInt(cur_str[3]);
                int x_top = cur_x + cur_w;
                int y_top = cur_y + cur_h;
                if(x >= cur_x && x <= x_top && y >= cur_y && y <= y_top) {
                    result.add((Integer)map.keySet().toArray()[0]);
                    flag = true;
                    temp = map;
                    break;
                }else{
                    temp = map;
                    tmp.push(map);
                }
            }
            if(flag == true) {
                while(!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }
                stack.push(temp);

            }else{
                while(!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }

                result.add(-1);
            }

        }
        
        for(int ii = 0; ii < result.size(); ii ++) {
            System.out.println(result.get(ii));
        }

    }
}

