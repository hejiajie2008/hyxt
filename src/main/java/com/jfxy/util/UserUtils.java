package com.jfxy.util;

public class UserUtils {
	
	public static boolean isNotAdmin(int userid){
		if(userid>1){
			return true;
		}else{
			return false;
		}
	}

}
