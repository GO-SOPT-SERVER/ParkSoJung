package week3.advanced.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUserReq {
    private String nickname;
    private String email;
    private String phone;
    private String password;
}
