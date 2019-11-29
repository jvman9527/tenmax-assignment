package com.tenmax.interview.assignment.basic.repository

import com.tenmax.interview.assignment.basic.domain.Ad
import com.tenmax.interview.assignment.basic.domain.Image
import com.tenmax.interview.assignment.basic.domain.Link
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import spock.lang.Specification

@DataJpaTest
class AdRepositorySpec extends Specification {

    @Autowired
    AdRepository adRepository

    def "儲存一筆新的廣告資料後可以正確獲得對應的廣告代號"() {
        given: "一筆新的廣告資料"
        Ad ad = newAd("全新上架")

        when: "儲存至資料庫"
        adRepository.save(ad)

        then: "正確獲得這筆廣告的代號"
        assert ad.id instanceof Long
    }

    def "可以使用Title欄位撈出相關資料，需要支援模糊查詢"() {
        given:
        int dataNumber = 10
        List<Ad> adList = (1..dataNumber).collect { newAd("這是模糊查詢測試第${it}號廣告的抬頭欄位") }

        when:
        adRepository.saveAll(adList)
        Page<Ad> searchResult = adRepository.findByTitleContaining("模糊查詢測試", PageRequest.of(0, 100))

        then:
        searchResult.getTotalElements() == dataNumber
    }

    static Ad newAd(title) {
        new Ad(
            title,
            "${title} description",
            new Image("//tenmax/interview/img/${title}_img.png", 1,1),
            new Image("//tenmax/interview/icon/${title}_icon.png", 1, 1),
            new Link("https://tenmax.io/click/${title}"),
            ["https://tenmax.io/impression/link/${title}"]
        )
    }

}

