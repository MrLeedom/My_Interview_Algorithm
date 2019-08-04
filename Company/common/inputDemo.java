package common;

import java.util.Scanner;

/***************************************************************************
 @description :
 Java 5添加了java.util.Scanner类，这是一个用于扫描输入文本的新的实用程序。它是以前的StringTokenizer和Matcher类之间的某种结合。
 由于任何数据都必须通过同一模式的捕获组检索或通过使用一个索引来检索文本的各个部分。于是可以结合使用正则表达式和从输入流中检索特定类型数据项的方法。
 这样，除了能使用正则表达式之外，Scanner类还可以任意地对字符串和基本类型(如int和double)的数据进行分析。借助于Scanner，可以针对任何要处理的文本内容编写自定义的语法分析器。

 Scanner是SDK1.5新增的一个类,可使用该类创建一个对象。

 Scanner reader=new Scanner(System.in);　

 然后reader对象调用下列方法（函数）,读取用户在命令行输入的各种数据类型　　

 next.Byte(),nextDouble(),nextFloat,nextInt(),nextLine(),nextLong(),nextShot()　

 上述方法执行时都会造成堵塞,等待用户在命令行输入数据回车确认.例如,拥护在键盘输入12.34，hasNextFloat()的值是true,而hasNextInt()的值是false。
 NextLine()等待用户输入一个文本行并且回车，该方法得到一个String类型的数据。

 Scanner的构造器支持多种方式，可以从字符串（Readable）、输入流、文件等等来直接构建Scanner对象，有了Scanner了，就可以逐段（根据正则分隔式）来扫描整个文本，
 并对扫描后的结果做想要的处理。

 下面是一些API函数的用法：

 delimiter() ：返回此 Scanner 当前正在用于匹配分隔符的 Pattern。
 hasNext() ：判断扫描器中当前扫描位置后是否还存在下一段。（原APIDoc的注释很扯淡）
 hasNextLine() ：如果在此扫描器的输入中存在另一行，则返回 true。
 next() ：查找并返回来自此扫描器的下一个完整标记。
 nextLine() ：此扫描器执行当前行，并返回跳过的输入信息。

 next() 与 nextLine() 区别

 next():
     1、一定要读取到有效字符后才可以结束输入。以空格、回车、Tab键都会视为结束符。。
     2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
     3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
           next() 不能得到带有空格的字符串。
 nextLine()：
     1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。

     2、可以获得空白。

 注意：建议能不使用就尽量不要使用nextLine()。尽量使用next。因为有时会出现吃回车现象。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-08-04 09:57  caoshipeng  create
 ****************************************************************************/
public class inputDemo {
    public static void main(String args[]) {
        String str = null;
        String str2;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            str2 = in.next();
            System.out.println("next:");
            System.out.println(str2);
            str = in.nextLine();
            System.out.println("nextLine:");
            System.out.println(str);

            str = null;
            break;
        }
        in.close();

    }
}
