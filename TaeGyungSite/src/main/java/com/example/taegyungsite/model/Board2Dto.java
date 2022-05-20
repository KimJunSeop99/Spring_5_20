package com.example.taegyungsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.taegyungsite.model
 * fileName : BoardDto
 * author : ds
 * date : 2022-05-17
 * description : 개발순서 : Model -> Dao -> xml -> Service -> Controller
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-17         ds          최초 생성
 */
// 롬북(Lombok) 라이브러리에서 제공하는 어노테이션
// @Getter, @Setter : 자동으로 getter / setter 메소드를 만들어줌
// @ToString : 객체를 출력( System.out.println(board2Dto); //
//             => 객체 주소값 ( fdsa@fdsa ) => 멤버변수의 값을 모두 출력해줌
//    객체 안의 멤버변수값을 알고 싶으면 toString 메소드의 overriding이 필요함
//    @Getter + @Setter + @ToString + @HashCode => @Data
@Getter
@Setter
@ToString
// @JsonNaming :  자바 클래스의 noticeYn 를 자동으로 notice_yn으로 변환해줌
// 자바클래스 멤버변수 => Json { "속성명" : 값 }
// ex) Board2Dto 의 noticeYn => 웹 클라이언트(HTML) : Json { "notice_yn" : "N" }
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Board2Dto extends CommonDto {
//    번호 ( PK : 기본키 )
    private Long idx;
//    제목
    private String title;
//    내용
    private String content;
//    작성자
    private String writer;
//    조회 수
    private int viewCnt;
//    공지여부 ( Y, N )
    private String noticeYn;
//    비밀여부 ( Y, N )
    private String secretYn;

//    setter ( 저장용 ) / getter ( 조회용 ) 메소드 생성 필요
}






