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

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drug_detail_img)
    ImageView drugDetailImg;
    @BindView(R.id.drug_ggxh)
    TextView drugGgxh;
    @BindView(R.id.drug_pzwh)
    TextView drugPzwh;
    @BindView(R.id.drug_zycf)
    TextView drugZycf;
    @BindView(R.id.drug_xz)
    TextView drugXz;
    @BindView(R.id.drug_zzjb)
    TextView drugZzjb;
    @BindView(R.id.drug_syz)
    TextView drugSyz;
    @BindView(R.id.drug_yfyl)
    TextView drugYfyl;
    @BindView(R.id.drug_manu)
    TextView drugManu;
    @BindView(R.id.drug_blfy)
    TextView drugBlfy;
    @BindView(R.id.drug_jj)
    TextView drugJj;
    @BindView(R.id.drug_zysx)
    TextView drugZysx;
    @BindView(R.id.drug_ywxhzy)
    TextView drugYwxhzy;
    @BindView(R.id.drug_zc)
    TextView drugZc;
    @BindView(R.id.drug_yxq)
    TextView drugYxq;

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
        showDrugPicture();
        drugGgxh.setText(String.format(getString(R.string.format_drug_ggxh), checkText(drugInfo.getGgxh())));
        drugPzwh.setText(String.format(getString(R.string.format_drug_pzwh), checkText(drugInfo.getPzwh())));
        drugZycf.setText(String.format(getString(R.string.format_drug_zycf), checkText(drugInfo.getZycf())));
        drugXz.setText(String.format(getString(R.string.format_drug_xz), checkText(drugInfo.getXz())));
        drugZzjb.setText(String.format(getString(R.string.format_drug_zzjb), checkText(drugInfo.getZzjb())));
        drugSyz.setText(String.format(getString(R.string.format_drug_syz), checkText(drugInfo.getSyz())));
        drugYfyl.setText(String.format(getString(R.string.format_drug_yfyl), checkText(drugInfo.getYfyl())));
        drugManu.setText(String.format(getString(R.string.format_drug_manu), checkText(drugInfo.getManu())));
        drugBlfy.setText(String.format(getString(R.string.format_drug_blfy), checkText(drugInfo.getBlfy())));
        drugJj.setText(String.format(getString(R.string.format_drug_jj), checkText(drugInfo.getJj())));
        drugZysx.setText(String.format(getString(R.string.format_drug_zysx), checkText(drugInfo.getZysx())));
        drugYwxhzy.setText(String.format(getString(R.string.format_drug_ywxhzy), checkText(drugInfo.getYwxhzy())));
        drugZc.setText(String.format(getString(R.string.format_drug_zc), checkText(drugInfo.getZc())));
        drugYxq.setText(String.format(getString(R.string.format_drug_yxq), checkText(drugInfo.getYxq())));
    }

    private String checkText(String text) {
        return text.equals("") ? "尚不明确。" : text;
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
