package com.rabt.healthycollection.ui.bwcomic.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.BWComicPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: 黑白漫画列表项适配器
 */

public class BWComicAdapter extends BaseQuickAdapter<BWComicPage.Page.ComicItem, BaseViewHolder> {

    public BWComicAdapter() {
        super(R.layout.bwcomic_item, null);
    }

    public BWComicAdapter(List<BWComicPage.Page.ComicItem> data) {
        super(R.layout.bwcomic_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BWComicPage.Page.ComicItem comicItem) {
        helper.setText(R.id.card_title, comicItem.getTitle())
                .setText(R.id.card_date, comicItem.getTime());
        Glide.with(mContext)
                .load(comicItem.getThumbnailList().get(0))
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into((ImageView) helper.getView(R.id.card_img));
    }
}
