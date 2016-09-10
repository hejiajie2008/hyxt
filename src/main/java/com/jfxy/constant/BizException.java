package com.jfxy.constant;

import org.springframework.dao.DataAccessException;

/**
 * 业务处理异常
 * @author hejiajie
 *
 */
public class BizException extends DataAccessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5712045286570447884L;
	/**
	 * 异常码
	 */
	private int code;

   
	public BizException(int code,String message) {
		super(message);
	    this.code = code;
	}

	public BizException(int code,String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

    /**
     *获得异常码
     * @return 异常CODE
     */
	public int getCode() {
		return code;
	}
}
