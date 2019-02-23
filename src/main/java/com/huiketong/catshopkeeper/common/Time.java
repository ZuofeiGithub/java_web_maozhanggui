package com.huiketong.catshopkeeper.common;


import com.huiketong.catshopkeeper.exception.DateException;

public class Time {

    public static void main(String[] args)  {
        try {
            kk(0);
        } catch (DateException e) {
            System.out.println(e.getMessage());
        }
    }

   public  static void kk(int num) throws DateException {
       if(num==0){
           throw new DateException("除数不能为0");
       }else{
           int i=10/num;
       }
   }

}
