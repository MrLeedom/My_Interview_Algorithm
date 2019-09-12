package meituan;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-11 15:52  caoshipeng  create
 ****************************************************************************/
class ReviewEncourage implements Runnable{
    private int n;//中奖用户数
    private int count = 0;//发放优惠卷和贡献值情况
    private int cur = 1; //当前计数
    public ReviewEncourage() {}
    public ReviewEncourage(int n) {
        this.n = n;
    }      // 构造函数,n为中奖用户数

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                //发放完毕时，跳出循环
                if(cur > n) {
                    break;
                }
                if(cur++ % 2 == 1) {
                    bonus(new PrizePool());
                }else{
                    if(count++ % 2 == 0) {
                        coupon(new PrizePool());
                    }else{
                        contribution(new PrizePool());
                    }

                }
            }
        }
    }


    public class PrizePool {
        public void send(String input) {
            System.out.print(input);
        }

    }

    public void bonus(PrizePool prizePool) {
        prizePool.send("A");
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) {
        prizePool.send("B");
    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) {
        prizePool.send("C");
    }  // 仅能打印C，表示发放贡献值

}
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        ReviewEncourage re = new ReviewEncourage(number);
        ReviewEncourage.PrizePool pool = new ReviewEncourage().new PrizePool();
        Thread thread1 = new Thread(re, "bonus");
        Thread thread2 = new Thread(re, "coupon");
        Thread thread3 = new Thread(re, "contribution");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
