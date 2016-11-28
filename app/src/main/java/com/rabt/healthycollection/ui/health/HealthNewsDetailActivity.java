package com.rabt.healthycollection.ui.health;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.ui.health.presenter.HealthNewsDetailPresenter;
import com.rabt.healthycollection.ui.health.view.HealthNewsDetailView;
import com.rabt.healthycollection.utils.SnackbarUtil;

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
    @BindView(R.id.detial_author)
    TextView detialAuthor;
    @BindView(R.id.detial_content)
    TextView detialContent;
    @BindView(R.id.detial_decoration_line)
    ImageView detialLine;


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
        StatusBarUtil.setColor(mContext, ContextCompat.getColor(mContext, R.color.colorPrimary));
        setToolBar(mToolBar, "");
        showProgress();
        mPresenter.getComicDetail(getIntent().getStringExtra(HealthConstants.HEALTHNEWS_ID));
    }

    @Override
    public void showError(String msg) {
        stopProgress();
        SnackbarUtil.showShort(detialContent, msg);
    }

    @Override
    public void showComicDetail(HealthNewsDetail.Info healthNewsDetail) {
        stopProgress();
        detialDate.setText(healthNewsDetail.getTime());
        detialAuthor.setText(healthNewsDetail.getAuthor());
        detialLine.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= 24) {
            detialTitle.setText(Html.fromHtml(healthNewsDetail.getTitle(), Html.FROM_HTML_MODE_COMPACT));
            detialContent.setText(Html.fromHtml(healthNewsDetail.getContent(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            detialTitle.setText(Html.fromHtml(healthNewsDetail.getTitle()));
            detialContent.setText(Html.fromHtml(healthNewsDetail.getContent()));
        }
    }
}
