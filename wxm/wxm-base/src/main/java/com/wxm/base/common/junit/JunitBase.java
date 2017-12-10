package com.wxm.base.common.junit;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 
 * <b>Title:</b> 单元测试基类<br>
 * <b>Description:</b> 所有的单元测试类都必须继承此类，并加上@RunWith(BlockJUnit4ClassRunner.class)注解<br>
 * <b>Date:</b> 2017年11月7日 上午11:26:36<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class JunitBase {

    private ClassPathXmlApplicationContext context;

    private String springXmlPath;

    public JunitBase() {
    }

    public JunitBase(String springXmlPath) {
        this.springXmlPath = springXmlPath;
    }

    @Before
    public void before() {
        if (StringUtils.isEmpty(springXmlPath)) {
            springXmlPath = "classpath*:config/applicationContext-*.xml";
        }

        try {
            context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.close();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        return (T) context.getBean(beanId);
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        return (T) context.getBean(clazz);
    }
}
