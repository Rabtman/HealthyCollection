package com.rabt.healthycollection.ui.hospital.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.City;

import me.yokeyword.indexablerv.IndexableAdapter;

public class CityAdapter extends IndexableAdapter<City> {

    private Context context;

    public CityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
        return new HeadVH(LayoutInflater.from(context).inflate(R.layout.index_city_head, parent, false));
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        return new ItemVH(LayoutInflater.from(context).inflate(R.layout.index_city_item, parent, false));
    }

    @Override
    public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
        HeadVH vh = (HeadVH) holder;
        vh.tv.setText(indexTitle);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, City entity) {
        ItemVH vh = (ItemVH) holder;
        vh.tv.setText(entity.getName());
    }

    private class HeadVH extends RecyclerView.ViewHolder {
        TextView tv;

        public HeadVH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.city_head);
        }
    }

    private class ItemVH extends RecyclerView.ViewHolder {
        TextView tv;

        public ItemVH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.city_item);
        }
    }
}