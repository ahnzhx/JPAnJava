package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.Post;
import com.example.sonniespringdev.springDataCommon.PostRepository;
import com.example.sonniespringdev.springDataCommon.PostRepositoryTestConfig;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;


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

    /**
     * Querydsl을 이용해 select문 날리기
     */
    @Test
    public void crud() {

        Post post = new Post();
        post.setTitle("hibernate");

        postRepository.save(post.publish());
//        Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
//        Optional<Post> one = postRepository.findOne(predicate);
//        assertThat(one).isNotEmpty();

    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");
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

    @Test
    public void save(){
        Post post = new Post();
        post.setTitle("Jpa");
        postRepository.save(post); //persist

        assertThat(entityManager.contains(post)).isTrue();

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        //데이터 가공할 때 꼭 리턴받는 값으로 해야된다
        final Post updatedPost = postRepository.save(postUpdate);

        assertThat(entityManager.contains(updatedPost)).isTrue();
        // 또 업데이트 하고싶을 때, updatedPost를 써야함! postUpdate가 아니고!
        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(updatedPost != postUpdate);


        final List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartswith(){
        Post post = new Post();
        post.setTitle("Spring data jpa");
        postRepository.save(post);

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle(){
        savePost();

        List<Post> all = postRepository.findByTitle("Spring");
        assertThat(all.size()).isEqualTo(1);
    }
}