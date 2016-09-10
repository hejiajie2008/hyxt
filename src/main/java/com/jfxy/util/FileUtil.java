package com.jfxy.util;

import java.util.Date;

public class FileUtil {

	public static String randPath() {
		Date date = new Date();
		String path = DateUtil.format(date, DateUtil.yyyyMM);
		String fileName = DateUtil.dateRandom();

		return path + "/" + fileName;
	}

	public static String getExtend(String filename) {
		String[] splitname = filename.split("\\.");
		if (splitname.length == 1) {
			return "";
		} else {
			return "." + splitname[splitname.length - 1];
		}
	}

}
