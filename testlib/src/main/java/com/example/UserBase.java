package com.example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by lc434 on 2017/3/20
 */

public class UserBase <T>{
    private UserInnerBean uis;
    public UserBase() {
        Class<UserInnerBean> clazz;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            //参数化类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            clazz = (Class<UserInnerBean>) actualTypeArguments[0];
        } else {
            clazz = (Class<UserInnerBean>) genericSuperclass;
        }
        try {
            System.out.println("----==---" + clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static class UserInnerBean {
        @Override
        public String toString() {
            return "UserInnerBean{}";
        }
    }
}
