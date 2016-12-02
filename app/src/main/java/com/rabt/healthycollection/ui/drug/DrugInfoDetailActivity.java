package com.rabt.healthycollection.ui.drug;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.utils.StringUtils;
import com.rabt.healthycollection.utils.ToastUtil;

import butterknife.BindView;

/**
 * @author zjm
 * @Description: 药品详情页面
 * @date 2016/12/2
 */

public class DrugInfoDetailActivity extends SimpleActivity {

    @BindView(R.id.drug_detail_name)
    TextView drugDetailName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drug_detail_img)
    ImageView drugDetailImg;

    private DrugInfoPage.DrugInfo drugInfo;

    @Override
    protected int getLayout() {
        return R.layout.activity_drug_detail;
    }

    @Override
    protected void initData() {
        drugInfo = getIntent().getParcelableExtra(HealthConstants.DRUG_INFO);
        if (drugInfo == null) {
            ToastUtil.shortShow(getString(R.string.msg_load_err));
            return;
        }
        setToolBar(toolbar, drugInfo.getDrugName());
        drugDetailName.setText(String.format(getString(R.string.format_detail_drug_name), drugInfo.getDrugName()));
        showDrugPicture();
    }

    private void showDrugPicture() {
        //没有图片地址则不显示图片
        if (StringUtils.isEmpty(drugInfo.getImg())) {
            drugDetailImg.setVisibility(View.GONE);
        } else {
            drugDetailImg.setVisibility(View.VISIBLE);
            Glide.with(mContext)
                    .load(drugInfo.getImg())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .crossFade()
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            //图片加载失败则不显示图片
                            drugDetailImg.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(drugDetailImg);
        }
    }
}
