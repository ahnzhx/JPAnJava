package com.example.sonniespringdev;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private String comment;
    @ManyToOne
    private Post post;

    private Integer likeCount = 0;

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
