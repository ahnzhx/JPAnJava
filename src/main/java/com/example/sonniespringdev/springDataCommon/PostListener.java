package com.example.sonniespringdev.springDataCommon;

import org.springframework.context.ApplicationListener;

//PostRepositoryTestConfig에서 bean으로 등록함
public class PostListener implements ApplicationListener<PostPublishedEvent> {

    //이벤트가 발생했을 때 해야할 일
    @Override
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("==============");
        System.out.println(event.getPost()+" is published");
        System.out.println("======");
    }
}
