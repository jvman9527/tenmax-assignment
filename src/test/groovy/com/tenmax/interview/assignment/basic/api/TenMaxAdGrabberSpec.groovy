package com.tenmax.interview.assignment.basic.api

import com.tenmax.interview.assignment.basic.domain.Ad
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import spock.lang.Shared
import spock.lang.Specification

class TenMaxAdGrabberSpec extends Specification {

    @Shared
    String tenmaxApiEndpoint = "https://tenmax-mock-dsp.azurewebsites.net/api/getAds?code=s9Ybtsb6hwigndO6a5OwsLmXOPR0olrW7nBFFE7QmHfvaQ6p9GWXwg=="

    @Shared
    TenMaxAdGrabber tenMaxAdGrabber

    def setupSpec() {
        def converter = new MappingJackson2HttpMessageConverter()
        converter.setSupportedMediaTypes([MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN])
        def restTemplate = new RestTemplate([converter])
        tenMaxAdGrabber = new RestTemplateTenMaxAdGrabber(tenmaxApiEndpoint, restTemplate)
    }

    def "TenMax 廣告回傳內容各欄位不為空值"() {
        when:
        Ad ad = tenMaxAdGrabber.grabHard()

        then:
        ad.title
        ad.description
        ad.imageUrl
        ad.iconUrl
        ad.clickUrl
    }

    /**
     * 人品測試，一百次呼叫內總有一次會中吧 XD
     */
    def "TenMax 廣告可能會有空的回傳"() {
        expect:
        (1..100).any { tenMaxAdGrabber.grab() == null }
    }

}

