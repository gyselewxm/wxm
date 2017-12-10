package com.wxm.mybatis.mapper.weekend.reflection;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

import com.wxm.mybatis.mapper.weekend.Fn;

public class Reflections {
    public static String fnToFieldName(Fn<?, ?> fn) {
        try {
            Method e = fn.getClass().getDeclaredMethod("writeReplace", new Class[0]);
            e.setAccessible(Boolean.TRUE.booleanValue());
            SerializedLambda serializedLambda = (SerializedLambda) e.invoke(fn, new Object[0]);
            String getter = serializedLambda.getImplMethodName();
            String fieldName = Introspector.decapitalize(getter.replace("get", ""));
            return fieldName;
        } catch (ReflectiveOperationException arg4) {
            throw new ReflectionOperationException(arg4);
        }
    }
}