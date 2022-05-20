package com.example.taegyungsite.dao;

import com.example.taegyungsite.model.Board2Dto;
import com.example.taegyungsite.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.dao
 * fileName : BoardDao
 * author : ds
 * date : 2022-05-17
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-17         ds          최초 생성
 */
// @Mapper : Mybatis에서 사용하는 어노테이션 , 스프링에 객체 생성
//           xml에서 interface를 구현함( CRUD sql문 작성 )
@Mapper
public interface Board2Dao {

//    insert sql문을 위한 메소드
    int insertBoard(Board2Dto params);

//    게시판 목록 조회하는 메소드 ( select sql문 )
    List<Board2Dto> selectBoardAllList();

//    게시판 페이징 처리를 위한 메소드
    List<Board2Dto> selectBoardList(Board2Dto params);

//    게시판 상세 목록 조회하는 메소드 ( 매개변수가 게시판번호인 select sql문 )
    Board2Dto selectBoardDetail(Long idx);

//    게시물의 총 건수를 가져오는 메소드 ( select : 1건 )
    int selectBoardTotalCount(Board2Dto params);

//    게시판 글 수정 메소드
    int updateBoard(Board2Dto params);

//    게시판 글 삭제 메소드
    int deleteBoard(Long idx);
}












