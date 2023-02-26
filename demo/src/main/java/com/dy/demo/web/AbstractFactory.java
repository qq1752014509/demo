package com.dy.demo.web;

import org.apache.commons.lang3.StringUtils;

public interface AbstractFactory {
    public abstract AbstractProduct createFactory();
}

class AFactory implements AbstractFactory {

    @Override
    public AbstractProduct createFactory() {
        System.out.println("创建A工厂");
        return new AProduct();
    }
}

class BFactory implements AbstractFactory {

    @Override
    public AbstractProduct createFactory() {
        System.out.println("创建B工厂");
        return new BProduct();
    }
}

interface AbstractProduct {
    public abstract void createProduct();
}

class AProduct implements AbstractProduct {

    @Override
    public void createProduct() {
        System.out.println("创建A产品");
    }
}

class BProduct implements AbstractProduct {

    @Override
    public void createProduct() {
        System.out.println("创建B产品");
    }
}

class C {

    public static void main(String[] args) {
        /*
        简单工厂：一个抽象工厂，二个具体产品继承实现工厂，根据参数 指定创建哪款产品

        工厂方法：一个抽象工厂和一个抽象产品，二个具体工厂和具体产品，
                连接点具体工厂类返回值为抽象产品
                抽象工厂-> 具体工厂（返回值为抽象产品，实现为具体产品）-> 抽象产品-> 具体产品

         抽象工厂：一个抽象工厂和多个抽象工厂，多个具体工厂、多个具体产品

         */
        AFactory aFactory = new AFactory();
        AbstractProduct factory = aFactory.createFactory();
        factory.createProduct();

        BFactory bFactory = new BFactory();
        AbstractProduct factory1 = bFactory.createFactory();
        factory1.createProduct();

    }
}


