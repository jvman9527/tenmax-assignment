package com.tenmax.interview.assignment.advanced.api;

import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;

import java.util.Map;

/**
 * TenMax 模擬廣告盜接版
 * 偷接 TenMax 廣告API直到成功後直接回傳
 */
public class ThiefMockTenMaxAd implements MockTenMaxAd {

    private static final int DEFAULT_RETRY_COUNT = 10;

    private TenMaxAdGrabber tenMaxAdGrabber;

    public ThiefMockTenMaxAd(TenMaxAdGrabber tenMaxAdGrabber) {
        this.tenMaxAdGrabber = tenMaxAdGrabber;
    }

    @Override
    public Map response() {
        return tenMaxAdGrabber.requestTenMaxAd(DEFAULT_RETRY_COUNT);
    }

}

