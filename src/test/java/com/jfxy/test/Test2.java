package com.jfxy.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Test2 {
	public static void main(String[] args) {
		int start=17574;
		int size=1000000;
		//int size=20;
		StringBuffer sb=new StringBuffer();
		for(int i=start;i<start+size+1;i++){
			sb.append(i+"\r\n");
		}
		
		try {
			FileUtils.write(new File("\\\\hejiajie\\scan\\test.txt"), sb.toString(),Charset.forName("UTF-8"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
