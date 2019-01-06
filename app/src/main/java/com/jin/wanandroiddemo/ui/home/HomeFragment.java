package com.jin.wanandroiddemo.ui.home;

import com.jin.wanandroiddemo.R;
import com.jin.wanandroiddemo.base.BaseFragment;

/**
 * Created by SuHongJin on 2019/1/6.
 */

public class HomeFragment extends BaseFragment {
    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

    }
}
