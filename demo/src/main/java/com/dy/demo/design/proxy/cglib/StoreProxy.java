package com.dy.demo.design.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class StoreProxy implements MethodInterceptor {


    public <T> T getProxyInstance(Class<T> tclzz){
        //en跑僧，增强器
        Enhancer enhancer = new Enhancer();
        //设置需要增强类的加载器对象
        enhancer.setClassLoader(tclzz.getClassLoader());
        //设置需要增强的类
        //enhancer.setContextClass(tclzz);
        //设置方法拦截器，代理工厂
        enhancer.setCallback(this);
        //创建代理类
        return (T)enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //前置方法
        System.out.println("执行相关业务逻辑，开始代理。。。。  cglib动态代理");

        //调用真实服务对象
        Object object = methodProxy.invokeSuper(o, objects);

        //后置方法
        System.out.println("执行相关业务逻辑，结束代理。。。。  cglib动态代理");
        return object;
    }


    public static void main(String[] args) {
        //创建代理工厂，获取被代理的对象
        StoreProxy factory = new StoreProxy();
        //获取增强之后的被代理对象
        ChanelSupplier supplier = factory.getProxyInstance(ChanelSupplier.class);
        //执行方法
        supplier.pay("13");

        /*
        cglib动态代理
        一个普通类（没有实现接口），一个代理类实现MethodInterceptor 重写intercept（in 铺set）方法
        通过Enhancer增强器对目标类进行增强

        jdk动态代理和cglib动态代理的区别
        jdk：对实现接口的类进行代理，cglib对普通类进行代理
        jdk：通过反射对目标类进行动态代理，cglib通过对目标类生成一个子类，对目标方法进行拦截来进行动态代理(目标类不能final修饰)
        jdk: 代理实现InvocationHandler接口 重写invoke方法，cglib代理实现MethodInterceptor接口，重写intercept方法


         */
    }

}
