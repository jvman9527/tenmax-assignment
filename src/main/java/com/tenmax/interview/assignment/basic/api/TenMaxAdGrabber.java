package com.tenmax.interview.assignment.basic.api;

import com.tenmax.interview.assignment.basic.domain.Ad;

/**
 * TenMax 廣告擷取器，嘗試抓取的結果可能為空
 */
public interface TenMaxAdGrabber {

    /**
     * 抓取廣告
     */
    Ad grab();

    /**
     * 盡可能的成功抓取廣告
     */
    Ad grabHard();

}
