package com.example.sonniespringdev.springDataCommon;

import com.example.sonniespringdev.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post> {
    Page<Post> findByTitleContains(String title, Pageable pageable);
}
