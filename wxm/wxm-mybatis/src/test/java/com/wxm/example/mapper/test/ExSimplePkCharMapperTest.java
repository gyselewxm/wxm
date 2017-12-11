package com.wxm.example.mapper.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wxm.base.common.junit.JunitBase;
import com.wxm.example.mapper.ExSimplePkCharMapper;
import com.wxm.example.pojo.bo.ExSimplePkCharBO;
import com.wxm.example.pojo.entity.ExSimplePkChar;
import com.wxm.example.pojo.query.ExSimplePkCharQuery;
import com.wxm.mybatis.mapper.util.UUIDUtil;

public class ExSimplePkCharMapperTest extends JunitBase {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ExSimplePkCharMapper mapper;

    @Override
    public void before() {
        super.before();
        mapper = getBean(ExSimplePkCharMapper.class);
    }

    @Test
    public void testSelectOne() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        ExSimplePkChar bean = mapper.selectByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelectBOOne() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        ExSimplePkCharBO bean = mapper.selectBOByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelect() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setLike_remark("dd");
        List<ExSimplePkChar> list = mapper.select(query);
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectBO() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setLike_remark("dd");
        List<ExSimplePkCharBO> list = mapper.selectBO(query);
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectAll() {
        List<ExSimplePkChar> list = mapper.selectAll();
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectAllBO() {
        List<ExSimplePkCharBO> list = mapper.selectAllBO();
        logger.debug("查询结果：" + JSON.toJSONString(list));
    }

    @Test
    public void testSelectCount() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setRemark("dddsf");
        int count = mapper.selectCount(query);
        logger.debug("相等查询结果：" + count);

        query = new ExSimplePkCharQuery();
        query.setLike_remark("dd");
        count = mapper.selectCount(query);
        logger.debug("全模糊查询结果：" + count);

        query = new ExSimplePkCharQuery();
        query.setLikeL_remark("ad");
        count = mapper.selectCount(query);
        logger.debug("左模糊查询结果：" + count);

        query = new ExSimplePkCharQuery();
        query.setLikeR_remark("dd");
        count = mapper.selectCount(query);
        logger.debug("右模糊查询结果：" + count);
    }

    @Test
    public void testSelectByPrimaryKey() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        ExSimplePkChar bean = mapper.selectByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(bean));
    }

    @Test
    public void testSelectBOByPrimaryKey() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        ExSimplePkCharBO beanBo = mapper.selectBOByPrimaryKey(query);
        logger.debug("查询结果：" + JSON.toJSONString(beanBo));
    }

    @Test
    public void testInsert() {
        ExSimplePkChar bean = new ExSimplePkChar();
        // bean.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        mapper.insert(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testInsertSelective() {
        ExSimplePkChar bean = new ExSimplePkChar();
        mapper.insertSelective(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testUpdateByPrimaryKey() {
        ExSimplePkChar bean = new ExSimplePkChar();
        bean.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        mapper.updateByPrimaryKey(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        ExSimplePkChar bean = new ExSimplePkChar();
        bean.setId("34f1788e-29fe-486b-b052-175dbf9eba1d");
        bean.setRemark("Update");
        mapper.updateByPrimaryKey(bean);
        logger.debug(JSON.toJSONString(bean));
    }

    @Test
    public void testDelete() {
        ExSimplePkCharQuery query = new ExSimplePkCharQuery();
        query.setRemark("dd");
        int count = mapper.delete(query);
        logger.debug("删除条数:" + count);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int count = mapper.deleteByPrimaryKey("3d155dd6-83b9-48eb-8584-4753f38fade6");
        logger.debug("删除条数:" + count);
    }

    @Test
    public void testInsertList() {
        List<ExSimplePkChar> list = new LinkedList<ExSimplePkChar>();
        ExSimplePkChar bean;
        for (int i = 0; i < 5; i++) {
            bean = new ExSimplePkChar();
            bean.setId(UUIDUtil.getUUID());
            list.add(bean);
        }
        mapper.insertList(list);
        logger.debug(JSON.toJSONString(list));
    }

}
