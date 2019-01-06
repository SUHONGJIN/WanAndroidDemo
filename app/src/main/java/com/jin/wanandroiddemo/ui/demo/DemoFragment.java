package com.jin.wanandroiddemo.ui.demo;

import com.jin.wanandroiddemo.R;
import com.jin.wanandroiddemo.base.BaseFragment;

/**
 * Created by SuHongJin on 2019/1/6.
 */

public class DemoFragment extends BaseFragment {
    public static DemoFragment getInstance() {
        return new DemoFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_demo;
    }

    @Override
    protected void initData() {

    }
}
