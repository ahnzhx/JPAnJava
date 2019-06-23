package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.Post;
import com.example.sonniespringdev.springDataCommon.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository comments;

    @Autowired
    PostRepository posts;


    @Test
    public void getComment(){
        comments.getById(1l);
        System.out.println("========================");
        comments.findById(1l);

    }

    @Test
    public void getCommentTwo(){
        Post post = new Post();
        post.setTitle("jpa");
        final Post savedPost = posts.save(post);

        Comment comment = new Comment();
        comment.setComment("spring data jpa projection");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        comments.save(comment);

        comments.findByPost_Id(savedPost.getId(), CommentOnly.class).forEach(c->{
            System.out.println("============");
            System.out.println(c.getComment());
        });
    }

}