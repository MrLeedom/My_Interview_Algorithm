package bytedance;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-22 08:52  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i = 0;i < number; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array = new int[n];
            for(int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }

            for(int k = 0; k < n; k++) {
                int count = 0;
                if(array[k] > m) {
                    count = k;
                }else{
                    int gap = m - array[k];
                    //将这个k-1数组反转
                    int[] tmp = Arrays.copyOfRange(array, 0, k);
                    Arrays.sort(tmp);
                    for(int z = 0; z <= k - 1; z++) {
                        if(gap < tmp[z] || gap <= 0) {
                            count++;
                        }else{
                            gap -= tmp[z];
                            //可以放弃这一题也可以不放弃
//                            if(loss(tmp, k, gap) >= noloss(tmp, k, gap)) {
//                                gap -= tmp[z];
//                            }
                        }
                    }
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }

    private static int noloss(int[] array, int k, int gap) {
        if(k < 0 || gap <= 0) {
            return 1;
        }
        return Math.min(noloss(array, k -1, gap), loss(array, k -1, gap));
    }

    private static int loss(int[] array, int k, int target) {
        if(k < 0 || target <= 0) {
            return 1;
        }
        int result = Math.min(1 + noloss(array, k -1, target - array[k]), 1 + loss(array, k - 1, target - array[k]));
        return result;
    }
}
