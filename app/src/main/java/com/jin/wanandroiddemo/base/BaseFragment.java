package com.jin.wanandroiddemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础碎片类
 * Created by SuHongJin on 2019/1/6.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    /**
     * 正常状态、处理页面加载中、页面加载失败、页面没数据
     */
    private static final int NORMAL_STATE = 0;
    private static final int LOADING_STATE = 1;
    public static final int ERROR_STATE = 2;
    public static final int EMPTY_STATE = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this,view);
        intiUI();
        initData();
    }

    /**
     * 获取xml布局
     * @return
     */
    protected  abstract int  getLayoutId();

    /**
     * 初始化UI布局
     */
    protected void intiUI(){
        if (getView() == null){
            return;
        }
    }
    /**
     * 数据初始化
     */
    protected abstract  void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
