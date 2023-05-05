package week3.advanced.controller.dto.assembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import week3.advanced.controller.dto.request.PostReq;
import week3.advanced.domain.Post;
import week3.advanced.domain.User;

@Component
@RequiredArgsConstructor
public class PostAssembler {

    public Post toEntity(PostReq postReq, User user) {
        return Post.builder()
                .title(postReq.getTitle())
                .content(postReq.getContent())
                .user(user)
                .build();
    }
}
