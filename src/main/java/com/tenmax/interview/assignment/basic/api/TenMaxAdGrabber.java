package com.tenmax.interview.assignment.basic.api;

import com.tenmax.interview.assignment.basic.domain.Ad;

import java.util.Map;

/**
 * TenMax 廣告擷取器，嘗試抓取的結果可能為空
 */
public interface TenMaxAdGrabber {

    /**
     * 取得原始廣告請求回應內容，並設定重試次數
     */
    Map requestTenMaxAd(int retry);

    /**
     * 抓取廣告
     */
    Ad grab();

    /**
     * 抓取廣告，並設定重試次數
     */
    Ad grab(int retry);

    /**
     * 盡可能的成功抓取廣告
     */
    Ad grabHard();

}
