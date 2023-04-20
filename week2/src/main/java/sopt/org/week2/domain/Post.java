package sopt.org.week2.domain;


import lombok.Getter;

@Getter
public class Post {
    private Long Id;
    private String title;
    private String content;
    private Long writer;

    public Post(String title, String content, Long writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void setId(Long id) {
        Id = id;
    }
}
