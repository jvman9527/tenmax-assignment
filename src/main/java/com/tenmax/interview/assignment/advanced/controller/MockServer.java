package com.tenmax.interview.assignment.advanced.controller;

import com.tenmax.interview.assignment.advanced.api.MockTenMaxAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * TenMax 廣告 Mock Server
 */
@RestController
public class MockServer {

    @Autowired
    MockTenMaxAd mockTenMaxAd;

    @RequestMapping("/api/getAds")
    public Callable mock(@RequestParam(required = false) String code) {
        if (code == null) {
            throw new UnauthorizedException();
        }

        return () -> mockTenMaxAd.response();
    }

}

