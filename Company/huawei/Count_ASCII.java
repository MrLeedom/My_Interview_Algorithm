import java.util.*;

/**
 * @author:leedom
 * @date: 4/10/19 5:28 PM
 * Description:
 *      输入一个字符串,(字母或者数字,可能含有重复值),按照其ASCII码顺序输出
 *      例如:eeefffkkk
 *      输出:e  3
 *          f  3
 *          g  2
 *          h  2
 *          k  1
 *          最终答案是:efghkefghef
 *   String类是final类,也即意味着String类不能被继承,并且它的成员方法都默认为final方法.在JAVA中,被final修饰的类不允许被继承,并且该类中的方法都默认为final方法,
 *   被final修饰的方法会被内嵌调用以提升执行效率
 *   String类实际是通过char数组来保存字符串
 * License: (C)Copyright 2019
 */
public class Count_ASCII {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] charArray = input.toCharArray();
        //建立ASCII数组,下标对应ASCII值
        int[] asciiArray = new int[127];
        //统计每个ASCII字符出现的次数

        for (int i = 0; i < charArray.length; i++) {
            asciiArray[charArray[i]]++;
        } 
        
        StringBuilder sb = new StringBuilder();
        //标记位,如果数组所有次数减为0,则退出循环
        int zeroCount = 0;
        while(zeroCount != 127) {
            zeroCount = 0;
            for(int j = 0; j < asciiArray.length; j++) {
                //循环遍历已经实现了按照ASCII码排序
                if(asciiArray[j] != 0) {
                    //拿到当前位的字符
                    char ch = (char) j;
                    //添加到输出
                    sb.append(ch);
                    //次数减1
                    asciiArray[j]--;
                }else{
                    zeroCount++;
                }
            }
        }
        System.out.println(sb.toString());
    }
  
}
