package com.hqumath.androidmvp.ui.repos;

/**
 * ****************************************************************
 * 文件名称: LoginContract
 * 作    者: Created by PTShell
 * 创建时间: 2019/1/21 15:08
 * 文件描述:
 * 注意事项:
 * 版权声明:
 * ****************************************************************
 */
public interface ReposDetailContract {
    void onGetReposInfoSuccess(Object object);

    void onGetReposInfoError(String errorMsg, String code);

    void onGetListSuccess(boolean isRefresh, boolean isNewDataEmpty);

    void onGetListError(String errorMsg, String code, boolean isRefresh);
}
