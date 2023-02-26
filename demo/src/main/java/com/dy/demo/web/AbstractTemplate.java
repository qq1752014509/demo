package com.dy.demo.web;

public abstract class AbstractTemplate {

    protected final void ss(){
        a();
        b();
        c();
    }

    protected abstract void a();

    protected abstract void b();

    protected abstract void c();

}

class mdl extends AbstractTemplate {

    @Override
    public void a() {
        System.out.println("麦当劳  养鸡");
    }

    @Override
    public void b() {
        System.out.println("麦当劳  杀鸡");
    }

    @Override
    public void c() {
        System.out.println("麦当劳  炸鸡");
    }
}

class kdj extends AbstractTemplate {

    @Override
    public void a() {
        System.out.println("肯德基  养鸡");
    }

    @Override
    public void b() {
        System.out.println("肯德基  杀鸡");
    }

    @Override
    public void c() {
        System.out.println("肯德基  炸鸡");
    }
}

class atest{
    public static void main(String[] args) {
        /*
        模板模式
        父类去控制行为，子类根据实际情况去重写 每个子类特有的内容
        减少代码的重复，重用性提高


         */
        AbstractTemplate mdl = new mdl();
        mdl.ss();

        AbstractTemplate kdj = new kdj();
        kdj.ss();
    }


}
