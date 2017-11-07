package com.wxm.service;

import java.util.List;

import com.wxm.mybatis.datasource.annotation.DataSource;
import com.wxm.mybatis.datasource.annotation.DataSource.DataSourceType;

/**
 * <b>标题: </b> 删除相关SERVICE接口 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年6月25日 下午10:46:45 <br/>
 * <b>版本: </b>1.0
 */
public interface IDeleteService {

    /**
     * 
     * <b>标题: </b> 删除记录 <br/>
     * <b>描述: </b> <br/>
     * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
     * <b>时间: </b>2017年6月25日 下午10:23:20 <br/>
     * <b>版本: </b>1.0
     * 
     * @param id
     *            实体ID
     * @return 返回操作记录数
     */
    @DataSource(DataSourceType.master)
    public int remove(String id);

    /**
     * 
     * <b>标题: </b> 批量删除记录 <br/>
     * <b>描述: </b> <br/>
     * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
     * <b>时间: </b>2017年6月25日 下午10:24:11 <br/>
     * <b>版本: </b>1.0
     * 
     * @param ids
     *            实体ID列表
     * @return 返回操作记录数
     */
    @DataSource(DataSourceType.master)
    public int batchRemove(List<String> ids);
}
