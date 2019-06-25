package offer;

/**
 * @author:leedom
 * @date: 6/24/19 4:30 PM
 * Description:
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
