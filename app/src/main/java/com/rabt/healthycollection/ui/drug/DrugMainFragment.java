package com.rabt.healthycollection.ui.drug;

import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ImageView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleFragment;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-30 药品搜索
 * description:
 */

public class DrugMainFragment extends SimpleFragment {


    @BindView(R.id.drug_category)
    AppCompatSpinner drugCategory;
    @BindView(R.id.drug_search)
    AppCompatImageButton drugSearch;
    @BindView(R.id.drug_line)
    ImageView drugLine;
    @BindView(R.id.drug_close)
    AppCompatImageButton drugClose;
    @BindView(R.id.drug_keyword)
    AppCompatEditText drugKeyword;

    @Override
    protected int getLayout() {
        return R.layout.fragment_drug_main;
    }

    @Override
    protected void initData() {

    }
}
