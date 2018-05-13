package com.example.lou.thewishofthestar.ui.Fragment;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.ValueBleBookContract;
import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;
import com.example.lou.thewishofthestar.presenter.BookBannerPresenter;
import com.example.lou.thewishofthestar.ui.Fragment.book.BookReuseFragment;
import com.example.lou.thewishofthestar.ui.Fragment.book.adapter.FragmentReuseAdapter;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ValuableBookFragment extends BaseFragment implements ValueBleBookContract.View{


    private Banner banner;
    private XTabLayout tablay;
    private ViewPager vp;
    private LinearLayout book_linear;
    private BookBannerPresenter presenter;
    private List<String> title;
    private List<Fragment>fragmentList=new ArrayList<>();
    private List<BookMasterBean.DataBean.SystemAdsBean> systemAds;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_valuable_book;
    }

    @Override
    protected void init() {
        banner = getView().findViewById(R.id.banner);
        tablay = getView().findViewById(R.id.tablay);
        book_linear = getView().findViewById(R.id.book_linear);
        vp = getView().findViewById(R.id.vp);

    }

    @Override
    protected void initLoad() {
        if (isNetWorkAvaliable(getContext())){
            presenter = new BookBannerPresenter(this);
            presenter.loadData(getContext(),20,0);
            book_linear.setVisibility(View.GONE);
        }else{
            book_linear.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void Error(String e) {

    }

    @Override
    public void showBookdata(BookMasterBean bookMasterBean) {
        List<BookMasterBean.DataBean.ArtcircleCategoriesBean> artcircleCategories = bookMasterBean.getData().getArtcircleCategories();
        systemAds = bookMasterBean.getData().getSystemAds();

        initBanner();
        title=new ArrayList<>();

        title.add("智能筛选");
        title.add("赞数最多");
        title.add("最新评论");
        for (int i = 0; i <artcircleCategories.size() ; i++) {
            title.add(artcircleCategories.get(i).getName());

        }
        for (int i = 0; i < title.size(); i++) {
            BookReuseFragment fragment = new BookReuseFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("rows",20);
            bundle.putInt("sortord",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }

        FragmentReuseAdapter adapter = new FragmentReuseAdapter(getChildFragmentManager(), title, fragmentList);
        vp.setAdapter(adapter);
        tablay.setupWithViewPager(vp);

    }

    private void initBanner() {
        List<String>bannerList=new ArrayList<>();
        for (int i = 0; i <systemAds.size() ; i++) {
            bannerList.add(systemAds.get(i).getMobileImgUrl());
        }
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImages(bannerList);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(getActivity()).load((String) path).into(imageView);
            }
        });
        banner.start();
    }

    /**
     * 判断当前是否有网
     *
     * @return
     */
    private boolean isNetWorkAvaliable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        if (manager == null)
            return false;

        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null)
            return info.isAvailable();

        return false;
    }
}
