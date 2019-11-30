package com.tenmax.interview.assignment.advanced.api;

import com.tenmax.interview.assignment.basic.domain.Ad;
import com.tenmax.interview.assignment.basic.domain.Image;
import com.tenmax.interview.assignment.basic.domain.Link;
import com.tenmax.interview.assignment.basic.repository.AdRepository;

import java.util.*;

/**
 * TenMax Mock Api
 */
public class RepositoryMockTenMaxAd implements MockTenMaxAd {

    private AdRepository adRepository;

    public RepositoryMockTenMaxAd(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public Map response() {
        return null;
    }

    public static Map toMockApiResult(Ad ad) {
        List<Map> assets = new ArrayList<>();
        assets.add(toData("description", ad.getDescription()));
        assets.add(toImg("imageUrl", ad.getImageUrl()));
        assets.add(toData("title", ad.getTitle()));
        assets.add(toImg("iconUrl", ad.getIconUrl()));
        assets.add(toLink("clickUrl", ad.getClickUrl()));

        Map<String, Object> nativeMap = new LinkedHashMap<>();
        nativeMap.put("assets", assets);
        nativeMap.put("impressionLink", ad.getImpressionLink());

        Map<String, Object> result = new HashMap<>();
        result.put("native", nativeMap);
        return result;
    }

    private static Map toImg(String type, Image img) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("type", type);
        data.put("img", img);
        return data;
    }

    private static Map toLink(String type, Link link) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("type", type);
        data.put("link", link);
        return data;
    }

    private static Map toData(String type, Object value) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> val = new HashMap<>();
        val.put("value", value);
        data.put("type", type);
        data.put("data", val);
        return data;
    }

}
