package com.nineee.springboot.response;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: ljj
 * @Date: 2019/6/26 14:41
 * @Desc
 */
public class DynamicSubject implements InvocationHandler {

    private Object object;

    public DynamicSubject(Object object) {
        this.object = object;
    }

    public DynamicSubject() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);

        method.invoke(proxy,args);
        System.out.println("after calling " + method);
        return null;
    }
}
