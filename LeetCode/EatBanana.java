import java.util.Arrays;

/**
 * @author:leedom
 * @date: 4/15/19 8:56 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class EatBanana {
    /***************************  本人解法  *************************************/
    public static int minSpeed(int[] bananas, int H) {
        int speed = -1;
        if(H < bananas.length) {
            throw new IllegalArgumentException("cannot eat all bananas");
        } else if (H == bananas.length) {
            Arrays.sort(bananas);
            speed =  bananas[bananas.length-1];
        } else {
            Arrays.sort(bananas);
            for(int i = 1; i < bananas[bananas.length-1]; i++) {
                int j = 0;
                int sum = 0;
                while(j < bananas.length) {
                    //Math.ceil中必须是整数才能够取整
                    sum += Math.ceil((double)bananas[j] / i);
                    j += 1;
                }
                if(sum == H) {
                    speed = i;
                    break;
                }
            }
        }
        return speed;
    }
    /****************************  官方答案  ************************************/
    public static int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while(low < high) {
            int mid = (low + high) /2;
            if(!possible(piles, H, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static boolean possible(int[] arr, int H, int W) {
        int time = 0;
        for(int p : arr) {
            time += (p-1) / W + 1;
        }
        return time <= H;
    }
    public static void main(String[] args){
        int[] piles = {30, 11, 23, 4, 20};
        int H = 6;
        System.out.println(minSpeed(piles, H));
    }
}
