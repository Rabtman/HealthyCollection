package com.rabt.healthycollection.ui.hospital.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.utils.StringUtils;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: 医院搜索列表项适配器
 */

public class HospitalSearchResultAdapter extends BaseQuickAdapter<HospitalPage.HospitalInfo, BaseViewHolder> {

    public HospitalSearchResultAdapter() {
        super(R.layout.hospitalsearch_item, null);
    }

    public HospitalSearchResultAdapter(List<HospitalPage.HospitalInfo> data) {
        super(R.layout.hospitalsearch_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, HospitalPage.HospitalInfo content) {

        helper.setText(R.id.card_name, content.getHosName())
                .setText(R.id.card_tsks, String.format(mContext.getString(R.string.format_hospital_tsks), content.getTsks()));
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
                            //图片加载失败则不显示图片
                            helper.setVisible(R.id.card_img, false);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into((ImageView) helper.getView(R.id.card_img));
        }
    }
}
