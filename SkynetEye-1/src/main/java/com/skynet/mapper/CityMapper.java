/** 
 * Project Name:SkynetEye
 * File Name:CityMapper.java 
 * Package Name:com.skyne.mapper 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2018年8月18日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.skynet.bean.City;

public interface CityMapper {
	
//	@Select("select * from city where id = #{id}")
//	City findCityById(@Param("id") String id);

}
