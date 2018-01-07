package com.wildma.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wildma.mvp.R;
import com.wildma.mvp.dagger2.component.DaggerUserInfoActivityComponent;
import com.wildma.mvp.dagger2.module.UserInfoActivityModule;
import com.wildma.mvp.presenter.UserInfoPresenter;

import javax.inject.Inject;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${用户信息界面}
 */
public class UserInfoActivity extends AppCompatActivity implements UserInfoView {

    private TextView    mTvName;
    private ProgressBar mPbLoading;
    //    UserInfoPresenter mUserInfoPresenter;

    @Inject //标注实例化对象
    UserInfoPresenter mUserInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view
        mTvName = (TextView) findViewById(R.id.tv_name);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);

        //init
        //使用new的方式实例化UserInfoPresenter
        //        mUserInfoPresenter = new UserInfoPresenter(this);

        //使用Dagger2的方式实例化UserInfoPresenter
        //将Module与目标类联系起来
        DaggerUserInfoActivityComponent
                .builder()
                .userInfoActivityModule(new UserInfoActivityModule(this))
                .build()
                .inject(this);
    }

    /**
     * 获取数据按钮点击事件
     *
     * @param view
     */
    public void getData(View view) {
        mUserInfoPresenter.requestData();
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showName(String name) {
        mTvName.setText(name);
    }

    @Override
    public void showFailReason(String failReason) {
        Toast.makeText(getApplicationContext(), failReason, Toast.LENGTH_SHORT).show();
    }
}
