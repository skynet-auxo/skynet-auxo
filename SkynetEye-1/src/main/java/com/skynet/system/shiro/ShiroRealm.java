/** 
 * Project Name:SkynetEye
 * File ShiroRealm 
 * Package Name:com.skynet.system.shiro 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月22日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :shiro配置类
 * 
 * 登录认证 一般情况下 , 登录成功之后就给当前用户进行权限赋予了
 * 根据用户的权限信息做授权判断，这一步是以doGetAuthenticationInfo为基础的，只有在有用户信息后才能根据用户的角色和授权信息做判断是否给用户授权，
 * 因此这里的Roles和Permissions是用户的两个重点判断依据 
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */
package com.skynet.system.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.skynet.system.bean.Esecuserol;
import com.skynet.system.bean.Esecusrdef;
import com.skynet.system.dao.UserDao;
import com.skynet.system.service.MenuService;

@Configuration
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userMapper;
	@Autowired
	private MenuService menuService;

	/**
	 *  获取用户的权限信息，这是为下一步的授权做判断，获取当前用户的角色和这些角色所拥有的权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		Long userId = ((Esecuserol) SecurityUtils.getSubject().getPrincipal()).getUserId();
		Set<String> perms = menuService.listPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}

	/**
	 * 登录认证 一般情况下 ,
	 * 登录成功之后就给当前用户进行权限赋予了，根据用户的权限信息做授权判断，这一步是以doGetAuthenticationInfo为基础的，
	 * 只有在有用户信息后才能根据用户的角色和授权信息做判断是否给用户授权，因此这里的Roles和Permissions是用户的两个重点判断依据
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = (String) token.getPrincipal();
		// 查出是否有此用户
//		Esecusrdef user = userMapper.findByName(token.getUsername());

		Map<String, Object> map = new HashMap<>(16);
		map.put("userName", username);
		String password = new String((char[]) token.getCredentials());
		Esecusrdef user = userMapper.list(map).get(0);
		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		// 密码错误
		if (!password.equals(user.getPassWord())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}
		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		Session session = SecurityUtils.getSubject().getSession();
		//成功则放入session
		session.setAttribute("user", user);
		
		return info;

//	    if(user != null){ 
//	        // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验 
//	        List<Esecuserol> rlist = uRoleDao.findRoleByUid(user.getUserId());//获取用户角色 
//	        List<UPermission> plist = uPermissionDao.findPermissionByUid(user.getUserId());//获取用户权限 
//	        List<String> roleStrlist=new ArrayList<String>();////用户的角色集合 
//	        List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合 
//	        for (Esecuserol role : rlist) { 
//	          roleStrlist.add(role.getName()); 
//	        } 
//	        for (UPermission uPermission : plist) { 
//	          perminsStrlist.add(uPermission.getName()); 
//	        } 
//	        user.setRoleStrlist(roleStrlist); 
//	        user.setPerminsStrlist(perminsStrlist); 
//	        Session session = SecurityUtils.getSubject().getSession(); 
//	        session.setAttribute("user", user);//成功则放入session 
//	        // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验 
//	        return new SimpleAuthenticationInfo(user, user.getPassword(), getName()); 
//	      } 
//	      return null;
	}

}
