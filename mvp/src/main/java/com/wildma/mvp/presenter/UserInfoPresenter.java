package com.wildma.mvp.presenter;


import android.os.Handler;
import android.os.Looper;

import com.wildma.mvp.model.bean.UserInfobean;
import com.wildma.mvp.model.biz.OnRequestListener;
import com.wildma.mvp.model.biz.RequestBiz;
import com.wildma.mvp.model.biz.RequestBizIml;
import com.wildma.mvp.view.UserInfoView;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${用户信息P层}
 */
public class UserInfoPresenter {

    private UserInfoView mUserInfoView;
    private RequestBiz   requestBiz;
    private Handler      mHandler;

    public UserInfoPresenter(UserInfoView userInfoView) {
        this.mUserInfoView = userInfoView;
        requestBiz = new RequestBizIml();
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 请求数据
     */
    public void requestData() {
        mUserInfoView.showLoading();
        requestBiz.requestData(new OnRequestListener() {
            @Override
            public void onSuccess(final Object data) {
                //因为请求开启了子线程，所以这里需要用UI线程去更新界面
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserInfoView.hideLoading();
                        UserInfobean userInfobean = (UserInfobean) data;
                        mUserInfoView.showName("我的昵称是：" + userInfobean.getName());
                    }
                });

            }

            @Override
            public void onFailed(final String failReason) {
                //因为请求开启了子线程，所以这里需要用UI线程去更新界面
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserInfoView.hideLoading();
                        mUserInfoView.showFailReason(failReason);
                    }
                });
            }
        });
    }

}
