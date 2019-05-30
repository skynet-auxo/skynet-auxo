/** 
 * Project Name:SkynetEye
 * File Name:FileServiceImpl.java 
 * Package Name:com.skynet.common.service.imp 
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
package com.skynet.common.service.imp;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.skynet.common.bean.Esysfildef;
import com.skynet.common.config.SkynetConfig;
import com.skynet.common.dao.FileDao;
import com.skynet.common.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileMapper;
	
	@Autowired
	private SkynetConfig bootdoConfig;
	
	@Override
	public Esysfildef get(Long id) {
		return fileMapper.get(id);
	}

	@Override
	public List<Esysfildef> list(Map<String, Object> map) {
		return fileMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return fileMapper.count(map);
	}

	@Override
	public int create(Esysfildef sysFile) {
		return fileMapper.create(sysFile);
	}

	@Override
	public int update(Esysfildef sysFile) {
		return fileMapper.update(sysFile);
	}

	@Override
	public int delete(Long id) {
		return fileMapper.delete(id);
	}

	@Override
	public int batchDelete(Long[] ids) {
		return fileMapper.batchDelete(ids);
	}

	@Override
	public Boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = bootdoConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}

}
