package com.tony.symmetric;

import javax.crypto.SecretKey;

import org.junit.Test;

import com.tony.messagedigest.Base64Util;

/**
 * @Description:Test For DES
 * @Author:tony
 * @Since:2015年11月2日
 */
public class DESTest {
	
	@Test
	public void testEncrytAndDecrypt() throws Exception{
		
		//generate des key
		String keyStr = DESUtil.genKeyDES();
		System.out.println(keyStr);
		
		//transfer string key to SecretKey object
		SecretKey key = DESUtil.loadKeyDES(keyStr);
		
		//encrypt 
		byte[] source = "Hello DES !".getBytes("UTF-8");
		byte[] encResult = DESUtil.encryptDES(source, key);
		String base64Str = Base64Util.byte2base64(encResult); //base64
		System.out.println(base64Str);
		
		//decrypt
		byte[] source2 = Base64Util.base642byte(base64Str);
		byte[] decResult = DESUtil.decryptDES(source2, key);
		System.out.println(new String(decResult,"UTF-8"));
	}
}
