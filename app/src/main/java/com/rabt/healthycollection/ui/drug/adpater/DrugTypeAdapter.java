package com.rabt.healthycollection.ui.drug.adpater;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.DrugType;

/**
 * author: Rabtman
 * date: 2016-12-01
 * description:
 */

public class DrugTypeAdapter implements SpinnerAdapter {

    private Context mContext;

    public DrugTypeAdapter(Context context) {
        mContext = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return HealthConstants.DRUG_TYPE.size();
    }

    @Override
    public DrugType getItem(int position) {
        return HealthConstants.DRUG_TYPE.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.drug_type_item, parent);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.drug_type);
        textView.setText(HealthConstants.DRUG_TYPE.get(position).getType());
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
