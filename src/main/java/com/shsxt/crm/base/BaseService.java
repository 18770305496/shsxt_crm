package com.shsxt.crm.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    /**
     * 添加记录
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public  Integer save(T entity) throws DataAccessException{
        return baseDao.save(entity);
    }

    /**
     * 批量添加记录
     * @param entities
     * @return
     * @throws DataAccessException
     */
    public  Integer saveBatch(List<T> entities) throws  DataAccessException{
        return baseDao.saveBatch(entities);
    }

    /**
     * 查询单条记录
     * @param id
     * @return
     * @throws DataAccessException
     */
    public T queryById(Integer id) throws DataAccessException{
        return baseDao.queryById(id);
    }


    /**
     * 多条件查询
     * @param baseQuery
     * @return
     * @throws DataAccessException
     */
    public PageInfo<T> queryByParams(BaseQuery baseQuery) throws  DataAccessException{
        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        List<T> entities=baseDao.queryByParams(baseQuery);
        return new PageInfo<T>(entities);
    }


    public Map<String,Object> queryForPage(BaseQuery baseQuery) throws  DataAccessException{
        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        List<T> entities=baseDao.queryByParams(baseQuery);
        PageInfo<T> pageInfo=new PageInfo<T>(entities);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    /**
     * 更新单条记录
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public Integer update(T entity) throws DataAccessException{
        return baseDao.update(entity);
    }


    /**
     * 批量更新记录
     * @param map
     * @return
     * @throws DataAccessException
     */
    public  Integer updateBatch(Map map) throws  DataAccessException{
        return baseDao.updateBatch(map);
    }

    /**
     * 删除单条记录
     * @param id
     * @return
     * @throws DataAccessException
     */
    public  Integer delete(Integer id) throws  DataAccessException{
        AssertUtil.isTrue(null==id||id<=0||null==queryById(id),"待删除记录不存在!");
        return baseDao.delete(id);
    }
    /**
     * 批量删除记录
     * @param ids
     * @return
     * @throws DataAccessException
     */
    public  Integer deleteBatch(Integer[] ids) throws DataAccessException{
        AssertUtil.isTrue(null==ids||ids.length==0,"请选择待删除记录!");
        return baseDao.deleteBatch(ids);
    }
}
