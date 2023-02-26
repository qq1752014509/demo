package com.dy.demo.design.proxy;

public class ChanelSupplier implements IStore{

    @Override
    public void pay(String money) {
        System.out.println("已购买" + money +"元的商品");
    }

}
