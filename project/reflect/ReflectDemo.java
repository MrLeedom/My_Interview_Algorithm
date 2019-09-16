package reflect;

/***************************************************************************
 @description :
 java反射说的是在运行状态中，对于任何一个类，我们都能够知道这个类有哪些方法和属性。对于任何一个对象，我们都能够对它的方法和属性
 进行调用。我们把这种动态获取对象信息和调用对象方法的功能称之为反射机制。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 13:52  caoshipeng  create
 ****************************************************************************/
public class ReflectDemo {
    public static void main(String[] args) {
        /* 方案一 */
        //创建一个对象
        ReflectDemo demo = new ReflectDemo();
        //获取该对象的class对象
        Class cls = demo.getClass();
        //获取类名称
        System.out.println(cls.getName());

        /* 方案二 */
        Class c1 = ReflectDemo.class;
        //获取类名称
        System.out.println(c1.getName());

        /* 方案三 */
        try{
            //根据类的全路径名获取
            Class c2 = Class.forName("reflect.ReflectDemo");

            //获取类名称
            System.out.println(c2.getName());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
