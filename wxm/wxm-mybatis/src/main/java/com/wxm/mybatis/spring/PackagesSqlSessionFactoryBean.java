package com.wxm.mybatis.spring;

import java.io.IOException;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.util.StringUtils;

import com.wxm.base.common.util.LoggerUtils;
import com.wxm.base.common.util.PackageUtils;

/**
 * <b>标题: </b>通过通配符方式配置typeAliasesPackage <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 398600198@qq.com <br/>
 * <b>时间: </b>2015-2-23 下午11:56:45 <br/>
 * <b>版本: </b>V1.0
 */
public class PackagesSqlSessionFactoryBean extends SqlSessionFactoryBean {

    @Override
    public void setTypeAliasesPackage(String typeAliasesPackage) {
        try {
            if (StringUtils.hasLength(typeAliasesPackage) && typeAliasesPackage.contains("*")) {
                typeAliasesPackage = PackageUtils.getPackageWildcards(typeAliasesPackage);
            }
            super.setTypeAliasesPackage(typeAliasesPackage);
        } catch (IOException e) {
            LoggerUtils.error("扫描实体类失败", e);
        }
    }

    @Override
    public void setPlugins(Interceptor[] plugins) {
        super.setPlugins(plugins);
    }
}
