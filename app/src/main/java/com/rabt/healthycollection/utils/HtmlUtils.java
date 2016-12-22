package com.rabt.healthycollection.utils;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/**
 * @author zjm
 * @Description:
 * @date 2016/12/22
 */

public class HtmlUtils {

    public static void setText(TextView view, String text) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        } else {
            view.setText(Html.fromHtml(text));
        }
    }
}
