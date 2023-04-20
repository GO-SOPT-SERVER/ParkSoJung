package sopt.org.week2.service;

import org.springframework.stereotype.Service;
import sopt.org.week2.domain.User;
import sopt.org.week2.dto.request.RegisterUserRequest;
import sopt.org.week2.dto.response.GetUserResponse;

import java.util.List;
import java.util.stream.Collectors;

import static sopt.org.week2.Week2Application.userList;

@Service
public class UserService {
    public String registerUser(RegisterUserRequest request) {

        User newUser = new User(
                request.getGender(),
                request.getName(),
                request.getContact(),
                request.getAge()
        );

        userList.add(newUser);
        newUser.setId((long)userList.size());

        return newUser.getId()+"번 유저가 등록되었습니다 !";

    }

    public GetUserResponse getUser(Long userId) {
        User user = userList.get((int)(userId-1));
        return GetUserResponse.toDto(user);
    }

    public List<GetUserResponse> searchUser(String name) {
        List<User> users = userList.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
        return GetUserResponse.toDto(users);
    }
}
