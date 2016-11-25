package com.rabt.healthycollection.ui.health;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.ui.health.presenter.HealthNewsDetailPresenter;
import com.rabt.healthycollection.ui.health.view.HealthNewsDetailView;

import butterknife.BindView;

/**
 * @author zjm
 * @Description: 健康资讯详情
 * @date 2016/11/14
 */

public class HealthNewsDetailActivity extends BaseActivity<HealthNewsDetailPresenter> implements HealthNewsDetailView {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.main_date)
    TextView mainDate;
    @BindView(R.id.main_author)
    TextView mainAuthor;
    @BindView(R.id.main_content)
    TextView mainContent;


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
        mPresenter.getComicDetail(getIntent().getStringExtra(HealthConstants.HEALTHNEWS_ID));
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showComicDetail(HealthNewsDetail.Info healthNewsDetail) {
        mainDate.setText(healthNewsDetail.getTime());
        mainAuthor.setText(healthNewsDetail.getAuthor());
        if (Build.VERSION.SDK_INT >= 24) {
            mainTitle.setText(Html.fromHtml(healthNewsDetail.getTitle(), Html.FROM_HTML_MODE_COMPACT));
            mainContent.setText(Html.fromHtml(healthNewsDetail.getContent(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            mainTitle.setText(Html.fromHtml(healthNewsDetail.getTitle()));
            mainContent.setText(Html.fromHtml(healthNewsDetail.getContent()));
        }
    }
}
