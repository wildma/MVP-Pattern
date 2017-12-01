package com.wildma.mvp.model.biz;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${请求业务}
 */
public interface RequestBiz {

    /**
     * 请求数据
     *
     * @param listener 成功或失败的回调接口
     */
    void requestData(OnRequestListener listener);
}
