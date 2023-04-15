package sopt.org.week2.dto.request;

import lombok.Getter;

@Getter
public class RegisterUserRequest {
    private String gender;
    private String name;
    private String contact;
    private int age;

}
