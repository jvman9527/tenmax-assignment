package com.tenmax.interview.assignment.advanced.config;

import com.tenmax.interview.assignment.advanced.api.GoofAroundMockTenMaxAd;
import com.tenmax.interview.assignment.advanced.api.RandomMockTenMaxAd;
import com.tenmax.interview.assignment.advanced.api.RepositoryMockTenMaxAd;
import com.tenmax.interview.assignment.advanced.api.ThiefMockTenMaxAd;
import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.repository.AdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class MockTenMaxAdConfig {

//    @Bean
//    public ThiefMockTenMaxAd thiefMockTenMaxAd(TenMaxAdGrabber tenMaxAdGrabber) {
//        return new ThiefMockTenMaxAd(tenMaxAdGrabber);
//    }

    @Bean
    public RepositoryMockTenMaxAd repositoryMockTenMaxAd(AdRepository adRepository) {
        return new RepositoryMockTenMaxAd(adRepository);
    }

    @Bean
    public GoofAroundMockTenMaxAd goofAroundMockTenMaxAd() {
        return new GoofAroundMockTenMaxAd();
    }

    @Bean
    public RandomMockTenMaxAd mockTenMaxAd(RepositoryMockTenMaxAd repositoryMockTenMaxAd, GoofAroundMockTenMaxAd goofAroundMockTenMaxAd) {
        return new RandomMockTenMaxAd(repositoryMockTenMaxAd, goofAroundMockTenMaxAd);
    }

}

