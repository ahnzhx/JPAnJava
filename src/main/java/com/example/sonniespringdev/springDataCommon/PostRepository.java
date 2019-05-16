package com.example.sonniespringdev.springDataCommon;

import com.example.sonniespringdev.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository extends YourRepository<Post, Long>, PostCustomRepository<Post> {
    Page<Post> findByTitleContains(String title, Pageable pageable);
}
