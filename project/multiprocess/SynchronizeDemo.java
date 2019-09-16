package multiprocess;

/***************************************************************************
 @description :
 他是悲观锁
 synchronized关键字，使用内置锁，来实现对变量的同步操作，进而实现对变量操作的原子性和其他线程对变量的可见性，从而确保了并发情况下的
 线程安全。用它来修饰一个方法或者一个代码块的时候，能够保证同一时刻最多只有一个线程执行该段代码。synchronized是内置语言实现的，synchronized
 在发生异常时，会自动释放线程占用的锁，因此不会导致死锁现象产生。
 释放锁的时机：
 1.当方法（代码块）执行完毕后会自动释放锁
 2.当一个线程执行的代码出现异常时，其所持有的锁会自动释放
 3.不会由于异常导致死锁现象
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 14:03  caoshipeng  create
 ****************************************************************************/
public class SynchronizeDemo {
    /* 用的锁是对象（内置锁）*/
    public synchronized void function() throws InterruptedException {
        for (int i = 0; i <3; i++) {
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }

    /* 修饰代码块 */
    public void test1() {
        synchronized (this) {
            //dosomething
        }
    }

    /* 修饰静态方法代码块，静态方法属于类方法，获取到的锁是属于类的锁*/
    public static synchronized void staticFunction()
            throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }

    public static void main(String[] args) {
        final SynchronizeDemo demo = new SynchronizeDemo();

        // 创建线程执行静态方法
        Thread t1 = new Thread(() -> {
            try {
                staticFunction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建线程执行实例方法
        Thread t2 = new Thread(() -> {
            try {
                demo.function();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 启动
        t1.start();
        t2.start();
    }
}
