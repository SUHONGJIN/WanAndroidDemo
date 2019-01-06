package com.jin.wanandroiddemo.ui.home;

import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.jin.wanandroiddemo.R;
import com.jin.wanandroiddemo.base.BaseActivity;
import com.jin.wanandroiddemo.ui.demo.DemoFragment;
import com.jin.wanandroiddemo.ui.mine.MineFragment;
import com.jin.wanandroiddemo.ui.system.SystemFragment;
import com.jin.wanandroiddemo.ui.wx.WxFragment;
import com.jin.wanandroiddemo.utils.BottomNavigationViewHelper;
import com.jin.wanandroiddemo.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar_common)
    Toolbar toolbarCommon;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.float_button)
    FloatingActionButton floatButton;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private List<Fragment> fragmentList;
    private int lastIndex;
    private long mExitTime;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    floatButton.setVisibility(View.VISIBLE);
                    selectFragment(0);
                    ToastUtil.show(HomeActivity.this,"0");
                    return true;
                case R.id.navigation_system:
                    floatButton.setVisibility(View.VISIBLE);
                    selectFragment(1);
                    ToastUtil.show(HomeActivity.this,"1");
                    return true;
                case R.id.navigation_wx:
                    floatButton.setVisibility(View.VISIBLE);
                    selectFragment(2);
                    ToastUtil.show(HomeActivity.this,"2");
                    return true;
                case R.id.navigation_demo:
                    floatButton.setVisibility(View.VISIBLE);
                    selectFragment(3);
                    ToastUtil.show(HomeActivity.this,"3");
                    return true;
                case R.id.navigation_mine:
                    floatButton.setVisibility(View.GONE);
                    selectFragment(4);
                    ToastUtil.show(HomeActivity.this,"4");
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(toolbarCommon);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    /**
     *选中碎片
     */
    private void selectFragment(int index){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = fragmentList.get(index);
        Fragment lastFragment = fragmentList.get(lastIndex);
        lastIndex = index;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.frame_layout,currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

    @Override
    protected void initView() {
        // 将item 设置为不移动
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // 设置为蓝色背景
        floatButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.theme)));
    }

    @Override
    protected void initData() {
        initFragment();
        selectFragment(0);
    }

    @OnClick(R.id.float_button)
    void click(View view){
        switch (view.getId()){
            case R.id.float_button:
                ToastUtil.show(HomeActivity.this,"点击");
                break;
                default:
                    break;
        }
    }
    /**
     * 初始化碎片
     */
    private void initFragment(){
        fragmentList  = new ArrayList<>();
        fragmentList.add(HomeFragment.getInstance());
        fragmentList.add(SystemFragment.getInstance());
        fragmentList.add(WxFragment.getInstance());
        fragmentList.add(DemoFragment.getInstance());
        fragmentList.add(MineFragment.getInstance());
    }

    /**
     * 创建menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu_hot:
                ToastUtil.show(HomeActivity.this,"热门");
                break;
            case R.id.main_menu_search:
                ToastUtil.show(HomeActivity.this,"搜索");
                break;
                default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
