package com.example.sonniespringdev;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Post {

    @Id @GeneratedValue
    private Long id;
    private String title;
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
