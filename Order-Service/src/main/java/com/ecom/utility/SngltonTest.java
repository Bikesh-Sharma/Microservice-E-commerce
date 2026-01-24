package com.ecom.utility;

public class SngltonTest {

   private static SngltonTest getInstance;

   private SngltonTest(){

   }
   public static SngltonTest getInstance(){
       if (getInstance==null){
           getInstance = new SngltonTest();
       }
       return getInstance;
   }



}
