/** 
 * Project Name:SkynetEye
 * File Name:Esecroldef.java 
 * Package Name:com.skynet.common.bean 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2018年8月20日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.bean;

import java.sql.Timestamp;
import java.util.List;

import com.skynet.common.bean.BaseObject;

/**
 * @author Administrator
 *
 */
public class Esecroldef extends BaseObject {

	private static final long serialVersionUID = 1L;
	/**
	 * role Id
	 */
	private Long roleId;
	/***
	 * role name 
	 */
	private String roleName;
	/***
	 * 角色标识
	 */
	private String roleSign;
	/***
	 * 备注
	 */
	private String remark;
	private Long createUserId;
	private Timestamp createTime;
	private Long updateUserId;
	private Timestamp updateTime;
	/***
	 * 菜单
	 */
	private List<Long> menuIds;
	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleSign
	 */
	public String getRoleSign() {
		return roleSign;
	}
	/**
	 * @param roleSign the roleSign to set
	 */
	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the createUserId
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateUserId
	 */
	public Long getUpdateUserId() {
		return updateUserId;
	}
	/**
	 * @param updateUserId the updateUserId to set
	 */
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the menuIds
	 */
	public List<Long> getMenuIds() {
		return menuIds;
	}
	/**
	 * @param menuIds the menuIds to set
	 */
	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}
	
	
}
