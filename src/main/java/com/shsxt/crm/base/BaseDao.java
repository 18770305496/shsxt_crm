package com.shsxt.crm.base;

import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    /**
     * 添加记录
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public  Integer save(T entity) throws DataAccessException;

    /**
     * 批量添加记录
     * @param entities
     * @return
     * @throws DataAccessException
     */
    public  Integer saveBatch(List<T> entities) throws  DataAccessException;

    /**
     * 查询单条记录
     * @param id
     * @return
     * @throws DataAccessException
     */
    public  T queryById(Integer id) throws  DataAccessException;


    /**
     * 多条件查询
     * @param baseQuery
     * @return
     * @throws DataAccessException
     */
    public  List<T> queryByParams(BaseQuery baseQuery) throws  DataAccessException;


    /**
     * 更新单条记录
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public  Integer update(T entity) throws DataAccessException;


    /**
     * 批量更新记录
     * @param map
     * @return
     * @throws DataAccessException
     */
    public  Integer updateBatch(Map map) throws  DataAccessException;


    /**
     * 删除单条记录
     * @param id
     * @return
     * @throws DataAccessException
     */
    public  Integer delete(Integer id) throws  DataAccessException;

    /**
     * 批量删除记录
     * @param ids
     * @return
     * @throws DataAccessException
     */
    public  Integer deleteBatch(Integer[] ids) throws  DataAccessException;


}
