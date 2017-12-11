package com.wxm.example.service.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.wxm.base.common.junit.JunitBase;
import com.wxm.example.pojo.entity.ExIsnullDefault;
import com.wxm.example.service.IExIsnullDefaultService;

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
    private IExIsnullDefaultService exIsnullDefaultService;

    @Test
    public void testInsert() {
        ExIsnullDefault bean = new ExIsnullDefault();
        try {
            // bean.setId("80ef9076-cec4-11e7-a4bd-4ccc6a80f9ee");
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

            exIsnullDefaultService.insert(bean);
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

            exIsnullDefaultService.insert(bean);
            logger.debug(String.format("%s\n%s", "保存成功", JSON.toJSONString(bean)));
        } catch (Exception e) {
            logger.debug("因未设置非空值而导致保存失败", e);
        }
    }

    @Test
    public void testInsertSelective() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsertList() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectAllBO() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectBOByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectCount() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelect() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectBO() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectOne() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectBOOne() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdate() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateSelective() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

}
