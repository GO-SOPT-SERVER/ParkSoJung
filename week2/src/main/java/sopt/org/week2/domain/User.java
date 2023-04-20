package sopt.org.week2.domain;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String gender;
    private String name;
    private String contact;
    private int age;

    public User(String gender, String name, String contact, int age) {
        this.gender = gender;
        this.name = name;
        this.contact = contact;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
