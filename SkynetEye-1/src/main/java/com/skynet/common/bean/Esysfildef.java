/** 
 * Project Name:SkynetEye
 * File Name:Esysfildef.java 
 * Package Name:com.skynet.common.bean 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月21日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.common.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Esysfildef extends BaseObject {

	private static final long serialVersionUID = 1L;
	/**
	 * file id
	 */
    private Long id;
    /**
     * file type
     */
    private Integer type;
    /**
     * file rul
     */
    private String url;
    
	private Long createUserId;
	
	private Date createTime;
	
	private Long updateUserId;
	
	private Date updateTime;

	
	
	/**
	 * 
	 */
	public Esysfildef() {
		super();
	}

	/**
	 * @param id
	 * @param type
	 * @param url
	 * @param createUserId
	 * @param createTime
	 * @param updateUserId
	 * @param updateTime
	 */
	public Esysfildef(Long id, Integer type, String url, Long createUserId, Date createTime, Long updateUserId,
			Date updateTime) {
		super();
		this.id = id;
		this.type = type;
		this.url = url;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}
	
	public Esysfildef(Integer type, String url, Long createUserId, Date date, Long updateUserId,
			Date date2) {
		super();
		this.type = type;
		this.url = url;
		this.createUserId = createUserId;
		this.createTime = date;
		this.updateUserId = updateUserId;
		this.updateTime = date2;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	public Date getCreateTime() {
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
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
