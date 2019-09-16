package designMode.FactoryMode;

/***************************************************************************
 @description :
 一个基础接口定义了功能，每个实现接口的子类就是产品，然后定义一个工厂接口，实现了工厂接口的就是工厂，
 这时候，接口编程的优点就出现了，我们可以新增产品类（只需要实现产品接口），只需要同时新增一个工厂类，
 客户端就可以轻松调用新产品的代码。
 抽象工厂的灵活性就体现在这里，无需改动原有的代码，毕竟对于客户端来说，静态工厂模式在不改动staticfactory
 类的代码时无法新增产品，如果采用了抽象工厂模式，就可以轻松的新增扩展类。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 12:21  caoshipeng  create
 ****************************************************************************/
//interface food{}
//
//class A implements food{}
//class B implements food{}

interface produce{ food get();}

class FactoryForA implements produce{
    @Override
    public food get() {
        return new A();
    }
}
class FactoryForB implements produce{
    @Override
    public food get() {
        return new B();
    }
}
public class AbstractFactory {
    public void ClientCode(String name){
        food x= new FactoryForA().get();
        x = new FactoryForB().get();
    }
}
