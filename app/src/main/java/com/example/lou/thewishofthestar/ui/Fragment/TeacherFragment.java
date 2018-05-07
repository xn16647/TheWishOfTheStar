package com.example.lou.thewishofthestar.ui.Fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.HomeContract;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.DataBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomewoksBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.presenter.HomePresenter;
import com.example.lou.thewishofthestar.ui.Adapter.HomeAdapter;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TeacherFragment extends BaseFragment implements HomeContract.View{


    private ProgressDialog progressDialog;
    private HomeContract.Presenter presenter;
    private RecyclerView home_recyc;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        home_recyc = getView().findViewById(R.id.home_recyc);
        home_recyc.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @SuppressLint("CheckResult")
    @Override
    protected void initLoad() {
        presenter = new HomePresenter(this);
        presenter.loadData(getContext());
    }



    @Override
    public void showSuccees(HomeBean homeBean) {
        HomeAdapter homeAdapter = new HomeAdapter(homeBean.getData(),getContext());
        home_recyc.setAdapter(homeAdapter);

    }

    @Override
    public void Error(String e) {

    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }
}
