package com.example.lou.thewishofthestar.ui.Fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.lou.thewishofthestar.utils.HttpHelp;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TeacherFragment extends BaseFragment implements HomeContract.View{


    private ProgressDialog progressDialog;
    private HomeContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {


    }

    @SuppressLint("CheckResult")
    @Override
    protected void initLoad() {
        presenter = new HomePresenter(this);
        presenter.loadData(getContext());
    }



    @Override
    public void showSuccees(HomeBean homeBean) {
        DataBean data = homeBean.getData();
        List<HomewoksBean> homewoks = data.getHomewoks();
        String content = homewoks.get(0).getContent();
        String message = homeBean.getMessage();
        Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
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
