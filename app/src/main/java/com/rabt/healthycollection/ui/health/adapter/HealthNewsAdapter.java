package com.rabt.healthycollection.ui.health.adapter;

import android.os.Build;
import android.text.Html;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.HealthNewsPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: 健康资讯列表项适配器
 */

public class HealthNewsAdapter extends BaseQuickAdapter<HealthNewsPage.Page.Content, BaseViewHolder> {

    public HealthNewsAdapter() {
        super(R.layout.healthnews_item, null);
    }

    public HealthNewsAdapter(List<HealthNewsPage.Page.Content> data) {
        super(R.layout.healthnews_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HealthNewsPage.Page.Content content) {
        if (Build.VERSION.SDK_INT >= 24) {
            helper.setText(R.id.card_title, Html.fromHtml(content.getTitle(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            helper.setText(R.id.card_title, Html.fromHtml(content.getTitle()));
        }
        helper.setText(R.id.card_date, content.getTime())
                .setText(R.id.card_author, content.getAuthor());
        Glide.with(mContext)
                .load(content.getImg())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into((ImageView) helper.getView(R.id.card_img));
    }
}
