package com.tony.asymmetric;

import java.security.KeyPair;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.junit.Test;

import com.tony.messagedigest.Base64Util;

public class RSATest {
	@Test
	public void testRSA() throws Exception {
		KeyPair keyPair = RSAUtil.getKeyPair();

		String publicKey = RSAUtil.getPublicKey(keyPair);
		System.out.println(publicKey);

		String privateKey = RSAUtil.getPrivateKey(keyPair);
		System.out.println(privateKey);

		String content = "Hello World !";

		byte[] bytes = RSAUtil.publicEncrypt(content.getBytes("UTF-8"),
				RSAUtil.string2PublicKey(publicKey));
		System.out.println(Base64Util.byte2base64(bytes));

		byte[] decBytes = RSAUtil.privateDecrypt(bytes,
				RSAUtil.string2PrivateKey(privateKey));
		System.out.println(StringUtils.newStringUtf8(decBytes));

	}
}
