package com.example.sonniespringdev.springDataCommon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends YourRepository<Post, Long>
        , QuerydslPredicateExecutor<Post>{
    Page<Post> findByTitleContains(String title, Pageable pageable);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Post p Set p.title = ?1 where p.id = ?2")
    int updateTitle(String title, Long id);

    List<Post> findByTitleStartsWith(String title);

    @Query("select p from #{#entityName} as p where p.title = :title")
    List<Post> findByTitle(@Param("title") String keyword) ;

}
