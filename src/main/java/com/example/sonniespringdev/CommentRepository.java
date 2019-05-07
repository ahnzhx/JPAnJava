package com.example.sonniespringdev;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {
    Comment save(Comment comment);
    List<Comment> findAll();

    //코멘트에 키워드가 있는 것들을 모두 검색
    @Query(value = "select c from Comment as c", nativeQuery = true)
    List<Comment> findByTitleContains(String keyword);

    //like가 몇개 이상인 코멘트들만 불러올 때
    //어떤 글에 like가 몇개 이상인 것들
    Page<Comment> findByLikeCountGreaterThanAndPost (int likeCount, Post post, Pageable pageable);


}
