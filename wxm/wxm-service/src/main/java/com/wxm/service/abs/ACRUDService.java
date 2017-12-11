package com.wxm.service.abs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxm.mybatis.mapper.common.Mapper;
import com.wxm.service.ICRUDService;

/**
 * 
 * <b>Title:</b> 通用增删改查业务接口实现类 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月11日 下午1:39:28 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 * @param <B>
 *            表对应业务逻辑实体
 */
public abstract class ACRUDService<T, B> implements ICRUDService<T, B> {
    @Autowired
    protected Mapper<T, B> mapper;

    @Override
    public int insert(T bean) {
        return mapper.insert(bean);
    }

    @Override
    public int insertSelective(T bean) {
        return mapper.insertSelective(bean);
    }

    @Override
    public int insertList(List<T> list) {
        return mapper.insertList(list);
    }

    @Override
    public int updateByPrimaryKey(T bean) {
        return mapper.updateByPrimaryKey(bean);
    }

    @Override
    public int updateByPrimaryKeySelective(T bean) {
        return mapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public int update(Object query) {
        return mapper.update(query);
    }

    @Override
    public int updateSelective(Object query) {
        return mapper.updateSelective(query);
    }

    @Override
    public int deleteByPrimaryKey(Object object) {
        return mapper.deleteByPrimaryKey(object);
    }

    @Override
    public int delete(Object query) {
        return mapper.delete(query);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<B> selectAllBO() {
        return mapper.selectAllBO();
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public B selectBOByPrimaryKey(Object key) {
        return mapper.selectBOByPrimaryKey(key);
    }

    @Override
    public int selectCount(Object query) {
        return mapper.selectCount(query);
    }

    @Override
    public List<T> select(Object query) {
        return mapper.select(query);
    }

    @Override
    public List<B> selectBO(Object query) {
        return mapper.selectBO(query);
    }

    @Override
    public T selectOne(Object query) {
        return mapper.selectOne(query);
    }

    @Override
    public B selectBOOne(Object query) {
        return mapper.selectBOOne(query);
    }

}
