package com.rabt.healthycollection.ui.drug;

import android.content.Intent;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleFragment;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.utils.KeyboardUtils;
import com.rabt.healthycollection.utils.StringUtils;
import com.rabt.healthycollection.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: Rabtman
 * date: 2016-11-30 药品搜索
 * description:
 */

public class DrugMainFragment extends SimpleFragment {


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
        //监听输入框变化
        drugKeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //控制清除按钮的状态
                if (!StringUtils.isEmpty(s.toString())) {
                    drugClose.setVisibility(View.VISIBLE);
                } else {
                    drugClose.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @OnClick(R.id.drug_search)
    void search() {
        if (StringUtils.isEmpty(drugKeyword.getText().toString())) {
            ToastUtil.shortShow(getString(R.string.msg_search_keyword_null));
            return;
        }
        KeyboardUtils.hideSoftInput(getActivity());
        Intent intent = new Intent(getContext(), DrugSearchResultActivity.class);
        intent.putExtra(HealthConstants.DRUG_KEYWORD, drugKeyword.getText().toString());
        startActivity(intent);
    }

    @OnClick(R.id.drug_close)
    void clear() {
        drugKeyword.setText("");
    }
}
