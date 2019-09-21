package netease.internet;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-21 16:02  caoshipeng  create
 ****************************************************************************/
public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int length = sc.nextInt();
            int[] array = new int[length];
            for(int j = 0; j < length; j++) {
                array[j] = sc.nextInt();
            }

            System.out.println(minLength2(array));
        }
    }
    public static int minLength2(int[] array) {
        int max = 0;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] >= sum) {
                count++;
                sum += array[i];
            }else{
                max = max > count ? max : count;
                count = 1;
                sum = array[i];
            }
        }
        max = max > count ? max : count;
        return max;
    }

    public static int minLength(int[] array) {
        int[] zeros = new int[array.length];
        for(int i = 0; i < zeros.length; i++) {
            zeros[i] = 0;
        }
        zeros[0] = array[0];
        for(int k = 1; k < array.length; k++) {
            for(int j = zeros.length - 1; j >= 0; j--) {
                if(j == 0) {
                    if(zeros[j] > array[k]) {
                        zeros[j] = array[k];
                    }
                }else{
                    if(array[k] >= zeros[j-1]) {
                        if(zeros[j] == 0 && zeros[j-1] != 0) {
                            zeros[j] = zeros[j-1] + array[k];
                        }else{
                            zeros[j] = Math.min(zeros[j], zeros[j-1] + array[k]);
                        }
                    }

                }
            }
        }
        for(int i = zeros.length - 1; i >= 0; i--) {
            if(zeros[i] != 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
