package com.tony.messagedigest;

import org.junit.Test;


public class MD5Test{
	
	@Test
	public void testMD5() throws Exception{
		System.out.println(MD5Util.getMD5Str("Hello World"));
	}
}