package com.jfxy.util;

public class PassWordUtils {
	
	public static String password(String message)  {
		
			try {
				return DesUtils.encrypt(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return null;
		
	}

}
