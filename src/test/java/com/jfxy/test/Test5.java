package com.jfxy.test;

import java.io.File;

public class Test5 {
	public static String path="D:\\svndata\\qhjf\\zhimakahuadianshang\\trunk\\doc";
	public static String[] contents=new String[]{
		"01_plan",
		"02_requirement",
		"03_design",
		"04_test",
		"05_other"
	};
	public static void main(String[] args) {
		for(String content:contents){
			String filepath=path+"/"+content;
			File file=new File(filepath);
			file.mkdirs();
		}
	}

}
