package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crudRepository(){
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
    public void crud(){

        Post post = new Post();
        post.setTitle("hibernate");

        //transient 상태
        assertThat(postRepository.contains(post)).isFalse();

        postRepository.save(post);

        //persistent 상태
        assertThat(postRepository.contains(post)).isTrue();


        postRepository.delete(post);
        postRepository.flush();
    }
}