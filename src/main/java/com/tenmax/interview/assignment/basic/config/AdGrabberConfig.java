package com.tenmax.interview.assignment.basic.config;

import com.tenmax.interview.assignment.basic.api.RestTemplateTenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableScheduling
public class AdGrabberConfig {

    @Bean
    public RestTemplate restTemplate() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
        return new RestTemplate(Collections.singletonList(converter));
    }

    @Bean
    public TenMaxAdGrabber tenMaxAdGrabber(@Value("${tenmax.api.endpoint}") String tenmaxApiEndpoint, RestTemplate restTemplate) {
        return new RestTemplateTenMaxAdGrabber(tenmaxApiEndpoint, restTemplate);
    }

}
