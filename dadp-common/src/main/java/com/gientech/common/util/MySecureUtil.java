package com.gientech.common.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * 加密解密工具类，依赖hutool工具包
 * 
 * @author 胡砥峰
 *
 */
public class MySecureUtil {

	private final static String KEY = "1234565437892132";// 密匙

	/**
	 * 加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, HexUtil.encodeHexStr(KEY).getBytes());
		return aes.encryptHex(str);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 * @return
	 */
	public static String decrypt(String str) {
		SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, HexUtil.encodeHexStr(KEY).getBytes());
		return aes.decryptStr(str, CharsetUtil.CHARSET_UTF_8);
	}

	public static void main(String[] args) {

		// 明文
		String content = "DADP";
		System.out.println("明文:" + content);

		// 加密为16进制表示
		String encryptHex = MySecureUtil.encrypt(content);
		System.out.println("密文:" + encryptHex);

		// 解密为字符串
		String decryptStr = MySecureUtil.decrypt(encryptHex);
		System.out.println("明文:" + decryptStr);
	}

}
