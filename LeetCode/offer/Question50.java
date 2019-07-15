package offer;

/**
 * @author:leedom
 * @date:2019/7/11 23:33
 * Description:从1到n的整数中1出现的次数
 * ，例如，1，11，12，。。。，111
 * License: (C)Copyright 2019
 */
public class Question50 {
    public static int countFromOne2N(int N) {
        if(N < 0) {
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= N; i++) {
            count += numberOne(i);
        }
        return count;
    }

    public static int numberOne(int target) {
        if(target <= 0) {
            return 0;
        }
        int count = 0;
        while(target > 0) {
            if(target % 10 == 1) {
                count++;
            }
            target = target / 10;
        }
        return count;
    }

    /**
     *以21354为例，寻找1出现的次数：
     *
     * 个位：从1至21350中包含了2135个10，因此1出现了2135次，21351，21352，21353，21354其中21351包含了一个1，故个位出现1的次数为：2135*10(1-1) + 1 = 2136次；
     *
     * 公式：( 2135+1）* 10^(1-1) = 2136；
     *
     * 十位：从1到21300中包含了213个100，因此1出现了213 * 10^(2-1) = 2130次，剩下的数字是21301到21354，它们的十位数字是5 > 1；因此它会包含10个1；故总数为2130 + 10 = 2140次；
     *
     * 公式：（213 + 1）* 10^(2-1) = 2140次；
     *
     * 百位：从1到21000中包含了21个1000，因此1出现了21 * 10^(3-1) = 2100次，剩下的数字是21001到21354，它们的百位数字是3 > 1；因此它会包含100个1；故总数为2100 + 100 = 2200次；
     *
     * 公式：（21 + 1）* 10^(3-1) = 2200次；
     *
     * 千位：从1到20000中包含了2个10000，因此1出现了2 * 10^(4-1) = 2000次，剩下的数字是20001到21354，它们的千位数字是1 = 1；情况稍微复杂些，354 + 1 = 355；故1的总数为2000 + 355 = 2355次；
     *
     * 公式：2 * 10^(4-1) + 354 + 1 = 2355次；
     *
     * 万位：万位是2 > 1，没有更高位；因此1出现的次数是1 * 10^(5-1) = 10000次；
     *
     * 公式：（0 + 1）*10^(5-1) = 10000次；
     *
     * 故总共为：2136+2140+2200+2355+10000=18831次；
     * @param n  目标点
     * @param x  起点
     * @return
     * @throws Exception
     */
    public static int countFromOneToN(int n, int x) throws Exception {
        if(n <1 || x < 1 || x > 9) {
            throw new Exception("the variable is wrong!");
        }
        int curr, low, temp, high = n, i = 1, total = 0;
        while(high!=0){
            high = n / (int)Math.pow(10, i); //获取第i位的高位
            temp = n % (int)Math.pow(10, i); //
            curr = temp / (int)Math.pow(10, i-1); //获取第i位
            low = temp%(int)Math.pow(10, i-1); //获取第i位的低位
            if(curr == x){ //等于x
                total += high*(int)Math.pow(10, i-1)+ low + 1;
            }else if(curr < x){ //小于x
                total += high*(int) Math.pow(10, i-1);
            }else{ //大于x
                total += (high + 1) * (int)Math.pow(10, i-1);
            }
            i++;
        }
        return total;
    }
    public static void main(String[] args) throws Exception{
        System.out.println(countFromOne2N(11));
        System.out.println(countFromOneToN(11, 1));
    }
}
