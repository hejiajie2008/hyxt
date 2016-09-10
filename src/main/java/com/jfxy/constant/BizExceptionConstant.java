package com.jfxy.constant;

/**
 * 业务异常常量
 * 
 * @author hejiajie
 * 
 */
public interface BizExceptionConstant {
	/**
	 * 成功
	 */
	int SUCCESS = 0;
	/**
	 * md5 操作异常
	 */
	int MD5_OPERATE_EXCEPTION = 1;
	/**
	 * base64 操作异常
	 */
	int BASE64_OPERATE_EXCEPTION = 2;
	/**
	 * 编码不支持异常
	 */
	int UNSUPPORTED_ENCODING_EXCEPTION = 3;
	/**
	 * URL 连接异常
	 */
	int URL_CONNECTION_EXCEPTION = 4;

	/**
	 * 不支持拼音异常
	 */
	int UNSUPPORTED_PINYIN_EXCEPTION = 5;
	/**
	 * 业务错误
	 */
	int BIZ_ERROR = 6;
	/**
	 * 图片产生异常
	 */
	int PICTURE_GENERATOR_ERROR = 7;
	/**
	 * 短彩信发送错误
	 */
	int MSG_SEND_ERROR = 8;
	/**
	 * 模板合并错误
	 */
	int TEMPLATE_MERAGE_ERROR = 9;
	/**
	 * DOM4J 获取元素出错
	 */
	int DOM4J_VISTOR_ERROR = 10;
	/**
	 * DOM4J 解析报错
	 */
	int DOM4J_PARSE_ERROR = 10;
	/**
	 * ZIP压缩出错
	 */
	int ZIP_COMPRESS_ERROR = 11;
	/**
	 * 彩信号码出错
	 */
	int MMS_NO_ERROR = 11;
	/**
	 * 编码已被使用
	 */
	int CODE_ALREADY_USED = 12;
	/**
	 * 重复操作
	 */
	int REPETITIVE_OPERATE = 13;
	/**
	 * 支付宝配制异常
	 */
	int ALIPAY_CONFIG_ERROR = 14;
	/**
	 * 订单号为空错误
	 */
	int ORDER_NULL_ERROR = 15;
	/**
	 * 订单类型出错
	 */
	int ORDER_TYPE_ERROR = 16;
	/**
	 * 响应流被打判或低层SOCKET中断
	 */
	int RESPONSE_RESET = 17;
	/**
	 * 日期转换错误
	 */
	int DATE_PRASE_ERROR = 18;
	/**
	 * 系统选项没有配制错误
	 */
	int SYS_OPTION_NOT_CONFIG_ERROR = 19;
	/**
	 * JAXB 解析错误
	 */
	int JAXB_ERROR = 20;
	/**
	 * 乐观锁异常
	 */
	public static final int OPTIMISTIC_EXCEPTION = 101;
	/**
	 * 低层数据库操作异常
	 */
	public static final int DB_OPERATE_EXCEPTION = 102;
	/**
	 * 实体为空异常
	 */
	public static final int ENTITY_NULL_EXCEPTION = 103;

	/**
	 * 没有主键可用
	 */
	public static final int NO_ID_CAN_USED = 104;
	/**
	 * 结果集不唯一
	 */
	public static final int RESULT_NOT_UNIQUE = 105;

	/**
	 * 请求参数错误
	 */
	int PARAMTER_ERROR = 1001;
	/**
	 * 企码码为空
	 */
	int CORP_CODE_NULL = 1002;
	/**
	 * 用户名为空
	 */
	int USER_NAME_NULL = 1003;
	/**
	 * 密码为空
	 */
	int PASSWORD_NULL = 1004;
	/**
	 * 企业码错误
	 */
	int CORP_CODE_ERROR = 1005;
	/**
	 * 用户错误
	 */
	int USER_NAME_ERROR = 1006;
	/**
	 * 密码错误
	 */
	int PASSWORD_ERROR = 1007;
	/**
	 * 信号错误
	 */
	int SIGN_ERROR = 1008;
	/**
	 * 请求名错误
	 */
	int TRANSACTION_NAME_ERROR = 1009;
	/**
	 * 项目代码错误
	 */
	int APPLICATION_ERROR = 1010;
	/**
	 * 企业集团不存在
	 */
	int CORP_GROUP_NOT_EXISTS = 1011;
	/**
	 * XML格式错误
	 */
	int XML_FORMAT_ERROR = 1012;
	/**
	 * JSON格式错误
	 */
	int JSON_FORMAT_ERROR = 1013;
	/**
	 * 数据库异常
	 */
	int DB_ERROR = 1014;
	/**
	 * 其他错误
	 */
	int OTHER_ERROR = 1015;

}
