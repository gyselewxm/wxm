package com.wxm.mybatis.mapper.weekend;

import java.io.Serializable;
import java.util.function.Function;

public interface Fn<T, R> extends Function<T, R>, Serializable {
}