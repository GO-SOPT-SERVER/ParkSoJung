package week3.advanced.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import week3.advanced.domain.Post;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class GetPostRes {
    private Long postIdx;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime createdAt;

    public static GetPostRes toEntity(Post post) {
        return GetPostRes.builder()
                .postIdx(post.getPostIdx())
                .title(post.getTitle())
                .content(post.getContent())
                .nickname(post.getUser().getNickname())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
