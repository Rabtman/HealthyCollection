package com.rabt.healthycollection.ui.bwcomic.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.BWComicPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public interface BWComicView extends BaseView {
    void showContent(List<BWComicPage.Page.ComicItem> items);

    void showMoreContent(List<BWComicPage.Page.ComicItem> items, boolean hasMore);
}
