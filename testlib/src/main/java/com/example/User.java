package com.example;

/**
 * Created by lc434 on 2017/3/20
 */

public class User extends UserBase<UserBase.UserInnerBean> {
    private int a = 0;

    @Override
    public String toString() {
        return "User{" +
                "a=" + a +
                '}';
    }
}
