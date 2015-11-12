package com.tony.symmetric;

import javax.crypto.SecretKey;

import org.junit.Test;

import com.tony.messagedigest.Base64Util;

public class AESTest {

	@Test
	public void testAESEncrypt() throws Exception{
		String testStr = "Hello World !";
		String keyStr = AESUtil.genKeyAES();
		System.out.println(keyStr);
		SecretKey key = AESUtil.loadKeyAES(keyStr);
		byte[] bytes = AESUtil.encryptAES(testStr.getBytes("UTF-8"), key);
		System.out.println(Base64Util.byte2base64(bytes));
	}
	
}
