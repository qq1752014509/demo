package com.dy.demo.design.proxy.staticState;

import com.dy.demo.design.proxy.ChanelSupplier;
import com.dy.demo.design.proxy.IStore;

public class StoreProxy implements IStore {

    private IStore store;

    public StoreProxy(IStore chanelSupplier){
        this.store = chanelSupplier;
    }

    @Override
    public void pay(String money) {
        System.out.println("开始代理。。。。");

        store.pay(money);

        System.out.println("结束代理。。。。");
    }


    public static void main(String[] args) {

        /*
        静态代理：

        一个接口，一个普通类（正常实现一个接口）
        一个代理类（正常实现一个接口），通过构造方法把普通类装进来
                                  方法重写内部，调用普通类的方法，并做增强
        缺点：不太灵活，不符合开闭原则，在业务变化多的场景下 不适用
         */

        ChanelSupplier chanelSupplier = new ChanelSupplier();
        StoreProxy storeProxy = new StoreProxy(chanelSupplier);
        storeProxy.pay("13");

    }



}
