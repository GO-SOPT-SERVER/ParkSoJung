package sopt.org.week2.domain;

import lombok.Getter;

@Getter
public class PostLike {

    private Long id;
    private Long userId;
    private Long postId;
    private boolean status;

    public void setId(Long id) {
        this.id = id;
    }

    public PostLike(Long userId, Long postId, boolean status) {
        this.userId = userId;
        this.postId = postId;
        this.status = status;
    }
}
