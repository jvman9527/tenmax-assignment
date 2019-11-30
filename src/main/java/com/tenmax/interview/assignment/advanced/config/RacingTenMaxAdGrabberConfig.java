package com.tenmax.interview.assignment.advanced.config;

import com.tenmax.interview.assignment.advanced.api.RacingTenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.api.RestTemplateTenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RacingTenMaxAdGrabberConfig {

    /**
     * Mock Server API 廣告擷取器
     * @param endpoint
     * @param restTemplate
     * @return
     */
    @Bean
    public TenMaxAdGrabber localMockAdGrabber(@Value("${mock.api.endpoint}") String endpoint, RestTemplate restTemplate) {
        return new RestTemplateTenMaxAdGrabber(endpoint, restTemplate);
    }

    @Bean
    public TenMaxAdGrabber racingTenMaxAdGrabber(TenMaxAdGrabber tenMaxAdGrabber, TenMaxAdGrabber localMockAdGrabber) {
        return new RacingTenMaxAdGrabber(tenMaxAdGrabber, localMockAdGrabber);
    }

}

