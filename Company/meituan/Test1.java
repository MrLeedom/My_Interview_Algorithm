package meituan;

import java.util.Scanner;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-11 14:52  caoshipeng  create
 ****************************************************************************/
public class Test1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = str.substring(1, str.length()-1);
        String[] arr = newStr.split(",");
        Double[] nums = new Double[arr.length];
        StringBuilder result = new StringBuilder();
        result.append("[");
        for(int i = 0; i < arr.length; i++) {

            nums[i] = Double.parseDouble(arr[i].substring(1, arr[i].length()-1));
            String tmp = toChinaUpper(arr[i].substring(1, arr[i].length()-1));
            result.append("\"");
            result.append(tmp);
            result.append("\", ");
        }
        result.deleteCharAt(result.lastIndexOf(","));
        result.deleteCharAt(result.lastIndexOf(" "));

        result.append("]");
        System.out.println(result);
    }

    /**
     * 转换为中国人民币大写字符串,精确到分
     * @param engnumber 传入小写数字字符串
     * @return
     * @throws Exception
     */
    public static String toChinaUpper(String engnumber) throws Exception {
        boolean lessZero = false;
        if(engnumber.startsWith("-")) {
            engnumber = engnumber.substring(1);
            lessZero = true;
        }

        if (!engnumber.matches("^[0-9]*$|^0+\\.[0-9]+$|^[1-9]+[0-9]*$|^[1-9]+[0-9]*.[0-9]+$")) {
            throw new Exception("money format error!");
        }
        String[] part = engnumber.split("\\.");
        String front = part[0];
        String end = part.length > 1 ? part[1] : "";
        //替换前置0
        if(front.matches("^0+$"))
        {
            front = "0";
        }else if(front.matches("^0+(\\d+)$")){
            front = front.replaceAll("^0+(\\d+)$", "$1");
        }

        StringBuffer integer = new StringBuffer();
        for (int i = 0; i < front.length(); i++) {
            char perchar = front.charAt(i);
            integer.append(changeName(perchar));
            integer.append(changeName(front.length() - i - 1));
        }
        StringBuffer special = new StringBuffer();
        if (part.length > 1 && !"00".equals(end)) {
            int length = end.length() >= 2 ? 2 : end.length();
            for (int i = 0; i < length; i++) {
                char perchar = end.charAt(i);
                special.append(changeName(perchar));
                if (i == 0)
                    special.append('角');
                if (i == 1)
                    special.append('分');
            }
        }
        String result = integer.toString() + special.toString();
        result = dispose(result);
        if(lessZero && !"零元整".equals(result)) {
            result = "负" + result;
        }
        return result;
    }

    private static char changeName(char number) {
        switch (number) {
            case '0':
                return '零';
            case '1':
                return '壹';
            case '2':
                return '贰';
            case '3':
                return '叁';
            case '4':
                return '肆';
            case '5':
                return '伍';
            case '6':
                return '陆';
            case '7':
                return '柒';
            case '8':
                return '捌';
            case '9':
                return '玖';
        }
        return '0';
    }

    private static char changeName(int index) {
        int realIndex =  index  % 9;
        if(index > 8) {//亿过后进入回归,之后是十,百...
            realIndex =  (index - 9) % 8;
            realIndex = realIndex + 1;
        }
        switch (realIndex) {
            case 0:
                return '元';
            case 1:
                return '十';
            case 2:
                return '百';
            case 3:
                return '千';
            case 4:
                return '万';
            case 5:
                return '十';
            case 6:
                return '百';
            case 7:
                return '千';
            case 8:
                return '亿';
        }
        return '0';
    }

    private static String dispose(String result) {
        result = result.replaceAll("0", "");//处理
        result = result.replaceAll("零千零百零十|零千零百|零百零十|零千|零百|零十", "零");
        result = result.replaceAll("零+", "零").replace("零亿", "亿");
        result = result.matches("^.*亿零万[^零]千.*$") ? result.replace("零万", "零") : result.replace("零万", "万");
        result = result.replace("亿万", "亿");
        //处理小数
        result = result.replace("零角", "零").replace("零分", "");
        result = result.replaceAll("(^[零元]*)(.+$)", "$2");
        result = result.replaceAll("(^.*)([零]+元)(.+$)", "$1元零$3");

        //处理整数单位
        result = result.replaceAll("元零角零分|元零角$|元$|^零$|元零$|零元$", "元整");
        result = result.replaceAll("^元整$", "零元整");


        return result;
    }

}
