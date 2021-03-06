package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.PostRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("sonnie");
        account.setPassword("1234");

        Study study = new Study();
        study.setName("Spring data JPA");
        study.setOwner(account); // 주인이 study라서 반드시 set 해줘야 함

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        postRepository.findAll().forEach(System.out::println);
    }
}
