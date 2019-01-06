package com.jin.wanandroiddemo.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jin.wanandroiddemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础活动类
 * Created by SuHongJin on 2019/1/6.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private BaseActivity activity;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        activity=this;
        initStatusColor();
        initToolbar();
        initView();
        initData();
    }

    /**
     * 初始化状态栏颜色
     */
    private void initStatusColor(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            Window window = activity.getWindow();
            //设置透明状态栏，这样才能让ContentView 向上，6.0小米手机设置toolbar会被挤上去
            //window。addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个flag才能调用setStatusBarColor来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColor(R.color.theme));

            ViewGroup mContentView = (ViewGroup)activity.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView!=null){
                ViewCompat.setFitsSystemWindows(mChildView,false);
            }
        }
    }
    /**
     * 获取xml布局资源
     */
    protected abstract int getLayoutId();
    /**
     * 初始化布局
     */
    protected abstract void initView();
    /**
     * 初始化数据
     */
    protected abstract void initData();
    /**
     * 初始化toolbar
     */
    protected  void initToolbar(){}


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
