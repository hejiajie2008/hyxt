package com.jfxy.constant;
/**
 * 常用正则常量
 * @author hejiajie
 *
 */
public interface RegexConstant {
	/**
	 * 精确匹配15位的身份证号或18位的身份证号
	 */
   String ID_NO="^([1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3})|([1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[X,x]))$";
   /**
    * 手机号
    */
  String MOBILE_NO= "^(?:13\\d|15\\d|18\\d)-?\\d{8}$";

}
