package com.hqumath.androidmvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * ****************************************************************
 * 文件名称: BaseFragment
 * 作    者: Created by PTShell
 * 创建时间: 2019/1/21 15:12
 * 文件描述:
 * 注意事项:
 * 版权声明:
 * ****************************************************************
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mContext;
    private View rootView;
    //protected boolean hasRequested;//在onResume中判断是否已经请求过数据。用于懒加载

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = initContentView(inflater, container, savedInstanceState);
            //事件监听
            initListener();
            //初始化数据
            initData();
        } else {
            //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null)
                parent.removeView(rootView);
        }
        return rootView;
    }

    protected abstract View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initData();
}
