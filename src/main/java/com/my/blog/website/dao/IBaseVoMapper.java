package com.my.blog.website.dao;

import java.io.Serializable;
import java.util.List;

import com.my.blog.website.exception.DaoException;

/**
 * DAO 通用sql，但是还需要在mapper xml文件中显示写出
 * 
 * @author shangpan
 *
 * @param <T>
 */
public interface IBaseVoMapper<T extends Serializable> {

	long countByExample(T example);

	int deleteByExample(T example);

	int deleteByPrimaryKey(Integer id);

	int insert(T record);

	int insertSelective(T record);

	List<T> selectByExample(T example);

	T selectByPrimaryKey(Integer id);
	
	//  扩展方法
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws DaoException
	 */
	public Object save(String str, Object obj) throws DaoException;
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws DaoException
	 */
	public Object update(String str, Object obj) throws DaoException;
	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws DaoException
	 */
	public Object delete(String str, Object obj) throws DaoException;

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws DaoException
	 */
	public Object findForObject(String str, Object obj) throws DaoException;

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws DaoException
	 */
	public Object findForList(String str, Object obj) throws DaoException;
	
	/**
	 * 查找对象封装成Map
	 * @param s
	 * @param obj
	 * @return
	 * @throws DaoException
	 */
	public Object findForMap(String sql, Object obj, String key , String value) throws DaoException;
}
