package com.example.lou.thewishofthestar.ui.Fragment.woker;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.RemarkContract;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;
import com.example.lou.thewishofthestar.presenter.RemarkPresenter;
import com.example.lou.thewishofthestar.presenter.WokerPresenter;
import com.example.lou.thewishofthestar.ui.Fragment.woker.adapter.NoppsycheAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemarkFragment extends BaseFragment implements RemarkContract.View{
    private RemarkContract.Presenter presenter;
    private ProgressDialog progressDialog;
    private RecyclerView recycler;
    private LinearLayout remark_linear;
    private NoppsycheAdapter adapter;
    private LinearLayoutManager manager;
    private List<WokerMasterBean.DataBean.ListBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_remark;
    }

    @Override
    protected void init() {
        list =  new ArrayList<>();
        recycler = getView().findViewById(R.id.recycler);
        remark_linear = getView().findViewById(R.id.remark_linear);
        if (isNetWorkAvaliable(getContext())){
            presenter = new RemarkPresenter(this);
            presenter.loadData(getContext());
            recycler.setVisibility(View.VISIBLE);
            remark_linear.setVisibility(View.GONE);
        }else{
            recycler.setVisibility(View.GONE);
            remark_linear.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void initLoad() {
        adapter = new NoppsycheAdapter(list, getActivity());
        manager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);


    }

    @Override
    public void showRemark(WokerMasterBean wokerMasterBean) {
        list.clear();
        list.addAll(wokerMasterBean.getData().getList());
        adapter.notifyDataSetChanged();
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
