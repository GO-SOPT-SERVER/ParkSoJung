package week3.advanced.controller.dto.assembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import week3.advanced.controller.dto.request.PostUserReq;
import week3.advanced.domain.User;

@Component
@RequiredArgsConstructor
public class UserAssembler {

    public User toEntity(PostUserReq postUserReq) {
        return User.builder()
                .nickname(postUserReq.getNickname())
                .email(postUserReq.getEmail())
                .phone(postUserReq.getPhone())
                .password(postUserReq.getPassword())
                .build();
    }
}
