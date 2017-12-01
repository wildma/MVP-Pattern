package com.wildma.mvc;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wildma.mvc.model.bean.UserInfobean;
import com.wildma.mvc.model.biz.OnRequestListener;
import com.wildma.mvc.model.biz.RequestBizIml;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${用户信息界面}
 */
public class UserInfoActivity extends AppCompatActivity {

    private TextView      mTvName;
    private RequestBizIml mRequestBizIml;
    private ProgressBar   mPbLoading;
    private Handler       mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view
        mTvName = (TextView) findViewById(R.id.tv_name);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);

        //init
        mHandler = new Handler();
        mRequestBizIml = new RequestBizIml();

    }

    /**
     * 获取数据按钮点击事件
     *
     * @param view
     */
    public void getData(View view) {
        requestData();
    }

    /**
     * 请求数据
     */
    private void requestData() {
        mPbLoading.setVisibility(View.VISIBLE);
        mRequestBizIml.requestData(new OnRequestListener() {
            @Override
            public void onSuccess(final Object data) {
                //因为请求开启了子线程，所以这里需要用UI线程去更新界面
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPbLoading.setVisibility(View.GONE);
                        UserInfobean userInfobean = (UserInfobean) data;
                        mTvName.setText("我的昵称是：" + userInfobean.getName());
                    }
                });
            }

            @Override
            public void onFailed(final String failReason) {
                //因为请求开启了子线程，所以这里需要用UI线程去更新界面
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPbLoading.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), failReason, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
