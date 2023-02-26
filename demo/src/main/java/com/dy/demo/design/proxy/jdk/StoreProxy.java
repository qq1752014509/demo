package com.dy.demo.design.proxy.jdk;

import com.dy.demo.design.proxy.ChanelSupplier;
import com.dy.demo.design.proxy.IStore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 */
public class StoreProxy implements InvocationHandler {

    private Object store;

    public StoreProxy(Object store){
        this.store = store;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行相关业务逻辑，开始代理。。。。  jdk动态代理");

        //method.invoke()方法，反射调用  我们的真实对象提供服务
        Object invoke = method.invoke(store, args);

        System.out.println("执行相关业务逻辑，结束代理。。。。  jdk动态代理");
        return invoke;
    }


    public static void main(String[] args) {
        IStore chanelSupplier = new ChanelSupplier();
        StoreProxy storeProxy = new StoreProxy(chanelSupplier);

        /*
        JDK动态代理
        一个接口，一个普通类（实现一个接口）
        一个代理类（实现一个 InvocationHandler （int k 神）接口，重写invoke（int 窝可）方法）

         特点：必须代理类实现 invocationHandler 接口，重写invoke方法，利用反射，调用服务方法
               jdk版本越高，则越快，运行性能越高，在jdk1.8有显著提升
         */

        IStore iStore = (IStore) Proxy.newProxyInstance(chanelSupplier.getClass().getClassLoader(),
                chanelSupplier.getClass().getInterfaces(),
                storeProxy);
        iStore.pay("13");


    }
}
