package com.dy.demo.design.factory;

public class Test {
    public static void main(String[] args) {
        /*
        工厂模式
        1）
        简单工厂模式（静态工厂方法模式）
        通过参数的不同 决定实例最后哪一款产品
        细节：工厂类-》抽象产品-》普通产品

        2）
        抽象工厂模式
        主要用于创建相关对象的家族
        抽象工厂-》普通工厂（创建产品）-》抽象产品-》普通产品（普通产品声明细节）

        3）
        工厂方法模式：
        一个抽象工厂接口，一个普通工厂类（实现抽象工厂方法），通过工厂获取产品实例
        一个抽象产品接口，一个普通产品类（实现抽象产品方法）

        抽象工厂-》普通工厂（创建产品）-》抽象产品-》普通产品（普通产品声明细节）
         */
        IFactory a = new AFactory();
        IProduct iProduct = a.iFactory();
        iProduct.aProduct();
    }
}
