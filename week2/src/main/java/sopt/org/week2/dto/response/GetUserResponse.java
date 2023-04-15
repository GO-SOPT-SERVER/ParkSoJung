package sopt.org.week2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week2.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class GetUserResponse {
    private Long id;
    private String gender;
    private String name;
    private String contact;
    private int age;

    public static GetUserResponse toDto(User user) {
        return new GetUserResponse(user.getId(), user.getGender(), user.getName(), user.getContact(), user.getAge());
    }

    public static List<GetUserResponse> toDto(List<User> users) {
        return users.stream()
                .map(GetUserResponse::toDto).collect(Collectors.toList());
    }
}
