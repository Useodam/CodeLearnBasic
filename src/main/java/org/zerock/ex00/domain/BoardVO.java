package org.zerock.ex00.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data // 롬복 Data 어노테이션은 Getter, Setter를 자동으로 생성해줌
public class BoardVO {

    private Long bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
