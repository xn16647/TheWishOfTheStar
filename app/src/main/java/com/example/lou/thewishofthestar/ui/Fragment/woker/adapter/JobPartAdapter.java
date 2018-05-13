package com.example.lou.thewishofthestar.ui.Fragment.woker.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.JobPartBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 1
 * on 2018/5/11.
 * at 北京
 */

public class JobPartAdapter extends RecyclerView.Adapter<JobPartAdapter.ViewHolder> {
    private List<JobPartBean.DataBean.CommentsBean.ListBean> list;
    private Context context;

    public JobPartAdapter(List<JobPartBean.DataBean.CommentsBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public JobPartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jobpart_comment_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final JobPartAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.photo) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.photo.setImageDrawable(circularBitmapDrawable);
            }
        });

        holder.nickname.setText(list.get(position).getNickname());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        Date date = new Date(list.get(position).getCreateDate());
        holder.createDate.setText(sdf.format(date));

        holder.content.setText(list.get(position).getContent());
        holder.replyNum.setText("共"+list.get(position).getReplyNum()+"条回复");
        holder.praiseNum.setText(list.get(position).getPraiseNum()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView photo;
        private final TextView nickname;
        private final TextView createDate;
        private final TextView content;
        private final TextView replyNum;
        private final TextView praiseNum;
        private final TextView huifu;
        private final ImageView zan;

        public ViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            nickname = itemView.findViewById(R.id.nickname);
            createDate = itemView.findViewById(R.id.createDate);
            content = itemView.findViewById(R.id.content);
            replyNum = itemView.findViewById(R.id.replyNum);
            praiseNum = itemView.findViewById(R.id.praiseNum);
            huifu = itemView.findViewById(R.id.huifu);
            zan = itemView.findViewById(R.id.zan);
        }
    }
}
