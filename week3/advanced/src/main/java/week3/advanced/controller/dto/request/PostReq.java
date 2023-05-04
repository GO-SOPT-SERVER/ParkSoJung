package week3.advanced.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostReq {
    private String title;
    private String content;
    private Long userIdx;
}
