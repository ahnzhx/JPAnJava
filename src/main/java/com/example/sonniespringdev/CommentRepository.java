package com.example.sonniespringdev;

import java.util.List;
import java.util.Optional;

import com.example.sonniespringdev.springDataCommon.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {
    // 아래 둘은 JpaRepository에 기본값으로 설정되어 있는 듯??!
	Comment save(Comment comment);
    List<Comment> findAll();

    //코멘트에 키워드가 있는 것들을 모두 검색
    @Query(value = "select c from Comment as c", nativeQuery = true)
    List<Comment> findByTitleContains( String keyword);

    //like가 몇개 이상인 코멘트들만 불러올 때
    //어떤 글에 like가 몇개 이상인 것들
    Page<Comment> findByLikeCountGreaterThanAndPost (int likeCount, Post post, Pageable pageable);

    //List<Comment> findByCommentContainsIgnoreCase(String keyword);
    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);
    //Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

    //여러 자료형을 활용할 수 있도록 Generic 타입을 쓴다
    <T> List<T> findByPost_Id(long id, Class<T> type);
}
