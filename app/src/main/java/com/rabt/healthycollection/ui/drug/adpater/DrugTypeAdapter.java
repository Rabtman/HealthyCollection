package com.rabt.healthycollection.ui.drug.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.DrugType;

/**
 * author: Rabtman
 * date: 2016-12-01
 * description:
 */

public class DrugTypeAdapter extends BaseAdapter {

    private Context mContext;

    public DrugTypeAdapter(Context context) {
        mContext = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.drug_type_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.drug_type);
        textView.setText(HealthConstants.DRUG_TYPE.get(position).getType());
        return convertView;
    }
}
