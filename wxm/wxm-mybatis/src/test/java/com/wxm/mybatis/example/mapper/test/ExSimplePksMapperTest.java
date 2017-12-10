package com.wxm.mybatis.example.mapper.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wxm.base.common.junit.JunitBase;
import com.wxm.mybatis.example.mapper.ExSimplePksMapper;
import com.wxm.mybatis.example.pojo.bo.ExSimplePksBO;
import com.wxm.mybatis.example.pojo.entity.ExSimplePks;
import com.wxm.mybatis.example.pojo.query.ExSimplePksQuery;
import com.wxm.mybatis.mapper.util.UUIDUtil;

public class ExSimplePksMapperTest extends JunitBase {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ExSimplePksMapper mapper;

    @Override
    public void before() {
        super.before();
        mapper = getBean(ExSimplePksMapper.class);
    }

    @Test
    public void testSelectOne() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setId("a0d695a0-9ead-4538-bf5f-d07e304f4f40");
        query.setVarcharId("4f0ae111-7e2a-4d0b-80f0-3d01709e0930");
        query.setIntegerId(882);
        ExSimplePks bean = mapper.selectByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelectBOOne() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setId("a0d695a0-9ead-4538-bf5f-d07e304f4f40");
        query.setVarcharId("4f0ae111-7e2a-4d0b-80f0-3d01709e0930");
        query.setIntegerId(882);
        ExSimplePksBO beanBo = mapper.selectBOByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(beanBo));
    }

    @Test
    public void testSelect() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setLike_remark("dd");
        List<ExSimplePks> list = mapper.select(query);
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectBO() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setLike_remark("dd");
        List<ExSimplePksBO> list = mapper.selectBO(query);
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectAll() {
        List<ExSimplePks> list = mapper.selectAll();
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectAllBO() {
        List<ExSimplePksBO> list = mapper.selectAllBO();
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectCount() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setRemark("dddsf");
        int count = mapper.selectCount(query);
        logger.debug("相等查询结果：" + count);

        query = new ExSimplePksQuery();
        query.setLike_remark("dd");
        count = mapper.selectCount(query);
        logger.debug("全模糊查询结果：" + count);

        query = new ExSimplePksQuery();
        query.setLikeL_remark("ad");
        count = mapper.selectCount(query);
        logger.debug("左模糊查询结果：" + count);

        query = new ExSimplePksQuery();
        query.setLikeR_remark("dd");
        count = mapper.selectCount(query);
        logger.debug("右模糊查询结果：" + count);
    }

    @Test
    public void testSelectByPrimaryKey() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setId("a0d695a0-9ead-4538-bf5f-d07e304f4f40");
        query.setVarcharId("4f0ae111-7e2a-4d0b-80f0-3d01709e0930");
        query.setIntegerId(882);
        ExSimplePks bean = mapper.selectByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelectBOByPrimaryKey() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setId("a0d695a0-9ead-4538-bf5f-d07e304f4f40");
        // query.setVarcharId("4f0ae111-7e2a-4d0b-80f0-3d01709e0930");
        query.setIntegerId(882);
        ExSimplePksBO beanBo = mapper.selectBOByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(beanBo));
    }

    @Test
    public void testInsert() {
        ExSimplePks bean = new ExSimplePks();
        bean.setVarcharId(UUIDUtil.getUUID());
        bean.setIntegerId((int) Math.round(Math.random() * 1000));
        mapper.insert(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testInsertSelective() {
        ExSimplePks bean = new ExSimplePks();
        bean.setVarcharId(UUIDUtil.getUUID());
        bean.setIntegerId((int) Math.round(Math.random() * 1000));
        mapper.insert(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testUpdateByPrimaryKey() {
        ExSimplePks bean = new ExSimplePks();
        bean.setId("a0d695a0-9ead-4538-bf5f-d07e304f4f40");
        bean.setVarcharId("4f0ae111-7e2a-4d0b-80f0-3d01709e0930");
        bean.setIntegerId(882);
        mapper.updateByPrimaryKey(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        ExSimplePks bean = new ExSimplePks();
        bean.setId("a0d695a0-9ead-4538-bf5f-d07e304f4f40");
        bean.setVarcharId("4f0ae111-7e2a-4d0b-80f0-3d01709e0930");
        bean.setIntegerId(882);
        bean.setRemark("Update");
        mapper.updateByPrimaryKeySelective(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testDelete() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setRemark("dd");
        int count = mapper.delete(query);
        logger.debug("删除条数:" + count);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        ExSimplePksQuery query = new ExSimplePksQuery();
        query.setId("216fb57d-6a7f-4e93-b50c-9195213a22c7");
        query.setVarcharId("3c084a51-794c-454f-8be9-05d33a89451c");
        query.setIntegerId(776);
        int count = mapper.deleteByPrimaryKey(query);
        logger.debug("删除条数:" + count);
    }

    @Test
    public void testInsertList() {
        List<ExSimplePks> list = new LinkedList<ExSimplePks>();
        ExSimplePks bean;
        for (int i = 0; i < 5; i++) {
            bean = new ExSimplePks();
            bean.setId(UUIDUtil.getUUID());
            bean.setVarcharId(UUIDUtil.getUUID());
            bean.setIntegerId((int) Math.round(Math.random() * 1000));
            list.add(bean);
        }
        mapper.insertList(list);
        logger.debug(JSON.toJSONString(list));
    }

}
