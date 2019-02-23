package com.huiketong.catshopkeeper.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * 密码MD5加密
 *
 */
public class PwdMd5Util {
    /**
     * 密码MD5加密
     * @param password
     * @return
     */
    public static String md5Hex(String password){

        return DigestUtils.md5Hex(password);
    }

    /**
     *随机生成用户名
     * @return
     */
    public static String makeRandomUserName(){
        char charr[] = "1234567890_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        for (int x = 0; x < 10; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }
}
