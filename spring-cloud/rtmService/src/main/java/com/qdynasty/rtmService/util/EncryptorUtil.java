package com.qdynasty.rtmService.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class EncryptorUtil {

	public static void main(String[] args) {
		// 加密工具
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		// 加密配置
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		// 自己在用的时候更改此密码
		config.setPassword("123456");
		// 应用配置
		encryptor.setConfig(config);
		String plaintext = "gathink";
		// 加密
		String ciphertext = encryptor.encrypt(plaintext);
		System.out.println(plaintext + " : " + ciphertext);

	}
}
