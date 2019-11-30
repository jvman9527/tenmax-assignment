package com.tenmax.interview.assignment.basic.api;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 利用 Spring RestTemplate 實作的 TenMax 廣告擷取器
 */
public class RestTemplateTenMaxAdGrabber extends AbstractTenMaxAdGrabber {

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

}

