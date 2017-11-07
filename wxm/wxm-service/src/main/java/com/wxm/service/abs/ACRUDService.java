package com.wxm.service.abs;

import java.util.List;
import java.util.Map;

import com.wxm.service.ICRUDService;

/**
 * <b>标题: </b> 增删改查相关SERVICE抽象类 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年6月25日 下午10:49:30 <br/>
 * <b>版本: </b>1.0
 */
public abstract class ACRUDService<T, V, D, Q> extends ABaseService<T, V, D, Q> implements ICRUDService<T, D> {

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int batchUpdate(List<T> ts) {
        int count = 0;
        for (T t : ts) {
            count += mapper.updateByPrimaryKeySelective(t);
        }
        return count;
    }

    @Override
    public int remove(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchRemove(List<String> idList) {
        int count = 0;
        for (String id : idList) {
            count += mapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public D queryOne(String id) {
        return mapper.selectByPrimaryKey(id);
    }
    

    @Override
    public List<T> queryList(Map<String, Object> params) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int count(Map<String, Object> params) {
        // TODO Auto-generated method stub
        return 0;
    }
}
