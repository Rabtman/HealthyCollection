package com.rabt.healthycollection.ui.hospital;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.utils.StringUtils;
import com.rabt.healthycollection.utils.ToastUtil;

import butterknife.BindView;

/**
 * @author zjm
 * @Description: 医院详情页面
 * @date 2016/12/2
 */

public class HospitalInfoDetailActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hospital_detail_img)
    ImageView hospitalDetailImg;

    private HospitalPage.HospitalInfo hospitalInfo;

    @Override
    protected int getLayout() {
        return R.layout.activity_hospital_detail;
    }

    @Override
    protected void initData() {
        hospitalInfo = getIntent().getParcelableExtra(HealthConstants.HOSPITAL_INFO);
        if (hospitalInfo == null) {
            ToastUtil.shortShow(getString(R.string.msg_load_err));
            return;
        }
        setToolBar(toolbar, hospitalInfo.getHosName());
        showHospitalPicture();

    }

    private String checkText(String text) {
        return text.equals("") ? "尚不明确。" : text;
    }

    private void showHospitalPicture() {
        //没有图片地址则不显示图片
        if (StringUtils.isEmpty(hospitalInfo.getImg())) {
            hospitalDetailImg.setVisibility(View.GONE);
        } else {
            hospitalDetailImg.setVisibility(View.VISIBLE);
            Glide.with(mContext)
                    .load(hospitalInfo.getImg())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .crossFade()
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            //图片加载失败则不显示图片
                            hospitalDetailImg.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(hospitalDetailImg);
        }
    }
}
