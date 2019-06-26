package offer;

/**
 * @author:leedom
 * @date: 6/24/19 4:30 PM
 * Description:     字符串匹配（表示数值的字符串）
 *      +100
 *      5e2
 *      -123
 *      -1E-16
 * License: (C)Copyright 2019
 */
public class Question24 {
    public static boolean isNumeric(char[] str) {
        if(str==null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
