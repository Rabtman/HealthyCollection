package com.rabt.healthycollection.ui.health.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.utils.TimeUtil;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: 健康资讯列表项适配器
 */

public class HealthNewsAdapter extends BaseQuickAdapter<HealthNewsPage.HealthNews, BaseViewHolder> {

    public HealthNewsAdapter() {
        super(R.layout.healthnews_item, null);
    }

    public HealthNewsAdapter(List<HealthNewsPage.HealthNews> data) {
        super(R.layout.healthnews_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HealthNewsPage.HealthNews content) {
        helper.setText(R.id.card_title, content.getTitle())
                .setText(R.id.card_date, TimeUtil.millis2String(content.getTime(), "yyyy-MM-dd"));
        Glide.with(mContext)
                .load(BuildConfig.TN_IMG_URL + content.getImg())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into((ImageView) helper.getView(R.id.card_img));
    }
}
