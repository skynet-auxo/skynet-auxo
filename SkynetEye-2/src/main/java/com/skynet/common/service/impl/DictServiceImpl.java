/** 
 * Project Name:SkynetEye
 * File Name:DictServiceImpl.java 
 * Package Name:com.skynet.common.service.impl 
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
package com.skynet.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.common.bean.Egcmdicdef;
import com.skynet.common.dao.DictDao;
import com.skynet.common.service.DictService;
import com.skynet.system.bean.Esecusrdef;

@Service
public class DictServiceImpl implements DictService {
	
    @Autowired
    private DictDao dictDao;

	@Override
	public Egcmdicdef get(Long id) {
        return dictDao.get(id);
	}

	@Override
	public List<Egcmdicdef> list(Map<String, Object> map) {
        return dictDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
        return dictDao.count(map);
	}

	@Override
	public int create(Egcmdicdef dict) {
        return dictDao.create(dict);
	}

	@Override
	public int update(Egcmdicdef dict) {
        return dictDao.update(dict);
	}

	@Override
	public int delete(Long id) {
        return dictDao.delete(id);
	}

	@Override
	public int batchDelete(Long[] ids) {
        return dictDao.batchDelete(ids);
	}

	@Override
	public List<Egcmdicdef> listType() {
        return dictDao.listType();
	}

	@Override
	public String getName(String type, String value) {
        Map<String, Object> param = new HashMap<String, Object>(16);
        param.put("type", type);
        param.put("value", value);
        String rString = dictDao.list(param).get(0).getName();
        return rString;
	}

	@Override
	public List<Egcmdicdef> getHobbyList(Esecusrdef user) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "hobby");
        List<Egcmdicdef> hobbyList = dictDao.list(param);

        if (StringUtils.isNotEmpty(user.getHobby())) {
            String userHobbys[] = user.getHobby().split(";");
            for (String userHobby : userHobbys) {
                for (Egcmdicdef hobby : hobbyList) {
                    if (!Objects.equals(userHobby, hobby.getId().toString())) {
                        continue;
                    }
                    hobby.setRemarks("true");
                    break;
                }
            }
        }

        return hobbyList;
	}

	@Override
	public List<Egcmdicdef> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return dictDao.list(param);
	}

	@Override
	public List<Egcmdicdef> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return dictDao.list(param);
	}

}
