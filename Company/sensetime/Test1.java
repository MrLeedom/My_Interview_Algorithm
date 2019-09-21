package sensetime;

import java.lang.reflect.Method;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-21 18:58  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("java.lang.String");
        Method[] methods = cls.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println(m);
        }
        
    }
}
