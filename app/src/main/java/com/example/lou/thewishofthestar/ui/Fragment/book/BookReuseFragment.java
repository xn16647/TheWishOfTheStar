package com.example.lou.thewishofthestar.ui.Fragment.book;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.ValueBleBookContract;
import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;
import com.example.lou.thewishofthestar.presenter.BookBannerPresenter;
import com.example.lou.thewishofthestar.presenter.StealPresenter;
import com.example.lou.thewishofthestar.ui.Fragment.book.adapter.BookAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookReuseFragment extends BaseFragment implements ValueBleBookContract.View{


    private RecyclerView recycler;
    private BookBannerPresenter presenter;
    private ImageView image;
    private TextView no;
    private LinearLayout book_linear;
    private List<BookMasterBean.DataBean.ArtcircleListBean.ListBean> list = new ArrayList<>();
    private BookAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book_reuse;
    }

    @Override
    protected void init() {
        recycler = getView().findViewById(R.id.recycler);
        image = getView().findViewById(R.id.image);
        no = getView().findViewById(R.id.no);
        book_linear = getView().findViewById(R.id.book_linear);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(manager);
        adapter = new BookAdapter(list, getActivity());
        recycler.setAdapter(adapter);
    }

    @Override
    protected void initLoad() {
        Bundle bundle = getArguments();
        int rows = bundle.getInt("rows");
        int sortord = bundle.getInt("sortord");
        presenter = new BookBannerPresenter(this);
        presenter.loadData(getContext(),rows,sortord);
    }

    @Override
    public void Error(String e) {

    }

    @Override
    public void showBookdata(BookMasterBean bookMasterBean) {

        List<BookMasterBean.DataBean.ArtcircleListBean.ListBean> mlist = bookMasterBean.getData().getArtcircleList().getList();
        Log.e("tag",bookMasterBean.getData().getArtcircleList().getList().get(0).getNickname());
        if(bookMasterBean.getData().getArtcircleCategories() == null){
            recycler.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            no.setVisibility(View.GONE);
        }else{
            recycler.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
            no.setVisibility(View.GONE);
            list.addAll(mlist);
        }
        adapter.notifyDataSetChanged();
    }


}
