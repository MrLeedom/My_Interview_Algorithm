package test;

import com.leedom.MyArray;

import static org.junit.Assert.*;

/**
 * @author:leedom
 * @date: 3/28/19 4:16 PM
 * Description:
 * License: (C)Copyright 2019
 */
public class MyArrayTest {
    public static void main(String[] args){
        //创建自定义封装数组结构，数组大小为4
        MyArray array = new MyArray(4);
        //添加4个元素分别是1,2,3,4
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        //显示数组元素
        array.display();
        //根据下标为0的元素
        int i = array.get(0);
        System.out.println(i);
        //删除4的元素
        array.delete(4);
        //将元素3修改为33
        array.modify(3, 33);
        array.display();
    }

}