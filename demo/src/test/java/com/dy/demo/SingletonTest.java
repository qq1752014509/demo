package com.dy.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SingletonTest {



    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0, 0);
        System.out.println(list);

        HashMap<String, Object> map = new HashMap<>();
        map.put("123", "324");
        Object o = map.get("123");

    }




}

class Singleton {
    private Singleton(){

    }

    private static volatile Singleton s;

    public static Singleton getSingleton(){
        if (null == s){
            synchronized (Singleton.class){
                if(null == s){
                    s = new Singleton();
                }
            }
        }
        return s;
    }


}
