package multiprocess;

/***************************************************************************
 @description :
 synchronized可重入锁验证:get方法中顺序进入了set方法，说明synchronized的确是可重入锁。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 14:45  caoshipeng  create
 ****************************************************************************/
public class SynchronizedReentrant implements Runnable{
        public synchronized void get() {
            System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
            //reentrantLock.lock();
            System.out.println("3 get thread name-->" + Thread.currentThread().getName());
            set();
            //reentrantLock.unlock();
            System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
        }

        public synchronized void set() {
            //reentrantLock.lock();
            System.out.println("4 set thread name-->" + Thread.currentThread().getName());
            //reentrantLock.unlock();
        }

        @Override
        public void run() {
            System.out.println("1 run thread name-->" + Thread.currentThread().getName());
            get();
        }

        public static void main(String[] args) {
            SynchronizedReentrant test = new SynchronizedReentrant();
            for (int i = 0; i < 10; i++) {
                new Thread(test, "thread-" + i).start();
            }
        }


}
