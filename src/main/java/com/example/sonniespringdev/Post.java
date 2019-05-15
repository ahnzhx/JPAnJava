package com.example.sonniespringdev;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Post {

    @Id @GeneratedValue
    private Long id;
    private String title;
    @Lob // 내용이 255자 넘을 가능성이 있을 때, 이 @Lob을 써줌
    private String content;
    @Temporal(TemporalType.TIMESTAMP) //temporal 타입 3개 중 한개 꼭 써야함
    private Date created;
    private Integer likeCount;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<Comment>();

    public void addComment(Comment comment){
        this.getComments().add(comment);
        comment.setPost(this);
    }

    @Override
    public String  toString() {
        return "Post{" +
                " title='" + title + '\'' +
                '}';
    }
}
