package concurrentprogramming;

/***************************************************************************
 @description :
 演示串行和并发执行累加的操作
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-17 19:32  caoshipeng  create
 ****************************************************************************/
public class ConcurrencyTest {
    private static final long count = 100001;
    
    public static void main(String[] args) throws InterruptedException{
        double a = 5/2;
        System.out.println(a);
        //并发计算
        concurrency();
        //单线程计算
        serial();
    }
    
    private static void concurrency() throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0; i < count; i++) {
                    a += 5;
                }
                System.out.println(a);
            }
        });
        thread.start();
        
        int b = 0;
        for(long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        //t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒，并不影响同一时刻处在运行状态的其他线程
        //join方法只是了解它能够使得t.join()中的t优先执行，当t执行完后才会执行其他线程，能够使得线程之间的并行执行变成串行执行。
        thread.join();
        System.out.println("concurrency:" + time + "ms,b= " +b);
    }
    
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for(long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
