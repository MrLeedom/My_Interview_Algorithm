package designMode.FactoryMode;

/***************************************************************************
 @description :
 工厂模式，最常用的工厂模式是静态工厂，利用static方法，作为一种类似于常见工具类utils等辅助效果
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 12:09  caoshipeng  create
 ****************************************************************************/
interface food{}

class A implements food{}
class B implements food{}
class C implements food{}

public class StaticFactory {

    private StaticFactory(){}

    public static food getA(){  return new A(); }
    public static food getB(){  return new B(); }
    public static food getC(){  return new C(); }
}

class Client{
    //客户端代码只需要将相应的参数传入即可得到对象
    //用户不需要了解工厂类内部的逻辑。
    public void get(String name){
        food x = null ;
        if ( name.equals("A")) {
            x = StaticFactory.getA();
        }else if ( name.equals("B")){
            x = StaticFactory.getB();
        }else {
            x = StaticFactory.getC();
        }
    }
}
