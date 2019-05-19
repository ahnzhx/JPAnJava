package com.example.sonniespringdev.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long>
        , QuerydslPredicateExecutor<PersonalInfo> {
}
