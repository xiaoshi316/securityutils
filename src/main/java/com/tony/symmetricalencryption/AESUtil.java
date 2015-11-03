package com.tony.symmetricalencryption;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.tony.messagedigest.Base64Util;

/**
 * @Description:AES算法
 * @Author:tony
 * @Since:2015年11月3日
 */
public class AESUtil {

	/**
	 * @Description:生成AES密钥
	 * @Author:tony
	 * @Since:2015年11月3日
	 * @Param:@return
	 * @Param:@throws NoSuchAlgorithmException
	 * @Return:String
	 */
	public static String genKeyAES() throws NoSuchAlgorithmException {
		/**
		 * 通过KeyGenerator获取密钥生成器的实例后，设置密钥为128位，
		 * 便可生成AES算法的密钥，并且每次生成的都不相同
		 */
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey key = keyGen.generateKey();
		//为了方便存储，一般将得到的DES密钥Base64编码成字符串
		String base64Str = Base64Util.byte2base64(key.getEncoded());
		return base64Str;
	}

	/**
	 * @Description:把Base64字符串转换为SecretKey
	 * @Author:tony
	 * @Since:2015年11月3日
	 * @Param:@param base64Key
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:SecretKey
	 */
	public static SecretKey loadKeyAES(String base64Key) throws IOException {
		byte[] bytes = Base64Util.base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "AES");
		return key;
	}

	/**
	 * @Description:加密
	 * @Author:tony
	 * @Since:2015年11月3日
	 * @Param:@param source
	 * @Param:@param key
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:byte[]
	 */
	public static byte[] encryptAES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}

	/**
	 * @Description:解密
	 * @Author:tony
	 * @Since:2015年11月3日
	 * @Param:@param source
	 * @Param:@param key
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:byte[]
	 */
	public static byte[] decryptAES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
}
