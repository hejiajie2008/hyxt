package com.jfxy.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

public class EhcacheUtil {
	
	  public static String  md5Password(String username,String password){ 
	        
	        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator(); 
	        String salt= secureRandomNumberGenerator.nextBytes().toHex(); 
	        System.out.println(salt);
	        salt="18cd204b9dc84dbf17a602ec30532ac0";
	        //组合username,两次迭代，对密码进行加密 
	       String password_cipherText= new Md5Hash(password,username+salt,2).toHex(); 
	       return password_cipherText;
	      
	    } 
	  public static String  quckmd5Password(String username){ 
	       return md5Password(username,username);
	      
	    } 
	  
	  
	  public static void main(String[] args) {
		 /// String md5password=new Md5Hash("admin","",2).toHex();
		  //System.out.println(md5password);
		 //220a6ad0147127cdcce2ecdcc04b6a6b
		  System.out.println(quckmd5Password("123456"));
	}
	

}
