package com.tenmax.interview.assignment.basic.api;

import com.tenmax.interview.assignment.basic.domain.Ad;
import com.tenmax.interview.assignment.basic.domain.Image;
import com.tenmax.interview.assignment.basic.domain.Link;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tenmax.interview.assignment.basic.util.MapUtils.*;

/**
 * 利用 Spring RestTemplate 實作的 TenMax 廣告擷取器
 */
public class RestTemplateTenMaxAdGrabber implements TenMaxAdGrabber {

    private static final int MAX_REQUEST_RETRY_COUNT = 100;

    private final String endpoint;

    private RestTemplate restTemplate;

    public RestTemplateTenMaxAdGrabber(String endpoint, RestTemplate restTemplate) {
        this.endpoint = endpoint;
        this.restTemplate = restTemplate;
    }

    /**
     * 對廣告擷取API發出請求，並回傳內容主體
     * @param retry 請求重試次數
     */
    public Map requestTenMaxAd(int retry) {
        while (retry > 0) {
            Map responseBody = restTemplate.getForObject(endpoint, Map.class);
            if (responseBody == null || responseBody.isEmpty()) {
                retry--;
            } else {
                return responseBody;
            }
        }

        return null;
    }

    /**
     * 將廣告圖片內容轉成 Image 物件實例的工具方法
     */
    private Image toImage(Map img) {
        String url = (String) img.get("url");
        Integer w = (Integer) img.get("w");
        Integer h = (Integer) img.get("h");
        return new Image(url, w, h);
    }

    /**
     * 嘗試抓取廣告 N 次，可能回傳空的內容
     */
    public Ad grab(int retry) {
        Map responseBody = requestTenMaxAd(retry);

        if (responseBody == null) {
            return null;
        }

        List<Map> assets = (List) recursivelyGet(responseBody, "native.assets");
        Map<String, Map> assetsMap = assets.stream().collect(Collectors.toMap(
            (Map asset) -> (String) asset.get("type"),
            (Map asset) -> asset
        ));

        String title = (String) recursivelyGet(assetsMap, "title.data.value");
        String description = (String) recursivelyGet(assetsMap, "description.data.value");
        Image imageUrl = toImage((Map) recursivelyGet(assetsMap, "imageUrl.img"));
        Image iconUrl = toImage((Map) recursivelyGet(assetsMap, "iconUrl.img"));
        Link clickUrl = new Link((String) recursivelyGet(assetsMap, "clickUrl.link.url"));
        List<String> impressionLink = (List) recursivelyGet(responseBody, "native.impressionLink");
        return new Ad(title, description, imageUrl, iconUrl, clickUrl, impressionLink);
    }

    /**
     * 嘗試抓取廣告一次，可能回傳空的內容
     */
    public Ad grab() {
        return grab(1);
    }

    /**
     * 盡可能的成功抓取廣告，最多嘗試一百次，可能回傳空的內容，若不是 API 出錯，就是你的人品出錯 XD
     */
    public Ad grabHard() {
        return grab(MAX_REQUEST_RETRY_COUNT);
    }

}

