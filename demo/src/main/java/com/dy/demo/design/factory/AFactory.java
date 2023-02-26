package com.dy.demo.design.factory;

public class AFactory implements IFactory{
    @Override
    public IProduct iFactory() {
        System.out.println("工厂创建 a产品，并执行相关业务逻辑");
        return new AProduct();
    }
}
