package com.wxm.web.servlet.view.freemarker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * <b>标题: </b> 自定义FreeMarkerView，用于解析视图 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年10月15日 上午9:24:20 <br/>
 * <b>版本: </b>1.0
 */
public class WxmFreeMarkerView extends FreeMarkerView {

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        model.put("ctx", request.getContextPath()); // 上下文
        super.exposeHelpers(model, request);
    }

}
