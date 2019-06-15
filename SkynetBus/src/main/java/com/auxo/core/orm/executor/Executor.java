package com.skynet.orm.executor;

import java.util.List;

import com.skynet.orm.base.BaseTable;
import com.skynet.orm.exception.ServiceException;

public interface Executor {

	<E extends BaseTable> int insert(E e, String exceptionCode) throws ServiceException;

	<E extends BaseTable> int update(E e, String exceptionCode) throws ServiceException;
	
	<E extends BaseTable> int updateByKey(E e, String exceptionCode) throws ServiceException;

	<E extends BaseTable> int upsert(E e, String exceptionCode) throws ServiceException;
	
	<E extends BaseTable> int delete(E e, String exceptionCode) throws ServiceException;
	
	<E extends BaseTable> int deleteByKey(E e, String exceptionCode) throws ServiceException;
	
	<E extends BaseTable> E select(E e, String exceptionCode) throws ServiceException;
	
	<E extends BaseTable> E selectByKey(E e, String exceptionCode) throws ServiceException;

	<E extends BaseTable> List<E> selectList(E e, String exceptionCode) throws ServiceException;

}
