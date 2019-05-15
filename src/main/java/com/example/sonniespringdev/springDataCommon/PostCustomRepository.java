package com.example.sonniespringdev.springDataCommon;

import com.example.sonniespringdev.Post;

import java.util.List;

public interface PostCustomRepository<T> {
    List<Post> findMyPost();
    void delete(T entity);
}
