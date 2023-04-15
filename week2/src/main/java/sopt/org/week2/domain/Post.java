package sopt.org.week2.domain;


import lombok.Getter;

@Getter
public class Post {
    private Long Id;
    private String title;
    private String content;
    private Long writer;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(Long id) {
        Id = id;
    }
}
