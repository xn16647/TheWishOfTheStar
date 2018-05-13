package com.example.lou.thewishofthestar.ui.Fragment.propheys.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.ProphesyBean;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 1
 * on 2018/5/8.
 * at 北京
 */

public class PropHeysAdapter extends RecyclerView.Adapter<PropHeysAdapter.ViewHolder> {
   private List<ProphesyBean.DataBean.ListBean> list;
   private Context context;
    private ItemListener listener;
    public PropHeysAdapter(List<ProphesyBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public PropHeysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.prophsey_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PropHeysAdapter.ViewHolder holder, final int position) {
        Picasso.with(context).load(list.get(position).getCoverImg()).into(holder.coverImg);
        holder.address.setText(list.get(position).getAddress());
        holder.reservationNum.setText(list.get(position).getReservationNum()+"");
        holder.subscribeNum.setText(list.get(position).getSubscribeNum()+"");
        holder.price.setText(list.get(position).getPrice()+"");
        if(list.get(position).getId()==66){
            holder.type.setText("表演");
        }else{
            holder.type.setText("声乐");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(list.get(position).getStartDate());
        holder.startDate.setText(sdf.format(date));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 listener.Listener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView coverImg;
        private final TextView type;
        private final TextView startDate;
        private final TextView address;
        private final TextView reservationNum;
        private final TextView subscribeNum;
        private final TextView price;

        public ViewHolder(View itemView) {
            super(itemView);

            coverImg = itemView.findViewById(R.id.coverImg);
            type = itemView.findViewById(R.id.type);
            startDate = itemView.findViewById(R.id.startDate);
            address = itemView.findViewById(R.id.address);
            reservationNum = itemView.findViewById(R.id.reservationNum);
            subscribeNum = itemView.findViewById(R.id.subscribeNum);
            price = itemView.findViewById(R.id.price);
        }
    }

    public interface ItemListener{
        void Listener(int position);
    }

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }
}
