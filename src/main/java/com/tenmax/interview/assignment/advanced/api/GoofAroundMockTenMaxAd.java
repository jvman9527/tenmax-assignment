package com.tenmax.interview.assignment.advanced.api;

import java.util.Collections;
import java.util.Map;

/**
 * TenMax 模擬廣告摸魚版
 * 先打混一個固定時間，然後回傳個空洞的結果
 */
public class GoofAroundMockTenMaxAd implements MockTenMaxAd {

    public static final int DEFAULT_GOOF_AROUND_SECONDS = 10;

    private int goofAroundSeconds;

    public GoofAroundMockTenMaxAd() {
        this(DEFAULT_GOOF_AROUND_SECONDS);
    }

    public GoofAroundMockTenMaxAd(int goofAroundSeconds) {
        this.goofAroundSeconds = goofAroundSeconds;
    }

    @Override
    public Map response() {
        try {
            Thread.sleep(goofAroundSeconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return Collections.EMPTY_MAP;
    }

}

