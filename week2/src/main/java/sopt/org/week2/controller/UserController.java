package sopt.org.week2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.week2.dto.request.RegisterUserRequest;
import sopt.org.week2.dto.response.GetUserResponse;
import sopt.org.week2.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
     * 유저 등록
     */
    @PostMapping("/user")
    public String registerUser(@RequestBody final RegisterUserRequest request) {
        return userService.registerUser(request);
    }

    /**
     * 유저 검색 (유저 Id)
     * @param userId
     */
    @GetMapping("/user/{userId}")
    public GetUserResponse getUser(@PathVariable final Long userId) {
        return userService.getUser(userId);
    }

    /**
     * 유저 검색 (유저 이름)
     * @param name
     */
    @GetMapping("/user/search")
    public List<GetUserResponse> searchUser(@RequestParam final String name) {
        return userService.searchUser(name);
    }

}
