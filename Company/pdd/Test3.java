package pdd;

/***************************************************************************
 @description :
 链接：https://www.nowcoder.com/discuss/212543
 来源：牛客网

 题目如下：
 0时刻，某人收到了N个工作，完成每个工作所需的时间为cost[i]，
 工作的完成存在先后的依赖关系（即某些工作必须在其它工作之前完成）。
 一个人顺序完成N个工作，问如何安排完成工作的顺序，使得完成工作的平均响应时间最短，
 输出这样的顺序，在满足平均响应时间最短的情况下，要求字典序最小？（响应时间：从接收到工作到工作完成的时间）

 输入第一行 n, m。n为任务个数，m为任务依赖个数。
 输入第二行 Pi，各任务耗时。
 输入 3 -> (3 + m) 行，各任务依赖。
 1 3 表示第一个任务依赖于第三个任务
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-07-29 23:16  caoshipeng  create
 ****************************************************************************/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * 0时刻，某人收到了N个工作，完成每个工作所需的时间为cost[i]，
 * 工作的完成存在先后的依赖关系（即某些工作必须在其它工作之前完成）。
 * 一个人顺序完成N个工作，问如何安排完成工作的顺序，使得完成工作的平均响应时间最短，
 * 输出这样的顺序，在满足平均响应时间最短的情况下，要求字典序最小？（响应时间：从接收到工作到工作完成的时间）
 *
 * 输入第一行 n, m。n为任务个数，m为任务依赖个数。
 * 输入第二行 Pi，各任务耗时。
 * 输入 3 - 3 + m 行，各任务依赖。
 * 1 3 表示第一个任务依赖于第三个任务
 */
public class Test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n_m = sc.nextLine();
        // 接收输入的m和n
        int n = Integer.valueOf(n_m.split(" ")[0]);
        int m = Integer.valueOf(n_m.split(" ")[1]);
        String P = sc.nextLine();
        ArrayList<Task> tasks = new ArrayList<>();
        String[] timesString = P.split(" ");
        // 接收输入的时间数组，并根据输入建立task的数组
        for (int i = 0;i<n;i++){
            tasks.add( new Task(Integer.valueOf(timesString[i]),i));
        }
        // 接收输入的依赖关系，然后完善各个任务的pre和behand的依赖
        for(int i = 0;i<m;i++){
            String depend = sc.nextLine();
            int taskId = Integer.valueOf(depend.split(" ")[0]);
            int dependId = Integer.valueOf(depend.split(" ")[1]);
            tasks.get(taskId).pre.add(tasks.get(dependId));
            tasks.get(dependId).behand.add(tasks.get(taskId));
        }
        // 将没有依赖的任务放入优先级队列
        PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>(new TaskComparator());
        for (int i=0;i<tasks.size();i++){
            Task t = tasks.get(i);
            if (t.pre.size()==0){
                taskPriorityQueue.offer(t);
                tasks.remove(t);
                i--;
            }
        }

        StringBuilder result = new StringBuilder();
        while (taskPriorityQueue.size()!=0){
            // 从优先级队列中取出任务，然后执行该任务，再把依赖这个任务的所有任务的pre中去除该任务，
            Task task = taskPriorityQueue.poll();
            result.append(task.number).append(" ");
            for(Task b :task.behand){
                b.pre.remove(task);
                // 如果b任务去除了task的前置之后，他没有前置了，
                // 就把他放到优先级队列中,同时在剩余任务tasks中删除该任务
                if(b.pre.size()==0){
                    taskPriorityQueue.offer(b);
                    tasks.remove(b);
                }
            }
        }
        // 最终按各个任务执行的顺序输出各个任务的编号
        System.out.println(result.toString());
    }
}

/**
 * 任务类，其中value是这个任务需要的时间
 * number是这个任务的编号
 * pre是这个任务所依靠的任务的数组
 * behand是依靠这个任务的任务的数组
 */
class Task{
    int value;
    int number;
    ArrayList<Task> pre;
    ArrayList<Task> behand;

    public Task(int v,int n) {
        this.number = n;
        this.value = v;
        this.pre = new ArrayList<>();
        this.behand = new ArrayList<>();
    }
}

/**
 * 用于优先级队列的比较器
 */
class TaskComparator  implements Comparator<Task>{

    @Override
    public int compare(Task t1, Task t2) {
        return t1.value-t2.value;
    }
}