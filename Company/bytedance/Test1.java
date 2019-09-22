package bytedance;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-22 08:10  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[number+1];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }
        int count = 1;

        String str = sc.nextLine();
        char[] array = str.toCharArray();
        for(int k = 0; k < array.length; k++) {
            if(array[k] == 'O') {
                nums[count++] = k;
            }
        }
        //record 'o' position, calculate
        int first = 0;
        int second = 1;
        for(int m = 0; m < array.length; m++) {
            if(array[m] == 'O') {
                System.out.print(0 + " ");
                first++;
                second++;
            }else{
                int before = nums[first] == -1 ? 3 * number: nums[first];
                int after = nums[second] == -1 ? 3 * number: nums[second];
                int result = Math.min(Math.abs(m - before), Math.abs(after - m));
                System.out.print(result + " ");
            }
        }

    }
}
