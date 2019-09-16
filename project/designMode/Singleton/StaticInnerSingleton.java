package designMode.Singleton;

/***************************************************************************
 @description :
 使用静态内部类实现单例模式，在内部创建一个实例，构造器全部设置为private，所有方法均在该实例上改动，
 在创建上要注意类的实例化只能执行一次，可以采用许多种方法来实现，比如synchronized关键字或者利用内部
 类等机制来实现。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 12:27  caoshipeng  create
 ****************************************************************************/
public class StaticInnerSingleton {
    private StaticInnerSingleton() { }

    private static class SingletonHandle {
        private static StaticInnerSingleton single = new StaticInnerSingleton();
    }

    public StaticInnerSingleton getInstance() {
        return SingletonHandle.single;
    }
}
