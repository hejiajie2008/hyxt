package com.jfxy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.log4j.chainsaw.Main;

import com.jfxy.constant.BizException;
import com.jfxy.constant.BizExceptionConstant;



/**
 * 日期工具类
 * 
 * @author hejiajie
 * 
 */
public final class DateUtil {
	/**
	 * 通用格式标识 yyyy-MM-dd HH:mm
	 */
	public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
	
	/**
	 * 通用格式标识 yyyy-MM-dd HH:mm
	 */
	public static final String yyyyMM = "yyyyMM";
	/**
	 * 通用格式标识 yyyy-MM-dd HH:mm:ss
	 */
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 通用格式标识 yyyy-MM-dd HH
	 */
	public static final String yyyy_MM_dd_HH = "yyyy-MM-dd HH";
	/**
	 * 通用格式标识 yyyy/MM/dd
	 */
	public static final String yyyy__MM__dd = "yyyy/MM/dd";
	/**
	 * 通用格式标识 yyyy-MM-dd
	 */
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	/**
	 * 通用格式标识yyyyMMdd
	 */
	public static final String yyyyMMdd = "yyyyMMdd";
	
	/**
	 * 通用格式标识yyyyMMdd
	 */
	public static final String yyMMddHHmmssSSS = "yyMMddHHmmssSSS";
	/**
	 * 通用格式标识 HH:mm
	 */
	public static final String HH_mm = "HH:mm";
	/**
	 * 通用格式标识 HHmm
	 */
	public static final String HHmm = "HHmm";
	
	public static String dateNow(){
		return format(new Date(), yyyy_MM_dd_HH_mm_ss);
	}
	public static String dateRandom(){
		SimpleDateFormat sdf = new SimpleDateFormat(yyMMddHHmmssSSS);
		String dateform =sdf.format(new Date())+new Random().nextInt(10);
		return dateform;
	}

	/**
	 * 把日期格式化字符串
	 * 
	 * @param date
	 *            要格式化的日期
	 * @param pattern
	 *            日期的格式
	 * @return 格式化后的字符串
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return StringUtil.EMPTY;
		}
		if (StringUtil.isTrimBlank(pattern)) {
			pattern = yyyy_MM_dd_HH_mm;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 把日期格式化字符串
	 * 
	 * @param date
	 *            要格式化的日期
	 * @param pattern
	 *            日期的格式
	 * @return 格式化后的字符串
	 */
	public static String format(String pattern) {
		Date date=new Date();
		
		if (StringUtil.isTrimBlank(pattern)) {
			pattern = yyyy_MM_dd_HH_mm;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 把日期格式化字符串
	 * 
	 * @param date
	 *            要格式化的日期
	 * @param pattern
	 *            日期的格式
	 * @return 格式化后的字符串
	 */
	public static String getyyyyMM() {
		Date date=new Date();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.yyyyMM);
		return sdf.format(date);
	}
	
	/**
	 * 把日期格式化字符串
	 * 
	 * @param date
	 *            要格式化的日期
	 * @param pattern
	 *            日期的格式
	 * @return 格式化后的字符串
	 */
	public static String getyyyyMMdd() {
		Date date=new Date();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.yyyyMMdd);
		return sdf.format(date);
	}
	
	/**
	 * 把日期格式化字符串
	 * 
	 * @param date
	 *            要格式化的日期
	 * @param pattern
	 *            日期的格式
	 * @return 格式化后的字符串
	 */
	public static String getHHmmssws() {
		StringBuffer sb=new StringBuffer();
		Calendar nowtime = new GregorianCalendar();
		sb.append(nowtime.get(Calendar.HOUR_OF_DAY))
		.append(nowtime.get(Calendar.MINUTE))
		.append(nowtime.get(Calendar.SECOND))
		.append(nowtime.get(Calendar.MILLISECOND));  
		return sb.toString();
	}
	
	
	
	

	/**
	 * 把日期字符串转换成日期对象
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param pattern
	 *            格式串
	 * @return 转换后的日期
	 */
	public static Date parse(String dateStr, String pattern) {
		if (StringUtil.isTrimBlank(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			throw new BizException(BizExceptionConstant.DATE_PRASE_ERROR, "日期转换错误");
		}
	}
	/**
	 * 自动匹配类型
	 * @param dateStr
	 * @return
	 */
	public static Date parse(String dateStr) throws ParseException {
		if (StringUtil.isTrimBlank(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf =null;
		if(dateStr.contains("-")){
			 sdf = new SimpleDateFormat(yyyy_MM_dd);
			
		}else if(dateStr.contains("/")){
			 sdf = new SimpleDateFormat(yyyy__MM__dd);
		}else{
			 sdf = new SimpleDateFormat(yyyyMMdd);
		}
		
		
			return sdf.parse(dateStr);
		
	}

	/**
	 * 去掉时分秒，毫秒的写法
	 * 
	 * @param date
	 *            日期
	 * @return 去掉时分秒，毫秒的方法
	 */
	public static Date shortDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获得根据旧的日期获得新的日期
	 * 
	 * @param date
	 *            旧的日期
	 * @param field
	 *            变动的时间部分
	 * @param amount
	 *            变动量
	 * @return 新的时间
	 */
	public static Date add(Date date, int field, int amount) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.add(field, amount);
		return c.getTime();
	}

	/**
	 * 获得天数
	 * 
	 * @param date
	 *            日期
	 * @return 获得天数
	 */
	public static int date(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		return c.get(Calendar.DATE);
	}

	/**
	 * 获得月份
	 * 
	 * @param date
	 *            日期
	 * @return 获得天数
	 */
	public static int month(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		return c.get(Calendar.MONTH);
	}

	/**
	 * 获得年份
	 * 
	 * @param date
	 *            日期
	 * @return 获得年份
	 */
	public static int year(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获得日期的最大天数
	 * 
	 * @param date
	 *            日期
	 * @return 最大的天数
	 */
	public static int maxDate(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, -1);
		return c.get(Calendar.DATE);

	}

}
