package com.rabt.healthycollection.ui.hospital;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jaeger.library.StatusBarUtil;
import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.presenter.HospitalInfoDetailPresenter;
import com.rabt.healthycollection.ui.hospital.view.HospitalInfoDetailView;
import com.rabt.healthycollection.utils.HtmlUtils;
import com.rabt.healthycollection.utils.SnackbarUtil;
import com.rabt.healthycollection.utils.StringUtils;

import butterknife.BindView;

/**
 * @author zjm
 * @Description: 医院详情页面
 * @date 2016/12/2
 */

public class HospitalInfoDetailActivity extends BaseActivity<HospitalInfoDetailPresenter> implements HospitalInfoDetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hospital_detail_img)
    ImageView hospitalDetailImg;
    @BindView(R.id.hospital_detail_msg)
    TextView hospitalDetailMsg;
    @BindView(R.id.hospital_detail_phone)
    TextView hospitalDetailPhone;
    @BindView(R.id.hospital_detail_location)
    TextView hospitalDetailLocation;


    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_hospital_detail;
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
    }

    @Override
    protected void initData() {
        showProgress();
        int hospitalId = getIntent().getIntExtra(HealthConstants.HOSPITAL_ID, -1);
        if (hospitalId == -1) {
            HospitalPage.HospitalInfo info = getIntent().getParcelableExtra(HealthConstants.HOSPITAL_INFO);
            if (info == null) return;
            showContent(info);
        } else {
            mPresenter.showHospitalInfoDetail(hospitalId);
        }
    }

    private void showHospitalPicture(String imgUrl) {
        //没有图片地址则不显示图片
        if (StringUtils.isEmpty(imgUrl)) {
            hospitalDetailImg.setVisibility(View.GONE);
        } else {
            hospitalDetailImg.setVisibility(View.VISIBLE);
            Glide.with(mContext)
                    .load(imgUrl)
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

    @Override
    public void showContent(HospitalPage.HospitalInfo detail) {
        stopProgress();
        setToolBar(toolbar, detail.getName());
        hospitalDetailPhone.setText(detail.getTel().replaceAll(",", "\n"));
        hospitalDetailLocation.setText(detail.getAddress());
        HtmlUtils.setText(hospitalDetailMsg, detail.getMessage());
        showHospitalPicture(BuildConfig.TN_IMG_URL + detail.getImg());
    }

    @Override
    public void showError(String msg) {
        stopProgress();
        SnackbarUtil.showShort(toolbar, msg);
    }
}
