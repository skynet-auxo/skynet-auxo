/** 
 * Project Name:SkynetEye
 * File Name:RoleServiceImpl.java 
 * Package Name:com.skynet.system.service.impl 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月24日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skynet.system.bean.Esecroldef;
import com.skynet.system.bean.Esecrolmeu;
import com.skynet.system.dao.RoleDao;
import com.skynet.system.dao.RoleMenuDao;
import com.skynet.system.dao.UserDao;
import com.skynet.system.dao.UserRoleDao;
import com.skynet.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    public static final String ROLE_ALL_KEY = "\"role_all\"";

    public static final String DEMO_CACHE_NAME = "role";

    @Autowired
    RoleDao roleDao;
    @Autowired
    RoleMenuDao roleMenuDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleDao userRoleDao;
    
	@Override
	public Esecroldef get(Long id) {
		Esecroldef roleDO = roleDao.get(id);
        return roleDO;
	}

	@Override
	public List<Esecroldef> list() {
        List<Esecroldef> roles = roleDao.list(new HashMap<>(16));
        return roles;
	}

	@Transactional
	@Override
	public int create(Esecroldef role) {
        int count = roleDao.create(role);
        List<Long> menuIds = role.getMenuIds();
        Long roleId = role.getRoleId();
        List<Esecrolmeu> rms = new ArrayList<>();
        for (Long menuId : menuIds) {
        	Esecrolmeu rmDo = new Esecrolmeu();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rms.add(rmDo);
        }
        roleMenuDao.deleteByRoleId(roleId);
        if (rms.size() > 0) {
        	roleMenuDao.batchCreate(rms);
        }
        return count;
	}

	@Transactional
	@Override
	public int update(Esecroldef role) {
        int r = roleDao.update(role);
        List<Long> menuIds = role.getMenuIds();
        Long roleId = role.getRoleId();
        roleMenuDao.deleteByRoleId(roleId);
        List<Esecrolmeu> rms = new ArrayList<>();
        for (Long menuId : menuIds) {
        	Esecrolmeu rmDo = new Esecrolmeu();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rms.add(rmDo);
        }
        if (rms.size() > 0) {
        	roleMenuDao.batchCreate(rms);
        }
        return r;
	}

	@Transactional
	@Override
	public int delete(Long id) {
        int count = roleDao.delete(id);
        userRoleDao.deleteByRoleId(id);
        roleMenuDao.deleteByRoleId(id);
        return count;
	}

	@Override
	public List<Esecroldef> list(Long userId) {
        List<Long> rolesIds = userRoleDao.listRoleId(userId);
        List<Esecroldef> roles = roleDao.list(new HashMap<>(16));
        for (Esecroldef roleDO : roles) {
            roleDO.setRoleSign("false");
            for (Long roleId : rolesIds) {
                if (Objects.equals(roleDO.getRoleId(), roleId)) {
                    roleDO.setRoleSign("true");
                    break;
                }
            }
        }
        return roles;
	}

	@Transactional
	@Override
	public int batchDelete(Long[] ids) {
        int r = roleDao.batchDelete(ids);
        return r;
	}

}
