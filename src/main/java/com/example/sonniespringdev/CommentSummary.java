package com.example.sonniespringdev;

public interface CommentSummary {
    String getComment();
    int getUp();
    int getDown();

    default String getVotes(){
        return getUp() + " " + getDown();
    }

    /*
    * Open projection
    * (성능 별로 안좋음 -> 모든 컬럼값을 가져오기 때문에)
    * */
    /*@Value("#{target.up + ' ' + target.down}")
    String getVotes();*/
}
