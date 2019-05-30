/** 
 * Project Name:SkynetEye
 * File Name:EsecusrdefC.java 
 * Package Name:com.skynet.system.bean.subtype 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2018年8月20日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.bean.subtype;

import com.skynet.system.bean.Esecusrdef;

/**
 * @author Administrator
 *
 */
public class EsecusrdefC {
	
	private Esecusrdef esecusrdef = new Esecusrdef();
	
    private String pwdOld;

    private String pwdNew;

	/**
	 * @return the esecusrdef
	 */
	public Esecusrdef getEsecusrdef() {
		return esecusrdef;
	}

	/**
	 * @param esecusrdef the esecusrdef to set
	 */
	public void setEsecusrdef(Esecusrdef esecusrdef) {
		this.esecusrdef = esecusrdef;
	}

	/**
	 * @return the pwdOld
	 */
	public String getPwdOld() {
		return pwdOld;
	}

	/**
	 * @param pwdOld the pwdOld to set
	 */
	public void setPwdOld(String pwdOld) {
		this.pwdOld = pwdOld;
	}

	/**
	 * @return the pwdNew
	 */
	public String getPwdNew() {
		return pwdNew;
	}

	/**
	 * @param pwdNew the pwdNew to set
	 */
	public void setPwdNew(String pwdNew) {
		this.pwdNew = pwdNew;
	}
	

}
