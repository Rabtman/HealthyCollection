package com.rabt.healthycollection.ui.drug.adpater;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.DrugInfoPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: 药品搜索列表项适配器
 */

public class DrugSearchResultAdapter extends BaseQuickAdapter<DrugInfoPage.DrugInfo, BaseViewHolder> {

    public DrugSearchResultAdapter() {
        super(R.layout.healthnews_item, null);
    }

    public DrugSearchResultAdapter(List<DrugInfoPage.DrugInfo> data) {
        super(R.layout.healthnews_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DrugInfoPage.DrugInfo content) {

        helper.setText(R.id.card_name, content.getDrugName())
                .setText(R.id.card_use, content.getSyz())
                .setText(R.id.card_company, content.getManu());
        Glide.with(mContext)
                .load(content.getImg())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into((ImageView) helper.getView(R.id.card_img));
    }
}
