package com.tenmax.interview.assignment.basic.repository

import com.tenmax.interview.assignment.basic.domain.Ad
import com.tenmax.interview.assignment.basic.domain.Image
import com.tenmax.interview.assignment.basic.domain.Link
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class AdRepositorySpec extends Specification {

    @Autowired
    AdRepository adRepository

    Ad ad = new Ad(
        "ad title",
        "ad description",
        new Image("//tenmax/interview/img/a.png", 1,1),
        new Image("//tenmax/interview/icon/b.png", 1, 1),
        new Link("https://tenmax.io/click/me")
    )

    def "save ad correctly"() {
        when:
        adRepository.save(ad)

        then:
        assert ad.id instanceof Long
    }

}

