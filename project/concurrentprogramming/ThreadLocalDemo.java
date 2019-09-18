package concurrentprogramming;

/***************************************************************************
 @description :
 ThreadLocal是用在多线程的场景下的！！！
 * 保存线程上下文信息，在任意需要的地方可以获取；
 * 线程安全的，避免某些情况需要考虑线程安全必须同步带来的性能损失
 保存线程上下文信息，在任意需要的地方可以获取！！！
 ThreadLocal在我们的Spring框架中，会有些事务管理，用ThreadLocal存储Connection，从而各个DAO可以获取同一
 Connection，可以进行事务回滚，提交等操作。
 ThreadLocal无法解决共享变量更新问题，ThreadLocal对象建议使用static修饰。这个变量是针对一个线程内所有操作共享的，
 所以设置为静态变量，只分配一块存储空间，所有此类的对象（只要是这个线程内定义的）都可以操纵这个变量。

 每个线程往ThreadLocal中读写数据是线程隔离，互相之间不会影响的，所以ThreadLocal无法解决共享对象的更新问题。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-17 21:47  caoshipeng  create
 ****************************************************************************/
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for(int i = 0; i < 100; i++) {
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                    try{
                        Thread.sleep(200);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                threadLocal.remove();
            }
        }, "threadLocal1").start();

        new Thread(() -> {
            try {
                for(int i = 0; i < 100; i++) {
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                    try{
                        Thread.sleep(200);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                threadLocal.remove();
            }
        }, "threadLocal2").start();
    }

}
