package com.huiketong.catshopkeeper.exception;

/**
 * 日期处理异常
 */
public class DateException extends  Exception{
    private static final long serialVersionUID = 1L;

    // 提供无参数的构造方法
    public DateException() {
    }

    // 提供一个有参数的构造方法，可自动生成
    public DateException(String message) {
        super(message);// 把参数传递给Throwable的带String参数的构造方法
    }



}
