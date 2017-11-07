package com.wxm.base.common.util;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;

/**
 * <b>标题: </b>包体工具类 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 398600198@qq.com <br/>
 * <b>时间: </b>2015-2-23 下午11:59:03 <br/>
 * <b>版本: </b>V1.0
 */
public class PackageUtils {
    private final static String TARGET_CLASS = "/target/classes/";

    /**
     * 
     * <b>标题: </b>根据指定的、包含通配符的包，获取所有包 <br/>
     * <b>描述: </b> <br/>
     * <b>作者: </b>吴晓敏 398600198@qq.com <br/>
     * <b>时间: </b>2015-2-24 下午1:27:19 <br/>
     * <b>版本: </b>V1.0
     * 
     * @param str
     * @return
     * @throws IOException
     */
    public static String getPackageWildcards(String str) throws IOException {
        if (!StringUtils.hasLength(str)) {
            LoggerUtils.error("映射别名的包路径为空！！！");
            return null;
        }
        // 指定的所有包
        StringBuilder resultPackages = new StringBuilder();
        // 分离多个指定包
        String[] packages = StringUtils.tokenizeToStringArray(str, ",; \t\n");

        if (packages == null || packages.length <= 0) {
            LoggerUtils.error("映射别名的包路径不存在或路径错误！！！");
            return null;
        }

        LoggerUtils.debug("----------根据指定的、包含通配符的包，获取所有包（开始）----------");
        LoggerUtils.debug("配置文件源路径:{}", str);

        for (String pkg : packages) {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            // 将加载多个模式匹配的Resource
            Resource[] resources = resolver.getResources(String.format("classpath*:%s", pkg.trim()).replace(".", "/"));
            for (Resource resource : resources) {
                String url = resource.getURL().toString();
                int index = url.lastIndexOf(TARGET_CLASS) + TARGET_CLASS.length();
                String uri = url.substring(index);

                // 去掉ClassPath路径，并将“/”替换为“.”
                String packageUri = uri.replace("/", ".");
                // 去掉最后一个“.”
                packageUri = packageUri.substring(0, packageUri.length() - 1);
                LoggerUtils.debug("{} -->> {}", uri, packageUri);
                if (resultPackages != null && resultPackages.length() > 0) {
                    // 若resultPackages不为空，则添加“,”
                    resultPackages.append(",");
                }
                // 将获取的包路径加入结果变量（指定的所有包）中
                resultPackages.append(packageUri);
            }
        }
        // 包名获取结果
        LoggerUtils.debug("包名获取结果:\n{}", resultPackages.toString());
        LoggerUtils.debug("----------根据指定的、包含通配符的包，获取所有包（结束）----------");
        return resultPackages.toString();
    }
}
