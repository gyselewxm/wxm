package com.wxm.base.spring;

import java.beans.Introspector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * 
 * <b>Title:</b> 自定义Spring的Service层命名策略 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月11日 下午5:45:49 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class WxmAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
        if (StringUtils.isEmpty(shortClassName)) {
            return shortClassName;
        }
        // 针对service层的实现类*ServiceImpl，取消Impl后缀
        final String IMPL = "Impl";
        if (shortClassName.endsWith(IMPL)) {
            return Introspector.decapitalize(shortClassName.substring(0, shortClassName.indexOf(IMPL)));
        }
        return super.buildDefaultBeanName(definition);
    }

}
