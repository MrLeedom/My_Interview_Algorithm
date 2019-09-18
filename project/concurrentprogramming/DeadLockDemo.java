package concurrentprogramming;

/***************************************************************************
 @description :
 死锁例子：线程1和线程2互相等待对方释放锁
 *避免一个线程同时获取多个锁
 *避免一个线程在锁内同时占用多个资源,尽量保证每个锁只占用一个资源
 *尝试使用定时锁，使用tryLock(timeout)来替代内部锁机制
 *对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-17 20:40  caoshipeng  create
 ****************************************************************************/
public class DeadLockDemo {
    /*A锁*/
    private static String A = "A";
    /*B锁*/
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
