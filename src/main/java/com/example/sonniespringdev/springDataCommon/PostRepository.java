package com.example.sonniespringdev.springDataCommon;

import com.example.sonniespringdev.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends YourRepository<Post, Long>, PostCustomRepository<Post> {
    Page<Post> findByTitleContains(String title, Pageable pageable);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Post p Set p.title = ?1 where p.id = ?2")
    int updateTitle(String title, Long id);
}
