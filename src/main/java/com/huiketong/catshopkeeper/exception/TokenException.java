package com.huiketong.catshopkeeper.exception;

public class TokenException extends  Exception{

    private static final long serialVersionUID = 1L;

    // 提供无参数的构造方法
    public TokenException() {
    }

    // 提供一个有参数的构造方法，可自动生成
    public TokenException(String message) {
        super(message);// 把参数传递给Throwable的带String参数的构造方法
    }

}
