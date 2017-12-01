package com.wildma.mvp.view;

/**
 * Author     wildma
 * DATE       2016/11/25
 * Desc	      ${用户信息View层接口}
 */
public interface UserInfoView {

    /**
     * 显示加载圈
     */
    void showLoading();

    /**
     * 隐藏加载圈
     */
    void hideLoading();

    /**
     * 显示昵称
     *
     * @param name 昵称
     */
    void showName(String name);

    /**
     * 显示失败原因
     *
     * @param failReason 失败原因
     */
    void showFailReason(String failReason);
}
