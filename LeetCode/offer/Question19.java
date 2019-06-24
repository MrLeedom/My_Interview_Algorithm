package offer;

/**
 * @author:leedom
 * @date:2019/6/23 21:16
 * Description: 数值的整数次方
 *  给定一个double类型的浮点数base和int类型的整数exponent，求base的exponent次方!
 *      将整个算法的复杂度降为O(logN)
 * License: (C)Copyright 2019
 */
public class Question19 {
    public static double Power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if(exponent < 0) {
            exponent = - exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if(exponent % 2 !=0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }
    
    public static void main(String[] args) {
        System.out.println(Power(2,2));
    }
}
