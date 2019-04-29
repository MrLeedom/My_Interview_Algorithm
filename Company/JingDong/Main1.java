import java.util.Scanner;

/**
 * @author:leedom
 * @date: 4/13/19 6:39 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class Main1 {
    static boolean isOne(char ch){
        return ch == '1';
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input==null){
            System.out.println('0');
            System.exit(0);
        }
        int preCount=0;
        int maxCount = -1;
        int[] record = new int[input.length()-1];
        for(int i = 1 ; i <= input.length()-1; i++) {
            String temp1 = input.substring(input.length()-i,input.length());
            String temp2 = input.substring(0,input.length()-i);
            String newString = temp1 + temp2;
            char[] array = newString.toCharArray();


            for(int j = 0; j < array.length; j++) {
                preCount=0;
                int cur = j;
                if(isOne(array[cur])){
                    preCount++;
                }else{
                    continue;
                }
                cur++;
                while(cur <= array.length-1 && isOne(array[cur])) {
                    preCount++;
                    cur++;
                }
                if(preCount>maxCount){
                    maxCount=preCount;
                }
            }
        }
        System.out.println(maxCount);
    }
    
}
