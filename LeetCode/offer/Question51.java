package offer;

/**
 * @author:leedom
 * @date:2019/7/15 21:36
 * Description:数字序列中的某一位数字
 * 数字以01234567891011121314.。。的格式化序列到一个字符串中，求这个字符串的第index位
 * 巧妙地用到了非整除的思想，前面几个数字的特点来做
 * License: (C)Copyright 2019
 */
public class Question51 {
    public static int getDigitAtIndex(int index) {
        if(index < 0) {
            return -1;
        }
        int place = 1;//1表示个位，2表示十位。。。
        while(true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount*place;
            if(index < totalAmount){
                return getDigitAtIndex(index, place);
            }
            index -= totalAmount;
            place++;
        }
    }

    /**
    *   place位数的数字组成的字符串长度
     *   10， 90， 900， 。。。
     */
    private static int getAmountOfPlace(int place) {
        if(place == 1) {
            return 10;
        }
        return (int)Math.pow(10, place-1) * 9;
    }

    /**
     *  place位数的起始数字
     *  0， 10， 100，。。。。
     * @param place
     * @return
     */
    private static int getBeginNumberOfPlace(int place) {
        if(place == 1) {
            return 0;
        }
        return (int) Math.pow(10, place - 1);
    }

    /**
     * 在place位数组成的字符串中，第index个数
     * @param index
     * @param place
     * @return
     */
    private static int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }
    
    public static void main(String[] args) {
        System.out.println(getDigitAtIndex(97));
    }
}
