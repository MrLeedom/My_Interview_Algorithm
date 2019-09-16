package util;

/***************************************************************************
 @description :
 ipv4的地址可分解成4段，每段范围0～255；int类型的变量同样也有4个字节，每个字节的上限也是255（11111111），
 且每个字节都有8位，结合这两个特性，可以把IP地址的每一段分别对应到int的每个字节当中，因为要存储到一个int变量中，
 所以要在存储时依次位移8位，这样一个IP便可以保存在一个int类型变量中。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-15 21:57  caoshipeng  create
 ****************************************************************************/
public class IpConvert {
    public static void main(String[] args) {
        String ip = "172.185.255.233";

        //step1:分解IP字符串，并对应写入字节数组
        byte[] ip1 = ipToBytes(ip);

        //step2:对字节数组里的每个字节进行左移位处理，分别对应到整形变量的4个字节
        int ip2 = bytesToInt(ip1);
        System.out.println("整形IP---->" + ip2);

        //step3：对整形变量进行右移位处理，恢复IP字符串
        String ip3 = intToIp(ip2);
        System.out.println("字符串IP---->" + ip3);
    }

    /**
     * 把int -> string地址
     * @param ipInt
     * @return
     */
    private static String intToIp(int ipInt) {
        return new StringBuilder()
                .append(((ipInt >> 24) & 0xff)).append('.')
                .append(((ipInt >> 16) & 0xff)).append('.')
                .append(((ipInt >> 8) & 0xff)).append('.')
                .append((ipInt & 0xff))
                .toString();
    }

    /**
     * 根据位运算把byte[] -> int
     * 原理：将每个字节强制转为8位二进制码，然后左移8位，对应到int变量的4个字节中
     * @param bytes
     * @return
     */
    private static int bytesToInt(byte[] bytes) {
        //初始化int变量addr=0
        int addr = 0;
        //强制转化为8位二进制码，比如原码101，强转后00000101
        addr |= (bytes[0] &0xFF);
        //左移8位，给下个字节的拼接创造环境
        addr = addr << 8;
        addr |= (bytes[1] &0xFF);
        addr = addr << 8;
        addr |= (bytes[2] &0xFF);
        addr = addr << 8;
        addr |= (bytes[3] &0xFF);
        addr = addr << 8;
        return addr;
    }

    /**
     * step1：把IP地址分解为一个byte数组
     * @param ip
     * @return
     */
    private static byte[] ipToBytes(String ip) {
        byte[] ret = new byte[4];
        String[] ipArr = ip.split("\\.");
        try{
            ret[0] = (byte)(Integer.parseInt(ipArr[0]));
            ret[1] = (byte)(Integer.parseInt(ipArr[1]));
            ret[2] = (byte)(Integer.parseInt(ipArr[2]));
            ret[3] = (byte)(Integer.parseInt(ipArr[3]));
            return ret;
        }catch (Exception e) {
            throw new IllegalArgumentException("invalid ip:" + ipArr );
        }
    }
}
