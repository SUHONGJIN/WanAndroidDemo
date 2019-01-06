package com.jin.wanandroiddemo.ui.system;

import com.jin.wanandroiddemo.R;
import com.jin.wanandroiddemo.base.BaseFragment;

/**
 * Created by SuHongJin on 2019/1/6.
 */

public class SystemFragment extends BaseFragment {

    public static  SystemFragment getInstance(){
        return new SystemFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initData() {

    }
}
