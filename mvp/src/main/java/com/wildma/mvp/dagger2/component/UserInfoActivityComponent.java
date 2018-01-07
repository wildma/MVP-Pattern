package com.wildma.mvp.dagger2.component;

import com.wildma.mvp.dagger2.module.UserInfoActivityModule;
import com.wildma.mvp.view.UserInfoActivity;

import dagger.Component;

/**
 * Author       wildma
 * Date         2016/11/25
 * Desc	        ${TODO}
 */
@Component(modules = UserInfoActivityModule.class) //作为Module与目标类之间的桥梁
public interface UserInfoActivityComponent {

    /**
     * 定义注入的方法
     * @param activity
     */
    void inject(UserInfoActivity activity);
}
