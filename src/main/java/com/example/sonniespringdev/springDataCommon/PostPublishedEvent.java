package com.example.sonniespringdev.springDataCommon;

import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent extends ApplicationEvent {

    private final Post post;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public PostPublishedEvent(Object source) {
        super(source);
        this.post = (Post) source;

    }

    //어떤 Post에 대한 event였는지 참조할 수 있도록 getter 생성
    public Post getPost() {
        return post;
    }
}
