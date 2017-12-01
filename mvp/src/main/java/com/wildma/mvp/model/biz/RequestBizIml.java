package com.wildma.mvp.model.biz;


import com.wildma.mvp.model.bean.UserInfobean;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${请求业务实现类}
 */
public class RequestBizIml implements RequestBiz {

    @Override
    public void requestData(final OnRequestListener listener) {

        /**
         * 开启子线程休眠2秒来模拟网络请求，请求成功后填充数据到Userbean，并通过接口将成功或失败回调出去
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    UserInfobean userInfobean = new UserInfobean();
                    userInfobean.setName("wildma");
                    boolean isRequestSuccess = true;//模拟请求是否成功
                    if (null != listener) {
                        if (isRequestSuccess) {
                            listener.onSuccess(userInfobean);
                        } else {
                            listener.onFailed("服务器繁忙，请稍后再试！");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
