package sopt.week3.controller.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
//@RequiredArgsConstructor // 왜 AllArgsConstructor 사용하면 안 되는거지,, 왜,, 왜,,?
@AllArgsConstructor // noArgsConstructor가 있어야만 사용 가능 ! = 역직렬화할 때, 기본 생성자를 만든 후, 맵핑되어야 하는데 기본 생성자가 없으면 맵핑할 대상을 찾지 못해서 발생하는 에러
@NoArgsConstructor
public class UserRequestDto {
    @Email(message = "이메일 형식에 맞지 않습니다")
    @NotNull
    private String email;

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "닉네임 형식에 맞지 않습니다")
    private String nickname;

    @NotBlank
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;
}
