package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.Post;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private Integer likeCount = 0;

    private int up;

    private int down;

    private boolean best;

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
