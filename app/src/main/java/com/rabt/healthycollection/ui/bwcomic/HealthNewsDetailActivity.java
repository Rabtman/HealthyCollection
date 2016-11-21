package com.rabt.healthycollection.ui.bwcomic;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.ui.bwcomic.presenter.HealthNewsDetailPresenter;
import com.rabt.healthycollection.ui.bwcomic.view.HealthNewsDetailView;

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
        mainTitle.setText(healthNewsDetail.getTitle());
        mainDate.setText(healthNewsDetail.getTime());
        mainAuthor.setText(healthNewsDetail.getAuthor());
        mainContent.setText(healthNewsDetail.getContent());
    }
}
