package com.wxm.example.service.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.wxm.base.common.junit.JunitBase;
import com.wxm.example.pojo.bo.ExIsnullDefaultBO;
import com.wxm.example.pojo.entity.ExIsnullDefault;
import com.wxm.example.pojo.query.ExIsnullDefaultQuery;
import com.wxm.example.service.IExIsnullDefaultService;
import com.wxm.mybatis.mapper.util.UUIDUtil;

/**
 * <b>Title:</b> 示例-是否为空-默认<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月11日 下午5:50:35 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class ExIsnullDefaultServiceTest extends JunitBase {
    private Logger logger = LoggerFactory.getLogger(ExIsnullDefaultServiceTest.class);

    @Autowired
    private IExIsnullDefaultService service;

    @Override
    public void before() {
        super.before();
        service = getBean(IExIsnullDefaultService.class);
    }

    @Test
    public void testInsert() {
        ExIsnullDefault bean = new ExIsnullDefault();
        try {
            bean.setId("80ef9076-cec4-11e7-a4bd-4ccc6a80f9ee");
            bean.setVarcharNotnull("varcharNotnull"); // 变长字符串_非空
            // bean.setVarcharCannull("varcharCannull"); // 变长字符串_可空
            // bean.setVarcharCannullDefault("varcharCannullDefault"); // 变长字符串_可空_默认
            bean.setCharNotnull("charNotnull"); // 定长字符串_非空
            // bean.setCharCannull("charCannull"); // 定长字符串_可空
            // bean.setCharCannullDefault("charCannullDefault"); // 定长字符串_可空_默认

            // 该值不会存入数据库
            bean.setVarcharNotinsertCannull("varcharNotinsertCannull"); // 变长字符串_非插入_可空

            // 该值不会存入数据库
            bean.setVarcharNotinsertCannullDefault("varcharNotinsertCannullDefault"); // 变长字符串_非插入_可空_默认

            // 该值不会存入数据库，需将该字段上的insertable设为true才可测试通过
            bean.setVarcharNotinsertNotnull("varcharNotinsertNotnull");

            service.insert(bean);
            logger.debug(String.format("%s\n%s", "保存成功", JSON.toJSONString(bean)));
        } catch (Exception e) {
            logger.debug("因未设置非空值而导致保存失败", e);
        }
        try {
            // 该值取代数据库默认值
            bean.setVarcharNotnullDefault("varcharNotnullDefault"); // 变长字符串_非空_默认

            // 该值取代数据库默认值
            bean.setCharNotnullDefault("charNotnullDefault"); // 定长字符串_非空_默认

            // 该值不会存入数据库，需将该字段上的insertable设为true才可存入数据库
            bean.setVarcharNotinsertNotnullDefault("varcharNotinsertNotnullDefault");

            service.insert(bean);
            logger.debug(String.format("%s\n%s", "保存成功", JSON.toJSONString(bean)));
        } catch (Exception e) {
            logger.debug("因未设置非空值而导致保存失败", e);
        }
    }

    @Test
    public void testInsertSelective() {
        ExIsnullDefault bean = new ExIsnullDefault();
        try {
            bean.setVarcharNotnull("varcharNotnull"); // 变长字符串_非空
            // bean.setVarcharCannull("varcharCannull"); // 变长字符串_可空
            // bean.setVarcharCannullDefault("varcharCannullDefault"); // 变长字符串_可空_默认
            bean.setCharNotnull("charNotnull"); // 定长字符串_非空
            // bean.setCharCannull("charCannull"); // 定长字符串_可空
            // bean.setCharCannullDefault("charCannullDefault"); // 定长字符串_可空_默认

            // 该值不会存入数据库
            bean.setVarcharNotinsertCannull("varcharNotinsertCannull"); // 变长字符串_非插入_可空

            // 该值不会存入数据库
            bean.setVarcharNotinsertCannullDefault("varcharNotinsertCannullDefault"); // 变长字符串_非插入_可空_默认

            // 该值不会存入数据库，需将该字段上的insertable设为true才可测试通过
            bean.setVarcharNotinsertNotnull("varcharNotinsertNotnull");

            service.insertSelective(bean);
            logger.debug(String.format("%s\n%s", "保存成功", JSON.toJSONString(bean)));
        } catch (Exception e) {
            logger.debug("因未设置非空值而导致保存失败", e);
        }
    }

    @Test
    public void testInsertList() {
        List<ExIsnullDefault> list = new LinkedList<ExIsnullDefault>();
        ExIsnullDefault bean;
        for (int i = 0; i < 5; i++) {
            bean = new ExIsnullDefault();
            bean.setId(UUIDUtil.getUUID());
            bean.setVarcharNotnull("varcharNotnull"); // 变长字符串_非空
            // bean.setVarcharCannull("varcharCannull"); // 变长字符串_可空
            // bean.setVarcharCannullDefault("varcharCannullDefault"); // 变长字符串_可空_默认
            bean.setCharNotnull("charNotnull"); // 定长字符串_非空
            // bean.setCharCannull("charCannull"); // 定长字符串_可空
            // bean.setCharCannullDefault("charCannullDefault"); // 定长字符串_可空_默认
            // 该值不会存入数据库
            bean.setVarcharNotinsertCannull("varcharNotinsertCannull"); // 变长字符串_非插入_可空
            // 该值不会存入数据库
            bean.setVarcharNotinsertCannullDefault("varcharNotinsertCannullDefault"); // 变长字符串_非插入_可空_默认
            // 该值不会存入数据库，需将该字段上的insertable设为true才可测试通过
            bean.setVarcharNotinsertNotnull("varcharNotinsertNotnull");
            // 该值取代数据库默认值
            bean.setVarcharNotnullDefault("varcharNotnullDefault"); // 变长字符串_非空_默认
            // 该值取代数据库默认值
            bean.setCharNotnullDefault("charNotnullDefault"); // 定长字符串_非空_默认
            // 该值不会存入数据库，需将该字段上的insertable设为true才可存入数据库
            bean.setVarcharNotinsertNotnullDefault("varcharNotinsertNotnullDefault");

            list.add(bean);
        }
        service.insertList(list);
        logger.debug(String.format("%s\n%s", "保存成功", JSON.toJSONString(list)));
    }

    @Test
    public void testSelectAll() {
        List<ExIsnullDefault> list = service.selectAll();
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectAllBO() {
        List<ExIsnullDefaultBO> list = service.selectAllBO();
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectByPrimaryKey() {
        ExIsnullDefault bean = service.selectByPrimaryKey("80ef9076-cec4-11e7-a4bd-4ccc6a80f9ee");
        logger.debug("查询结果" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelectBOByPrimaryKey() {
        ExIsnullDefaultBO beanBo = service.selectBOByPrimaryKey("80ef9076-cec4-11e7-a4bd-4ccc6a80f9ee");
        logger.debug("查询结果" + JSON.toJSONString(beanBo));
    }

    @Test
    public void testSelectCount() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setLike_varcharNotnullDefault("Not");
        int count = service.selectCount(query);
        logger.debug("全查询总数:" + count);

        query = new ExIsnullDefaultQuery();
        query.setLikeL_varcharNotnullDefault("fault");
        count = service.selectCount(query);
        logger.debug("左查询总数:" + count);

        query = new ExIsnullDefaultQuery();
        query.setLikeR_varcharNotnullDefault("var");
        count = service.selectCount(query);
        logger.debug("右查询总数:" + count);
    }

    @Test
    public void testSelect() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setLike_varcharNotnullDefault("Notn");
        List<ExIsnullDefault> list = service.select(query);
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectBO() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setLike_varcharNotnullDefault("Notn");
        List<ExIsnullDefaultBO> list = service.selectBO(query);
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectOne() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setLike_varcharNotnullDefault("EE");
        ExIsnullDefault bean = service.selectOne(query);
        logger.debug("查询结果:" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelectBOOne() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setLike_varcharNotnullDefault("EE");
        ExIsnullDefaultBO beanBo = service.selectBOOne(query);
        logger.debug("查询结果:" + JSON.toJSONString(beanBo));
    }


    @Test
    public void testUpdateByPrimaryKey() {
        ExIsnullDefault bean = new ExIsnullDefault();
        bean.setId("80ef9076-cec4-11e7-a4bd-4ccc6a80f9ee");
        bean.setVarcharNotnull("varcharNotnull"); // 变长字符串_非空
        bean.setCharNotnull("charNotnull"); // 定长字符串_非空
        // bean.setVarcharNotinsertCannull("varcharNotinsertCannull"); // 变长字符串_非插入_可空
        bean.setVarcharNotinsertCannullDefault("varcharNotinsertCannullDefault"); // 变长字符串_非插入_可空_默认
        bean.setVarcharNotinsertNotnull("varcharNotinsertNotnull");
        // 该值取代数据库默认值
        bean.setVarcharNotnullDefault("varcharNotnullDefault"); // 变长字符串_非空_默认
        // 该值取代数据库默认值
        bean.setCharNotnullDefault("charNotnullDefault"); // 定长字符串_非空_默认
        // 该值不会存入数据库，需将该字段上的insertable设为true才可存入数据库
        bean.setVarcharNotinsertNotnullDefault("varcharNotinsertNotnullDefault");
        service.updateByPrimaryKey(bean);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        ExIsnullDefault bean = new ExIsnullDefault();
        bean.setId("80ef9076-cec4-11e7-a4bd-4ccc6a80f9ee");
        bean.setVarcharNotnull("Update"); // 变长字符串_非空
        service.updateByPrimaryKeySelective(bean);
    }

    @Test
    public void testUpdate() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setVarcharNotnull("varcharNotnull"); // 变长字符串_非空
        query.setCharNotnull("charNotnull"); // 定长字符串_非空
        // 该值不会存入数据库
        query.setVarcharNotinsertCannull("varcharNotinsertCannull"); // 变长字符串_非插入_可空
        // 该值不会存入数据库
        query.setVarcharNotinsertCannullDefault("varcharNotinsertCannullDefault"); // 变长字符串_非插入_可空_默认
        // 该值不会存入数据库，需将该字段上的insertable设为true才可测试通过
        query.setVarcharNotinsertNotnull("varcharNotinsertNotnull");
        // 该值取代数据库默认值
        query.setVarcharNotnullDefault("default"); // 变长字符串_非空_默认
        // 该值取代数据库默认值
        query.setCharNotnullDefault("charNotnullDefault"); // 定长字符串_非空_默认
        // 该值不会存入数据库，需将该字段上的insertable设为true才可存入数据库
        query.setVarcharNotinsertNotnullDefault("varcharNotinsertNotnullDefault");
        query.setVarcharCannull("Update"); // 变长字符串_可空
        query.setUpdate_varcharNotnullDefault("default");
        int count = service.update(query);
        logger.debug("更新条数:" + count);
    }

    @Test
    public void testUpdateSelective() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setVarcharCannull("Update--"); // 变长字符串_可空
        query.setUpdate_varcharNotnullDefault("default");
        int count = service.updateSelective(query);
        logger.debug("更新条数:" + count);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int count = service.deleteByPrimaryKey("fd39985b-dc29-11e7-9107-4ccc6a80f9ee");
        logger.debug("删除条数:" + count);
    }

    @Test
    public void testDelete() {
        ExIsnullDefaultQuery query = new ExIsnullDefaultQuery();
        query.setVarcharNotnullDefault("varcharNotnullDefault");
        int count = service.delete(query);
        logger.debug("删除条数:" + count);
    }

}
