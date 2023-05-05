package week3.advanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week3.advanced.controller.dto.request.PostUserReq;
import week3.advanced.controller.dto.response.PostUserRes;
import week3.advanced.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("/join")
    public ResponseEntity<PostUserRes> join(@RequestBody final PostUserReq postUserReq) {
        return new ResponseEntity<>(userService.join(postUserReq), HttpStatus.CREATED);
    }

}
