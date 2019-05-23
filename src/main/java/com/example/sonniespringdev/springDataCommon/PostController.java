package com.example.sonniespringdev.springDataCommon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;


    /**
     * 매개변수에 (@PathVariable("id") Post post)로 줄 수 있음
     * {id}와 post의 이름이 다르기 때문에
     * @PathVaraible에 꼭 ("id") 써주기~~
     * @param id
     * @return
     */
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id){
        final Optional<Post> byId = postRepository.findById(id);
        final Post post = byId.get();
        return post.getTitle();
    }

    /**
     * 위의 메소드와 같음! 표현방법이 다름
     */

    @GetMapping("/posts2/{id}")
    public String getPost2(@PathVariable("id") Post post){
        return post.getTitle();
    }

    @GetMapping("/posts")
    public PagedResources<Resource<Post>> getPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler){
        final Page<Post> all = postRepository.findAll(pageable);
        return assembler.toResource(all);
    }
}
