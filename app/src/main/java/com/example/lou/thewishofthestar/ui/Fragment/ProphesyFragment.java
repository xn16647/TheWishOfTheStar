package com.example.lou.thewishofthestar.ui.Fragment;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.PropheysContract;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.ProphesyBean;
import com.example.lou.thewishofthestar.presenter.PropheysPresenter;
import com.example.lou.thewishofthestar.ui.Activity.MainActivity;
import com.example.lou.thewishofthestar.ui.Fragment.propheys.adapter.PropHeysAdapter;
import com.example.lou.thewishofthestar.ui.Fragment.propheys.adapter.PropheysDetailsActivity;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class ProphesyFragment extends BaseFragment implements View.OnClickListener ,PropheysContract.View{


    private TextView home_notice_fragment_timesort_btn;
    private RelativeLayout home_notice_fragment_timesort_btn_group;
    private RelativeLayout recycler_item;
    private RecyclerView recycler;
    private RelativeLayout no_content;
    private Button home_notice_fragment_listview_fault_btn;
    private RelativeLayout home_notice_fragment_listview_fault;
    private TextView start;
    private LinearLayout home_notice_fragment_timesort_start_group;
    private TextView end;
    private LinearLayout home_notice_fragment_timesort_end_group;
    private TextView reset;
    private TextView confirm;
    private LinearLayout home_notice_fragment_timesort_group;
    private boolean Tag = false;
    private PropheysPresenter presenter;
    private List<ProphesyBean.DataBean.ListBean> list=new ArrayList<>();
    private LinearLayoutManager manager;
    private PropHeysAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_prophesy;
    }

    @Override
    protected void init() {

        home_notice_fragment_timesort_btn = (TextView) getView().findViewById(R.id.home_notice_fragment_timesort_btn);
        home_notice_fragment_timesort_btn_group = (RelativeLayout) getView().findViewById(R.id.home_notice_fragment_timesort_btn_group);
        recycler_item = (RelativeLayout) getView().findViewById(R.id.recycler_item);
        recycler = (RecyclerView) getView().findViewById(R.id.home_notice_fragment_listview);
        no_content = (RelativeLayout) getView().findViewById(R.id.no_content);
        home_notice_fragment_listview_fault_btn = (Button) getView().findViewById(R.id.home_notice_fragment_listview_fault_btn);
        home_notice_fragment_listview_fault = (RelativeLayout) getView().findViewById(R.id.home_notice_fragment_listview_fault);
        start = (TextView) getView().findViewById(R.id.start);
        home_notice_fragment_timesort_start_group = (LinearLayout) getView().findViewById(R.id.home_notice_fragment_timesort_start_group);
        end = (TextView) getView().findViewById(R.id.end);
        home_notice_fragment_timesort_end_group = (LinearLayout) getView().findViewById(R.id.home_notice_fragment_timesort_end_group);
        reset = (TextView) getView().findViewById(R.id.reset);
        confirm = (TextView) getView().findViewById(R.id.confirm);
        home_notice_fragment_timesort_group = (LinearLayout) getView().findViewById(R.id.home_notice_fragment_timesort_group);


        if(isNetWorkAvaliable(getContext())){
            presenter = new PropheysPresenter(this);
            presenter.loadData(getContext(),1,2,HttpHelp.getUserId(getContext()),"","");
            home_notice_fragment_listview_fault.setVisibility(View.GONE);
        }else {
            home_notice_fragment_listview_fault.setVisibility(View.VISIBLE);
        }

        home_notice_fragment_listview_fault_btn.setOnClickListener(this);
        home_notice_fragment_timesort_btn.setOnClickListener(this);
        home_notice_fragment_timesort_start_group.setOnClickListener(this);
        home_notice_fragment_timesort_end_group.setOnClickListener(this);
        reset.setOnClickListener(this);
        confirm.setOnClickListener(this);
        home_notice_fragment_timesort_group.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(home_notice_fragment_timesort_group.getVisibility()==View.VISIBLE) {
                    home_notice_fragment_timesort_group.setVisibility(View.GONE);
                    home_notice_fragment_timesort_btn.setText("时间筛选");
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initLoad() {
        isNetworkConnected(getContext());
        manager = new LinearLayoutManager(getContext());
        adapter = new PropHeysAdapter(list, getContext());
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        adapter.setListener(new PropHeysAdapter.ItemListener() {
            @Override
            public void Listener(int position) {
                Intent intent = new Intent(getActivity(), PropheysDetailsActivity.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_notice_fragment_timesort_btn:
                if (Tag == false) {
                    Tag = true;
                    home_notice_fragment_timesort_btn.setText("取消");
                    home_notice_fragment_timesort_group.setVisibility(View.VISIBLE);
                } else {
                    Tag = false;
                    home_notice_fragment_timesort_btn.setText("时间筛选");
                    home_notice_fragment_timesort_group.setVisibility(View.GONE);
                }
                break;
            case R.id.home_notice_fragment_timesort_start_group:
                showDatePickDlg();
                break;
            case R.id.home_notice_fragment_timesort_end_group:
                endDatePickDlg();
                break;
            case R.id.reset:
                end.setText("");
                start.setText("");
                list.clear();
                presenter.loadData(getContext(),1,2,HttpHelp.getUserId(getContext()),"","");
                home_notice_fragment_timesort_group.setVisibility(View.GONE);
                home_notice_fragment_timesort_btn.setText("时间筛选");
                break;
            case R.id.confirm:
                String StartTime = start.getText().toString();
                String EndTime = end.getText().toString();
                list.clear();
                presenter.loadData(getContext(),1,2,HttpHelp.getUserId(getContext()),StartTime,EndTime);
                home_notice_fragment_timesort_btn.setText("时间筛选");
                end.setText("");
                start.setText("");
                home_notice_fragment_timesort_group.setVisibility(View.GONE);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void showDatePickDlg() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                start.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    @TargetApi(Build.VERSION_CODES.N)
    public void endDatePickDlg() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                end.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void showSuccees(ProphesyBean prophesyBean) {
        if(prophesyBean.getData().getList()==null){
            no_content.setVisibility(View.VISIBLE);
            recycler_item.setVisibility(View.GONE);
        }else{
            no_content.setVisibility(View.GONE);
            recycler_item.setVisibility(View.VISIBLE);
            list.addAll(prophesyBean.getData().getList());
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void Error(String e) {

    }

    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(CONNECTIVITY_SERVICE);
                    NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
                    if (mNetworkInfo != null) {
                        home_notice_fragment_listview_fault.setVisibility(View.GONE);
                            return mNetworkInfo.isAvailable();
                         }else{
                        home_notice_fragment_listview_fault.setVisibility(View.VISIBLE);
                    }
                 }
             return false;
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
