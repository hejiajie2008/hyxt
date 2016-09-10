package com.jfxy.util;

import java.security.MessageDigest;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.jfxy.constant.SymbolConstant;

public class Md5Utils {
	
	/*** 
     * MD5加码 生成32位md5码 
     */  
    public static String string2md5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
    
    public static String string2MD5(String inStr){  
        
        return string2md5(inStr).toUpperCase();
  
    } 
  
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
	
	public static String encrypt(String password){
		String md5password=new Md5Hash(password,SymbolConstant.SALT,2).toHex(); 
		return md5password;
	}
	
	// 测试主函数  
    public static void main(String args[]) {  
        String s = new String("11");  
        System.out.println("原始：" + s);  
        System.out.println("MD5后：" + string2MD5(s)); 
        
        System.out.println("加密的：" + convertMD5(s));
        System.out.println(convertMD5("AFDEGE@"));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));  
  
    }  


}
