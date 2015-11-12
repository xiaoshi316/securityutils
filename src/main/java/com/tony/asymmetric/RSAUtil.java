package com.tony.asymmetric;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.tony.messagedigest.Base64Util;

/**
 *@Description:非对称算法  RSA
 *@Author:tony
 *@Since:2015年11月12日
 */
public class RSAUtil {

	/**
	 * @Description:产生一对密钥
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:KeyPair
	 */
	public static KeyPair getKeyPair() throws Exception{
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair  = keyPairGenerator.generateKeyPair();
		return keyPair;
	}
	
	/**
	 * @Description:获取公钥
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param keyPair
	 * @Param:@return
	 * @Return:String
	 */
	public static String getPublicKey(KeyPair keyPair){
		PublicKey publicKey = keyPair.getPublic();
		byte[] bytes = publicKey.getEncoded();
		return Base64Util.byte2base64(bytes);
	}
	
	/**
	 * @Description:获取私钥
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param keyPair
	 * @Param:@return
	 * @Return:String
	 */
	public static String getPrivateKey(KeyPair keyPair){
		PrivateKey privateKey = keyPair.getPrivate();
		byte[] bytes = privateKey.getEncoded();
		return Base64Util.byte2base64(bytes);
	}
	
	/**
	 * @Description:把Base64字符串转换为公钥
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param pubStr
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:PublicKey
	 */
	public static PublicKey string2PublicKey(String pubStr) throws Exception{
		byte[] keyBytes = Base64Util.base642byte(pubStr);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}
	
	/**
	 * @Description:把Base64字符串转换为私钥
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param priStr
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:PrivateKey
	 */
	public static PrivateKey string2PrivateKey(String priStr) throws Exception{
		byte[] keyBytes = Base64Util.base642byte(priStr);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	
	/**
	 * @Description:用公钥加密
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param content
	 * @Param:@param publicKey
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:byte[]
	 */
	public static byte[] publicEncrypt(byte[] content ,PublicKey publicKey) throws Exception{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bytes = cipher.doFinal(content);
		return bytes;
	}
	
	/**
	 * @Description:私钥解密
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param content
	 * @Param:@param privateKey
	 * @Param:@return
	 * @Param:@throws Exception
	 * @Return:byte[]
	 */
	public static byte[] privateDecrypt(byte[] content,PrivateKey privateKey) throws Exception{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE , privateKey);
		byte[] bytes = cipher.doFinal(content);
		return bytes;
	}
}
