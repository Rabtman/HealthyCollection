package com.rabt.healthycollection.ui.drug.adpater;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.utils.StringUtils;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: 药品搜索列表项适配器
 */

public class DrugSearchResultAdapter extends BaseQuickAdapter<DrugInfoPage.DrugInfo, BaseViewHolder> {

    public DrugSearchResultAdapter() {
        super(R.layout.drugsearch_item, null);
    }

    public DrugSearchResultAdapter(List<DrugInfoPage.DrugInfo> data) {
        super(R.layout.drugsearch_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, DrugInfoPage.DrugInfo content) {

        helper.setText(R.id.card_name, content.getDrugName())
                .setText(R.id.card_type, String.format(mContext.getString(R.string.format_drug_type), content.getType()))
                .setText(R.id.card_use, content.getSyz())
                .setText(R.id.card_company, content.getManu());
        //没有图片地址则不显示图片
        if (StringUtils.isEmpty(content.getImg())) {
            helper.setVisible(R.id.card_img, false);
        } else {
            helper.setVisible(R.id.card_img, true);
            Glide.with(mContext)
                    .load(content.getImg())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .crossFade()
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            //Logger.d(content.getDrugName() + "-onException:" + isFirstResource +"|model:" + model);
                            //图片加载失败则不显示图片
                            helper.setVisible(R.id.card_img, false);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            //Logger.d(content.getDrugName() + "-onResourceReady:" + isFirstResource +"|model:" + model);
                            return false;
                        }
                    })
                    .into((ImageView) helper.getView(R.id.card_img));
        }
    }
}
