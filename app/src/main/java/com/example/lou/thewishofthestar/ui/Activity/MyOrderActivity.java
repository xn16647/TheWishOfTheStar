package com.example.lou.thewishofthestar.ui.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.ui.Adapter.MyPagerAdapter;
import com.example.lou.thewishofthestar.ui.Fragment.OrderFragment;
import com.example.lou.thewishofthestar.ui.view.XViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyOrderActivity extends BaseActivity {

    private List<String> mList;
    private List<Fragment> mFragments;

    @BindView(R.id.order_title)
    TextView orderTitle;
    @BindView(R.id.order_back)
    ImageView orderBack;
    @BindView(R.id.order_tab)
    XTabLayout orderTab;
    @BindView(R.id.xviewpager)
    XViewPager xviewpager;


    @OnClick(R.id.order_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void init() {
        xviewpager.setNoScroll(true);
    }

    @Override
    protected void initLoad() {
        mList = new ArrayList<>();
        mFragments = new ArrayList<>();

        String order = getIntent().getStringExtra("order");
        if (order.equals("dai")) {
            orderTitle.setText("充值中心");
            mList.add("全部");
            mList.add("待付款");
            mList.add("待使用");
            mList.add("退货");



        } else if (order.equals("gift")) {
            orderTitle.setText("明细");
            mList.add("收到礼物");
            mList.add("现金收入");
        }
          else if(order.equals("collect")){
            orderTitle.setText("我的收藏");
            mList.add("直播课程");
            mList.add("体验课程");
            mList.add("偷听作业");
            mList.add("帖子");

        }

        for (int i = 0; i < mList.size(); i++) {
            mFragments.add(new OrderFragment());
        }

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), mList, mFragments);
        xviewpager.setAdapter(adapter);
        orderTab.setupWithViewPager(xviewpager);

    }
}
