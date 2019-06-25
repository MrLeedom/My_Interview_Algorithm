package offer;

/**
 * @author:leedom
 * @date:2019/6/23 21:34
 * Description:     打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数,从前往后输出,0010,1110,看看数据的结构再来尝试
 *      其实这个也有点暴力破解的味道!!!
 * License: (C)Copyright 2019
 */
public class Question20 {
    public static void printNumber(int n) {
        double threshold = 0;
        for(int i = 1; i <= n; i++) {
            threshold += Math.pow(10, i-1) *  9;
        }
        System.out.println(threshold);
        for(double k = 1; k <= threshold; k++) {
            System.out.println(k);
        }
    }

    public static void printToMaxOfDigits(int n) {
        if(n <= 0) {
            return;
        }
        char[] number = new char[n];
        printToMaxOfDigits(number, 0);
    }

    public static void printToMaxOfDigits(char[] number, int digit) {
        if(digit == number.length) {
            printNumber1(number);
            return;
        }
        for(int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            printToMaxOfDigits(number, digit+1);
        }
    }

    public static void printNumber1(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index ++;
        }
        while (index < number.length){
            System.out.print(number[index++]);
        }
        System.out.println();

    }
    
    public static void main(String[] args) {
//            printNumber(4);
            printToMaxOfDigits(4);
    }
}
