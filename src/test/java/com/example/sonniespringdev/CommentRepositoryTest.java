package com.example.sonniespringdev;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        commentRepository.save(null);
    }

}