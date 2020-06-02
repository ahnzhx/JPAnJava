package com.example.sonniespringdev;

import com.example.sonniespringdev.querydsl.PersonalInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonalInfoRepositoryTest {

    @Autowired
    PersonalInfoRepository personalInfoRepository;

    /**
     * Querydsl을 이용해 select문 만들기
     */
    @Test
    public void crud(){
        /*Predicate predicate = QPersonalInfo.personalInfo
                .firstName.containsIgnoreCase("keesun")
                .and(QPersonalInfo.personalInfo.lastName.startsWith("baik"));

        final Optional<PersonalInfo> one = personalInfoRepository.findOne(predicate);
        assertThat(one).isEmpty();*/
    }

}