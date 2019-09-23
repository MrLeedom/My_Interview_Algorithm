package cisco;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-23 19:42  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        /* 分割出主体功能 */
        int index = line.indexOf("<sip");
        String tmp = line.substring(0, index);
        /* 首先去处首部的特殊字符 */
        if(tmp.contains("\"") && tmp.startsWith("\"")) {
            tmp = tmp.substring(1, tmp.length());
        }
        if(tmp.contains("%22") && tmp.startsWith("%22")) {
            tmp = tmp.substring(3, tmp.length());
        }
        /* 首先去处尾部的特殊字符 */
        if(tmp.contains("\"") && tmp.endsWith("\"")) {
            tmp = tmp.substring(0, tmp.length()-1);
        }
        if(tmp.contains("%22") && tmp.endsWith("%22")) {
            tmp = tmp.substring(0, tmp.length() -3);
        }
        System.out.println(tmp);
    }
}
