package com.jfxy.action;


import javax.print.attribute.standard.PDLOverrideSupported;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfxy.constant.SymbolConstant;
import com.jfxy.util.PassWordUtils;


/**
 * 
 * 系统控制模块
 * 主要用于权限，用户登录
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Controller
@RequestMapping(value = "/sys")
public class SystemAction extends BaseAction{
	Logger logger=Logger.getLogger(SystemAction.class);
	
	
	/**
	 * 
	 * @param account
	 * @param password
	 * @param request
	 * @return
	 * 1表示成功
	 */
	@RequestMapping(value = "/tologin")
	@ResponseBody
	public int tologin(HttpServletRequest request,String account, String password) {
		
		/**
		if (!checkValidateCode(request)) {
			return 4;
		}
		**/
		account = account.trim();
		Subject subject = SecurityUtils.getSubject();
		
		//String md5password=new Md5Hash(password,SymbolConstant.SALT,2).toHex(); 
		String epassword=PassWordUtils.password(password);
		UsernamePasswordToken token = new UsernamePasswordToken(
				account, epassword);
		// token.setRememberMe(true);
		try {

			subject.login(token);
			logger.info("用户登录,用户名："+account);
			//subject.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
		} catch (UnknownAccountException ex) {
			String code=ex.getMessage();
			if("2".equals(code)){
				return  6;
			}else if("1".equals(code)){
				return 7;
			}
			return 7;
		}catch(IncorrectCredentialsException ex){

			return 0;
		}
		return 1;
	}
	/**
	 * 用户登出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		logger.info("用户注销");
		return "redirect:/login.jsp";
		
		
	}
	/**
	 * 验证码判断
	 * 
	 * @param request
	 * @return
	 */
	protected boolean checkValidateCode(HttpServletRequest request) {
		String result_verifyCode = request.getSession().getAttribute("code")
				.toString(); // 获取存于session的验证值
		String user_verifyCode = request.getParameter("valcode");// 获取用户输入验证码
		
		if (null == user_verifyCode
				|| !result_verifyCode.equalsIgnoreCase(user_verifyCode)) {
			return false;
		}
		return true;
	}
	
	
	


}