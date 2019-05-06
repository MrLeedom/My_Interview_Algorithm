package offer;

/**
 * @author:leedom
 * @date: 5/6/19 8:45 PM
 * Description:将一个字符串中的空格替换成%20
 * input:"A B"
 * output:"A%20B"
 * License: (C)Copyright 2019
 */
public class Question5 {
    public static String replaceResult(String str) {
        String temp = str.replaceAll("\\s", "%20");
        return temp;
    }

    public static String replaceSpace(StringBuffer str) {
        int p1 = str.length() -1;
        for(int i = 0; i <= p1; i++) {
            if(str.charAt(i) == ' ') {
                //当遇到一个空格,这个字符串会增长两个单位长度
                str.append("  ");
            }
        }
        int p2 = str.length() -1;
        while(p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1);
            if(str.charAt(p1--) == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--,  '2');
                str.setCharAt(p2--, '%');

            }else {
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }
    
    public static void main(String[] args){
        String str = "A B  V";
        System.out.println(replaceResult(str));
        
        StringBuffer sb = new StringBuffer("A B  V");
        System.out.println(replaceSpace(sb));
        
    }
}
