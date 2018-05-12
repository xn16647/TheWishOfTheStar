package com.example.lou.thewishofthestar.ui.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomewoksBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class HomeWokerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomewoksBean> mList;
    private Context context;

    public HomeWokerAdapter(List<HomewoksBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_woker_item, parent, false);
        WokerHolder holder = new WokerHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomewoksBean work = mList.get(position);
        if(holder instanceof WokerHolder){
            ((WokerHolder) holder).home_stu_name.setText(work.getNickname());
            ((WokerHolder) holder).home_content.setText(work.getContent());
            ((WokerHolder) holder).home_work_from.setText(work.getSource());
            Glide.with(context).load(work.getPhoto()).error(R.mipmap.user_head_portrait).into(((WokerHolder) holder).home_stu_img);
            Glide.with(context).load(work.getCoverImg()).into(((WokerHolder) holder).home_introimg);
            ((WokerHolder) holder).home_masterwork_listitem_worktype.setText(work.getWorksType());

            if(work.getTRealname()!=null){
                ((WokerHolder) holder).home_teachername.setText((String) work.getTRealname());
                Glide.with(context).load(work.getTPhoto()).into(((WokerHolder) holder).home_teacherimg);
                ((WokerHolder) holder).home_teacherlevel.setImageResource(R.mipmap.home_level_vip_blue);
                ((WokerHolder) holder).home_teacherintro.setText((String) work.getTIntro());
            }else {
                ((WokerHolder) holder).home_teacher_group.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class WokerHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RoundedImageView home_stu_img;
        public TextView home_stu_name;
        public TextView home_woke_time;
        public TextView home_work_from;
        public TextView home_content;
        public TextView home_contentintro;
        public ImageView home_introimg;
        public ImageView home_audioimg;
        public TextView home_masterwork_listitem_audio_time;
        public RelativeLayout home_audio_gorpu;
        public TextView home_masterwork_listitem_video_time;
        public LinearLayout home_video_group;
        public RelativeLayout home_introimg_group;
        public TextView home_masterwork_listitem_worktype;
        public RoundedImageView home_teacherimg;
        public TextView home_teachername;
        public ImageView home_teacherlevel;
        public TextView home_teacherintro;
        public TextView home__item_peep_price;
        public LinearLayout home__item_peep;
        public RelativeLayout home_teacher_group;
        public TextView home_masterwork_listitem_teacher_group_line;
        public CheckBox home_masterwork_list_item_reply_cb;
        public LinearLayout home_masterwork_list_item_reply_group;
        public CheckBox home_item_praise_cb;
        public LinearLayout home_masterwork_list_item_praise_group;
        public CheckBox home_masterwork_list_item_reward_cb;
        public LinearLayout home_reward_group;
        public LinearLayout home_masterwork_list_item_share;
        public LinearLayout home_masterwork_list_item_group;
        public WokerHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.home_stu_img = (RoundedImageView) rootView.findViewById(R.id.home_stu_img);
            this.home_stu_name = (TextView) rootView.findViewById(R.id.home_stu_name);
            this.home_woke_time = (TextView) rootView.findViewById(R.id.home_woke_time);
            this.home_work_from = (TextView) rootView.findViewById(R.id.home_work_from);
            this.home_content = (TextView) rootView.findViewById(R.id.home_content);
            this.home_contentintro = (TextView) rootView.findViewById(R.id.home_contentintro);
            this.home_introimg = (ImageView) rootView.findViewById(R.id.home_introimg);
            this.home_audioimg = (ImageView) rootView.findViewById(R.id.home_audioimg);
            this.home_masterwork_listitem_audio_time = (TextView) rootView.findViewById(R.id.home_masterwork_listitem_audio_time);
            this.home_audio_gorpu = (RelativeLayout) rootView.findViewById(R.id.home_audio_gorpu);
            this.home_masterwork_listitem_video_time = (TextView) rootView.findViewById(R.id.home_masterwork_listitem_video_time);
            this.home_video_group = (LinearLayout) rootView.findViewById(R.id.home_video_group);
            this.home_introimg_group = (RelativeLayout) rootView.findViewById(R.id.home_introimg_group);
            this.home_masterwork_listitem_worktype = (TextView) rootView.findViewById(R.id.home_masterwork_listitem_worktype);
            this.home_teacherimg = (RoundedImageView) rootView.findViewById(R.id.home_teacherimg);
            this.home_teachername = (TextView) rootView.findViewById(R.id.home_teachername);
            this.home_teacherlevel = (ImageView) rootView.findViewById(R.id.home_teacherlevel);
            this.home_teacherintro = (TextView) rootView.findViewById(R.id.home_teacherintro);
            this.home__item_peep_price = (TextView) rootView.findViewById(R.id.home__item_peep_price);
            this.home__item_peep = (LinearLayout) rootView.findViewById(R.id.home__item_peep);
            this.home_teacher_group = (RelativeLayout) rootView.findViewById(R.id.home_teacher_group);
            this.home_masterwork_listitem_teacher_group_line = (TextView) rootView.findViewById(R.id.home_masterwork_listitem_teacher_group_line);
            this.home_masterwork_list_item_reply_cb = (CheckBox) rootView.findViewById(R.id.home_masterwork_list_item_reply_cb);
            this.home_masterwork_list_item_reply_group = (LinearLayout) rootView.findViewById(R.id.home_masterwork_list_item_reply_group);
            this.home_item_praise_cb = (CheckBox) rootView.findViewById(R.id.home_item_praise_cb);
            this.home_masterwork_list_item_praise_group = (LinearLayout) rootView.findViewById(R.id.home_masterwork_list_item_praise_group);
            this.home_masterwork_list_item_reward_cb = (CheckBox) rootView.findViewById(R.id.home_masterwork_list_item_reward_cb);
            this.home_reward_group = (LinearLayout) rootView.findViewById(R.id.home_reward_group);
            this.home_masterwork_list_item_share = (LinearLayout) rootView.findViewById(R.id.home_masterwork_list_item_share);
            this.home_masterwork_list_item_group = (LinearLayout) rootView.findViewById(R.id.home_masterwork_list_item_group);
        }
    }

}
