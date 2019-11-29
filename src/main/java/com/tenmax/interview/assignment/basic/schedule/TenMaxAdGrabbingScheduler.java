package com.tenmax.interview.assignment.basic.schedule;

import com.tenmax.interview.assignment.basic.api.TenMaxAdGrabber;
import com.tenmax.interview.assignment.basic.domain.Ad;
import com.tenmax.interview.assignment.basic.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *  TenMax 廣告擷取排程器，每分鐘 0 秒時觸發，擷取內容不為空白時存入資料庫
 */
@Service
public class TenMaxAdGrabbingScheduler {

    @Autowired
    private TenMaxAdGrabber tenMaxAdGrabber;

    @Autowired
    private AdRepository adRepository;

    @Scheduled(cron = "0 * * * * *")
    public void grab() {
        Ad ad = tenMaxAdGrabber.grabHard();
        if (ad != null) {
            adRepository.save(ad);
        }
    }

}

