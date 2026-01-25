package com.ecom.utility;

public class SingletonTest {


    public static SingletonTest instance;
    public static SingletonTest getInstance(){
        if (instance==null){
            instance=new SingletonTest();
        }
        return instance;
    }





}
