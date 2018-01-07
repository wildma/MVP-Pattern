package com.wildma.mvp.dagger2.module;

import com.wildma.mvp.presenter.UserInfoPresenter;
import com.wildma.mvp.view.UserInfoActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Author       wildma
 * Date         2016/11/25
 * Desc	        ${TODO}
 */
@Module //实例化目标类需要依赖的对象
public class UserInfoActivityModule {

    UserInfoActivity mActivity;

    public UserInfoActivityModule(UserInfoActivity activity) {
        mActivity = activity;
    }

    /**
     * 该方法是用来提供实例化对象给目标类的
     *
     * @return
     */
    @Provides
    UserInfoPresenter provideUserInfoPresenter() {
        return new UserInfoPresenter(mActivity);
    }
}
