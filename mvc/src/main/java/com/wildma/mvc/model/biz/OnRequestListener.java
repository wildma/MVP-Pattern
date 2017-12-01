package com.wildma.mvc.model.biz;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${请求成功或失败的回调接口}
 */
public interface OnRequestListener {

    /**
     * 请求成功回调
     *
     * @param data 服务器返回的数据
     */
    void onSuccess(Object data);

    /**
     * 请求失败回调
     *
     * @param failReason 失败原因
     */
    void onFailed(String failReason);
}
