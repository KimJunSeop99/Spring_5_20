package com.example.taegyungsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.taegyungsite.model
 * fileName : CommentDto
 * author : ds
 * date : 2022-05-20
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-05-20         ds          최초 생성
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentDto extends CommonDto{
    private Long idx; // 댓글번호
    private Long boardIdx; // 게시판번호
    private String content; // 댓글내용
    private String writer; // 댓글작성자
}
