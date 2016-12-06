package com.rabt.healthycollection.ui.drug;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.DrugInfoDetail;
import com.rabt.healthycollection.ui.drug.presenter.DrugInfoDetailPresenter;
import com.rabt.healthycollection.ui.drug.view.DrugInfoDetailView;
import com.rabt.healthycollection.utils.SnackbarUtil;

import butterknife.BindView;

/**
 * @author zjm
 * @Description: 药品详情页面
 * @date 2016/12/2
 */

public class DrugInfoDetailActivity extends BaseActivity<DrugInfoDetailPresenter> implements DrugInfoDetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drug_detail_img)
    ImageView drugDetailImg;
    @BindView(R.id.drug_detail_msg)
    TextView drugDetailMsg;

    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_drug_detail;
    }

    @Override
    protected void initData() {
        setToolBar(toolbar, "");
        //showDrugPicture();
        showProgress();
        mPresenter.showDrugInfoDetail(getIntent().getIntExtra(HealthConstants.DRUG_ID, -1));
    }

    /*private void showDrugPicture(String img) {
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
    }*/

    @Override
    public void showError(String msg) {
        stopProgress();
        SnackbarUtil.showShort(drugDetailMsg, msg);
    }

    @Override
    public void showContent(DrugInfoDetail detail) {
        stopProgress();
        if (Build.VERSION.SDK_INT >= 24) {
            drugDetailMsg.setText(Html.fromHtml(detail.getMessage(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            drugDetailMsg.setText(Html.fromHtml(detail.getMessage()));
        }
    }
}
