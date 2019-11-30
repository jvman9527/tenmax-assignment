package com.tenmax.interview.assignment.advanced.schedule;

import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.domain.Ad;
import com.tenmax.interview.assignment.basic.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *  競賽版 TenMax 廣告擷取排程器，每分鐘 0 秒時觸發，擷取內容不為空白時存入資料庫
 */
@Component
public class RacingAdGrabbingScheduler {

    @Autowired
    private TenMaxAdGrabber racingTenMaxAdGrabber;

    @Autowired
    private AdRepository adRepository;

    @Scheduled(cron = "0 * * * * *")
    public void grab() {
        Ad ad = racingTenMaxAdGrabber.grab();
        if (ad != null) {
            adRepository.save(ad);
        }
    }

}

