package com.jfxy.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesUtils {
	
	public static String ENCODING="UTF-8";
	
	public static String KEY = Md5Utils.string2MD5("szYiJiaSoft").substring(0, 8);

	public DesUtils() {
	}

	// 测试
	public static void main(String args[]) {
		
		try {
			String mw=encrypt("123");
			
			
			
			System.out.println("密文"+mw);
			System.out.println("明文"+decrypt(mw));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 加密
	 * 
	 * @param datasource
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 */
	public static byte[] encrypt(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String encryptBasedDes(String data,byte[] keyb) {  
	        String encryptedData = null;  
	        try {  
	            // DES算法要求有一个可信任的随机数源  
	            SecureRandom sr = new SecureRandom();  
	            DESKeySpec deskey = new DESKeySpec(keyb);  
	            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
	            SecretKey key = keyFactory.generateSecret(deskey);  
	            // 加密对象  
	            Cipher cipher = Cipher.getInstance("DES");  
	            cipher.init(Cipher.ENCRYPT_MODE, key, sr);  
	            // 加密，并把字节数组编码成字符串  
	            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));  
	        } catch (Exception e) {  
//	            log.error("加密错误，错误信息：", e);  
	            throw new RuntimeException("加密错误，错误信息：", e);  
	        }  
	        return encryptedData;  
	    }  

	/**
	 * 解密
	 * 
	 * @param src
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}
	
	public static String decrypt(String message) throws Exception {  
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");  
         DESKeySpec desKeySpec = new DESKeySpec(KEY.getBytes(ENCODING));  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);  
        IvParameterSpec iv = new IvParameterSpec(KEY.getBytes(ENCODING));  
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);  
        
        byte[] buf = cipher.doFinal(toStringHex(message));  
        String a = new String(buf); 
       return a;  
    }  
	
	
	
	public static String encrypt(String message) throws Exception {  
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");  
        DESKeySpec desKeySpec = new DESKeySpec(KEY.getBytes(ENCODING));  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);  
        IvParameterSpec iv = new IvParameterSpec(KEY.getBytes(ENCODING));  
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);  
        byte[] buf = cipher.doFinal(message.getBytes(ENCODING));  
        String a = toHexString(buf).toUpperCase(); 
       return a;  
    }  
	
	public static String toHexString(byte b[]) {
		  StringBuffer hexString = new StringBuffer();
		  for (int i = 0; i < b.length; i++) {
		   String plainText = Integer.toHexString(0xff & b[i]);
		   if (plainText.length() < 2)
		    plainText = "0" + plainText;
		   hexString.append(plainText);
		  }
		  return hexString.toString();
		 }
	
	
	public static byte[] toStringHex(String arg) {
		int size=arg.length()/2;
		byte[] bt=new byte[size];
		  for (int i = 0; i < size; i++) {
			  bt[i]=(byte)Integer.parseInt(arg.substring(i*2, i*2+2),16);
			  
		  }
		  return bt;
		 }
	

}
