package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.PostPublishedEvent;
import com.example.sonniespringdev.springDataCommon.PostRepository;
import com.example.sonniespringdev.springDataCommon.PostRepositoryTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;


    @Test
    public void crudRepository() {
        //given
        Post post = new Post();
        post.setTitle("hello spring boot data common");
        assertThat(post.getId()).isNull();

        //when
        Post newPost = postRepository.save(post);

        //then
        assertThat(newPost.getId()).isNotNull();

        //when
        final List<Post> posts = postRepository.findAll();

        //then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        //when
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //when
        page = postRepository.findByTitleContains("spring", PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);
    }

    @Test
    public void crud() {

        Post post = new Post();
        post.setTitle("hibernate");

        //transient 상태
        assertThat(postRepository.contains(post)).isFalse();

        postRepository.save(post.publish());

        //persistent 상태
        assertThat(postRepository.contains(post)).isTrue();


        postRepository.delete(post);
        postRepository.flush();
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("sonnie's JPA");
        return postRepository.save(post);
    }

    @Test
    public void updateTitle() {
        String hibernate = "sonnie's hibernate";
        Post spring = savePost();

        spring.setTitle(hibernate);

        //update 쿼리를 따로 선언해 줄 필요 없이 findAll()날린다.
        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(hibernate);
    }
}