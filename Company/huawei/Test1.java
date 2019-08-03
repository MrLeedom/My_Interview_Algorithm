package huawei;
/**
 * @author:leedom
 * @date: 4/10/19 7:05 PM
 * Description:
 * 思路:1.首先将字符串存到数组中,
 *     2.接下来对每个字符串进行处理,长度以及补全以及截取等操作
 *     3.按照ASCII排序进行操作
 * License: (C)Copyright 2019
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Test1 {
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
        public static void print(String[] array) {
            for(int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                System.out.print("  ");
            }
        }
        public static void main(String[] args) {
//            String str = "1234567";
//            System.out.println(str+'0'*2);
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            String[] strs = new String[number];
            for(int i = 0; i < number; i++) {
                String temp = in.next();
                strs[i] = temp;
            }

            Vector<String> vector = new Vector<>();
            for(int j = 0; j < strs.length; j++) {
                char[] charArray = strs[j].toCharArray();
                int block_number = 0;
                if ( charArray.length % 8 == 0) {
                    block_number = charArray.length / 8;
                } else {
                    block_number = charArray.length / 8 + 1; 
                }
                //拆分成多少块,并将其放到容器中
                for(int k = 1; k <= block_number; k++) {
                    if(k != block_number) {
                        vector.add(strs[j].substring((k-1)*8, (k-1) * 8 + 8));
                    } else {
                        vector.add(strs[j].substring((k-1)*8, strs[j].toCharArray().length));
                    }

                }
            }
            Vector<String> output = new Vector<>();
            //最后对容器内部进行排序和补全操作
            for(int m = 0; m < vector.size(); m++){
                String temp = vector.get(m);
                int count = 8 - vector.get(m).length();
                while(count-- != 0) {
                    temp +=  "0";
                }
                output.add(temp);
            }
            //对于字符串进行升序
            String[] result = new String[output.size()];
            for(int n = 0; n < output.size(); n++) {
                result[n] = output.get(n);
            }
            Arrays.sort(result);
            print(result);
        }
        

}
