package com.jfxy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Service;

import com.jfxy.dao.SysmoduleDao;
import com.jfxy.dao.SysuserDao;
import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.Sysuser;


@Service("userRealm")
public class UserRealm extends AuthorizingRealm {

	//@Resource
	//private SysuserMapper sysuserMapper;
	
	@Resource
	private SysuserDao sysuserDao;
	
	@Resource
	private SysmoduleDao sysmoduleDao;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//UserService userService = ServiceFactory.getBean(UserService.class);
		
		
		//String username = (String) principals.getPrimaryPrincipal();
		
		//Sysuser sysUser = sysuserDao.findByUsername(username);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> roles=new HashSet<String>();
		
		Subject subject = SecurityUtils.getSubject();
		String roleidStr=subject.getSession().getAttribute("roleid").toString();
		Integer roleid=0;
		if(null==roleidStr){
			return null;
		}else{
			roleid=Integer.parseInt(roleidStr);
		}
		roles.add(roleidStr);
		authorizationInfo.setRoles(roles);
		if(roleid!=0){
			Set<String> permissions=sysuserDao.findPermissions(roleid);
			authorizationInfo.setStringPermissions(permissions);
		}
		
		
		

		return authorizationInfo;
	}
	
	
	
	@Resource
	SessionDAO sessionDAO;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//UserService userService = ServiceFactory.getBean(UserService.class);
		String username = (String) token.getPrincipal();
		Sysuser sysUser = sysuserDao.findByUsername(username);
		if ( sysUser == null) {
			throw new UnknownAccountException("1");// 没找到帐号
		}

		//Collection<Session> sessions = sessionDAO.getActiveSessions();
		
		

		/**
		for(Session session:sessions){
			String loginUser=String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			
			if(loginUser!=null){
				if(loginUser.equals(username)){
					throw new UnknownAccountException("2");// 该账号己在其它地方登录
				}
			}
		}
		**/
		/**
		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException(); // 帐号锁定
		}**/
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				sysUser.getUseraccount(), // 用户名
				sysUser.getUserpassword(), // 密码
				//ByteSource.Util.bytes(sysUser.getCredentialsSalt()),// salt=username+salt
				getName() // realm name
		);
		
		Integer roleid=sysUser.getUsergroupid();
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().setAttribute("userid", sysUser.getUserid());
		subject.getSession().setAttribute("usershopid", sysUser.getUsershopid());
		subject.getSession().setAttribute("ipadress", sysUser);
		subject.getSession().setAttribute("roleid", roleid);
		List<Sysmodule> menus=sysmoduleDao.findMenus(1);
		subject.getSession().setAttribute("menus", menus);
		
		
		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
