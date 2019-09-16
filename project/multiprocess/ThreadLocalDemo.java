package multiprocess;

import java.util.concurrent.CountDownLatch;

/***************************************************************************
 @description :
 演示ThreadLocal的使用:
    ThreadLocal 并不能解决线程间共享数据的问题；
    ThreadLocal 通过隐式的在不同线程内创建独立实例副本避免了实例线程安全的问题；
    每个线程持有一个Map并维护了ThreadLocal对象与具体实例的映射，该Map由于只被持有它的线程访问，故
    不存在线程安全以及锁的问题；
    ThreadLocalMap的Entry对ThreadLocal的引用为弱引用，避免了ThreadLocal对象无法被回收问题，也防止了内存泄漏；
    ThreadLocal适用于变量在线程间隔离且在方法间共享的场景。
 主要有四个方法：
    get()方法：获取与当前线程关联的ThreadLocal值；
    set(T value)方法：设置与当前线程关联的ThreadLocal值；
    initialValue()方法：设置与当前线程关联的ThreadLocal初始值，该方法是protected类型的，很显然是建议在子类重载该函数的，
                    所以通常该方法都会以匿名内部类的形式被重载，以指定初始值；
    remove()方法：将与当前线程关联的ThreadLocal值删除。
 需要注意countDownLatch是一个非常实用的多线程控制工具类，倒计数器。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-15 19:44  caoshipeng  create
 ****************************************************************************/
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException{
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for(int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for(int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();//计数减去1
            }, "thread - " + i).start();
        }

        countDownLatch.await();//等待，当计数减到0，所有线程并行执行
    }

    private static class InnerClass {

        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name: %s\n", Thread.currentThread().getName(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Thread name: %s\n", Thread.currentThread().getName(),
                    Counter.counter.get().toString());
        }
    }

    private static class Counter {
        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };
    }
}
