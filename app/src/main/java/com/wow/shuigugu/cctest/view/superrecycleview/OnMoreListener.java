package com.wow.shuigugu.cctest.view.superrecycleview;

/**
 * Created by cl on 2019/2/15.
 */
public interface OnMoreListener {
    /**
     * @param overallItemsCount
     * @param itemsBeforeMore
     * @param maxLastVisiblePosition for staggered grid this is max of all spans
     */
    void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition);
}
