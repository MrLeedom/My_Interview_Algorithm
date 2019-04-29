package com.leedom;

/**
 * @author:leedom
 * @date: 3/28/19 10:53 AM
 * Description:
 *      前缀表达式,中缀表达式,后缀表达式
 *    中缀是人最能识别的类型,可计算机不像人脑这么强大,所以他对于计算的问题还是以前缀表达式或者后缀表达式的方式来做的.
 * License: (C)Copyright 2019
 */

import java.util.Scanner;

/*********************************************  栈的定义(字符)  ************************************************/
class MyCharStack {
    private char[] array;
    private int maxSize;
    private int top;

    public MyCharStack(int size){
        this.maxSize = size;
        array = new char[size];
        top = -1;
    }

    //压入数据
    public void push(char value){
        if(top < maxSize-1){
            array[++top] = value;
        }
    }

    //弹出栈顶数据
    public char pop(){
        return array[top--];
    }

    //访问栈顶数据
    public char peek(){
        return array[top];
    }

    //查看指定位置的元素
    public char peekN(int n){
        return array[n];
    }

    //为了便于后面分解展示栈中的内容，我们增加了一个遍历栈的方法(实际上栈只能访问栈顶元素的)
    public void displayStack(){
        System.out.print("Stack(bottom-->top):");
        for(int i = 0 ; i < top+1; i++){
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println("");
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull(){
        return (top == maxSize-1);
    }

}

/***************************************  中缀表达式转成后缀表达式  **********************************************/
public class InfixToSuffix {
    //定义运算符栈
    private MyCharStack s1;
    //定义存储结果栈
    private MyCharStack s2;
    private String input;

    //默认构造方法，参数为输入的中缀表达式
    public InfixToSuffix(String in){
        input = in;
        s1 = new MyCharStack(input.length());
        s2 = new MyCharStack(input.length());
    }
    //中缀表达式转换为后缀表达式，将结果存储在栈中返回，逆序显示即后缀表达式
    public MyCharStack doTrans(){
        for(int j = 0 ; j < input.length() ; j++){
            System.out.print("s1栈元素为：");
            s1.displayStack();
            System.out.print("s2栈元素为：");
            s2.displayStack();
            char ch = input.charAt(j);
            System.out.println("当前解析的字符:"+ch);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    //如果当前字符是'(',则将其入栈
                    s1.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    //1、如果当前解析的字符是操作数，则直接压入s2
                    //2、
                    s2.push(ch);
                    break;
            }//end switch
        }//end for

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2;
    }

    public void gotOper(char opThis,int prec1){
        while(!s1.isEmpty()){
            char opTop = s1.pop();
            //如果栈顶是'(',直接将操作符压入s1
            if(opTop == '('){
                s1.push(opTop);
                break;
            }else{
                int prec2;
                if(opTop == '+' || opTop == '-'){
                    prec2 = 1;
                }else{
                    prec2 = 2;
                }
                //如果当前运算符比s1栈顶运算符优先级高，则将运算符压入s1
                if(prec2 < prec1){
                    s1.push(opTop);
                    break;
                }else{
                    //如果当前运算符与栈顶运算符相同或者小于优先级别，那么将S1栈顶的运算符弹出并压入到S2中
                    //并且要再次再次转到while循环中与 s1 中新的栈顶运算符相比较；
                    s2.push(opTop);
                }
            }

        }//end while
        //如果s1为空，则直接将当前解析的运算符压入s1
        s1.push(opThis);
    }

    //当前字符是 ')' 时，如果栈顶是'(',则将这一对括号丢弃，否则依次弹出s1栈顶的字符，压入s2，直到遇到'('
    public void gotParen(char ch){
        while(!s1.isEmpty()){
            char chx = s1.pop();
            if(chx == '('){
                break;
            }else{
                s2.push(chx);
            }
        }
    }

    /******************************************  计算机如何实现后缀表达式的运算  ***************************************/
    class MyIntStack {
        private int[] array;
        private int maxSize;
        private int top;

        public MyIntStack(int size){
            this.maxSize = size;
            array = new int[size];
            top = -1;
        }

        //压入数据
        public void push(int value){
            if(top < maxSize-1){
                array[++top] = value;
            }
        }

        //弹出栈顶数据
        public int pop(){
            return array[top--];
        }

        //访问栈顶数据
        public int peek(){
            return array[top];
        }

        //查看指定位置的元素
        public int peekN(int n){
            return array[n];
        }

        //为了便于后面分解展示栈中的内容，我们增加了一个遍历栈的方法(实际上栈只能访问栈顶元素的)
        public void displayStack(){
            System.out.print("Stack(bottom-->top):");
            for(int i = 0 ; i < top+1; i++){
                System.out.print(peekN(i));
                System.out.print(' ');
            }
            System.out.println("");
        }

        //判断栈是否为空
        public boolean isEmpty(){
            return (top == -1);
        }

        //判断栈是否满了
        public boolean isFull(){
            return (top == maxSize-1);
        }

    }

    /**
     * 1.从左往右扫描
     * 2.遇到数字的话,压入栈中
     * 3.遇到运算符,弹出栈顶两个数,并用运算符对这两个数做相应的计算,并将结果入栈
     * 4.重复上述2.3步骤,直到表达式右端,最后的值即为表达式的结果
     */
    class CalSuffix{
        private MyIntStack stack;
        private String input;

        public CalSuffix(String input) {
            this.input = input;
            stack = new MyIntStack(input.length());
        }

        public int doCalc() {
            int num1, num2, result;
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c >= '0' && c <= '9') {
                    //如果是数字的话,直接压入栈中
                    stack.push((int)(c-'0'));
                } else {
                    //注意先出来的为第二个操作数
                    num2 = stack.pop();
                    num1 = stack.pop();
                    switch (c) {
                        case '+' :
                            result = num1 + num2;
                            break;
                        case '-' :
                            result = num1 - num2;
                            break;
                        case '*' :
                            result = num1 * num2;
                            break;
                        case '/' :
                            result = num1 / num2;
                            break;
                        default:
                            result = 0;
                            break;
                    }
                    stack.push(result);
                }
            }
            result = stack.pop();
            return result;
        }
    }

    /********************************************  测试部分  *******************************************************/
    public static void main(String[] args){
        /***********  第一部分:将中缀表达式转成后缀表达式  ************/
        String input;
        System.out.println("enter infix:");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        InfixToSuffix in = new InfixToSuffix(input);
        MyCharStack my = in.doTrans();
        my.displayStack();
        /***********  第二部分:计算机识别后缀表达式  ************/
    }
}
