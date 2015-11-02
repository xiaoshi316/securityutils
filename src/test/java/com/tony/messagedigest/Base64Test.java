package com.tony.messagedigest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * @Description:Test For Base64
 * @Author:tony
 * @Since:2015年11月2日
 */
public class Base64Test {

	@Test
	public void testByte2base64() throws UnsupportedEncodingException{
		String testStr = "hello world";
		System.out.println(Base64Util.byte2base64(testStr.getBytes("UTF-8"))); //output:aGVsbG8gd29ybGQ=
	}
	
	@Test
	public void testBase642Byte() throws IOException{
		String base64 = "aGVsbG8gd29ybGQ=";
		byte[] result = Base64Util.base642byte(base64);
		System.out.println(new String(result,"UTF-8")); //output:hello world
	}
}
