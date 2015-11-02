package com.tony.messagedigest;

import java.security.MessageDigest;

public class MD5Util {
	public static byte[] getMD5Bytes(String content) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = md.digest(content.getBytes("utf-8"));
		return bytes;
	}
	
	public static String getMD5Str(String content)  throws Exception{
		byte[] bytes = getMD5Bytes(content);
		return new String(bytes,"utf-8");
	}
}
