package com.wildma.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wildma.mvp.R;
import com.wildma.mvp.presenter.UserInfoPresenter;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${用户信息界面}
 */
public class UserInfoActivity extends AppCompatActivity implements UserInfoView {

    private TextView          mTvName;
    private ProgressBar       mPbLoading;
    private UserInfoPresenter mUserInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view
        mTvName = (TextView) findViewById(R.id.tv_name);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);

        //init
        mUserInfoPresenter = new UserInfoPresenter(this);
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
