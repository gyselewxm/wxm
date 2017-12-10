/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.wxm.mybatis.mapper.mapperhelper;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.UnknownTypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxm.base.annotation.ColumnSql;
import com.wxm.mybatis.mapper.MapperException;
import com.wxm.mybatis.mapper.annotation.ColumnType;
import com.wxm.mybatis.mapper.annotation.NameStyle;
import com.wxm.mybatis.mapper.code.ColumnQueryEnum;
import com.wxm.mybatis.mapper.code.IdentityDialect;
import com.wxm.mybatis.mapper.code.Style;
import com.wxm.mybatis.mapper.entity.Config;
import com.wxm.mybatis.mapper.entity.EntityColumn;
import com.wxm.mybatis.mapper.entity.EntityField;
import com.wxm.mybatis.mapper.entity.EntityTable;
import com.wxm.mybatis.mapper.util.SimpleTypeUtil;
import com.wxm.mybatis.mapper.util.StringUtil;

/**
 * 实体类工具类 - 处理实体和数据库表以及字段关键的一个类
 * <p/>
 * <p>
 * 项目地址 : <a href="https://github.com/abel533/Mapper" target="_blank">https://github.com/abel533/Mapper</a>
 * </p>
 *
 * @author liuzh
 */
public class EntityHelper {
    private static Logger logger = LoggerFactory.getLogger(EntityHelper.class);

    /**
     * 实体类 => 表对象
     */
    private static final Map<Class<?>, EntityTable> entityTableMap = new ConcurrentHashMap<Class<?>, EntityTable>();

    /**
     * 获取表对象
     *
     * @param entityClass
     * @return
     */
    public static EntityTable getEntityTable(Class<?> entityClass) {
        EntityTable entityTable = entityTableMap.get(entityClass);
        if (entityTable == null) {
            throw new MapperException("无法获取实体类" + entityClass.getCanonicalName() + "对应的表名!");
        }
        return entityTable;
    }

    /**
     * 获取默认的orderby语句
     *
     * @param entityClass
     * @return
     */
    public static String getOrderByClause(Class<?> entityClass) {
        EntityTable table = getEntityTable(entityClass);
        if (table.getOrderByClause() != null) {
            return table.getOrderByClause();
        }
        StringBuilder orderBy = new StringBuilder();
        for (EntityColumn column : table.getEntityClassColumns()) {
            if (column.getOrderBy() != null) {
                if (orderBy.length() != 0) {
                    orderBy.append(",");
                }
                orderBy.append(column.getColumn()).append(" ").append(column.getOrderBy());
            }
        }
        table.setOrderByClause(orderBy.toString());
        return table.getOrderByClause();
    }

    /**
     * 
     * <b>Title:</b> 获取表对应实体全部列 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午2:29:29 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityClass
     *            表对应实体类
     * @return
     */
    public static Set<EntityColumn> getColumns(Class<?> entityClass) {
        return getEntityTable(entityClass).getEntityClassColumns();
    }

    /**
     * 
     * <b>Title:</b> 获取表对应业务逻辑实体全部列 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午2:29:58 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param boClass
     *            表对应业务逻辑实体类
     * @return
     */
    public static Set<EntityColumn> getBOColumns(Class<?> boClass) {
        return getEntityTable(boClass).getBoClassColumns();
    }

    /**
     * 
     * <b>Title:</b> 获取表对应查询条件实体全部列 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午2:30:38 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param queryClass
     *            表对应查询条件实体类
     * @return
     */
    public static Set<EntityColumn> getQueryColumns(Class<?> queryClass) {
        return getEntityTable(queryClass).getQueryClassColumns();
    }

    /**
     * 获取主键信息
     *
     * @param entityClass
     * @return
     */
    public static Set<EntityColumn> getPKColumns(Class<?> entityClass) {
        return getEntityTable(entityClass).getEntityClassPKColumns();
    }

    /**
     * 获取查询的Select
     *
     * @param entityClass
     * @return
     */
    public static String getSelectColumns(Class<?> entityClass) {
        EntityTable entityTable = getEntityTable(entityClass);
        if (entityTable.getBaseSelect() != null) {
            return entityTable.getBaseSelect();
        }
        Set<EntityColumn> columnList = getColumns(entityClass);
        StringBuilder selectBuilder = new StringBuilder();
        boolean skipAlias = Map.class.isAssignableFrom(entityClass);
        for (EntityColumn entityColumn : columnList) {
            selectBuilder.append(entityColumn.getColumn());
            if (!skipAlias && !entityColumn.getColumn().equalsIgnoreCase(entityColumn.getProperty())) {
                // 不等的时候分几种情况，例如`DESC`
                if (entityColumn.getColumn().substring(1, entityColumn.getColumn().length() - 1).equalsIgnoreCase(entityColumn.getProperty())) {
                    selectBuilder.append(",");
                } else {
                    selectBuilder.append(" AS ").append(entityColumn.getProperty()).append(",");
                }
            } else {
                selectBuilder.append(",");
            }
        }
        entityTable.setBaseSelect(selectBuilder.substring(0, selectBuilder.length() - 1));
        return entityTable.getBaseSelect();
    }

    /**
     * 
     * <b>Title:</b> 初始化表对应所有实体属性 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午1:55:37 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityClass
     *            表对应实体类类型
     * @param config
     *            通用配置
     */
    public static synchronized void initEntityNameMap(Class<?> entityClass, Config config) {
        if (entityTableMap.get(entityClass) != null) {
            return;
        }
        Style style = config.getStyle();
        // style，该注解优先于全局配置
        if (entityClass.isAnnotationPresent(NameStyle.class)) {
            NameStyle nameStyle = entityClass.getAnnotation(NameStyle.class);
            style = nameStyle.value();
        }

        // 创建并缓存EntityTable
        EntityTable entityTable = null;
        if (entityClass.isAnnotationPresent(Table.class)) {
            Table table = entityClass.getAnnotation(Table.class);
            if (!table.name().equals("")) {
                entityTable = new EntityTable(entityClass);
                entityTable.setTable(table);
            }
        }
        if (entityTable == null) {
            entityTable = new EntityTable(entityClass);
            // 可以通过stye控制
            entityTable.setName(StringUtil.convertByStyle(entityClass.getSimpleName(), style));
        }

        entityTable.setEntityClassColumns(new LinkedHashSet<EntityColumn>());
        entityTable.setEntityClassPKColumns(new LinkedHashSet<EntityColumn>());
        entityTable.setBoClassColumns(new LinkedHashSet<EntityColumn>());
        entityTable.setQueryClassColumns(new LinkedHashSet<EntityColumn>());

        /**
         * 处理所有表对应实体列
         */
        List<EntityField> fields = null;
        if (config.isEnableMethodAnnotation()) {
            fields = FieldHelper.getAll(entityClass);
        } else {
            fields = FieldHelper.getFields(entityClass);
        }
        for (EntityField field : fields) {
            // 如果启用了简单类型，就做简单类型校验，如果不是简单类型，直接跳过
            if (config.isUseSimpleType() && !SimpleTypeUtil.isSimpleType(field.getJavaType())) {
                continue;
            }
            processField(entityTable, style, field);
        }
        // 当pk.size=0的时候使用所有列作为主键
        if (entityTable.getEntityClassPKColumns().size() == 0) {
            entityTable.setEntityClassPKColumns(entityTable.getEntityClassColumns());
        }

        /**
         * 处理所有表对应业务逻辑实体列
         */
        try {
            Class<?> boClass = getBOClass(entityClass);
            if (null == boClass) {
                logger.warn("无法获取" + entityClass.getName() + "类对应的业务逻辑类!");
            }
            entityTable.setBoClass(boClass);
            fields = null;
            if (config.isEnableMethodAnnotation()) {
                fields = FieldHelper.getAll(boClass);
            } else {
                fields = FieldHelper.getFields(boClass);
            }
            for (EntityField field : fields) {
                // 如果启用了简单类型，就做简单类型校验，如果不是简单类型，直接跳过
                if (config.isUseSimpleType() && !SimpleTypeUtil.isSimpleType(field.getJavaType())) {
                    continue;
                }
                processBOField(entityTable, style, field);
            }
        } catch (ClassNotFoundException e) {
            logger.warn("无法获取" + entityClass.getName() + "类对应的业务逻辑类!");
        }

        /**
         * 处理所有表对应查询条件实体列
         */
        try {
            Class<?> queryClass = getQueryClass(entityClass);
            if (null == queryClass) {
                logger.warn("无法获取" + entityClass.getName() + "类对应的查询条件类!");
            }
            fields = null;
            if (config.isEnableMethodAnnotation()) {
                fields = FieldHelper.getAll(queryClass);
            } else {
                fields = FieldHelper.getFields(queryClass);
            }
            for (EntityField field : fields) {
                // 如果启用了简单类型，就做简单类型校验，如果不是简单类型，直接跳过
                if (config.isUseSimpleType() && !SimpleTypeUtil.isSimpleType(field.getJavaType())) {
                    continue;
                }
                processQueryField(entityTable, style, field);
            }
        } catch (ClassNotFoundException e) {
            logger.warn("无法获取" + entityClass.getName() + "类对应的查询条件类!");
        }

        entityTableMap.put(entityClass, entityTable);
    }

    /**
     * 
     * <b>Title:</b> 获取业务逻辑实体类 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午2:04:28 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityClass
     *            表对应实体类类型
     * @return
     * @throws ClassNotFoundException
     */
    private static Class<?> getBOClass(Class<?> entityClass) throws ClassNotFoundException {
        String boClassName = String.format("%sBO", entityClass.getName()).replace(".entity.", ".bo.");
        return Class.forName(boClassName);
    }

    /**
     * 
     * <b>Title:</b> 获取查询条件实体类 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午1:58:46 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityClass
     *            表对应实体类类型
     * @return
     * @throws ClassNotFoundException
     */
    private static Class<?> getQueryClass(Class<?> entityClass) throws ClassNotFoundException {
        String queryClassName = String.format("%sQuery", entityClass.getName()).replace(".entity.", ".query.");
        return Class.forName(queryClassName);
    }

    /**
     * 
     * <b>Title:</b> 处理表对应实体类的列 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午1:59:17 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityTable
     *            表对应实体表
     * @param style
     *            通用字段转换方式
     * @param field
     *            表对应实体的列
     */
    private static void processField(EntityTable entityTable, Style style, EntityField field) {
        // 排除字段
        if (field.isAnnotationPresent(Transient.class)) {
            return;
        }
        // Id
        EntityColumn entityColumn = new EntityColumn(entityTable);
        if (field.isAnnotationPresent(Id.class)) {
            entityColumn.setId(true);
        }
        // Column
        String columnName = null;
        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            columnName = column.name();
            entityColumn.setUpdatable(column.updatable());
            entityColumn.setInsertable(column.insertable());
        }
        // ColumnType
        if (field.isAnnotationPresent(ColumnType.class)) {
            ColumnType columnType = field.getAnnotation(ColumnType.class);
            // column可以起到别名的作用
            if (StringUtil.isEmpty(columnName) && StringUtil.isNotEmpty(columnType.column())) {
                columnName = columnType.column();
            }
            if (columnType.jdbcType() != JdbcType.UNDEFINED) {
                entityColumn.setJdbcType(columnType.jdbcType());
            }
            if (columnType.typeHandler() != UnknownTypeHandler.class) {
                entityColumn.setTypeHandler(columnType.typeHandler());
            }
        }
        // 表名
        if (StringUtil.isEmpty(columnName)) {
            columnName = StringUtil.convertByStyle(field.getName(), style);
        }
        entityColumn.setProperty(field.getName());
        entityColumn.setColumn(columnName);
        entityColumn.setJavaType(field.getJavaType());

        // 主键策略 - Oracle序列，MySql自动增长，UUID
        if (field.isAnnotationPresent(SequenceGenerator.class)) {
            SequenceGenerator sequenceGenerator = field.getAnnotation(SequenceGenerator.class);
            if (sequenceGenerator.sequenceName().equals("")) {
                throw new MapperException(entityTable.getEntityClass() + "字段" + field.getName() + "的注解@SequenceGenerator未指定sequenceName!");
            }
            entityColumn.setSequenceName(sequenceGenerator.sequenceName());
        } else if (field.isAnnotationPresent(GeneratedValue.class)) {
            GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
            if ("UUID".equals(generatedValue.generator())) {
                entityColumn.setUuid(true);
                // 优化:UUID支持回显
                entityColumn.setGenerator(generatedValue.generator());
            } else if (generatedValue.generator().equals("JDBC")) {
                entityColumn.setIdentity(true);
                entityColumn.setGenerator("JDBC");
                entityTable.setKeyProperties(entityColumn.getProperty());
                entityTable.setKeyColumns(entityColumn.getColumn());
            } else {
                // 允许通过generator来设置获取id的sql,例如mysql=CALL IDENTITY(),hsqldb=SELECT SCOPE_IDENTITY()
                // 允许通过拦截器参数设置公共的generator
                if (generatedValue.strategy() == GenerationType.IDENTITY) {
                    // mysql的自动增长
                    entityColumn.setIdentity(true);
                    if (!generatedValue.generator().equals("")) {
                        String generator = null;
                        IdentityDialect identityDialect = IdentityDialect.getDatabaseDialect(generatedValue.generator());
                        if (identityDialect != null) {
                            generator = identityDialect.getIdentityRetrievalStatement();
                        } else {
                            generator = generatedValue.generator();
                        }
                        entityColumn.setGenerator(generator);
                    }
                } else {
                    throw new MapperException(field.getName() + " - 该字段@GeneratedValue配置只允许以下几种形式:" + "\n1.全部数据库通用的@GeneratedValue(generator=\"UUID\")"
                            + "\n2.useGeneratedKeys的@GeneratedValue(generator=\\\"JDBC\\\")  "
                            + "\n3.类似mysql数据库的@GeneratedValue(strategy=GenerationType.IDENTITY[,generator=\"Mysql\"])");
                }
            }
        }
        entityTable.getEntityClassColumns().add(entityColumn);
        if (entityColumn.isId()) {
            entityTable.getEntityClassPKColumns().add(entityColumn);
        }
    }

    /**
     * 
     * <b>Title:</b> 处理表对应业务逻辑实体类的列 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午2:14:30 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityTable
     *            表对应实体表
     * @param style
     *            通用字段转换方式
     * @param field
     *            表对应查询条件实体的列
     */
    private static void processBOField(EntityTable entityTable, Style style, EntityField field) {
        EntityColumn entityColumn = new EntityColumn(entityTable);
        String tableName = entityTable.getName();
        // Column
        String columnName = null;
        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            columnName = column.name();
            entityColumn.setUpdatable(column.updatable());
            entityColumn.setInsertable(column.insertable());
        }
        // 表字段名
        if (StringUtil.isEmpty(columnName)) {
            String fieldName = field.getName();
            if (field.isAnnotationPresent(ColumnSql.class)) {
                ColumnSql columnSql = field.getAnnotation(ColumnSql.class);
                entityColumn.setColumnSql(String.format("(%s) AS %s", columnSql.value(), StringUtil.convertByStyle(fieldName, style)).replace("#TABLE#", tableName));
            } else {
            }
            columnName = StringUtil.convertByStyle(fieldName, style);
        }
        entityColumn.setProperty(field.getName());
        entityColumn.setColumn(columnName);
        entityColumn.setJavaType(field.getJavaType());
        entityTable.getBoClassColumns().add(entityColumn);
    }

    /**
     * 
     * <b>Title:</b> 处理表对应查询条件实体类的列 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午2:00:38 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param entityTable
     *            表对应实体表
     * @param style
     *            通用字段转换方式
     * @param field
     *            表对应查询条件实体的列
     */
    private static void processQueryField(EntityTable entityTable, Style style, EntityField field) {
        EntityColumn entityColumn = new EntityColumn(entityTable);
        // Column
        String columnName = null;
        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            columnName = column.name();
            entityColumn.setUpdatable(column.updatable());
            entityColumn.setInsertable(column.insertable());
        }
        // 表名
        if (StringUtil.isEmpty(columnName)) {
            String fieldName = field.getName();
            for (ColumnQueryEnum fragEnum : ColumnQueryEnum.values()) {
                if (fieldName.startsWith(fragEnum.getFrag())) {
                    entityColumn.setQueryEnum(fragEnum);
                    fieldName = fieldName.substring(fragEnum.getFrag().length());
                    break;
                }
            }
            columnName = StringUtil.convertByStyle(fieldName, style);
        }
        entityColumn.setProperty(field.getName());
        entityColumn.setColumn(columnName);
        entityColumn.setJavaType(field.getJavaType());
        // OrderBy
        if (field.isAnnotationPresent(OrderBy.class)) {
            OrderBy orderBy = field.getAnnotation(OrderBy.class);
            if (orderBy.value().equals("")) {
                entityColumn.setOrderBy("ASC");
            } else {
                entityColumn.setOrderBy(orderBy.value());
            }
        }
        entityTable.getQueryClassColumns().add(entityColumn);
    }

}
