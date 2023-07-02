package com.gientech.core.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * jasypt-spring-boot-starter
 * <p>
 * 生成密文的工具代码
 */
public class JasyptUtil {
    public static void main(String[] args) {

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        // 加密所需的salt
        textEncryptor.setPassword("gientech");

        // 要加密的数据（数据库的用户名或密码）
        String password = textEncryptor.encrypt("admin");

        System.out.println("加密后:" + password);
    }
}
