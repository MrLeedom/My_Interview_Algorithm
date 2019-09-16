package designMode.Decorator;

/***************************************************************************
 @description :
 给一类对象增加新的功能，装饰方法与具体的内部逻辑无关
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 12:46  caoshipeng  create
 ****************************************************************************/
interface Source{ void method();}
public class Decorator implements Source{

    private Source source ;
    public void decotate1(){
        System.out.println("decorate");
    }
    @Override
    public void method() {
        decotate1();
        source.method();
    }
}