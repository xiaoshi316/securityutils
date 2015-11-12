package com.tony.messagedigest;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @Description:Base64算法的使用
 * 
 * Base64是一种基于64个可打印字符来表示二进制数据的方法；
 * 这64个可打印字符包括: a-z、A-Z、0-9，此外还有两个字符在不同的系统中不同；
 * Base64并不是什么加密算法，而是一种编码算法；
 * 它可以将一组二进制信息编码成可打印的字符，方便存储、在网络上传输和展现
 * 
 * @Author:tony
 * @Since:2015年11月2日
 */
@SuppressWarnings("restriction")
public class Base64Util {

	/**
	 * @Description:把字节数组转换为字符串
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param bytes
	 * @Param:@return
	 * @Return:String
	 */
	public static String byte2base64(byte[] bytes) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(bytes);
	}

	/**
	 * @Description:把Base64字符串转换为字节数组
	 * @Author:tony
	 * @Since:2015年11月12日
	 * @Param:@param base64
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:byte[]
	 */
	public static byte[] base642byte(String base64) throws IOException {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		return base64Decoder.decodeBuffer(base64);
	}
}
