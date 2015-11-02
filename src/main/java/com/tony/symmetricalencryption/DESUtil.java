package com.tony.symmetricalencryption;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.tony.messagedigest.Base64Util;

/**
 * @Description:DES算法
 * @Author:tony
 * @Since:2015年11月2日
 */
public class DESUtil {

	/**
	 * @Description:生成DES算法的密钥
	 * @Author:tony
	 * @Since:2015年11月2日
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:String
	 */
	public static String genKeyDES() throws Exception{
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);
		SecretKey key = keyGen.generateKey();
		String base64Str = Base64Util.byte2base64(key.getEncoded());
		return base64Str;
	}
	
	/**
	 * @Description:把密钥字符串转化为SecretKey对象
	 * @Author:tony
	 * @Since:2015年11月2日
	 * @Param:@param base64Key
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:SecretKey
	 */
	public static SecretKey loadKeyDES(String base64Key) throws IOException{
		byte[] bytes = Base64Util.base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes,"DES");
		return key;
	}
	
	/**
	 * @Description:加密
	 * @Author:tony
	 * @Since:2015年11月2日
	 * @Param:@param source
	 * @Param:@param key
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:byte[]
	 */
	public static byte[] encryptDES(byte[] source,SecretKey key) throws Exception{
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	/**
	 * @Description:解密
	 * @Author:tony
	 * @Since:2015年11月2日
	 * @Param:@param source
	 * @Param:@param key
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:byte[]
	 */
	public static byte[] decryptDES(byte[] source,SecretKey key) throws Exception{
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
}
