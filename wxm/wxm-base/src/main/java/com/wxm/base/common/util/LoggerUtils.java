package com.wxm.base.common.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>标题: </b> 通用日志工具 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年10月5日 下午10:33:31 <br/>
 * <b>版本: </b>1.0
 */
public class LoggerUtils {
    private static Map<String, Logger> loggerMap = new HashMap<String, Logger>();

    /**
     * 
     * <b>标题: </b> 获取日志对象，默认命名为源调用者所在类 <br/>
     * <b>描述: </b> <br/>
     * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
     * <b>时间: </b>2017年10月5日 下午10:53:58 <br/>
     * <b>版本: </b>1.0
     * 
     * @return
     */
    private static Logger getLogger() {
        Logger log = null;
        String className = new Throwable().getStackTrace()[2].getClassName();
        if (loggerMap.containsKey(className)) {
            log = loggerMap.get(className);
        } else {
            try {
                log = LoggerFactory.getLogger(Class.forName(className));
                loggerMap.put(className, log);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return log;
    }

    public static void debug(String msg) {
        getLogger().debug(msg);
    }

    public static void debug(String format, Object... arguments) {
        getLogger().debug(format, arguments);
    }

    public static void info(String msg) {
        getLogger().info(msg);
    }

    public static void info(String format, Object... arguments) {
        getLogger().info(format, arguments);
    }

    public static void warn(String msg) {
        getLogger().warn(msg);
    }

    public static void warn(String format, Object... arguments) {
        getLogger().warn(format, arguments);
    }

    public static void warn(String msg, Throwable t) {
        getLogger().warn(msg, t);
    }

    public static void error(String message) {
        getLogger().error(message);
    }

    public static void error(String format, Object... arguments) {
        getLogger().error(format, arguments);
    }

    public static void error(String msg, Throwable t) {
        getLogger().error(msg, t);
    }
}
