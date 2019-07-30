import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:leedom
 * @date: 4/10/19 8:10 PM
 * Description:
 * 思路:处理字符串,采用栈这种结构来做,不考虑不匹配的问题,必然会匹配
 * 一旦遇到数字的话就会注意到
 * License: (C)Copyright 2019
 */
public class Test2 {
    public static void main(String[] args){
//        String string = "abc2(a)7{a8(s7[j]d)fg}";
//        Pattern p = Pattern.compile("[0-9a-zA-Z]+");
//        Matcher m = p.matcher(string);
//        while(m.find()){
//            System.out.println(m.group());
//        }
//
        String msg = "abc2(a)7{a8(s7[j]d)fg}";
        List<String> list=new ArrayList<String>();
        String str1 = "(?<=\\\\《)[^\\\\》]+";
        String str2 = "/(?<=\\\\《)[^\\\\》]+";
        String str3 = "(?<=\\\\《)[^\\\\》]+";
        Pattern p = Pattern.compile(str3);
        Matcher m = p.matcher(msg);
        while(m.find()){
            list.add(m.group().substring(1, m.group().length()-1));
        }

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String output = "";
        int key = 1;
        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();
        Vector<Integer> vector3 = new Vector<>();


        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch>='0' && ch <= '9') {
                key = (int)(ch-'0');
                continue;
            }
            switch (ch) {
                case '{' :
                    vector1.add(i);
                    break;
                case '}':
                    vector1.add(i);
                    break;
                case '[':
                    vector2.add(i);
                    break;
                case ']' :
                    vector2.add(i);
                    break;
                case '(':
                    vector3.add(i);
                    break;
                case ')':
                    vector3.add(i);
                    break;
                default:
            }
            output += ch;
        }
    }

}
