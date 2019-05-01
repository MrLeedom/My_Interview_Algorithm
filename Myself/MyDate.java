import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author:leedom
 * @date: 4/30/19 9:09 AM
 * Description:
 * License: (C)Copyright 2019
 */
public class MyDate {
    //设置为常量,提高可扩展性
    private static final String DEFAULT_PATTERN = "yyyy-mm-dd";

    private MyDate() {

    }
    /**
     * 将时间根据指定格式进行转换
     * @param date
     * @param format
     * @return
     */
    public static String getDateFormatString(Date date, String format) {
        if(date == null) {
            return "";
        } else {
            DateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }

    }

    /**
     *将字符串转成日期
     * @param date  时间戳
     * @param format
     * @return
     * @throws ParseException
     */
    public static String stringToDate(String date, String format) {
        if(date == null || date.isEmpty() || date.equals("null")) {
            return "";
        }
        if(format == null || format.isEmpty()) {
            format = DEFAULT_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(date+"000")));
    }

    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getDateFormatString(new Date(), "yyyy-MM-dd HH:mm:ss") );
        String timeStamp = timeStamp();
        System.out.println(stringToDate(timeStamp.toString(),"yyyy-MM-dd"));
    }
}
