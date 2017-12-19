package com.wxm.web.config;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * <b>Title:</b> 自定义WebMVC配置<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月31日 上午10:35:35<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
@Configuration
public class WxmWebMVCConfiguration implements WebMvcConfigurer {
    /**
     * 
     * <b>Title:</b> 解决中文乱码<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年10月31日 下午2:35:34<br>
     * 
     * @author wuxm
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}
