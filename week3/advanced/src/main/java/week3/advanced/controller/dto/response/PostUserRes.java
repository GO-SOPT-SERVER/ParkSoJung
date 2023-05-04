package week3.advanced.controller.dto.response;

import lombok.*;
import week3.advanced.domain.User;

@Builder
@AllArgsConstructor
@Getter
public class PostUserRes {
    private Long userIdx;
    private String nickname;

    public static PostUserRes toEntity(User user) {
        return PostUserRes.builder()
                .userIdx(user.getUserIdx())
                .nickname(user.getNickname())
                .build();
    }
}
