package designMode.Builder;

/***************************************************************************
 @description :
 在了解之前，先假设有一个问题，我们需要创建一个学生对象，
 属性有name,number,class,sex,age,school等属性，如果每一个属性都可以为空，
 也就是说我们可以只用一个name,也可以用一个school,name,或者一个class,number，
 或者其他任意的赋值来创建一个学生对象，这时该怎么构造？

 难道我们写6个1个输入的构造函数，15个2个输入的构造函数.......吗？
 这个时候就需要用到Builder模式了。给个例子，大家肯定一看就懂：
 @author      :    caoshipeng
 @copyright   :    华为技术有限公司（C），版权所有  2019-2020
 @modified    :    2019-09-16 12:32  caoshipeng  create
 ****************************************************************************/
public class Builder {
    static class Student{
        String name = null ;
        int number = -1 ;
        String sex = null ;
        int age = -1 ;
        String school = null ;

        //构建器，利用构建器作为参数来构建Student对象
        static class StudentBuilder{
            String name = null ;
            int number = -1 ;
            String sex = null ;
            int age = -1 ;
            String school = null ;
            public StudentBuilder setName(String name) {
                this.name = name;
                return  this ;
            }

            public StudentBuilder setNumber(int number) {
                this.number = number;
                return  this ;
            }

            public StudentBuilder setSex(String sex) {
                this.sex = sex;
                return  this ;
            }

            public StudentBuilder setAge(int age) {
                this.age = age;
                return  this ;
            }

            public StudentBuilder setSchool(String school) {
                this.school = school;
                return  this ;
            }
            public Student build() {
                return new Student(this);
            }
        }

        public Student(StudentBuilder builder){
            this.age = builder.age;
            this.name = builder.name;
            this.number = builder.number;
            this.school = builder.school ;
            this.sex = builder.sex ;
        }
    }

    public static void main( String[] args ){
        Student a = new Student.StudentBuilder().setAge(13).setName("LiHua").build();
        Student b = new Student.StudentBuilder().setSchool("sc").setSex("Male").setName("ZhangSan").build();
    }
}
