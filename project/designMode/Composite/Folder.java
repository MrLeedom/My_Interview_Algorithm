package designMode.Composite;

/***************************************************************************
 @description :
 组合模式是为了表示那些层次结构，同时部分和完整也可能是一样的结构，常见的如文件夹和树。
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 12:52  caoshipeng  create
 ****************************************************************************/
abstract class component{}

class File extends  component{ String filename;}

class Folder extends  component{
    //既可以放文件File类，也可以放文件夹Folder类。Folder类下又有子文件或子文件夹。
    component[] files ;
    String foldername ;
    public Folder(component[] source){
        files = source ;
    }

    public void scan(){
        for ( component f:files){
            if ( f instanceof File){
                System.out.println("File "+((File) f).filename);
            }else if(f instanceof Folder){
                Folder e = (Folder)f ;
                System.out.println("Folder "+e.foldername);
                e.scan();
            }
        }
    }

}