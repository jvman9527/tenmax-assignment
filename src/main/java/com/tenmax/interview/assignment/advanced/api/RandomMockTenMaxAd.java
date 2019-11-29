package com.tenmax.interview.assignment.advanced.api;

import java.util.Map;
import java.util.Random;

/**
 * TenMax 模擬廣告隨機版
 * 隨機代理其他種類的模擬廣告
 */
public class RandomMockTenMaxAd implements MockTenMaxAd {

    private Random random = new Random();

    private MockTenMaxAd[] mockTenMaxAds;

    public RandomMockTenMaxAd(MockTenMaxAd... mockTenMaxAds) {
        this.mockTenMaxAds = mockTenMaxAds;
    }

    @Override
    public Map response() {
        int idx = random.nextInt(mockTenMaxAds.length);
        return mockTenMaxAds[idx].response();
    }

}
