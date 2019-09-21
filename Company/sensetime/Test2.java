package sensetime;

/***************************************************************************
 @description :
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-21 20:10  caoshipeng  create
 ****************************************************************************/
public class Test2 {
    public static void main(String[] args) {
        int number = 9;
        System.out.println(judgeEven(number));
    }

    /**
     * 主要是拿这个数跟1逻辑与运算：num & 1 = 0 偶数;num & 1 = 1 奇数
     * @param target
     * @return
     */
    public static boolean judgeEven(int target) {
        int result = target & 1;
        if(result == 1) {
            return false;
        }else{
            return true;
        }
    }
}
