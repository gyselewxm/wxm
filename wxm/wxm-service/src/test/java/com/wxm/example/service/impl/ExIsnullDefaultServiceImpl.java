package com.wxm.example.service.impl;

import org.springframework.stereotype.Service;

import com.wxm.example.pojo.bo.ExIsnullDefaultBO;
import com.wxm.example.pojo.entity.ExIsnullDefault;
import com.wxm.example.service.IExIsnullDefaultService;
import com.wxm.service.base.abs.ACRUDService;

/**
 * <b>Title:</b> 示例-是否为空-默认<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月11日 下午5:48:30 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
@Service
public class ExIsnullDefaultServiceImpl extends ACRUDService<ExIsnullDefault, ExIsnullDefaultBO> implements
        IExIsnullDefaultService {

}
