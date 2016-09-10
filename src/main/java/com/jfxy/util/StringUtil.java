package com.jfxy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfxy.constant.RegexConstant;
import com.jfxy.constant.SymbolConstant;



public class StringUtil {

	/**
	 * 不为空 返回真
	 * 
	 * @param str
	 *            字符串
	 * @return 如果字符串不为空且长度大于1 返回真 ，其他返回假
	 */
	public static boolean isNotBlank(String str) {
		return str != null && !str.isEmpty();
	}

	/**
	 * 如果为空 返回真
	 * 
	 * @param str
	 *            字符串
	 * @return 如果为空或长度等于零，返回真，其他返回假
	 */
	public static boolean isBlank(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 去掉空格不为空 返回真
	 * 
	 * @param str
	 *            字符串
	 * @return 如果字符串不为空且去掉空格长度大于1 返回真 ，其他返回假
	 */
	public static boolean isNotTrimBlank(String str) {
		return str != null && !str.trim().isEmpty();
	}

	/**
	 * 去掉空格为空返回真
	 * 
	 * @param str
	 *            字符串
	 * @return 如果字符串为空或去掉空格长度为0,返回真，其他返回假
	 */
	public static boolean isTrimBlank(String str) {
		return str == null || str.trim().isEmpty();
	}

	/**
	 * 空串
	 */
	public final static String EMPTY = "";

	/**
	 * 首字母大写
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 首字母大写的字符串
	 */
	public static String capFirstUpperCase(String str) {
		if (isBlank(str)) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);

	}

	/**
	 * 首字母小写
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 首字母小写的字符串
	 */
	public static String capFirstLowerCase(String str) {
		if (isBlank(str)) {
			return str;
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	/**
	 * 数据库字段名到JAVA属性名转换
	 * 
	 * @param fieldName
	 *            数据库字段名
	 * @return java属性名称
	 */
	public static String fieldName2javaName(String fieldName) {
		if (isTrimBlank(fieldName)) {
			return EMPTY;
		}
		String strs[] = fieldName.split(SymbolConstant.UNDERLINE);
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(capFirstUpperCase(str.toLowerCase()));
		}
		return capFirstLowerCase(sb.toString());
	}

	/**
	 * java属性名称 到数据库字段名
	 * 
	 * @param javaName
	 *            java属性名称
	 * @return 数据库字段名称
	 */
	public static String javaName2fieldName(String javaName) {
		if (isTrimBlank(javaName)) {
			return EMPTY;
		}
		javaName = javaName.replaceAll("([A-Z])", "_$1");
		return javaName.toUpperCase();
	}

	/**
	 * 表名到类名
	 * 
	 * @param tableName
	 *            表名
	 * @return 类名
	 */
	public static String tableName2className(String tableName) {
		String className = fieldName2javaName(tableName);
		return capFirstUpperCase(className);
	}

	/**
	 * 类名到表名
	 * 
	 * @param className
	 *            类名
	 * @return 表名
	 */
	public static String className2tableName(String className) {
		if (isTrimBlank(className)) {
			return EMPTY;
		}
		String tableName = capFirstLowerCase(className);
		tableName = javaName2fieldName(tableName);
		return tableName.toUpperCase();
	}

	/**
	 * 匹配是否是身份证号
	 * 
	 * @param idNo
	 *            要匹配的字符串
	 * @return if match return true otherwise return false
	 */
	public static boolean isIdNo(String idNo) {
		if (StringUtil.isTrimBlank(idNo)) {
			return false;
		}
		Pattern p = Pattern.compile(RegexConstant.ID_NO);
		Matcher matcher = p.matcher(idNo);
		return matcher.find();

	}

	/**
	 * 匹配是否是手机号
	 * 
	 * @param mobile
	 *            手机号
	 * @return if match return true otherwise return false
	 */
	public static boolean isMobile(String mobile) {
		if (StringUtil.isTrimBlank(mobile)) {
			return false;
		}
		Pattern p = Pattern.compile(RegexConstant.MOBILE_NO);
		Matcher matcher = p.matcher(mobile);
		return matcher.find();
	}

	public static String num2String(Long no) {
		if (no.longValue() < 10L)
			return String.valueOf(no);
		if (no.longValue() < 36L)
			return String.valueOf((char) (int) (no.longValue() - 10L + 65L));
		if (no.longValue() < 62L)
			return String.valueOf((char) (int) (no.longValue() - 36L + 97L));

		return num2String(Long.valueOf(no.longValue() / 62L)) + num2String(Long.valueOf(no.longValue() % 62L));
	}

}
