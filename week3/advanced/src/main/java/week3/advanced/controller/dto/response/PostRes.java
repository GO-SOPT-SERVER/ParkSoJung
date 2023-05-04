package week3.advanced.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import week3.advanced.domain.Post;
import week3.advanced.domain.User;

@Builder
@AllArgsConstructor
@Getter
public class PostRes {
    private Long postIdx;

    public static PostRes toEntity(Post post) {
        return PostRes.builder()
                .postIdx(post.getPostIdx())
                .build();
    }
}
