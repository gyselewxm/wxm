package com.wxm.mybatis.mapper.provider;

import org.apache.ibatis.mapping.MappedStatement;

import com.wxm.mybatis.mapper.MapperException;
import com.wxm.mybatis.mapper.entity.EntityColumn;
import com.wxm.mybatis.mapper.mapperhelper.EntityHelper;
import com.wxm.mybatis.mapper.mapperhelper.MapperHelper;
import com.wxm.mybatis.mapper.mapperhelper.MapperTemplate;
import com.wxm.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * 
 * <b>Title:</b> 通用主键批量操作接口实现类 <br>
 * <b>Description:</b> ids 如 "1,2,3" <br>
 * <b>Date:</b> 2017年12月10日 下午4:42:31 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class IdsProvider extends MapperTemplate {

    public IdsProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 
     * <b>Title:</b> 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午4:43:09 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String deleteByIds(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entityClass);
        if (columnList.size() == 1) {
            EntityColumn column = columnList.iterator().next();
            sql.append(" where ");
            sql.append(column.getColumn());
            sql.append(" in (${_parameter})");
        } else {
            throw new MapperException("继承 deleteByIds 方法的实体类[" + entityClass.getCanonicalName() + "]中必须只有一个带有 @Id 注解的字段");
        }
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午4:43:21 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectByIds(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 将返回值修改为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entityClass);
        if (columnList.size() == 1) {
            EntityColumn column = columnList.iterator().next();
            sql.append(" where ");
            sql.append(column.getColumn());
            sql.append(" in (${_parameter})");
        } else {
            throw new MapperException("继承 selectByIds 方法的实体类[" + entityClass.getCanonicalName() + "]中必须只有一个带有 @Id 注解的字段");
        }
        return sql.toString();
    }
}
