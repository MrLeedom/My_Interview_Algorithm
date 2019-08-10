package JingDong;
import java.util.Scanner;

/**
 * @author:leedom
 * @date: 4/13/19 8:31 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String standard = "";
        for(int j = 1; j<=number;j++){
            standard += j;
        }
        int[] array = new int[number];
        int index=0;
        String input = "";
        
        while(index <= number-1){
            int ch = sc.nextInt();
            array[index++] = ch;
            input += ch;
        }
        char[] newArray = input.toCharArray();
        for(int k = 0; k < newArray.length; k++){
            if(newArray[k] == '1'){
                System.out.println(k);
            }
        }
    }
}
