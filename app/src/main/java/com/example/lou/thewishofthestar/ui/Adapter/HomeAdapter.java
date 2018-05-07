package com.example.lou.thewishofthestar.ui.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.data.Constant;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.DataBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomewoksBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.LiveCoursesBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.SystemAdsBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.UsersBean;
import com.example.lou.thewishofthestar.utils.HttpHelp;
import com.makeramen.roundedimageview.RoundedImageView;
import com.recker.flybanner.FlyBanner;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private DataBean dataBean;
    private Context context;

    public HomeAdapter(DataBean dataBean, Context context) {
        this.dataBean = dataBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.home_course_layout, parent, false);
                holder = new SystemAdsHolder(view);
                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.home_intent_layout, parent, false);
                holder = new ShapeHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.home_users_layout, parent, false);
                holder = new UserHolder(view);
                break;
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.home_users_layout, parent, false);
                holder = new CoursesHolder(view);
                break;
            case 4:
                view = LayoutInflater.from(context).inflate(R.layout.home_users_layout, parent, false);
                holder = new WokerHolder(view);
                break;
            case 5:
                view = LayoutInflater.from(context).inflate(R.layout.home_foot_item,parent,false);
                holder = new FootHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SystemAdsHolder) {
            List<String> mImage = new ArrayList<>();
            List<SystemAdsBean> systemAds = dataBean.getSystemAds();
            for (SystemAdsBean liveCours : systemAds) {
                mImage.add(liveCours.getMobileImgUrl());
            }
            ((SystemAdsHolder) holder).banner.setImagesUrl(mImage);
            ((SystemAdsHolder) holder).banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                }
            });


        }

        if (holder instanceof ShapeHolder) {
            ((ShapeHolder) holder).chat_shape_btn.setOnClickListener(this);
            ((ShapeHolder) holder).learn_shape_btn.setOnClickListener(this);
            ((ShapeHolder) holder).look_shape_btn.setOnClickListener(this);
            ((ShapeHolder) holder).woker_shape_btn.setOnClickListener(this);
            ((ShapeHolder) holder).find_teacher_btn.setOnClickListener(this);
        }

        if (holder instanceof UserHolder) {
            List<UsersBean> users = dataBean.getUsers();
            SuperAdapter<UsersBean> superAdapter = new SuperAdapter<UsersBean>(context, users, R.layout.home_user_item) {
                @Override
                public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, UsersBean item) {
                    holder.setText(R.id.user_name, item.getRealname());
                    holder.setText(R.id.users_content, item.getIntro());
                    ImageView user_img = holder.itemView.findViewById(R.id.user_img);
                    ImageView user_lv = holder.itemView.findViewById(R.id.user_lv);
                    Glide.with(context).load(item.getImages()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(user_img);
                    if (item.getUserType() == 3) {
                        user_lv.setImageResource(R.mipmap.home_level_vip_yellow);
                    } else if (item.getUserType() == 4) {
                        user_lv.setImageResource(R.mipmap.home_level_vip_red);
                    }
                }
            };
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((UserHolder) holder).user_recyc.setLayoutManager(linearLayoutManager);
            ((UserHolder) holder).user_recyc.setAdapter(superAdapter);

        }

        if (holder instanceof CoursesHolder) {
            ((CoursesHolder) holder).homttexttext.setText("课程推荐");
            ((CoursesHolder) holder).user_recyc.setLayoutManager(new GridLayoutManager(context, 2));
            List<LiveCoursesBean> liveCourses = dataBean.getLiveCourses();
            SuperAdapter<LiveCoursesBean> superAdapter = new SuperAdapter<LiveCoursesBean>(context, liveCourses, R.layout.courses_layout) {
                @Override
                public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, LiveCoursesBean item) {
                    holder.setText(R.id.courses_name, item.getRealname());
                    long endDate = item.getEndDate();
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd"); //格式化当前系统日期
                    String dateTime = dateFm.format(endDate);
                    dateTime.substring(6, dateTime.length());

                    holder.setText(R.id.courses_time, "开课时间:" + dateTime);
                    ImageView courses_img = holder.itemView.findViewById(R.id.courses_img);
                    Glide.with(context).load(item.getCoverImg()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(courses_img);
                    ImageView courses_lv = holder.itemView.findViewById(R.id.courses_lv);
                    if (item.getUserType() == 4) {
                        courses_lv.setImageResource(R.mipmap.home_level_vip_red);
                    } else {
                        courses_lv.setImageResource(R.mipmap.home_level_vip_yellow);

                    }

                }
            };

            ((CoursesHolder) holder).user_recyc.setAdapter(superAdapter);

        }

        if (holder instanceof WokerHolder) {
            List<HomewoksBean> homewoks = dataBean.getHomewoks();
            ((WokerHolder) holder).homttexttext.setText("推荐作业");
            ((WokerHolder) holder).user_recyc.setLayoutManager(new LinearLayoutManager(context));

            HomeWokerAdapter adapter = new HomeWokerAdapter(homewoks,context);
            ((WokerHolder) holder).user_recyc.setAdapter(adapter);

        }

        if(holder instanceof FootHolder){
            ((FootHolder) holder).foot_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chat_shape_btn:
                break;
            case R.id.learn_shape_btn:
                break;
            case R.id.look_shape_btn:
                break;
            case R.id.woker_shape_btn:
                break;
            case R.id.find_teacher_btn:
                break;
        }
    }


    class SystemAdsHolder extends RecyclerView.ViewHolder {
        FlyBanner banner;

        public SystemAdsHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);

        }
    }

    class ShapeHolder extends RecyclerView.ViewHolder {

        Button chat_shape_btn;
        Button learn_shape_btn;
        Button look_shape_btn;
        Button woker_shape_btn;
        Button find_teacher_btn;

        public ShapeHolder(View itemView) {
            super(itemView);
            chat_shape_btn = itemView.findViewById(R.id.chat_shape_btn);
            learn_shape_btn = itemView.findViewById(R.id.learn_shape_btn);
            look_shape_btn = itemView.findViewById(R.id.look_shape_btn);
            woker_shape_btn = itemView.findViewById(R.id.woker_shape_btn);
            find_teacher_btn = itemView.findViewById(R.id.find_teacher_btn);
        }
    }

    class UserHolder extends RecyclerView.ViewHolder {
        RecyclerView user_recyc;


        public UserHolder(View itemView) {
            super(itemView);
            user_recyc = itemView.findViewById(R.id.user_recyc);

        }
    }

    class CoursesHolder extends RecyclerView.ViewHolder {
        RecyclerView user_recyc;
        TextView homttexttext;

        public CoursesHolder(View itemView) {
            super(itemView);
            user_recyc = itemView.findViewById(R.id.user_recyc);
            homttexttext = itemView.findViewById(R.id.homttexttext);
        }
    }

    class WokerHolder extends RecyclerView.ViewHolder {
        RecyclerView user_recyc;
        TextView homttexttext;

        public WokerHolder(View rootView) {
            super(rootView);
            user_recyc = itemView.findViewById(R.id.user_recyc);
            homttexttext = itemView.findViewById(R.id.homttexttext);
        }
    }

    class FootHolder extends RecyclerView.ViewHolder{
        TextView foot_text;

        public FootHolder(View itemView) {
            super(itemView);
            foot_text = itemView.findViewById(R.id.home_foot_text);
        }
    }

}
