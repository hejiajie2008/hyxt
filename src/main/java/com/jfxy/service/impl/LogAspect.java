package com.jfxy.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfxy.dao.SyslogDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Syslog;

/**
 * 
 * 日志切面
 * 
 * @author hejiajie
 * @version 2.0, 2016年3月8日
 */
@Service
@Aspect
// 注入依赖
public class LogAspect {
	/**
	 * 添加业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.jfxy.action.*.*(..))")
	public void anyMethod() {
	}

	@Autowired
	public SyslogDao syslogDao;

	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入Action" + pjp.getTarget());
		Object object = pjp.proceed();// 执行该方法
		System.out.println("退出Action" + pjp.getTarget());

		Signature signature = pjp.getSignature();
		String method = signature.getName();

		Object requstObject = pjp.getArgs()[0];
		HttpServletRequest request = null;
		if (requstObject instanceof HttpServletRequest) {
			request = (HttpServletRequest) requstObject;
			String ip = getIpAddr(request);

			if (MemoryListener.logMap.containsKey(method)) {
				String xw = MemoryListener.logMap.get(method);
				Syslog syslog = new Syslog();
				syslog.setLogcreatetime(new Date());
				Subject subject = SecurityUtils.getSubject();
				
				Session session=subject.getSession();
				if(session==null){
					System.out.println("连接超时或登出");
					return object;
				}
				String userid = subject.getSession().getAttribute("userid")
						.toString();
				String userShopId = subject.getSession()
						.getAttribute("usershopid").toString();
				syslog.setLoguserid(Integer.parseInt(userid));
				syslog.setLogshopid(Integer.parseInt(userShopId));
				syslog.setLogdetail(xw);
				syslog.setLogipadress(ip);
				syslog.setLogtype("系统模块");
				syslogDao.insert(syslog);
			}
		}

		return object;
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
