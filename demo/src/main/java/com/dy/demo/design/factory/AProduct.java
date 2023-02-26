package com.dy.demo.design.factory;

public class AProduct implements IProduct{
    @Override
    public void aProduct() {
        System.out.println("创建产品。。。。内部业务逻辑");
    }
}
