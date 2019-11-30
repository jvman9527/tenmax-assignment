package com.tenmax.interview.assignment.advanced.api;

import com.tenmax.interview.assignment.basic.api.AbstractTenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

/**
 * 競賽版廣告擷取器，代理 Ｎ 個廣告擷取器
 * 利用 CompletableFuture 並發擷取請求，取得最先回應的一個
 * 預設五秒超時，返回空的結果
 */
public class RacingTenMaxAdGrabber extends AbstractTenMaxAdGrabber {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5;

    private TenMaxAdGrabber[] tenMaxAdGrabber;

    public RacingTenMaxAdGrabber(TenMaxAdGrabber... tenMaxAdGrabber) {
        this.tenMaxAdGrabber = tenMaxAdGrabber;
    }

    public Map requestTenMaxAd(int retry) {
        CompletableFuture[] racers = Stream.of(tenMaxAdGrabber)
                .map(grabber -> CompletableFuture.supplyAsync(() -> grabber.requestTenMaxAd(retry)))
                .toArray(CompletableFuture[]::new);

        try {
            return (Map) CompletableFuture.anyOf(racers).get(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            return null;

        } finally {
            for (CompletableFuture future : racers) {
                if (!future.isDone()) {
                    future.cancel(true);
                }
            }
        }
    }

}

