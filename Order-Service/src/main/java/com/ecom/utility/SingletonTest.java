package com.ecom.utility;

public class SingletonTest {

   public static SingletonTest instance;
    private SingletonTest(){

    }
    public static SingletonTest getInstance(){
        if (instance==null){
            instance=new SingletonTest();
        }
        return instance;
    }



}
