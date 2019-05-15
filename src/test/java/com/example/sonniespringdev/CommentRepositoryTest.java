package com.example.sonniespringdev;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

<<<<<<< HEAD
import java.util.List;
import java.util.concurrent.ExecutionException;

=======
>>>>>>> 685fdeaf5d46ac8fd3116fe329745c085f287015
@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;
    
    /**
     * 내가 회사에서 시도한 코드 -> 에러남~
     */
    @Test
	public void testingCommentCrud() {
		Post post1 = new Post();
		post1.setLikeCount(4);
		post1.setTitle("i want a solider~~~~~~~");
		
	/*	Comment comment1 = new Comment();
		comment1.setPost(post1);
		comment1.setContent("i like destiny's child~~!!");
		
		post1.addComment(comment1);*/
		
		
		postRepository.save(post1);
		
		assertThat(post1.getLikeCount()).isEqualTo(4);
		//commentRepository.save(comment1);
		
	}
     
    @Test
    public void crud(){
        createComment("spring data jpa", 11);
        createComment("spring data jpa2", 8);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));


        //List<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("Spring");
         //Page<Comment> comments3 = commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);

         //assertThat(comments.size()).isEqualTo(2);
         //assertThat(comments3.getNumberOfElements()).isEqualTo(2);
         //assertThat(comments3).first().hasFieldOrPropertyWithValue("likeCount", 11);
    }

    @Test
    public void asyncJpaTest() throws ExecutionException, InterruptedException {
        createComment("sleep sonnie", 4);
        createComment("wanna lay down SONNIE", 8);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));
        ListenableFuture<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("sonnie", pageRequest);
        System.out.println("==========");
        System.out.println("is done?"+ future.isDone());

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {

            }

            @Override
            public void onSuccess(@Nullable List<Comment> result) {
                System.out.println("-------------");
                result.forEach(System.out::println);
            }
        });

    }

    private void createComment(String keyword, int likeCount) {
        Comment comment = new Comment();
        comment.setComment(keyword);
        comment.setLikeCount(likeCount);
        commentRepository.save(comment);
    }

}