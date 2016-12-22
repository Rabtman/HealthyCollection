package com.rabt.healthycollection.ui.health;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.ui.health.presenter.HealthNewsDetailPresenter;
import com.rabt.healthycollection.ui.health.view.HealthNewsDetailView;
import com.rabt.healthycollection.utils.SnackbarUtil;
import com.rabt.healthycollection.utils.TimeUtil;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-16
 * description: 健康资讯详情
 */

public class HealthNewsDetailActivity extends BaseActivity<HealthNewsDetailPresenter> implements HealthNewsDetailView {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.detial_title)
    TextView detialTitle;
    @BindView(R.id.detial_date)
    TextView detialDate;
    @BindView(R.id.detial_description)
    TextView detialDescription;
    @BindView(R.id.detial_content)
    TextView detialContent;


    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_healthnews_detail;
    }

    @Override
    protected void initData() {
        setToolBar(mToolBar, "");
        showProgress();
        mPresenter.getHealthNewsDetail(getIntent().getIntExtra(HealthConstants.HEALTHNEWS_ID, -1));
    }

    @Override
    public void showError(String msg) {
        stopProgress();
        SnackbarUtil.showShort(detialContent, msg);
    }

    @Override
    public void showHealthNewsDetail(HealthNewsDetail healthNewsDetail) {
        stopProgress();
        detialDate.setText(TimeUtil.millis2String(healthNewsDetail.getTime(), "yyyy-MM-dd"));
        detialDescription.setText(healthNewsDetail.getDescription());
        if (Build.VERSION.SDK_INT >= 24) {
            detialTitle.setText(Html.fromHtml(healthNewsDetail.getTitle(), Html.FROM_HTML_MODE_COMPACT));
            detialContent.setText(Html.fromHtml(healthNewsDetail.getMessage(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            detialTitle.setText(Html.fromHtml(healthNewsDetail.getTitle()));
            detialContent.setText(Html.fromHtml(healthNewsDetail.getMessage()));
        }
    }
}
